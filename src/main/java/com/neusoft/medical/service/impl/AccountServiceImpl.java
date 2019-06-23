package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.AccountMapper;
import com.neusoft.medical.dao.DepartmentMapper;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.dao.StaffMapper;
import com.neusoft.medical.service.basicInfo.AccountService;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class AccountServiceImpl implements AccountService {
    private Logger logger = Logger.getLogger(AccountService.class);

    @Resource
    private AccountMapper accountMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private StaffMapper staffMapper;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Gson gson = new Gson();

    @Override
    public PageInfo<String> selectAccount(Integer currentPage, Integer pageSize, List<String> accountScope) {
        PageHelper.startPage(currentPage, pageSize);

        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andValidEqualTo(1);
        criteria.andAccountTypeIn(accountScope);
        List<Account> accountList = accountMapper.selectByExample(accountExample);
        List<String> accountJsonList = new CopyOnWriteArrayList<>();
        for (Account account : accountList) {
            JsonObject accountJsonObject = gson.toJsonTree(account).getAsJsonObject();
            accountJsonObject.remove("userPassword");
            if (account.getAccountType().equals(Constant.TYPE_OUTPATIENT_DOCTOR) || account.getAccountType().equals(Constant.TYPE_TECH_DOCTOR)) {  // 该用户是医生
                DoctorExample doctorExample = new DoctorExample();
                DoctorExample.Criteria doctorCriteria = doctorExample.createCriteria();
                doctorCriteria.andValidEqualTo(1);
                doctorCriteria.andAccountIdEqualTo(account.getAccountId());
                List<Doctor> doctorList = doctorMapper.selectByExample(doctorExample);
                if (doctorList.size() == 1) {
                    Doctor doctor = doctorList.get(0);
                    System.out.println("selectAccount: " + doctor.toString());
                    accountJsonObject.addProperty("realName", doctor.getDoctorName());
                    accountJsonObject.addProperty("departmentId", doctor.getDepartmentId());
                    accountJsonObject.addProperty("departmentName", departmentMapper.selectByPrimaryKey(doctor.getDepartmentId()).getDepartmentName());
                    accountJsonObject.addProperty("jobTitle", doctor.getJobTitle());
                    accountJsonObject.addProperty("doctorScheduling", doctor.getDoctorScheduling());
                }
            } else {  // 该用户是医生外的其他职员
                StaffExample staffExample = new StaffExample();
                StaffExample.Criteria staffCriteria = staffExample.createCriteria();
                staffCriteria.andValidEqualTo(1);
                staffCriteria.andAccountIdEqualTo(account.getAccountId());
                List<Staff> staffList = staffMapper.selectByExample(staffExample);
                if (staffList.size() == 1) {
                    Staff staff = staffList.get(0);
                    System.out.println("selectAccount: " + staff.toString());
                    accountJsonObject.addProperty("realName", staff.getRealName());
                    accountJsonObject.addProperty("departmentId", staff.getDepartmentId());
                    accountJsonObject.addProperty("departmentName", departmentMapper.selectByPrimaryKey(staff.getDepartmentId()).getDepartmentName());
                }
            }
            accountJsonList.add(accountJsonObject.toString());  // 将该用户信息添加到列表中
        }
        return new PageInfo<>(accountJsonList);
    }

    @Override
    public PageInfo<Doctor> selectDoctor(Integer currentPage, Integer pageSize, List<String> accountScope) {
        PageHelper.startPage(currentPage, pageSize);

        DoctorExample doctorExample = new DoctorExample();
        DoctorExample.Criteria criteria = doctorExample.createCriteria();
        criteria.andValidEqualTo(1);
        criteria.andAccountTypeIn(accountScope);

        return new PageInfo<>(doctorMapper.selectByExample(doctorExample));
    }

    @Override
    public boolean addAccount(String userName, String userPassword, String accountType, String realName, int departmentId, String jobTitle, int doctorScheduling) {
        try {
            if (selectAccountByUserName(userName) != null) {
                logger.info("username " + userName + " has been registered");
                return false;
            }
            Account account = new Account(null, userName, bCryptPasswordEncoder.encode(userPassword), accountType, 1, null, null, null);
            accountMapper.insert(account);
            if (account.getAccountId() == null) {
                throw new Exception("accountId is still null after trying to insert the database.");
            }

            if (accountType.equals(Constant.TYPE_OUTPATIENT_DOCTOR) || accountType.equals(Constant.TYPE_TECH_DOCTOR)) {
                // 如果是门诊医生或医技医生
                doctorMapper.insert(new Doctor(null, realName, departmentId, jobTitle, account.getAccountId(), accountType, doctorScheduling, 1, null, null, null));
            } else {
                // 如果是医院工作人员
                staffMapper.insert(new Staff(null, realName, departmentId, account.getAccountId(), accountType, 1, null, null, null));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateAccount(int accountId, String userName, String userPassword, String realName, int departmentId, String jobTitle, Integer doctorScheduling) {
        try {
            AccountExample accountExample = new AccountExample();
            accountExample.or().andValidEqualTo(1).andAccountIdEqualTo(accountId);
            accountMapper.updateByExampleSelective(new Account(accountId, userName, bCryptPasswordEncoder.encode(userPassword), null, 1, null, null, null), accountExample);
            String accountType = accountMapper.selectByPrimaryKey(accountId).getAccountType();

            if (accountType.equals(Constant.TYPE_OUTPATIENT_DOCTOR) || accountType.equals(Constant.TYPE_TECH_DOCTOR)) {
                // 如果是门诊医生或医技医生
                DoctorExample doctorExample = new DoctorExample();
                doctorExample.or().andValidEqualTo(1).andAccountIdEqualTo(accountId);
                doctorMapper.updateByExampleSelective(new Doctor(null, realName, departmentId, jobTitle, accountId, accountType, doctorScheduling, 1, null, null, null), doctorExample);
            } else {
                // 如果是医院工作人员
                StaffExample staffExample = new StaffExample();
                staffExample.or().andValidEqualTo(1).andAccountIdEqualTo(accountId);
                staffMapper.updateByExampleSelective(new Staff(null, realName, departmentId, accountId, accountType, 1, null, null, null), staffExample);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteAccount(List<Integer> accountIdList) {
        try {
            AccountExample accountExample = new AccountExample();
            accountExample.or().andValidEqualTo(1).andAccountIdIn(accountIdList);

            Account record = new Account();
            record.setValid(0);
            accountMapper.updateByExampleSelective(record, accountExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Account selectAccountByUserName(String userName) {
        AccountExample accountExample = new AccountExample();
        accountExample.or().andValidEqualTo(1).andUserNameEqualTo(userName);

        List<Account> accountList = accountMapper.selectByExample(accountExample);

        if (accountList.isEmpty()) {
            logger.info("username " + userName + " does not exist");
            return null;

        } else if (accountList.size() > 1) {
            logger.error("username " + userName + " is duplicate, please check the uniqueness of the account table in the database");
            return null;
        }

        return accountList.get(0);
    }

    @Override
    public Staff selectStaffByAccountId(Integer accountId) {
        StaffExample staffExample = new StaffExample();
        staffExample.or().andValidEqualTo(1).andAccountIdEqualTo(accountId);

        List<Staff> staffList = staffMapper.selectByExample(staffExample);
        if (staffList.isEmpty()) return null;
        if (staffList.size() > 1) {
            logger.error("accountId is duplicated, please check the uniqueness setting in related tables");
            return null;
        }
        return staffList.get(0);
    }
}
