package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMapperTest {
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
        int account = accountMapper.deleteByPrimaryKey(15);
    }

    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    @Transactional
    public void insert() {
        Account account = new Account(null, "username", "password", "00", 1, null, null, null);
        accountMapper.insert(account);
        System.out.println(account.getAccountId() + account.getUserName());
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
        Account account = accountMapper.selectByPrimaryKey(10);
        System.out.println(account.getAccountId() + account.getUserName());
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
        Account account = accountMapper.selectByPrimaryKey(15);
        account.setUserName("HUAWEI");
        account.setValid(1);
        account.setReserve1(null);
        account.setReserve2(null);
        account.setReserve3(null);
        accountMapper.updateByPrimaryKey(account);
        System.out.println(account.getAccountId() + account.getUserName());
    }
}