package com.neusoft.medical.service.impl;

import com.neusoft.medical.service.basicInfo.DoctorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorServiceImplTest {

    @Resource
    DoctorService doctorService;

    @Test
    public void findAllDoctor() {
        doctorService.findAllDoctor();
    }

    @Test
    public void selectDepartmentDoctorListByDoctorId() {
        doctorService.selectDepartmentDoctorIdListByDoctorId(1);
    }

    @Test
    public void selectDepartmentDoctorIdListByDoctorId() {
        doctorService.selectDepartmentDoctorListByDoctorId(1);
    }
}