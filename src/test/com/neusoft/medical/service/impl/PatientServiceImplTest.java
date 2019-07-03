package com.neusoft.medical.service.impl;

import com.neusoft.medical.service.basicInfo.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceImplTest {

    @Resource
    PatientService patientService;

    @Test
    public void selectPatientByIdentityCardNo() {
        patientService.selectPatientByIdentityCardNo("1");
    }
}