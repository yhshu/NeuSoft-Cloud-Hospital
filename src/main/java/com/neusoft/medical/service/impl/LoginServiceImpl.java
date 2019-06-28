package com.neusoft.medical.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.AccountTypePermissionMapper;
import com.neusoft.medical.dao.DepartmentMapper;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.dao.PermissionMapper;
import com.neusoft.medical.service.LoginService;
import com.neusoft.medical.service.basicInfo.AccountService;
import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.neusoft.medical.Util.Constant.*;

@Service
public class LoginServiceImpl implements LoginService {
    private Logger logger = Logger.getLogger(LoginService.class);

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private AccountService accountService;
    @Resource
    private AccountTypePermissionMapper accountTypePermissionMapper;
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private DepartmentMapper departmentMapper;

    private Gson gson = new Gson();

    @Override
    public String signIn(String userName, String userPassword) {
        // 找到数据库中加密的用户密码，与用户当前输入的密码进行比对
        Account account = accountService.selectAccountByUserName(userName);
        if (account == null)
            return Constant.SIGNIN_MISMATCH;

        if (bCryptPasswordEncoder.matches(userPassword, account.getUserPassword())) {
            // 用户密码核对成功，签发 token；同一用户每次生成的 token 不同
            logger.info("user " + userName + " successfully logged in");
            String token = bCryptPasswordEncoder.encode(userName);
            logger.info("token: " + token);

            redisTemplate.opsForHash().put("accountInfo", token, account);
            Date now = new Date();
            Date deadline = new Date(now.getTime() + TOKEN_AVAILABLE_TIME);
            redisTemplate.opsForHash().put("tokenDeadline", token, deadline);
            return token;

        } else {
            logger.info("password mismatch, username: " + userName + ", password: " + userPassword);
            return Constant.SIGNIN_MISMATCH;
        }
    }

    public String permissionRequest(String token) {
        // redis token
        Date deadline = (Date) redisTemplate.opsForHash().get("tokenDeadline", token);
        Date now = new Date();
        if (deadline == null) {
            // 客户端可能正在伪造 token
            return Constant.SIGNIN_MISMATCH;
        }
        if (now.after(deadline)) {
            // token 不再可用
            return Constant.SIGNIN_TOKEN_EXPIRED;
        }

        Account account = (Account) redisTemplate.opsForHash().get("accountInfo", token);
        JsonObject accountJsonObject = gson.toJsonTree(account).getAsJsonObject();
        accountJsonObject.remove("userPassword"); // 移除数据库中的密码

        // 返回用户信息，包括用户真实姓名、用户类型、科室名称、系统权限等
        String accountType = account.getAccountType();
        if (accountType.equals(TYPE_OUTPATIENT_DOCTOR) || accountType.equals(TYPE_TECH_DOCTOR)) {

            // 如果该用户是某种类型的医生
            Doctor doctor = accountService.selectDoctorByAccountId(account.getAccountId());
            JsonObject doctorJsonObject = gson.toJsonTree(doctor).getAsJsonObject();
            doctorJsonObject.addProperty("departmentName", departmentMapper.selectByPrimaryKey(doctor.getDepartmentId()).getDepartmentName());  // 科室名称
            // todo 用户类型
            accountJsonObject.add("accountInfo", doctorJsonObject);
        } else if (accountType.equals(TYPE_COLLECTOR_STAFF) || accountType.equals(TYPE_PHARMACY_STAFF) || accountType.equals(TYPE_FINANCIAL_STAFF) || accountType.equals(TYPE_REGISTRATION_STAFF)) {

            // 如果该用户是某种类型的医院工作人员
            Staff staff = accountService.selectStaffByAccountId(account.getAccountId());
            accountJsonObject.add("staff", gson.toJsonTree(staff));
        } else if (accountType.equals(TYPE_SYSTEM_ADMIN)) {

            // 如果该用户是系统管理员
            Staff staff = accountService.selectStaffByAccountId(account.getAccountId());
            accountJsonObject.add("staff", gson.toJsonTree(staff));
        }

        // 用户权限
        AccountTypePermissionExample accountTypePermissionExample = new AccountTypePermissionExample();
        accountTypePermissionExample.or().andValidEqualTo(1).andAccountTypeEqualTo(accountType);
        List<AccountTypePermission> accountTypePermissionList = accountTypePermissionMapper.selectByExample(accountTypePermissionExample);
        List<Integer> permissionIdList = new CopyOnWriteArrayList<>();
        for (AccountTypePermission accountTypePermission : accountTypePermissionList) {
            permissionIdList.add(accountTypePermission.getPermissionId());
        }

        PermissionExample permissionExample = new PermissionExample();
        permissionExample.or().andValidEqualTo(1).andPermissionIdIn(permissionIdList);
        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);
        List<String> permissionNameList = new CopyOnWriteArrayList<>();
        for (Permission permission : permissionList) {
            permissionNameList.add(permission.getPermissionName());
        }
        JsonArray permissionNameListJsonArray = gson.toJsonTree(permissionNameList).getAsJsonArray();
        accountJsonObject.add("permissionNameList", permissionNameListJsonArray);

        return accountJsonObject.toString();
    }
}
