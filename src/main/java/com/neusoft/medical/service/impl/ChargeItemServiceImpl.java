package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.bean.ChargeItemExample;
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
            chargeItemExample.or().andValidEqualTo(1).andDepartmentIdEqualTo(departmentId);
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

    @Override
    public PageInfo<ChargeItem> selectChargeItemByDepartmentIdWithPaging(List<Integer> departmentId, int currentPage, int pageSize) {
        try {
            PageHelper.startPage(currentPage, pageSize);

            ChargeItemExample chargeItemExample = new ChargeItemExample();
            chargeItemExample.or().andValidEqualTo(1).andDepartmentIdIn(departmentId);

            List<ChargeItem> chargeItemList = chargeItemMapper.selectByExample(chargeItemExample);

            if (!chargeItemList.isEmpty())
                return new PageInfo<>(chargeItemList);
            else
                System.out.println("ChargeItemServiceImpl 未找到科室 " + departmentId + " 可用的收费项目");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
