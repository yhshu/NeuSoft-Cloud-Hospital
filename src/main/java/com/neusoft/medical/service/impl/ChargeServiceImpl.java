package com.neusoft.medical.service.impl;

import com.google.gson.*;
import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.ChargeEntryMapper;
import com.neusoft.medical.dao.InvoiceMapper;
import com.neusoft.medical.dao.PrescriptionEntryMapper;
import com.neusoft.medical.dao.RegistrationMapper;
import com.neusoft.medical.service.registration.ChargeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static java.lang.Math.max;

@Service
public class ChargeServiceImpl implements ChargeService {
    @Resource
    private ChargeEntryMapper chargeEntryMapper;
    @Resource
    private PrescriptionEntryMapper prescriptionEntryMapper;
    @Resource
    private RegistrationMapper registrationMapper;
    @Resource
    private InvoiceMapper invoiceMapper;

    private Gson gson = new Gson();

    @Override
    public boolean checkout(String checkoutJson) {
        try {
            JsonObject checkoutJsonObject = new JsonParser().parse(checkoutJson).getAsJsonObject();

            String invoiceTitle = checkoutJsonObject.get("invoiceTitle").getAsString();
            int collectorId = checkoutJsonObject.get("collectorId").getAsInt();
            double invoiceAmount = checkoutJsonObject.get("invoiceAmount").getAsDouble();
            double selfPay = checkoutJsonObject.get("selfPay").getAsDouble();
            double accountPay = checkoutJsonObject.get("accountPay").getAsDouble();
            double reimbursementPay = checkoutJsonObject.get("reimbursementPay").getAsDouble();
            double discounted = checkoutJsonObject.get("discounted").getAsDouble();
            int invoiceState = checkoutJsonObject.get("invoiceState").getAsInt();
            JsonArray entryListJsonArray = checkoutJsonObject.get("entryList").getAsJsonArray();

            for (JsonElement entryJsonElement : entryListJsonArray) {
                JsonObject entryJsonObject = entryJsonElement.getAsJsonObject();

                int entryType = entryJsonObject.get("entryType").getAsInt();
                int entryId = entryJsonObject.get("entryId").getAsInt();

                // 处理收费条目：chargeEntry 或 prescriptionEntry
                if (entryType == Constant.ENTRY_TYPE_CHARGE_ENTRY) {
                    ChargeEntry chargeEntryRecord = chargeEntryMapper.selectByPrimaryKey(entryId);
                    chargeEntryRecord.setPayState(Constant.PAY_STATE_CHARGED);
                    chargeEntryRecord.setUnchargedNums(0);
                    chargeEntryMapper.updateByPrimaryKeySelective(chargeEntryRecord);
                } else if (entryType == Constant.ENTRY_TYPE_PRESCRIPTION_ENTRY) {
                    PrescriptionEntry prescriptionEntryRecord = prescriptionEntryMapper.selectByPrimaryKey(entryId);
                    prescriptionEntryRecord.setPayState(Constant.PAY_STATE_CHARGED);
                    prescriptionEntryMapper.updateByPrimaryKeySelective(prescriptionEntryRecord);
                } else {
                    throw new Exception("The value of entryType is null or wrong.");
                }

                // 处理支付记录
                Invoice invoiceRecord = new Invoice(null, invoiceTitle, collectorId, new Date(), invoiceAmount, selfPay, accountPay, reimbursementPay, discounted, Constant.INVOICE_VALID, 1);
                invoiceMapper.insert(invoiceRecord);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean refund(String refundJson) {
        try {
            JsonArray refundJsonArray = new JsonParser().parse(refundJson).getAsJsonArray();
            for (JsonElement refundJsonElement : refundJsonArray) {
                JsonObject refundJsonObject = refundJsonElement.getAsJsonObject();
                int entryType = refundJsonObject.get("entryType").getAsInt();
                int entryId = refundJsonObject.get("entryId").getAsInt();
                int refundNums = refundJsonObject.get("refundNums").getAsInt();

                if (entryType == Constant.ENTRY_TYPE_CHARGE_ENTRY) {
                    ChargeEntry chargeEntryRecord = chargeEntryMapper.selectByPrimaryKey(entryId);
                    chargeEntryRecord.setNotGivenNums(max(chargeEntryRecord.getNotGivenNums() - refundNums, 0));
                    if (chargeEntryRecord.getNotGivenNums() == 0)
                        chargeEntryRecord.setPayState(Constant.PAY_STATE_RETURNED);
                    chargeEntryMapper.updateByPrimaryKeySelective(chargeEntryRecord);
                } else if (entryType == Constant.ENTRY_TYPE_PRESCRIPTION_ENTRY) {
                    PrescriptionEntry prescriptionEntryRecord = prescriptionEntryMapper.selectByPrimaryKey(entryId);
                    prescriptionEntryRecord.setNotGivenNums(max(prescriptionEntryRecord.getNotGivenNums() - refundNums, 0));
                    if (prescriptionEntryRecord.getNotGivenNums() == 0)
                        prescriptionEntryRecord.setPayState(Constant.PAY_STATE_RETURNED);
                    prescriptionEntryMapper.updateByPrimaryKeySelective(prescriptionEntryRecord);
                } else {
                    throw new Exception("The value of entryType is null or wrong.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean withdrawRegistration(Integer registrationId) {
        try {
            RegistrationExample registrationExample = new RegistrationExample();
            registrationExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId).andIsVisitedEqualTo(Constant.REGIST_NOT_VISITED);

            List<Registration> registrationList = registrationMapper.selectByExample(registrationExample);
            assert registrationList != null && registrationList.size() <= 1;
            Registration registration = registrationList.get(0);
            registration.setRegistrationStatus(Constant.REGIST_WITHDRAW);
            registrationMapper.updateByPrimaryKeySelective(registration);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
