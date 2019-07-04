package com.neusoft.medical.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
    /**
     * 修改药品项目数目
     * 交付药品或收到退药
     *
     * @param prescriptionEntryListJson 药品项目信息，json 数组
     * @return 操作结果
     * prescriptionEntryListJson 数组中每个元素包含的属性：
     * - prescriptionEntryId 药品项编号
     * - executionNums       变动的药品数（交付药品为正数，收到退药为负数）
     */
    public void prescriptionEntryDelivery() {
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("prescriptionEntryId",45);
        jsonObject.addProperty("executionNums",7);
        jsonArray.add(jsonObject);
        distributionService.prescriptionEntryDelivery(jsonArray.toString());
    }
}