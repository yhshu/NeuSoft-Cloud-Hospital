package com.neusoft.medical.service.impl;

import com.neusoft.medical.service.techWorkstation.MedicalTechService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicalTechServiceImplTest {

    @Resource
    MedicalTechService medicalTechService;

    @Test
    public void selectChargeEntryList() {
        medicalTechService.selectChargeEntryList(1);
    }

    @Test
    public void chargeEntryListDelivery() {
        medicalTechService.chargeEntryListDelivery("");
    }

    @Test
    public void chargeEntryListRefund() {
        medicalTechService.chargeEntryListRefund("");
    }
}