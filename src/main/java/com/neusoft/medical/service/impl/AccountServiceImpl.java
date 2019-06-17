package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.neusoft.medical.bean.Account;
import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.dao.AccountMapper;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.example.AccountExample;
import com.neusoft.medical.example.DoctorExample;
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
            String accountJson = gson.toJson(account);
//            if(account.getAccountType())
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
        return true;
    }
}
