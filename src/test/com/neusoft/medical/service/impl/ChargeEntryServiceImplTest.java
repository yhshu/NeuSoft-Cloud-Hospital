package com.neusoft.medical.service.impl;

import com.neusoft.medical.dao.ChargeEntryMapper;
import com.neusoft.medical.service.registration.ChargeEntryService;
import com.qcloud.cos.transfer.Copy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChargeEntryServiceImplTest {
    @Resource
    private ChargeEntryService chargeEntryService;
    @Resource
    private ChargeEntryMapper chargeEntryMapper;

    @Test
    public void selectChargeEntryByRegistrationId() {
        Date today = new Date();
        Date startDate = new Date(today.getTime() - 1000 * 60 * 60 * 24 * 30);  // 一个月之前
        for (int i = 0; i < 50; i++) {
            chargeEntryService.selectChargeEntryByRegistrationId(1, 20, i, startDate, today, 0);
        }
    }

    @Test
    public void addChargeEntryToForm() {
        chargeEntryService.addChargeEntryToForm(null, 1, 1, 1, "doctorAdvice", 1, 1);
    }

    @Test
    public void deleteChargeItemInForm() {
        List<Integer> chargeEntryIdList = new CopyOnWriteArrayList<>();
        chargeEntryIdList.add(1);
        chargeEntryService.deleteChargeItemInForm(chargeEntryIdList);
    }

    @Test
    public void payBill() {
        List<Integer> chargeEntryIdList = new CopyOnWriteArrayList<>();
        chargeEntryIdList.add(1);
        chargeEntryService.payBill(chargeEntryIdList);
    }
}