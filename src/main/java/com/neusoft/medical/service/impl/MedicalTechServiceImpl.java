package com.neusoft.medical.service.impl;

import com.google.gson.*;
import com.neusoft.medical.bean.ChargeEntry;
import com.neusoft.medical.bean.ChargeEntryExample;
import com.neusoft.medical.dao.*;
import com.neusoft.medical.service.techWorkstation.MedicalTechService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static java.lang.Math.max;
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
    public String selectChargeEntryList(int registrationId) {
        String res;
        try {
            ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
            chargeEntryExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId);
            List<ChargeEntry> chargeEntryList = chargeEntryMapper.selectByExample(chargeEntryExample);
            JsonArray chargeEntryListJsonArray = gson.toJsonTree(chargeEntryList).getAsJsonArray();

            for (JsonElement chargeEntryJsonElement : chargeEntryListJsonArray) {
                JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                chargeEntryJsonObject.addProperty("doctorName", doctorMapper.selectByPrimaryKey(chargeEntryJsonObject.get("doctorId").getAsInt()).getDoctorName());         // 医生姓名
                chargeEntryJsonObject.addProperty("chargeItemNameZh", chargeItemMapper.selectByPrimaryKey(chargeEntryJsonObject.get("chargeItemId").getAsInt()).getNameZh());  // 药品中文名称
                chargeEntryJsonObject.addProperty("price", chargeItemMapper.selectByPrimaryKey(chargeEntryJsonObject.get("chargeItemId").getAsInt()).getPrice());   // 药品单价
            }

            res = chargeEntryListJsonArray.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }

    @Override
    public boolean chargeEntryListDelivery(String chargeEntryListJson) {
        try {
            JsonArray chargeEntryListJsonArray = new JsonParser().parse(chargeEntryListJson).getAsJsonArray();

            for (JsonElement chargeEntryJsonElement : chargeEntryListJsonArray) {
                JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                int chargeEntryId = chargeEntryJsonObject.get("chargeEntryId").getAsInt();
                int executionNums = chargeEntryJsonObject.get("executionNums").getAsInt();

                ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
                chargeEntryExample.or().andValidEqualTo(1).andChargeEntryIdEqualTo(chargeEntryId);

                ChargeEntry chargeEntry = chargeEntryMapper.selectByPrimaryKey(chargeEntryId);
                chargeEntry.setNotGivenNums(max(0, chargeEntry.getNotGivenNums() - executionNums));
                chargeEntryMapper.updateByPrimaryKey(chargeEntry);
            }

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
