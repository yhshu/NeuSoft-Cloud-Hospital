package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Account;
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
        accountService.selectAccount(1, 20, doctorScope);
    }

    @Test
    public void addAccount() {
        accountService.addAccount("test_username", "test_password", "00", "realname", 1, "主治医师", 1);
    }

    @Test
    public void updateAccount() {
    }

    @Test
    public void deleteAccount() {
    }

    @Test
    public void selectAccountByUserName() {
        accountService.selectAccountByUserName("test_username");
    }

    @Test
    public void selectStaffByAccountId() {
    }

    @Test
    public void selectDoctorByAccountId() {
    }
}