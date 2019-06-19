package com.neusoft.medical.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.neusoft.medical.bean.ChargeForm;
import com.neusoft.medical.bean.ChargeFormExample;
import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.dao.*;
import com.neusoft.medical.service.pharmacyWorkstation.MedicineDistributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MedicineDistributeServiceImpl implements MedicineDistributeService {
    @Resource
    private PatientMapper patientMapper;
    @Resource
    private RegistrationMapper registrationMapper;
    @Resource
    private ChargeFormMapper chargeFormMapper;
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
    public String selectChargeFormList(int registrationId) {
        String res = null;
        try {
            ChargeFormExample chargeFormExample = new ChargeFormExample();
            chargeFormExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId);
            List<ChargeForm> chargeFormList = chargeFormMapper.selectByExample(chargeFormExample);
            JsonArray chargeFormJsonArray = gson.toJsonTree(chargeFormList).getAsJsonArray();

            for (JsonElement chargeFormJsonElement : chargeFormJsonArray) {
                JsonObject chargeFormJsonObject = chargeFormJsonElement.getAsJsonObject();
                chargeFormJsonObject.addProperty("doctorName", doctorMapper.selectByPrimaryKey(chargeFormJsonObject.get("doctorId").getAsInt()).getDoctorName());  // 医生姓名
                chargeFormJsonObject.addProperty("chargeItemNameZh", chargeItemMapper.selectByPrimaryKey(chargeFormJsonObject.get("chargeItemId").getAsInt()).getNameZh());  // 药品中文名称
                chargeFormJsonObject.addProperty("price", chargeItemMapper.selectByPrimaryKey(chargeFormJsonObject.get("chargeItemId").getAsInt()).getPrice());  // 药品单价
            }

            res = chargeFormJsonArray.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }
}
