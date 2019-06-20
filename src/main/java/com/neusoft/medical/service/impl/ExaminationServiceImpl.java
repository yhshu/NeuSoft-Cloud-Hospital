package com.neusoft.medical.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
            JsonObject examinationJsonObject = gson.toJsonTree(examinationJson).getAsJsonObject();
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

            for (JsonElement chargeEntryJsonElement : chargeEntryListJsonArray) {
                JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                int chargeItemId = chargeEntryJsonObject.get("chargeItemId").getAsInt();
                int nums = chargeEntryJsonObject.get("nums").getAsInt();
                int collectorId = chargeEntryJsonObject.get("collectorId").getAsInt();
                String doctorAdvice = chargeEntryJsonObject.get("doctorAdvice").getAsString();

                ChargeItem chargeItem = chargeItemMapper.selectByPrimaryKey(chargeItemId);
                double unitPrice = MathUtil.doubleSetScale(chargeItem.getPrice(), 2);
                double totalPrice = MathUtil.doubleSetScale(unitPrice, 2);
                ChargeEntry chargeEntryRecord = new ChargeEntry(null, registrationId, null, chargeItemId, unitPrice, totalPrice, nums, nums, nums, Constant.CHARGE_STATUS_NOT_CHARGED, new Date(), registration.getDepartmentId(), registration.getDoctorId(), collectorId, 1, doctorAdvice, null, null, null);
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
}
