package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.ConstantItem;
import com.neusoft.medical.bean.ConstantItemExample;
import com.neusoft.medical.bean.ConstantType;
import com.neusoft.medical.bean.ConstantTypeExample;
import com.neusoft.medical.dao.ConstantItemMapper;
import com.neusoft.medical.dao.ConstantTypeMapper;
import com.neusoft.medical.service.ConstantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConstantServiceImpl implements ConstantService {
    @Resource
    private ConstantTypeMapper constantTypeMapper;
    @Resource
    private ConstantItemMapper constantItemMapper;

    public int getConstantTypeId(String constantTypeCode) {
        ConstantTypeExample constantTypeExample = new ConstantTypeExample();
        ConstantTypeExample.Criteria criteria = constantTypeExample.createCriteria();
        criteria.andConstantTypeCodeEqualTo(constantTypeCode);

        List<ConstantType> constantTypeList = constantTypeMapper.selectByExample(constantTypeExample);
        return constantTypeList.get(0).getConstantTypeId();
    }

    public List<ConstantItem> getConstantItemList(String constantTypeCode) {
        int constantTypeId = getConstantTypeId(constantTypeCode);
        ConstantItemExample constantItemExample = new ConstantItemExample();
        ConstantItemExample.Criteria criteria = constantItemExample.createCriteria();
        criteria.andConstantTypeIdEqualTo(constantTypeId);
        return constantItemMapper.selectByExample(constantItemExample);
    }

    public Map<Object, Object> getConstantIdToNameMap(String constantTypeCode) {
        List<ConstantItem> constantItemList = getConstantItemList(constantTypeCode);
        return constantItemList.stream().collect(
                Collectors.toMap(ConstantItem::getConstantItemId, ConstantItem::getConstantName));
    }

    public List<ConstantItem> getConstantIdToNameList(String constantTypeCode) {
        return getConstantItemList(constantTypeCode);
    }

    public Map<Object, Object> getConstantNameToIdMap(String constantTypeCode) {
        List<ConstantItem> constantItemList = getConstantItemList(constantTypeCode);
        return constantItemList.stream().collect(
                Collectors.toMap(ConstantItem::getConstantName, ConstantItem::getConstantItemId));
    }

    @Override
    public String getAccountTypeName(String str) {
        if (str.equals(TYPE_OUTPATIENT_DOCTOR)) return "门诊医生";
        if (str.equals(TYPE_TECH_DOCTOR)) return "医技医生";
        if (str.equals(TYPE_COLLECTOR_STAFF)) return "医院管理员";
        if (str.equals(TYPE_PHARMACY_STAFF)) return "药房操作员";
        if (str.equals(TYPE_FINANCIAL_STAFF)) return "财务管理员";
        if (str.equals(TYPE_REGISTRATION_STAFF)) return "挂号收费员";
        if (str.equals(TYPE_SYSTEM_ADMIN)) return "系统管理员";
        return null;
    }
}
