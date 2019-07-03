package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.SettlementCategory;
import com.neusoft.medical.dao.SettlementCategoryMapper;
import com.neusoft.medical.service.basicInfo.SettlementCategoryService;
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
public class SettlementCategoryServiceImplTest {

    @Resource
    SettlementCategoryService settlementCategoryService;
    @Resource
    SettlementCategoryMapper settlementCategoryMapper;

    @Test
    public void selectSettlementCategory() {
        settlementCategoryService.selectSettlementCategory(1,20);
    }

    @Test
    public void deleteSettlementCategory() {
        SettlementCategory settlementCategory = new SettlementCategory(10,"settlementCategoryName",1,null,null,null);
        List<Integer> settlementCategoryIdList = new ArrayList<>();
        settlementCategoryMapper.insert(settlementCategory);
        settlementCategoryIdList.add(settlementCategory.getSettlementCategoryId());
        settlementCategoryService.deleteSettlementCategory(settlementCategoryIdList);
    }

    @Test
    public void saveSettlementCategory() {
        settlementCategoryService.saveSettlementCategory(15,"自费");
    }

    @Test
    public void selectAllSettlementCategory() {
        settlementCategoryService.selectAllSettlementCategory();
    }
}