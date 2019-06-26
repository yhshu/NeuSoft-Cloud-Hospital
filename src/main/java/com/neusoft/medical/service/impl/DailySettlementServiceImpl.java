package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.Util.converter.DateTimeToStringConverter;
import com.neusoft.medical.Util.converter.DoubleToUpperCaseConverter;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.*;
import com.neusoft.medical.service.basicInfo.AccountService;
import com.neusoft.medical.service.registration.DailySettlementService;
import com.neusoft.medical.service.registration.InvoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class DailySettlementServiceImpl implements DailySettlementService {
    @Resource
    private DailySettlementMapper dailySettlementMapper;
    @Resource
    private DailySettlementDetailMapper dailySettlementDetailMapper;
    @Resource
    private InvoiceService invoiceService;
    @Resource
    private SettlementCategoryMapper settlementCategoryMapper;
    @Resource
    private InvoiceMapper invoiceMapper;
    @Resource
    private AccountService accountService;
    @Resource
    private RegistrationMapper registrationMapper;
    @Resource
    private DateTimeToStringConverter dateTimeToStringConverter;
    @Resource
    private DoubleToUpperCaseConverter doubleToUpperCaseConverter;

    private Gson gson = new Gson();

    @Override
    public PageInfo<DailySettlement> selectAllDailySettlementList(Integer currentPage, Integer pageSize) {
        List<DailySettlement> dailySettlementList = null;
        try {
            PageHelper.startPage(currentPage, pageSize);

            DailySettlementExample dailySettlementExample = new DailySettlementExample();
            dailySettlementExample.or().andValidEqualTo(1);

            dailySettlementList = dailySettlementMapper.selectByExample(dailySettlementExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert dailySettlementList != null;
        return new PageInfo<>(dailySettlementList);
    }

    @Override
    public PageInfo<DailySettlement> selectDailySettlementList(Date startDatetimeConverted, Date endDatetimeConverted, Integer collectorId, Integer currentPage, Integer pageSize) {
        List<DailySettlement> dailySettlementList = null;
        try {
            PageHelper.startPage(currentPage, pageSize);

            DailySettlementExample dailySettlementExample = new DailySettlementExample();
            dailySettlementExample.or().andValidEqualTo(1).andCollectorAccountIdEqualTo(collectorId).andDailySettlementDateBetween(startDatetimeConverted, endDatetimeConverted);

            dailySettlementList = dailySettlementMapper.selectByExample(dailySettlementExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert dailySettlementList != null;
        return new PageInfo<>(dailySettlementList);
    }

    @Override
    public PageInfo<String> selectDailySettlementDetail(Integer dailySettlementId, Integer currentPage, Integer pageSize) {
        List<String> res = new CopyOnWriteArrayList<>();
        try {
            PageHelper.startPage(currentPage, pageSize);
            DailySettlementDetailExample dailySettlementDetailExample = new DailySettlementDetailExample();
            dailySettlementDetailExample.or().andValidEqualTo(1).andDailySettlementIdEqualTo(dailySettlementId);

            List<DailySettlementDetail> dailySettlementDetailList = dailySettlementDetailMapper.selectByExample(dailySettlementDetailExample);
            JsonArray dailySettlementDetailListJsonArray = gson.toJsonTree(dailySettlementDetailList).getAsJsonArray();

            for (JsonElement dailySettlementDetailJsonElement : dailySettlementDetailListJsonArray) {
                JsonObject dailySettlementDetailJsonObject = dailySettlementDetailJsonElement.getAsJsonObject();

                Integer dailySettlementDetailState = dailySettlementDetailJsonObject.get("dailySettlementDetailState").getAsInt();
                Integer settlementCategoryId = dailySettlementDetailJsonObject.get("settlementCategoryId").getAsInt();

                if (dailySettlementDetailState != null) {
                    dailySettlementDetailJsonObject.remove("dailySettlementDetailState");
                    dailySettlementDetailJsonObject.addProperty("dailySettlementDetailState", invoiceService.getInvoiceState(dailySettlementDetailState));
                }
                dailySettlementDetailJsonObject.addProperty("settlementCategoryName", settlementCategoryMapper.selectByPrimaryKey(settlementCategoryId).getSettlementCategoryName());

                res.add(dailySettlementDetailJsonObject.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PageInfo<>(res);
    }

    @Override
    public String dailySettlementDocument(Integer dailySettlementId) {
        JsonObject dailySettlementDocument = new JsonObject();
        try {
            DailySettlement dailySettlement = dailySettlementMapper.selectByPrimaryKey(dailySettlementId);

            // 日结单上的数据包括：开始时间、结束时间、收款员姓名、制表时间
            // 发票张数、总金额、总自费支付、总账户支付、总报销支付、总折扣金额
            // 总药费、总处置费、总检查费、总挂号费、总金额的汉字大写
            dailySettlementDocument.addProperty("previousDailySettlementDate", dateTimeToStringConverter.convert(dailySettlement.getPreviousDailySettlementDate()));
            dailySettlementDocument.addProperty("endDatetime", dateTimeToStringConverter.convert(dailySettlement.getDailySettlementDate()));
            dailySettlementDocument.addProperty("collectorName", dailySettlement.getCollectorRealName());
            dailySettlementDocument.addProperty("tabulationTime", dateTimeToStringConverter.convert(new Date()));

            DailySettlementDetailExample dailySettlementDetailExample = new DailySettlementDetailExample();
            dailySettlementDetailExample.or().andValidEqualTo(1).andDailySettlementIdEqualTo(dailySettlementId);
            List<DailySettlementDetail> dailySettlementDetailList = dailySettlementDetailMapper.selectByExample(dailySettlementDetailExample);
            int invoiceNums = 0;
            double invoiceTotalAmount = 0.0;
            double selfPay = 0.0;
            double accountPay = 0.0;
            double reimbursementPay = 0.0;
            double discounted = 0.0;
            for (DailySettlementDetail dailySettlementDetail : dailySettlementDetailList) {
                invoiceNums += dailySettlementDetail.getInvoiceNums();
                invoiceTotalAmount += dailySettlementDetail.getInvoiceTotalAmount();
                selfPay += dailySettlementDetail.getSelfPay();
                accountPay += dailySettlementDetail.getAccountPay();
                reimbursementPay += dailySettlementDetail.getReimbursementPay();
                discounted += dailySettlementDetail.getDiscounted();
            }
            dailySettlementDocument.addProperty("invoiceNums", invoiceNums);
            dailySettlementDocument.addProperty("invoiceTotalAmount", invoiceTotalAmount);
            dailySettlementDocument.addProperty("selfPay", selfPay);
            dailySettlementDocument.addProperty("accountPay", accountPay);
            dailySettlementDocument.addProperty("reimbursementPay", reimbursementPay);
            dailySettlementDocument.addProperty("discounted", discounted);
            dailySettlementDocument.addProperty("invoiceTotalAmountCapital", doubleToUpperCaseConverter.convert(invoiceTotalAmount));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean checkDailySettlement(Integer dailySettlementId) {
        try {
            DailySettlement dailySettlement = dailySettlementMapper.selectByPrimaryKey(dailySettlementId);
            if (dailySettlement.getValid() == 0) return false;
            dailySettlement.setChecked(1);
            dailySettlementMapper.updateByPrimaryKeySelective(dailySettlement);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean generateDailySettlement(Integer collectorId, Date endDatetime) {
        // 首先获取指定收费员的上次日结时间，如果找不到上次日结时间，本次日结是该收费员的初次日结
        try {
            DailySettlementExample dailySettlementExample = new DailySettlementExample();
            dailySettlementExample.or().andValidEqualTo(1).andCollectorAccountIdEqualTo(collectorId);
            dailySettlementExample.setOrderByClause("daily_settlement_date desc");

            List<DailySettlement> dailySettlementList = dailySettlementMapper.selectByExample(dailySettlementExample);
            Date lastDailySettlementDate = null;
            if (!dailySettlementList.isEmpty()) {
                lastDailySettlementDate = dailySettlementList.get(0).getDailySettlementDate();
            }

            // 获取上次日结到现在的收费记录
            InvoiceExample invoiceExample = new InvoiceExample();
            InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
            assert endDatetime != null;
            criteria.andValidEqualTo(1);
            System.out.println(endDatetime);
            criteria.andPayTimeLessThan(endDatetime);
            if (lastDailySettlementDate != null)
                criteria.andPayTimeGreaterThan(lastDailySettlementDate);
            List<Invoice> invoiceList = invoiceMapper.selectByExample(invoiceExample);

            // 将收费记录存储为日结记录与日结明细
            String collectorRealName = accountService.selectStaffByAccountId(collectorId).getRealName();
            DailySettlement dailySettlement = new DailySettlement(null, collectorId, collectorRealName, new Date(), lastDailySettlementDate, 0, 1);
            dailySettlementMapper.insert(dailySettlement);

            Integer dailySettlementId = dailySettlement.getDailySettlementId();
            for (Invoice invoice : invoiceList) {
                Registration registration = registrationMapper.selectByPrimaryKey(invoice.getRegistrationId());
                DailySettlementDetail dailySettlementDetail = new DailySettlementDetail(null, dailySettlementId, invoice.getInvoiceNums(), invoice.getRegistrationId(), invoice.getInvoiceTitle(), invoice.getInvoiceAmount(), invoice.getSelfPay(), invoice.getAccountPay(), invoice.getReimbursementPay(), invoice.getDiscounted(), Constant.INVOICE_VALID, registration.getSettlementCategoryId(), 1);
                dailySettlementDetailMapper.insert(dailySettlementDetail);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
