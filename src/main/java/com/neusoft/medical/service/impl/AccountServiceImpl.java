package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Account;
import com.neusoft.medical.example.AccountExample;
import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.example.DoctorExample;
import com.neusoft.medical.dao.AccountMapper;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.service.basicInfo.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private DoctorMapper doctorMapper;

    @Override
    public PageInfo<Account> selectAccount(Integer currentPage, Integer pageSize, List<String> accountScope) {
        PageHelper.startPage(currentPage, pageSize);

        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andValidEqualTo(1);
        criteria.andAccountTypeIn(accountScope);

        return new PageInfo<>(accountMapper.selectByExample(accountExample));
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
}
