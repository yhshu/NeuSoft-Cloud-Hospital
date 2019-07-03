package com.neusoft.medical.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.neusoft.medical.service.registration.ChargeService;
import org.junit.Test;

import javax.annotation.Resource;


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

        JsonArray entryListJsonArray = new JsonArray();
        JsonObject entryJsonObject = new JsonObject();
        entryJsonObject.addProperty("entryType", 1);
        entryJsonObject.addProperty("entryId", 1);
        entryListJsonArray.add(entryJsonObject);

        checkoutJsonObject.add("entryList", entryListJsonArray);
        chargeService.checkout(checkoutJsonObject.toString());
    }

    @Test
    public void refund() {
    }

    @Test
    public void withdrawRegistration() {
    }
}