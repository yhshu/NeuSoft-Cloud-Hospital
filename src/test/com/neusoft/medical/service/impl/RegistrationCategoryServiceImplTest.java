package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.bean.RegistrationCategory;
import com.neusoft.medical.dao.RegistrationCategoryMapper;
import com.neusoft.medical.dao.RegistrationMapper;
import com.neusoft.medical.service.basicInfo.RegistrationCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationCategoryServiceImplTest {

    @Resource
    RegistrationCategoryService registrationCategoryService;
    @Resource
    RegistrationCategoryMapper registrationCategoryMapper;

    @Test
    public void selectRegistrationCategory() {
        registrationCategoryService.selectRegistrationCategory(1,20);
    }

    @Test
    public void addRegistrationCategory() {
        registrationCategoryService.addRegistrationCategory("registrationCategoryName",true,1,5.64);
    }

    @Test
    public void updateRegistrationCategoryByPrimaryKey() {
        registrationCategoryService.updateRegistrationCategoryByPrimaryKey(10,"registrationCategoryName",true,1,5.64);
    }

    @Test
    public void deleteRegistrationCategoryByPrimaryKey() {
        RegistrationCategory registration = new RegistrationCategory(1,"name",true,1,5.64,1);
        registrationCategoryMapper.insert(registration);
        List<Integer> registrationCategoryId = new ArrayList<>();
        registrationCategoryId.add(registration.getRegistrationCategoryId());
        registrationCategoryService.deleteRegistrationCategoryByPrimaryKey(registrationCategoryId);
    }

    @Test
    public void selectAllRegistrationCategory() {
        registrationCategoryService.selectAllRegistrationCategory();
    }

    @Test
    public void registrationFee() {
        registrationCategoryService.registrationFee(1);
    }
}