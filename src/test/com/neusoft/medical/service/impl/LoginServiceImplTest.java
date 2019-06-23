package com.neusoft.medical.service.impl;

import com.neusoft.medical.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceImplTest {
    @Resource
    private LoginService loginService;

    @Test
    public void signIn() {
        System.out.println(loginService.signIn("test", "test"));
    }
}