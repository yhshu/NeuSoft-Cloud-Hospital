package com.neusoft.medical.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.neusoft.medical.bean.ChargeEntry;
import com.neusoft.medical.bean.ChargeEntryExample;
import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.dao.*;
import com.neusoft.medical.service.techWorkstation.MedicalTechService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static java.lang.Math.min;

@Service
public class MedicalTechServiceImpl implements MedicalTechService {
    @Resource
    private PatientMapper patientMapper;
    @Resource
    private RegistrationMapper registrationMapper;
    @Resource
    private ChargeEntryMapper chargeEntryMapper;
    @Resource
    private ChargeItemMapper chargeItemMapper;
    @Resource
    private DoctorMapper doctorMapper;

    private Gson gson = new Gson();

    @Override
    public Patient selectPatient(int registrationId) {
        Registration registration = registrationMapper.selectByPrimaryKey(registrationId);
        return patientMapper.selectByPrimaryKey(registration.getPatientId());
    }

    @Override
    public String selectChargeEntryList(int registrationId) {
        String res = null;
        try {
            ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
            chargeEntryExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId);
            List<ChargeEntry> chargeEntryList = chargeEntryMapper.selectByExample(chargeEntryExample);
            JsonArray chargeEntryListJsonArray = gson.toJsonTree(chargeEntryList).getAsJsonArray();

            for (JsonElement chargeEntryJsonElement : chargeEntryListJsonArray) {
                JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                chargeEntryJsonObject.addProperty("doctorName", doctorMapper.selectByPrimaryKey(chargeEntryJsonObject.get("doctorId").getAsInt()).getDoctorName());  // 医生姓名
                chargeEntryJsonObject.addProperty("chargeItemNameZh", chargeItemMapper.selectByPrimaryKey(chargeEntryJsonObject.get("chargeItemId").getAsInt()).getNameZh());  // 药品中文名称
                chargeEntryJsonObject.addProperty("price", chargeItemMapper.selectByPrimaryKey(chargeEntryJsonObject.get("chargeItemId").getAsInt()).getPrice());  // 药品单价
            }

            res = chargeEntryListJsonArray.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }

    @Override
    public boolean chargeEntryListApply(List<Integer> chargeEntryIdList) {
        try {
            ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
            ChargeEntryExample.Criteria criteria = chargeEntryExample.createCriteria();
            criteria.andValidEqualTo(1).andChargeEntryIdIn(chargeEntryIdList);

            ChargeEntry record = new ChargeEntry();
            record.setNotGivenNums(0);
            chargeEntryMapper.updateByExampleSelective(record, chargeEntryExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean chargeEntryListRefund(String chargeEntryListRefundJson) {
        try {
            JsonArray medicineReturnJsonArray = gson.toJsonTree(chargeEntryListRefundJson).getAsJsonArray();
            for (JsonElement chargeEntryRefundJsonElement : medicineReturnJsonArray) {
                JsonObject chargeEntryRefundJsonObject = chargeEntryRefundJsonElement.getAsJsonObject();
                int chargeEntryId = chargeEntryRefundJsonObject.get("chargeEntryId").getAsInt();
                int returnNums = chargeEntryRefundJsonObject.get("returnNums").getAsInt();

                ChargeEntry chargeEntry = chargeEntryMapper.selectByPrimaryKey(chargeEntryId);
                chargeEntry.setNotGivenNums(min(chargeEntry.getNotGivenNums() + returnNums, chargeEntry.getNums()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
