package com.neusoft.medical.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.dao.ChargeItemMapper;
import com.neusoft.medical.service.doctorWorkstation.DisposalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DisposalServiceImpl implements DisposalService {
    @Resource
    private ChargeItemMapper chargeItemMapper;

    @Override
    public boolean addDisposal(String disposalJson) {
        try {
            JsonObject disposalJsonObject = new JsonParser().parse(disposalJson).getAsJsonObject();
            int registrationId = disposalJsonObject.get("registrationId").getAsInt();
            JsonArray chargeEntryListJsonArray = disposalJsonObject.get("chargeEntryList").getAsJsonArray();
            // todo

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<ChargeItem> selectDisposalItemListInChargeItemByDepartmentId(int departmentId) {

        return null;
    }

    @Override
    public String selectHistoryDisposal(Integer registrationId) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateDisposal(String disposalJson) {
        try {
            JsonObject disposalJsonObject = new JsonParser().parse(disposalJson).getAsJsonObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
