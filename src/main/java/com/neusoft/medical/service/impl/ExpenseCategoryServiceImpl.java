package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neusoft.medical.bean.ExpenseCategory;
import com.neusoft.medical.bean.ExpenseCategoryExample;
import com.neusoft.medical.dao.ExpenseCategoryMapper;
import com.neusoft.medical.service.finance.ExpenseCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {
    @Resource
    private ExpenseCategoryMapper expenseCategoryMapper;

    @Override
    public PageInfo<ExpenseCategory> selectExpenseCategory(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);

        ExpenseCategoryExample expenseCategoryExample = new ExpenseCategoryExample();
        expenseCategoryExample.or().andValidEqualTo(1);

        List<ExpenseCategory> expenseCategoryList = expenseCategoryMapper.selectByExample(expenseCategoryExample);
        return new PageInfo<>(expenseCategoryList);
    }

    @Override
    public boolean saveExpenseCategory(String expenseCategoryJson) {
        try {
            JsonObject expenseCategoryJsonObject = new JsonParser().parse(expenseCategoryJson).getAsJsonObject();

            Integer expenseCategoryId = null;
            try {
                expenseCategoryId = expenseCategoryJsonObject.get("expenseCategoryId").getAsInt();
            } catch (NullPointerException ignore) {
            }
            String expenseCategoryCode = expenseCategoryJsonObject.get("expenseCategoryCode").getAsString();
            String expenseCategoryName = expenseCategoryJsonObject.get("expenseCategoryName").getAsString();

            ExpenseCategory expenseCategoryRecord = new ExpenseCategory(null, expenseCategoryCode, expenseCategoryName, 1, null, null, null);

            if (expenseCategoryId == null) {
                // 新增费用科目
                expenseCategoryMapper.insert(expenseCategoryRecord);
            } else {
                // 更新费用科目
                expenseCategoryRecord.setExpenseCategoryId(expenseCategoryId);
                expenseCategoryMapper.updateByPrimaryKeySelective(expenseCategoryRecord);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteExpenseCategory(List<Integer> expenseCategoryIdList) {
        try {
            ExpenseCategoryExample expenseCategoryExample = new ExpenseCategoryExample();
            expenseCategoryExample.or().andValidEqualTo(1).andExpenseCategoryIdIn(expenseCategoryIdList);

            ExpenseCategory expenseCategoryRecord = new ExpenseCategory();
            expenseCategoryRecord.setValid(0);

            expenseCategoryMapper.updateByExampleSelective(expenseCategoryRecord, expenseCategoryExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
