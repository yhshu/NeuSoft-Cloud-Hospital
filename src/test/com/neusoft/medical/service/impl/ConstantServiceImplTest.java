package com.neusoft.medical.service.impl;

import com.neusoft.medical.dao.ConstantItemMapper;
import com.neusoft.medical.dao.ConstantTypeMapper;
import com.neusoft.medical.service.ConstantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConstantServiceImplTest {

    @Resource
    ConstantService constantService;
    @Resource
    ConstantTypeMapper constantTypeMapper;
    @Resource
    ConstantItemMapper constantItemMapper;

    @Test
    public void getConstantTypeId() {
    }

    @Test
    public void getConstantItemList() {
    }

    @Test
    public void getConstantIdToNameMap() {
    }

    @Test
    public void getConstantIdToNameList() {
    }

    @Test
    public void getConstantNameToIdMap() {
    }

    @Test
    public void getAccountTypeName() {
        constantService.getAccountTypeName("5");
    }
}