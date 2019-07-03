package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Prescription;
import com.neusoft.medical.dao.PrescriptionMapper;
import com.neusoft.medical.service.doctorWorkstation.PrescriptionService;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrescriptionServiceImplTest {

    @Resource
    PrescriptionService prescriptionService;
    @Resource
    PrescriptionMapper prescriptionMapper;

    @Test
    public void selectMedicine() {
        prescriptionService.selectMedicine();
    }

    @Test
    public void searchMedicine() {
        Prescription prescription = new Prescription(10,"nikam",10,10,10,1,null,null,null);
        prescriptionMapper.insert(prescription);
        prescriptionService.searchMedicine(10,"n");
    }

    @Test
    public void commonMedicine() {
        prescriptionService.commonMedicine(19);
    }

    @Test
    public void savePrescription() {
        prescriptionService.savePrescription("");
    }

    @Test
    public void selectHistoryPrescription() {
        prescriptionService.selectHistoryPrescription(1);
    }

    @Test
    public void selectUnpaidPrescription() {
        prescriptionService.selectHistoryPrescription(1);
    }

    @Test
    public void selectPrescriptionTemplate() {
        prescriptionService.selectPrescriptionTemplate(5,1);
    }

    @Test
    public void prescriptionListToJson() {
        List<Prescription> prescriptionList = new ArrayList<>();
        List<Integer> saveSateList = new ArrayList<>();
        prescriptionService.prescriptionListToJson(prescriptionList,saveSateList);
    }

    @Test
    public void deletePrescription() {
        Prescription prescription = new Prescription(10,"Name",1,10,1,1,null,null,null);
        prescriptionMapper.insert(prescription);
        List<Integer> prescriptionIdList = new ArrayList<>();
        prescriptionIdList.add(prescription.getPrescriptionId());
        prescriptionService.deletePrescription(prescriptionIdList);
    }

    @Test
    public void selectPrescriptionList() {
        prescriptionService.selectPrescriptionList(1);
    }
}