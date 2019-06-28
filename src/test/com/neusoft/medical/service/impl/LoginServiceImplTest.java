package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Account;
import com.neusoft.medical.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceImplTest {
    @Resource
    private LoginService loginService;
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void signIn() {
        System.out.println(loginService.signIn("test", "test"));
    }

    @Test
    public void permissionRequest() {
        // redis token
        Map<String, Account> stringAccountMap = new HashMap<>();
        redisTemplate.opsForHash().putAll("tokens", stringAccountMap);
        Map map = redisTemplate.opsForHash().entries("tokens");
        System.out.println(map);
    }
}