package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Account;
import com.neusoft.medical.dao.AccountMapper;
import com.neusoft.medical.service.basicInfo.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {
    @Resource
    private AccountService accountService;
    @Resource
    private AccountMapper accountMapper;

    @Test
    public void selectAccount() {
        List<String> accountScope = new CopyOnWriteArrayList<>();
        accountScope.add("00");
        accountScope.add("01");
        accountService.selectAccount(1, 20, accountScope);
    }

    @Test
    public void selectDoctor() {
        List<String> doctorScope = new CopyOnWriteArrayList<>();
        doctorScope.add("00");
        accountService.selectDoctor(1, 20, doctorScope);
    }

    @Test
    public void addAccount() {
        accountService.addAccount("test_username", "test_password", "00", "realname", 1, "主治医师", 1);
    }

    @Test
    public void updateAccount() {
        Account accountRecord = new Account(null, "test_username", "user_password", "00", 1, null, null, null);
        accountMapper.insert(accountRecord);
        Integer accountId = accountRecord.getAccountId();
        accountService.updateAccount(accountId, "test_username1", "test_password", "realname", 13, "主治医师", 1);
    }

    @Test
    public void deleteAccount() {
        Account accountRecord = new Account(null, "test_username", "user_password", "00", 1, null, null, null);
        accountMapper.insert(accountRecord);
        List<Integer> accountIdList = new CopyOnWriteArrayList<>();
        accountIdList.add(accountRecord.getAccountId());
        accountService.deleteAccount(accountIdList);
    }

    @Test
    public void selectAccountByUserName() {
        accountService.selectAccountByUserName("test_username");
    }

    @Test
    public void selectStaffByAccountId() {
        for (int i = 0; i < 100; i++) {
            accountService.selectStaffByAccountId(i);
        }
    }

    @Test
    public void selectDoctorByAccountId() {
        for (int i = 0; i < 100; i++) {
            accountService.selectDoctorByAccountId(i);
        }
    }
}