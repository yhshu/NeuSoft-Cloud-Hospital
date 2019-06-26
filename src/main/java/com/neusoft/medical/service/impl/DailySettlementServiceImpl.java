package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.*;
import com.neusoft.medical.service.basicInfo.AccountService;
import com.neusoft.medical.service.registration.DailySettlementService;
import com.neusoft.medical.service.registration.InvoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String dailySettlementDocument(Integer dailySettlementId) {
        // todo

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
            criteria.andValidEqualTo(1).andPayTimeLessThan(endDatetime);
            if (lastDailySettlementDate != null)
                criteria.andPayTimeGreaterThan(lastDailySettlementDate);
            List<Invoice> invoiceList = invoiceMapper.selectByExample(invoiceExample);

            // 将收费记录存储为日结记录与日结明细
            String collectorRealName = accountService.selectStaffByAccountId(collectorId).getRealName();
            DailySettlement dailySettlement = new DailySettlement(null, collectorId, collectorRealName, new Date(), 0, 1);
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
