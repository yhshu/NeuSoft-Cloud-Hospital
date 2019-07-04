package com.neusoft.medical.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.neusoft.medical.service.registration.ChargeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChargeServiceImplTest {
    @Resource
    private ChargeService chargeService;

    @Test
    /**
     * 收费（包括检查检验项目、处置项目、药品等收费项目）
     *
     * @param checkoutJson 收费信息，json 数组
     * @return 操作结果
     * checkoutJson 是一个 json 字符串，其属性包括：
     * - invoiceTitle 支付者
     * - collectorId 收银员编号
     * - invoiceNums 发票数量
     * - registrationId 挂号单编号
     * - invoiceAmount 找零后的实际入账金额
     * - selfPay 自费支付金额
     * - accountPay 账户支付金额
     * - reimbursementPay 报销支付金额
     * - discounted 优惠金额
     * - invoiceState 发票状态（有效 1）
     * - entryList 收费项目的列表，json 数组
     * <p>
     * 其中，entryList 数组中每个元素包含的属性：
     * - entryType: charge_entry: 0, prescription_entry: 1
     * - entryId    收费条目或处方条目的编号
     */
    public void checkout() {
        JsonObject checkoutJsonObject = new JsonObject();
        checkoutJsonObject.addProperty("invoiceTitle", "支付者");
        checkoutJsonObject.addProperty("collectorId",21);
        checkoutJsonObject.addProperty("invoiceNums",10);
        checkoutJsonObject.addProperty("registration",15);
        checkoutJsonObject.addProperty("invoiceAmount",10.6);
        checkoutJsonObject.addProperty("selfPay",10);
        checkoutJsonObject.addProperty("accountPay",5.6);
        checkoutJsonObject.addProperty("reimbursementPay",1.8);
        checkoutJsonObject.addProperty("discounted",0);
        checkoutJsonObject.addProperty("invoiceState",1);

        JsonArray entryListJsonArray = new JsonArray();
        JsonObject entryJsonObject = new JsonObject();
        entryJsonObject.addProperty("entryType", 1);
        entryJsonObject.addProperty("entryId", 1);
        entryListJsonArray.add(entryJsonObject);

        checkoutJsonObject.add("entryList", entryListJsonArray);
        chargeService.checkout(checkoutJsonObject.toString());
    }

    @Test
    /**
     * 退费（包括检查检验项目、处置项目、药品等收费项目）
     *
     * @param refundJson 退费信息，json 数组
     * @return 操作结果
     * refundJson 是一个 json 字符串，其属性包括：
     * - invoiceTitle 退费者
     * - collectorId 收银员编号
     * - invoiceNums 发票数量
     * - registrationId 挂号单编号
     * - entryList 退费项目的列表，json 数组
     * <p>
     * 其中，entryList 数组中每个元素包含的属性：
     * - entryType: charge_entry: 0, prescription_entry: 1
     * - entryId    收费条目或处方条目的编号
     * - refundNums 退费数量
     */
    public void refund() {
        JsonObject refundJsonObject = new JsonObject();
        refundJsonObject.addProperty("invoiceTitle","蔡徐坤");
        refundJsonObject.addProperty("collectorId",1);
        refundJsonObject.addProperty("invoiceNums",10);
        refundJsonObject.addProperty("registration",2);

        JsonArray entryListJsonArray = new JsonArray();
        JsonObject entryJsonObject = new JsonObject();
        entryJsonObject.addProperty("entryType",1);
        entryJsonObject.addProperty("entryId",1);
        entryJsonObject.addProperty("refundNums",1);
        entryListJsonArray.add(entryJsonObject);
        refundJsonObject.add("entryList",entryListJsonArray);

        chargeService.refund(refundJsonObject.toString());
    }

    @Test
    public void withdrawRegistration() {
        chargeService.withdrawRegistration(1);
    }
}