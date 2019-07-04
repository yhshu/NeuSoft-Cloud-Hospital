package com.neusoft.medical.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
    /**
     * 保存处方（三种保存状态：暂存、提交、存为模板）
     *
     * @param prescriptionJson 表示处方信息的 json 字符串
     * @return 操作结果
     * 该 json 字符串包含的属性：
     * - prescriptionId 处方编号（新增时填 -1，更新时填被更新的编号）
     * - prescriptionName 处方名称
     * - registrationId 挂号单编号（暂存或正式提交 必填，模板 可空）
     * - doctorId 创建模板的医生编号（暂存或正式提交 可空，模板 必填）
     * - saveState 保存状态（暂存 0；正式提交 1；全院模板 2；科室模板 3；医生个人模板 4）
     * - medicine 处方中包含的药物清单，json 数组
     * <p>
     * - medicine 数组中每个元素包含的属性：
     * - medicineId 处方药品编号
     * - unitPrice 药品单价
     * - nums 药品数量
     * - medicineUsage 药品用途
     * - medicineDosage 药品用量
     * - medicineFrequency 药品使用频率
     * - medicineNumberDay 药品使用天数
     * - skinTest 皮试
     * - skinTestResult 皮试结果
     * - doctorAdvice 医嘱
     */
    public void savePrescription() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("prescriptionId",18);
        jsonObject.addProperty("prescriptionName","处方名称");
        jsonObject.addProperty("registrationId",34);
        jsonObject.addProperty("doctorId",1);
        jsonObject.addProperty("saveState",1);
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject1 = new JsonObject();
        jsonObject1.addProperty("medicineId",48);
        jsonObject1.addProperty("unitPrice",50);
        jsonObject1.addProperty("nums",400);
        jsonObject1.addProperty("medicineUsage","药品用量");
        jsonObject1.addProperty("medicineDosage","药品用量");
        jsonObject1.addProperty("medicineFrequency","药品使用频率");
        jsonObject1.addProperty("medicineNumberDay","药品使用天数");
        jsonObject1.addProperty("skinTest","皮试");
        jsonObject1.addProperty("skinTestResult","皮试结果");
        jsonObject1.addProperty("doctorAdvice","医嘱");
        jsonArray.add(jsonObject1);
        jsonObject.add("medicine",jsonArray);
        prescriptionService.savePrescription(jsonObject.toString());
    }

    @Test
    public void selectHistoryPrescription() {
        for (int i = 0; i<100;i++)
            prescriptionService.selectHistoryPrescription(i);
    }

    @Test
    public void selectUnpaidPrescription() {
        for (int i = 0; i<100;i++)
        prescriptionService.selectHistoryPrescription(i);
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
        for (int i = 0; i<100;i++)
        prescriptionService.selectPrescriptionList(i);
    }
}