package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Account;
import com.neusoft.medical.bean.AccountExample;
import com.neusoft.medical.bean.Department;
import com.neusoft.medical.bean.DepartmentExample;
import com.neusoft.medical.dao.AccountMapper;
import com.neusoft.medical.service.AccountService;

import javax.annotation.Resource;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public PageInfo<Account> selectAccount(Integer currentPage, Integer pageSize, List<Integer> accountType) {
        PageHelper.startPage(currentPage, pageSize);

        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andValidEqualTo(1);
        List<Account> accountList = accountMapper.selectByExample(accountExample);

        // account 的具体角色可能是 doctor 或 staff
        if (accountType == null || accountType.isEmpty()) {  // 没有指定帐户类别
            return new PageInfo<>(accountList);
        }
//        else {
//            // todo 指定帐户类别
//        }
        return null;

    }
}
