package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.bean.ChargeItemExample;
import com.neusoft.medical.dao.ChargeItemMapper;
import com.neusoft.medical.dao.DepartmentMapper;
import com.neusoft.medical.dao.ExpenseCategoryMapper;
import com.neusoft.medical.service.basicInfo.ChargeItemService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ChargeItemServiceImpl implements ChargeItemService {
    private Logger logger = Logger.getLogger(ChargeItemService.class);
    @Resource
    private ChargeItemMapper chargeItemMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private ExpenseCategoryMapper expenseCategoryMapper;


    private Gson gson = new Gson();

    @Override
    public List<ChargeItem> selectChargeItemByDepartmentId(int departmentId) {
        try {
            ChargeItemExample chargeItemExample = new ChargeItemExample();
            chargeItemExample.or().andValidEqualTo(1).andDepartmentIdEqualTo(departmentId);
            List<ChargeItem> chargeItemList = chargeItemMapper.selectByExample(chargeItemExample);

            if (!chargeItemList.isEmpty()) {
                return chargeItemList;
            } else {
                logger.info("No charge items available for this department");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PageInfo<String> selectChargeItemByDepartmentIdWithPaging(List<Integer> departmentId, int currentPage, int pageSize) {
        try {
            PageHelper.startPage(currentPage, pageSize);

            ChargeItemExample chargeItemExample = new ChargeItemExample();
            chargeItemExample.or().andValidEqualTo(1).andDepartmentIdIn(departmentId);

            List<ChargeItem> chargeItemList = chargeItemMapper.selectByExample(chargeItemExample);
            List<String> res = new CopyOnWriteArrayList<>();
            JsonArray chargeItemListJsonArray = gson.toJsonTree(chargeItemList).getAsJsonArray();
            for (JsonElement chargeItemJsonElement : chargeItemListJsonArray) {
                JsonObject chargeItemJsonObject = chargeItemJsonElement.getAsJsonObject();

                Integer curDepartmentId = chargeItemJsonObject.get("departmentId").getAsInt();
                Integer expenseCategoryId = chargeItemJsonObject.get("expenseCategoryId").getAsInt();
                chargeItemJsonObject.addProperty("departmentName", departmentMapper.selectByPrimaryKey(curDepartmentId).getDepartmentName());
                chargeItemJsonObject.addProperty("expenseCategoryName", expenseCategoryMapper.selectByPrimaryKey(expenseCategoryId).getExpenseCategoryName());

                res.add(chargeItemJsonObject.toString());
            }

            if (!chargeItemList.isEmpty()) {  // chargeItemList not empty
                return new PageInfo<>(res);
            } else {
                logger.info("No charge items available for this department");
            }
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
