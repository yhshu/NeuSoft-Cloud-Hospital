package com.neusoft.medical.service.impl;

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
    public void saveMedicine() {
        medicineCatalogService.saveMedicine("");
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