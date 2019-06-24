package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.bean.ChargeItemExample;
import com.neusoft.medical.dao.ChargeItemMapper;
import com.neusoft.medical.service.basicInfo.ChargeItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    @Override
    public boolean saveChargeItem(Integer chargeItemId, String chargeItemCode, String nameZh, String specification, Double price, Integer expenseCategoryId, Integer departmentId, String namePinyin, String nameEn) {
        try {
            ChargeItem chargeItemRecord = new ChargeItem(null, chargeItemCode, nameZh, specification, price, expenseCategoryId, departmentId, namePinyin, null, new Date(), null, null, nameEn, 1, null, null, null);

            if (chargeItemId == null) {
                // 添加新收费项目
                chargeItemMapper.insert(chargeItemRecord);
            } else {
                // 更新收费项目
                chargeItemRecord.setChargeItemId(chargeItemId);
                chargeItemMapper.updateByPrimaryKeySelective(chargeItemRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteChargeItem(List<Integer> chargeItemIdList) {
        try {
            ChargeItemExample chargeItemExample = new ChargeItemExample();
            chargeItemExample.or().andValidEqualTo(1).andChargeItemIdIn(chargeItemIdList);

            ChargeItem chargeItemRecord = new ChargeItem();
            chargeItemRecord.setValid(0);

            chargeItemMapper.updateByExampleSelective(chargeItemRecord, chargeItemExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
