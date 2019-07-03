package com.neusoft.medical.service.impl;

import com.neusoft.medical.service.doctorWorkstation.OutpatientMedicalRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutpatientMedicalRecordServiceImplTest {

    @Resource
    OutpatientMedicalRecordService outpatientMedicalRecordService;
    @Resource

    @Test
    public void waitingRegistrationList() {
        outpatientMedicalRecordService.waitingRegistrationList(5,1);
    }

    @Test
    public void visitedRegistrationList() {
        outpatientMedicalRecordService.visitedRegistrationList(5,1);
    }

    @Test
    public void saveMedicalRecord() {
        outpatientMedicalRecordService.saveMedicalRecord("");
    }

    @Test
    public void saveMedicalRecordTemplate() {
        outpatientMedicalRecordService.saveMedicalRecordTemplate(1,"mainInfo","currentDisease","pastDisease","physicalExam","auxiliaryExam","opinion",1,1,"templateName");
    }

    @Test
    public void selectMedicalRecordsTemplateList() {
        outpatientMedicalRecordService.selectMedicalRecordsTemplateList(5,1);
    }

    @Test
    public void endRegistration() {
        outpatientMedicalRecordService.endRegistration(1);
    }

    @Test
    public void selectPatientHistoryMedicalRecords() {
        outpatientMedicalRecordService.selectPatientHistoryMedicalRecords(1);
    }

    @Test
    public void deleteMedicalRecords() {
        List<Integer> medicalRecordsIdList = new ArrayList<>();
        outpatientMedicalRecordService.deleteMedicalRecords(medicalRecordsIdList);
    }
}