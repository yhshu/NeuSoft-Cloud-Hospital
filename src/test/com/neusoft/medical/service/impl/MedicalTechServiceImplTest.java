package com.neusoft.medical.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
        for (int i = 0;i<30;i++)
        medicalTechService.selectChargeEntryList(i);
    }

    @Test
    /**
     * 交付收费项目
     *
     * @param chargeEntryListJson 收费项目信息，json 数组
     * @return 操作结果
     * chargeEntryListJson 数组中每个元素包含的属性：
     * - chargeEntryId 收费项目编号
     * - executionNums 此次消耗的项目数
     */
    public void chargeEntryListDelivery() {
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("chargeEntryId",20);
        jsonObject.addProperty("executionNums",2);
        jsonArray.add(jsonObject);
        medicalTechService.chargeEntryListDelivery(jsonArray.toString());
    }

    @Test
    /**
     * 收费项目退费
     * 收费项目只有在执行前可退，执行后的收费项目无法退费
     *
     * @param chargeEntryListRefundJson 退费信息，json 字符串
     * @return 操作结果
     * <p>
     * 退费信息 json 字符串是 json 数组，该数组中的每项元素包含如下属性：
     * - chargeId 收费项目的编号，int 型
     * - returnNums   退费数量，int 型
     */
    public void chargeEntryListRefund() {
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("chargeId",20);
        jsonObject.addProperty("returnNums",2);
        jsonArray.add(jsonObject);
        medicalTechService.chargeEntryListRefund(jsonArray.toString());
    }
}