package com.neusoft.medical.service.impl;

import com.neusoft.medical.service.pharmacyWorkstation.MedicineDistributionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineDistributionServiceImplTest {

    @Resource
    MedicineDistributionService distributionService;

    @Test
    public void selectPrescriptionEntryList() {
        distributionService.selectPrescriptionEntryList(1);
    }

    @Test
    public void prescriptionEntryDelivery() {
        distributionService.prescriptionEntryDelivery("");
    }
}