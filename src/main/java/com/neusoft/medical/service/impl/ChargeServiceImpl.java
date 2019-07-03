package com.neusoft.medical.service.impl;

import com.google.gson.*;
import com.neusoft.medical.service.ConstantService;
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
            int invoiceNums = checkoutJsonObject.get("invoiceNums").getAsInt();
            int registrationId = checkoutJsonObject.get("registrationId").getAsInt();
            double invoiceAmount = checkoutJsonObject.get("invoiceAmount").getAsDouble();
            double selfPay = checkoutJsonObject.get("selfPay").getAsDouble();
            double accountPay = checkoutJsonObject.get("accountPay").getAsDouble();
            double reimbursementPay = checkoutJsonObject.get("reimbursementPay").getAsDouble();
            double discounted = checkoutJsonObject.get("discounted").getAsDouble();
            int invoiceState = checkoutJsonObject.get("invoiceState").getAsInt();
            JsonArray entryListJsonArray = checkoutJsonObject.get("entryList").getAsJsonArray();

            double examinationFee = 0.0;  // 总检查费
            double disposalFee = 0.0;     // 总处置费
            double prescriptionFee = 0.0; // 总处方费

            for (JsonElement entryJsonElement : entryListJsonArray) {
                JsonObject entryJsonObject = entryJsonElement.getAsJsonObject();

                int entryType = entryJsonObject.get("entryType").getAsInt();
                int entryId = entryJsonObject.get("entryId").getAsInt();

                // 处理收费条目：chargeEntry 或 prescriptionEntry
                if (entryType == ConstantService.ENTRY_TYPE_CHARGE_ENTRY) {
                    ChargeEntry chargeEntryRecord = chargeEntryMapper.selectByPrimaryKey(entryId);
                    if (chargeEntryRecord.getChargeFormId() != null) {
                        disposalFee += chargeEntryRecord.getTotalPrice();
                    } else if (chargeEntryRecord.getExaminationId() != null) {
                        examinationFee += chargeEntryRecord.getTotalPrice();
                    }
                    chargeEntryRecord.setPayState(ConstantService.PAY_STATE_CHARGED);
                    chargeEntryRecord.setUnchargedNums(0);
                    chargeEntryMapper.updateByPrimaryKeySelective(chargeEntryRecord);
                } else if (entryType == ConstantService.ENTRY_TYPE_PRESCRIPTION_ENTRY) {
                    PrescriptionEntry prescriptionEntryRecord = prescriptionEntryMapper.selectByPrimaryKey(entryId);
                    prescriptionFee += prescriptionEntryRecord.getTotalPrice();
                    prescriptionEntryRecord.setPayState(ConstantService.PAY_STATE_CHARGED);
                    prescriptionEntryMapper.updateByPrimaryKeySelective(prescriptionEntryRecord);
                } else {
                    throw new Exception("The value of entryType is null or wrong");
                }

                // 处理支付记录
                Invoice invoiceRecord = new Invoice(null, invoiceTitle, invoiceNums, collectorId, registrationId, new Date(), invoiceAmount, selfPay, accountPay, reimbursementPay, discounted, invoiceState, prescriptionFee, examinationFee, disposalFee, 0.0, 1);
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
            JsonObject refundJsonObject = new JsonParser().parse(refundJson).getAsJsonObject();
            String invoiceTitle = refundJsonObject.get("invoiceTitle").getAsString();
            Integer collectorId = refundJsonObject.get("collectorId").getAsInt();
            Integer invoiceNums = refundJsonObject.get("invoiceNums").getAsInt();
            Integer registrationId = refundJsonObject.get("registrationId").getAsInt();

            JsonArray refundJsonArray = refundJsonObject.getAsJsonArray("entryList");  // 退费项目列表 json 数组
            for (JsonElement refundEntryJsonElement : refundJsonArray) {
                JsonObject refundEntryJsonObject = refundEntryJsonElement.getAsJsonObject(); // 退费项目信息
                int entryType = refundEntryJsonObject.get("entryType").getAsInt();  // 退费项目的类型
                int entryId = refundEntryJsonObject.get("entryId").getAsInt();  // 退费项目的编号
                int refundNums = refundEntryJsonObject.get("refundNums").getAsInt();  // 退费项目的数量

                double refundAmount = 0.0;  // 退费数量
                if (entryType == ConstantService.ENTRY_TYPE_CHARGE_ENTRY) { // 退费项目是检查/检验项目 或 处置项目
                    ChargeEntry chargeEntryRecord = chargeEntryMapper.selectByPrimaryKey(entryId);
                    int notGivenNumsInit = chargeEntryRecord.getNotGivenNums();  // 退费之前的尚未交付数量
                    int notGivenNumsNew = max(chargeEntryRecord.getNotGivenNums() - refundNums, 0); // 退费之后的尚未交付数量
                    chargeEntryRecord.setNotGivenNums(notGivenNumsNew);  // 退费后，尚未交付的项目数量减少
                    refundAmount = chargeEntryRecord.getUnitPrice() * (notGivenNumsInit - notGivenNumsNew);  // 退费金额（绝对值）

                    if (chargeEntryRecord.getNotGivenNums() == 0)  // 如果尚未交付数量为零，即项目被完全退费
                        chargeEntryRecord.setPayState(ConstantService.PAY_STATE_RETURNED);  // 支付状态设置为已退费
                    chargeEntryMapper.updateByPrimaryKeySelective(chargeEntryRecord);

                } else if (entryType == ConstantService.ENTRY_TYPE_PRESCRIPTION_ENTRY) { // 退费项目是药品
                    PrescriptionEntry prescriptionEntryRecord = prescriptionEntryMapper.selectByPrimaryKey(entryId);
                    int notGivenNumsInit = prescriptionEntryRecord.getNotGivenNums();   // 退费之前的尚未交付数量
                    int notGivenNumsNew = max(prescriptionEntryRecord.getNotGivenNums() - refundNums, 0);  // 退费之后的尚未交付数量
                    prescriptionEntryRecord.setNotGivenNums(notGivenNumsNew);
                    refundAmount = prescriptionEntryRecord.getUnitPrice() * (notGivenNumsInit - notGivenNumsNew);  // 退费金额（绝对值）

                    if (prescriptionEntryRecord.getNotGivenNums() == 0)
                        prescriptionEntryRecord.setPayState(ConstantService.PAY_STATE_RETURNED);  // 支付状态设置为已退费
                    prescriptionEntryMapper.updateByPrimaryKeySelective(prescriptionEntryRecord);

                } else {
                    throw new Exception("The value of entryType is null or wrong.");
                }

                Invoice invoiceRecord = new Invoice(null, invoiceTitle, invoiceNums, collectorId, registrationId, new Date(), refundAmount, null, null, null, null, ConstantService.PAY_STATE_RETURNED, null, null, null, null, 1);  // 生成退费记录
                invoiceMapper.insert(invoiceRecord); // 新增退费记录
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
            registrationExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId).andIsVisitedEqualTo(ConstantService.REGIST_NOT_VISITED);

            List<Registration> registrationList = registrationMapper.selectByExample(registrationExample);
            assert registrationList != null && registrationList.size() <= 1;
            Registration registration = registrationList.get(0);
            registration.setRegistrationStatus(ConstantService.REGIST_WITHDRAW);
            registrationMapper.updateByPrimaryKeySelective(registration);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
