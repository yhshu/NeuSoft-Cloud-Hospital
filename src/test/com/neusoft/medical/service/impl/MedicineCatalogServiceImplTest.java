package com.neusoft.medical.service.impl;

import com.google.gson.JsonObject;
import com.neusoft.medical.bean.Medicine;
import com.neusoft.medical.service.pharmacyWorkstation.MedicineCatalogService;
import com.neusoft.medical.service.techWorkstation.MedicalTechService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineCatalogServiceImplTest {

    @Resource
    MedicineCatalogService medicineCatalogService;

    @Test
    public void selectMedicine() {
        medicineCatalogService.selectMedicine(1,20);
    }

    @Test
    /**
     * 保存药品信息
     *
     * @param medicineJson 药品信息 json 字符串
     * @return 操作结果
     * medicineJson 字符串中包含的属性：
     * - medicineId            药品编号（新增时不填，更新时必填）
     * - medicineCode          药品代码
     * - nameZh                中文名称
     * - medicineSpecification 规格
     * - medicineUnit          包装单位
     * - medicineManufacturer  制造商
     * - medicineDosageId      剂型编号
     * - medicineTypeId        类型编号
     * - medicinePrice         单价
     * - namePinyin            药品名称拼音
     * - nums                  库存数目
     * - nameEn                英文名称
     */
    public void saveMedicine() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("medicineId",99);
        jsonObject.addProperty("medicineCode","药品代码");
        jsonObject.addProperty("nameZh","中文名称");
        jsonObject.addProperty("medicineSpecification","规格");
        jsonObject.addProperty("medicineUnit","包装单位");
        jsonObject.addProperty("medicineManufacturer","制作商");
        jsonObject.addProperty("medicineDosageId","剂型编号");
        jsonObject.addProperty("medicineTypeId","类型编号");
        jsonObject.addProperty("medicinePrice","9.9");
        jsonObject.addProperty("namePinyin","pinyin");
        jsonObject.addProperty("nums",45);
        jsonObject.addProperty("nameEn","english");
        medicineCatalogService.saveMedicine(jsonObject.toString());
    }

    @Test
    public void deleteMedicine() {
        Date today = new Date();
        Medicine medicine = new Medicine(1,"001","nameZh","medicineSpecification","medicineUnit","medicineManufacturer",1,1,0.1,"namePinYin",today,12,"nameEn",1,null,null,null);
        List<Integer> medicineIdList = new ArrayList<>();
        medicineIdList.add(medicine.getMedicineId());
        medicineCatalogService.deleteMedicine(medicineIdList);
    }
}