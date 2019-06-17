package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.ConstantItem;
import com.neusoft.medical.example.ConstantItemExample;
import com.neusoft.medical.bean.ConstantType;
import com.neusoft.medical.example.ConstantTypeExample;
import com.neusoft.medical.dao.ConstantItemMapper;
import com.neusoft.medical.dao.ConstantTypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConstantConverter {
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
}
