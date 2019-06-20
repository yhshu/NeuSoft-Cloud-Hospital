package com.neusoft.medical.service.impl;

import com.google.gson.*;
import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.Util.MathUtil;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.ChargeEntryMapper;
import com.neusoft.medical.dao.ChargeItemMapper;
import com.neusoft.medical.dao.ExaminationMapper;
import com.neusoft.medical.dao.RegistrationMapper;
import com.neusoft.medical.service.doctorWorkstation.ExaminationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.neusoft.medical.Util.Constant.EXPENSE_CATEGORY_EXAM;

@Service
public class ExaminationServiceImpl implements ExaminationService {
    @Resource
    private ChargeItemMapper chargeItemMapper;
    @Resource
    private ExaminationMapper examinationMapper;
    @Resource
    private ChargeEntryMapper chargeEntryMapper;
    @Resource
    private RegistrationMapper registrationMapper;

    private Gson gson = new Gson();

    @Override
    public boolean addExamination(String examinationJson) {
        // 首先获取 json 字符串中的属性值，然后将提交的信息加入到 examination 表和 charge_entry 表
        try {
            System.out.println("添加检查检验项目　Json 字符串: " + examinationJson);
            JsonObject examinationJsonObject = new JsonParser().parse(examinationJson).getAsJsonObject();
            int registrationId = examinationJsonObject.get("registrationId").getAsInt();
            int saveState = examinationJsonObject.get("saveState").getAsInt();
            String examName = examinationJsonObject.get("examName").getAsString();
            String clinicalImpression = examinationJsonObject.get("clinicalImpression").getAsString();
            String requirement = examinationJsonObject.get("requirement").getAsString();
            String examResult = examinationJsonObject.get("examResult").getAsString();
            JsonArray chargeEntryListJsonArray = examinationJsonObject.get("chargeEntryList").getAsJsonArray();

            Registration registration = registrationMapper.selectByPrimaryKey(registrationId);
            Examination examinationRecord = new Examination(null, registrationId, registration.getPatientName(), registration.getDoctorId(), registration.getDepartmentId(), saveState, examName, clinicalImpression, requirement, examResult, 1, null, null, null);
            examinationMapper.insert(examinationRecord);
            int examinationId = examinationRecord.getExaminationId();

            for (JsonElement chargeEntryJsonElement : chargeEntryListJsonArray) {
                JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                int chargeItemId = chargeEntryJsonObject.get("chargeItemId").getAsInt();
                int nums = chargeEntryJsonObject.get("nums").getAsInt();
                int collectorId = chargeEntryJsonObject.get("collectorId").getAsInt();
                String doctorAdvice = chargeEntryJsonObject.get("doctorAdvice").getAsString();

                ChargeItem chargeItem = chargeItemMapper.selectByPrimaryKey(chargeItemId);
                double unitPrice = MathUtil.doubleSetScale(chargeItem.getPrice(), 2);
                double totalPrice = MathUtil.doubleSetScale(unitPrice, 2);
                ChargeEntry chargeEntryRecord = new ChargeEntry(null, registrationId, null, chargeItemId, examinationId, unitPrice, totalPrice, nums, nums, nums, Constant.CHARGE_STATUS_NOT_CHARGED, new Date(), registration.getDepartmentId(), registration.getDoctorId(), collectorId, 1, doctorAdvice, null, null, null);
                chargeEntryMapper.insert(chargeEntryRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<ChargeItem> selectExamListInChargeItemByDepartmentId(Integer departmentId) {
        ChargeItemExample chargeItemExample = new ChargeItemExample();
        ChargeItemExample.Criteria criteria = chargeItemExample.createCriteria();
        criteria.andValidEqualTo(1);
        criteria.andDepartmentIdEqualTo(departmentId);
        criteria.andExpenseCategoryIdEqualTo(EXPENSE_CATEGORY_EXAM);

        return chargeItemMapper.selectByExample(chargeItemExample);
    }

    @Override
    public String selectHistoryExam(int registrationId) {
        ExaminationExample examinationExample = new ExaminationExample();
        examinationExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId);

        List<Examination> examinationList = examinationMapper.selectByExample(examinationExample);
        JsonArray examinationJsonArray = gson.toJsonTree(examinationList).getAsJsonArray();
        for (JsonElement examinationJsonElement : examinationJsonArray) {
            JsonObject examinationJsonObject = examinationJsonElement.getAsJsonObject();

            // 针对每项检查，找到其收费项目列表
            ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
            chargeEntryExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId);

        }
        return examinationJsonArray.toString();
    }
}
