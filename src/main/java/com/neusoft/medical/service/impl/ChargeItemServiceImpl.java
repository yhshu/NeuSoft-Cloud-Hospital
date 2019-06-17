package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.example.ChargeItemExample;
import com.neusoft.medical.dao.ChargeItemMapper;
import com.neusoft.medical.service.basicInfo.ChargeItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChargeItemServiceImpl implements ChargeItemService {
    @Resource
    private ChargeItemMapper chargeItemMapper;

    @Override
    public List<ChargeItem> selectChargeItemByDepartmentId(int departmentId) {
        try {
            ChargeItemExample chargeItemExample = new ChargeItemExample();
            ChargeItemExample.Criteria criteria = chargeItemExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andDepartmentIdEqualTo(departmentId);
            List<ChargeItem> chargeItemList = chargeItemMapper.selectByExample(chargeItemExample);

            if (!chargeItemList.isEmpty())
                return chargeItemList;
            else
                System.out.println("ChargeItemServiceImpl 未找到科室 " + departmentId + " 可用的收费项目");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
