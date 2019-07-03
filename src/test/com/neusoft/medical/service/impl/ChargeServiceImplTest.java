package com.neusoft.medical.service.impl;

import com.neusoft.medical.dao.ChargeFormMapper;
import com.neusoft.medical.dao.ChargeItemMapper;
import com.neusoft.medical.service.registration.ChargeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChargeServiceImplTest {

    @Resource
    private ChargeService chargeService;
    @Resource
    private ChargeFormMapper chargeFormMapper;

    @Test
    public void checkout() {
        String checkoutJson;
        chargeService.checkout("");
    }

    @Test
    public void refund() {
        String refundJson;
        chargeService.refund("");
    }

    @Test
    public void withdrawRegistration() {
        chargeService.withdrawRegistration(1);
    }
}