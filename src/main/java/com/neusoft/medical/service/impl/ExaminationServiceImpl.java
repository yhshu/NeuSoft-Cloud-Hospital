package com.neusoft.medical.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.bean.ChargeItemExample;
import com.neusoft.medical.dao.ChargeItemMapper;
import com.neusoft.medical.service.doctorWorkstation.ExaminationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Resource
    private ChargeItemMapper chargeItemMapper;

    private Gson gson = new Gson();

    @Override
    public boolean addExamination(String examinationJson) {
        try {
            JsonObject examinationJsonObject = gson.toJsonTree(examinationJson).getAsJsonObject();
            int registrationId = examinationJsonObject.get("registrationId").getAsInt();
            int saveState = examinationJsonObject.get("saveState").getAsInt();
            String examName = examinationJsonObject.get("examName").getAsString();
            String clinicalImpression = examinationJsonObject.get("clinicalImpression").getAsString();
            String requirement = examinationJsonObject.get("requirement").getAsString();
            String examResult = examinationJsonObject.get("examResult").getAsString();
            JsonArray chargeEntryListJsonArray = examinationJsonObject.get("chargeEntryList").getAsJsonArray();

            for (JsonElement chargeEntryJsonElement : chargeEntryListJsonArray) {
                JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                
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
