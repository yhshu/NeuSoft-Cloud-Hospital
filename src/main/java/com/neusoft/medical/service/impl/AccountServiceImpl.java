package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.neusoft.medical.bean.Account;
import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.Staff;
import com.neusoft.medical.dao.AccountMapper;
import com.neusoft.medical.dao.DepartmentMapper;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.dao.StaffMapper;
import com.neusoft.medical.example.AccountExample;
import com.neusoft.medical.example.DoctorExample;
import com.neusoft.medical.example.StaffExample;
import com.neusoft.medical.service.basicInfo.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private StaffMapper staffMapper;

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
            if (account.getAccountType().equals(TYPE_OUTPATIENT_DOCTOR) || account.getAccountType().equals(TYPE_TECH_DOCTOR)) {  // 该用户是医生
                DoctorExample doctorExample = new DoctorExample();
                DoctorExample.Criteria doctorCriteria = doctorExample.createCriteria();
                doctorCriteria.andValidEqualTo(1);
                doctorCriteria.andAccountIdEqualTo(account.getAccountId());
                List<Doctor> doctorList = doctorMapper.selectByExample(doctorExample);
                if (doctorList.size() == 1) {
                    Doctor doctor = doctorList.get(0);
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
                    accountJsonObject.addProperty("realName", staff.getRealName());
                    accountJsonObject.addProperty("departmentId", staff.getDepartmentId());
                    accountJsonObject.addProperty("departmentName", staff.getDepartmentName());
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
    public boolean addAccount(String userName, String userPassword, String accountType) {
        try {
            accountMapper.insert(new Account(null, userName, userPassword, accountType, 1, null, null, null));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateAccount(int accountId, String userName, String userPassword, String accountType) {
        try {
            AccountExample accountExample = new AccountExample();
            AccountExample.Criteria criteria = accountExample.createCriteria();
            criteria.andValidEqualTo(1);  // 有效的帐号记录
            criteria.andAccountIdEqualTo(accountId);
            accountMapper.updateByExampleSelective(new Account(accountId, userName, userPassword, accountType, 1, null, null, null), accountExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteAccount(List<Integer> accountIdList) {
        try {
            AccountExample accountExample = new AccountExample();
            AccountExample.Criteria criteria = accountExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andAccountIdIn(accountIdList);

            Account record = new Account();
            record.setValid(0);
            accountMapper.updateByExampleSelective(record, accountExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
