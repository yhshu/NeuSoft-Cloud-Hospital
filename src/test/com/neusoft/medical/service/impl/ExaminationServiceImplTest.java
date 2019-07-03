package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Examination;
import com.neusoft.medical.dao.ExaminationMapper;
import com.neusoft.medical.service.doctorWorkstation.ExaminationService;
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
public class ExaminationServiceImplTest {

    @Resource
    ExaminationService examinationService;
    @Resource
    ExaminationMapper examinationMapper;

    @Test
    public void addExamination() {
        examinationService.addExamination("");
    }

    @Test
    public void selectExamListInChargeItemByDepartmentId() {
        examinationService.selectExamListInChargeItemByDepartmentId(1);
    }

    @Test
    public void selectHistoryExam() {
        examinationService.selectHistoryExam(1);
    }

    @Test
    public void selectUnpaidExam() {
        examinationService.selectUnpaidExam(1);
    }

    @Test
    public void selectExam() {
        Examination examination = new Examination(1,1,"patientName",1,1,1,1,1,"examName","clinicallmpression","requirement","examRusult",1,null,null,null);
        examinationMapper.insert(examination);
        List<Integer> payStateList = new ArrayList<>();
        payStateList.add(examination.getExaminationId());
        examinationService.selectExam(1,payStateList);
    }

    @Test
    public void updateExamResult() {
        examinationService.updateExamResult("");
    }

    @Test
    public void deleteUnpaidChargeEntry() {
        Examination examination = new Examination(1,1,"patientName",1,1,1,1,1,"examName","clinicallmpression","requirement","examRusult",1,null,null,null);
        examinationMapper.insert(examination);
        List<Integer> chargeEntryIdList = new ArrayList<>();
        chargeEntryIdList.add(examination.getExaminationId());
        examinationService.deleteUnpaidChargeEntry(chargeEntryIdList);
    }

    @Test
    public void deleteExaminationList() {
        Examination examination = new Examination(1,1,"patientName",1,1,1,1,1,"examName","clinicallmpression","requirement","examRusult",1,null,null,null);
        examinationMapper.insert(examination);
        List<Integer> examinationIdList = new ArrayList<>();
        examinationIdList.add(examination.getExaminationId());
        examinationService.deleteExaminationList(examinationIdList);
    }

    @Test
    public void selectExaminationTemplate() {
        examinationService.selectExaminationTemplate(1,1);
    }

    @Test
    public void examinationListToJson() {
        Examination examination = new Examination(1,1,"patientName",1,1,1,1,1,"examName","clinicallmpression","requirement","examRusult",1,null,null,null);
        examinationMapper.insert(examination);
        List<Examination> examinationList = new ArrayList<>();
        examinationService.examinationListToJson(examinationList);
    }

    @Test
    public void selectExaminationAbstract() {
        examinationService.selectExaminationAbstract(1);
    }

    @Test
    public void updateExaminationAbstract() {
        examinationService.updateExaminationAbstract("");
    }
}