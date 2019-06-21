package com.neusoft.medical.service.impl;

import com.google.gson.*;
import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.Util.MathUtil;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.ChargeEntryMapper;
import com.neusoft.medical.dao.ChargeFormMapper;
import com.neusoft.medical.dao.ChargeItemMapper;
import com.neusoft.medical.dao.RegistrationMapper;
import com.neusoft.medical.service.doctorWorkstation.DisposalService;
import com.neusoft.medical.service.doctorWorkstation.ExaminationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.neusoft.medical.Util.Constant.EXPENSE_CATEGORY_DISPOSAL;

@Service
public class DisposalServiceImpl implements DisposalService {
    @Resource
    private ChargeItemMapper chargeItemMapper;
    @Resource
    private ChargeFormMapper chargeFormMapper;
    @Resource
    private ChargeEntryMapper chargeEntryMapper;
    @Resource
    private RegistrationMapper registrationMapper;
    @Resource
    private ExaminationService examinationService;

    private Gson gson = new Gson();

    @Override
    public boolean addDisposal(String disposalJson) {
        try {
            // 首先获取 json 字符串中的属性值，然后将提交的信息加入到 charge_form 表和 charge_entry 表
            JsonObject disposalJsonObject = new JsonParser().parse(disposalJson).getAsJsonObject();
            int registrationId = disposalJsonObject.get("registrationId").getAsInt();
            String chargeFormName = disposalJsonObject.get("chargeFormName").getAsString();
            int saveState = disposalJsonObject.get("saveState").getAsInt();
            JsonArray chargeEntryListJsonArray = disposalJsonObject.get("chargeEntryList").getAsJsonArray();

            Registration registration = registrationMapper.selectByPrimaryKey(registrationId);
            ChargeForm chargeFormRecord = new ChargeForm(null, chargeFormName, registrationId, saveState, Constant.PAY_STATE_NOT_CHARGED, Constant.EXEC_NOT_DONE, 1, null, null, null);
            chargeFormMapper.insert(chargeFormRecord);
            int chargeFormId = chargeFormRecord.getChargeFormId();

            for (JsonElement chargeEntryJsonElement : chargeEntryListJsonArray) {
                JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                int chargeItemId = chargeEntryJsonObject.get("chargeItemId").getAsInt();
                int nums = chargeEntryJsonObject.get("nums").getAsInt();
                String doctorAdvice = chargeEntryJsonObject.get("doctorAdvice").getAsString();

                ChargeItem chargeItemRecord = chargeItemMapper.selectByPrimaryKey(chargeItemId);
                double unitPrice = MathUtil.doubleSetScale(chargeItemRecord.getPrice(), 2);
                double totalPrice = MathUtil.doubleSetScale(unitPrice, 2);
                ChargeEntry chargeEntryRecord = new ChargeEntry(null, registrationId, chargeFormId, chargeItemId, null, unitPrice, totalPrice, nums, nums, nums, Constant.PAY_STATE_NOT_CHARGED, new Date(), registration.getDepartmentId(), registration.getDoctorId(), null, 1, doctorAdvice, null, null, null);
                chargeEntryMapper.insert(chargeEntryRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<ChargeItem> selectDisposalItemListInChargeItemByDepartmentId(int departmentId) {
        ChargeItemExample chargeItemExample = new ChargeItemExample();
        ChargeItemExample.Criteria criteria = chargeItemExample.createCriteria();
        criteria.andValidEqualTo(1);
        criteria.andDepartmentIdEqualTo(departmentId);
        criteria.andExpenseCategoryIdEqualTo(EXPENSE_CATEGORY_DISPOSAL);

        return chargeItemMapper.selectByExample(chargeItemExample);
    }

    @Override
    public String selectHistoryDisposal(Integer registrationId) {
        ChargeFormExample chargeFormExample = new ChargeFormExample();
        chargeFormExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId);

        List<ChargeForm> chargeFormList = chargeFormMapper.selectByExample(chargeFormExample);
        JsonArray chargeFormJsonArray = gson.toJsonTree(chargeFormList).getAsJsonArray();
        for (JsonElement chargeFormJsonElement : chargeFormJsonArray) {
            JsonObject chargeFormJsonObject = chargeFormJsonElement.getAsJsonObject();

            int chargeFormId = chargeFormJsonObject.get("chargeFormId").getAsInt();

            // 针对每项处置项目单，找到其处置项目列表
            ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
            chargeEntryExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId).andChargeFormIdEqualTo(chargeFormId);
            List<ChargeEntry> chargeEntryList = chargeEntryMapper.selectByExample(chargeEntryExample);
            JsonArray chargeEntryListJsonArray = gson.toJsonTree(chargeEntryList).getAsJsonArray();
            for (JsonElement chargeEntryJsonElement : chargeEntryListJsonArray) {
                JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                ChargeItem chargeItem = chargeItemMapper.selectByPrimaryKey(chargeEntryJsonObject.get("chargeItemId").getAsInt());
                chargeEntryJsonObject.add("chargeItem", gson.toJsonTree(chargeItem));
            }

            chargeFormJsonObject.add("chargeEntryList", chargeEntryListJsonArray);
        }
        return chargeFormJsonArray.toString();
    }

    @Override
    public boolean updateDisposal(String disposalJson) {
        try {
            JsonObject disposalJsonObject = new JsonParser().parse(disposalJson).getAsJsonObject();
            int chargeFormId = disposalJsonObject.get("chargeFormId").getAsInt();

            JsonArray chargeEntryList = disposalJsonObject.get("chargeEntryList").getAsJsonArray();
            for (JsonElement chargeEntryJsonElement : chargeEntryList) {
                JsonObject chargeEntryJsonObject = chargeEntryJsonElement.getAsJsonObject();
                int chargeEntryId = chargeEntryJsonObject.get("chargeEntryId").getAsInt();
                int notGivenNums = chargeEntryJsonObject.get("notGivenNums").getAsInt();
                ChargeEntry chargeEntryRecord = new ChargeEntry();
                chargeEntryRecord.setChargeEntryId(chargeEntryId);
                chargeEntryRecord.setNotGivenNums(notGivenNums);
                chargeEntryMapper.updateByPrimaryKeySelective(chargeEntryRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteDisposal(List<Integer> chargeEntryIdList) {
        return examinationService.deleteUnpaidChargeEntry(chargeEntryIdList);
    }
}
