package com.neusoft.medical.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
    /**
     * 新增检查检验项目
     *
     * @param examinationJson 检查检验项目信息，json 字符串
     * @return 操作结果
     * examinationJson 中包含的属性如下：
     * - registrationId 挂号单编号 （正式提交 必填，暂存 选填，模板 不填）
     * - saveState 保存状态（暂存 0；正式提交 1；全院模板 2；科室模板 3；医生个人模板 4）
     * - examName 检查名称
     * - clinicalImpression 临床印象
     * - requirement 目的和要求
     * - examResult 检验报告
     * - chargeEntryList 收费项目列表，以 json 数组表示
     * chargeEntryList 数组中的每项元素包含的属性如下：
     * - chargeItemId 收费项目编号
     * - nums 收费项目计数
     * - doctorAdvice 医嘱
     */
    public void addExamination() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("registrationId",10);
        jsonObject.addProperty("saveState",1);
        jsonObject.addProperty("examName","检查名称");
        jsonObject.addProperty("clinicalImpression","临床印象");
        jsonObject.addProperty("requirement","目的和要求");
        jsonObject.addProperty("examResult","检验报告");

        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject1 = new JsonObject();
        jsonObject1.addProperty("chargeItemId",10);
        jsonObject1.addProperty("nums",10);
        jsonObject1.addProperty("doctorAdvice","医嘱");
        jsonArray.add(jsonObject1);
        jsonObject.add("chargeEntryList",jsonArray);

        examinationService.addExamination(jsonObject.toString());
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
    /**
     * 执行检查
     * 更改检查状态，提交检查结果
     * <p>
     * 修改检查的临床印象、检查结果
     * 修改收费项目的尚未交付数量
     *
     * @param examinationJson 检查信息，json 字符串
     * @return 操作结果
     * <p>
     * examinationJson 中的属性包括：
     * - examinationId 检查检验编号
     * - clinicalImpression 临床印象
     * - examResult 检查结果
     * <p>
     * examinationJson 中包含的收费项目列表，属性名为 chargeEntryList
     * - not_given_nums 在执行检查检验后，尚未交付的项目数量
     */
    public void updateExamResult() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("examinationId","检查检验编号");
        jsonObject.addProperty("clinicalImpression","临床印象");
        jsonObject.addProperty("examResult","检查结果");

        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject1 = new JsonObject();
        jsonObject1.addProperty("not_given_nums",1);
        jsonArray.add(jsonObject1);
        jsonObject.add("chargeEntryList",jsonArray);
        examinationService.updateExamResult(jsonObject.toString());
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