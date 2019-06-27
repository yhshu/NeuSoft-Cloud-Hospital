package com.neusoft.medical.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.AccountMapper;
import com.neusoft.medical.dao.AccountTypePermissionMapper;
import com.neusoft.medical.dao.PermissionMapper;
import com.neusoft.medical.service.LoginService;
import com.neusoft.medical.service.basicInfo.AccountService;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class LoginServiceImpl implements LoginService {
    private Logger logger = Logger.getLogger(LoginService.class);

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private AccountService accountService;
    @Resource
    private AccountTypePermissionMapper accountTypePermissionMapper;
    @Resource
    private PermissionMapper permissionMapper;

    private Gson gson = new Gson();

    @Override
    public String signIn(String userName, String userPassword) {
        // 找到数据库中加密的用户密码，与用户当前输入的密码进行比对
        Account account = accountService.selectAccountByUserName(userName);
        if (account == null)
            return Constant.SIGNIN_MISMATCH;

        if (bCryptPasswordEncoder.matches(userPassword, account.getUserPassword())) {
            // 用户密码核对成功，返回用户信息与权限
            logger.info("user " + userName + " successfully logged in");

            JsonObject accountJsonObject = gson.toJsonTree(account).getAsJsonObject();
            accountJsonObject.remove("userPassword"); // 移除数据库中的密码
            String accountType = account.getAccountType();

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

        } else {
            logger.info("password mismatch, username: " + userName + ", password: " + userPassword);
            return Constant.SIGNIN_MISMATCH;
        }
    }
}
