package com.neusoft.medical.service.impl;

import com.google.gson.JsonObject;
import com.neusoft.medical.bean.ExpenseCategory;
import com.neusoft.medical.dao.ExpenseCategoryMapper;
import com.neusoft.medical.service.finance.ExpenseCategoryService;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpenseCategoryServiceImplTest {

    @Resource
    ExpenseCategoryService expenseCategoryService;
    @Resource
    ExpenseCategoryMapper expenseCategoryMapper;

    @Test
    public void selectExpenseCategory() {
        expenseCategoryService.selectExpenseCategory(1,20);
    }

    @Test
    /**
     * 保存费用科目
     *
     * @param expenseCategoryJson 费用科目信息，json 字符串
     * @return 操作结果
     * expenseCategoryJson 中的属性包括：
     * - expenseCategoryId 费用科目编号（新增时不填，更新时必填）
     * - expenseCategoryCode 费用代码
     * - expenseCategoryName 费用名称
     */
    public void saveExpenseCategory() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("expenseCategoryId",10);
        jsonObject.addProperty("expenseCategoryCode",10);
        jsonObject.addProperty("expenseCategoryName","费用");
        expenseCategoryService.saveExpenseCategory(jsonObject.toString());
    }

    @Test
    public void deleteExpenseCategory() {
        ExpenseCategory expenseCategory = new ExpenseCategory(1,"1","hh",1,null,null,null);
        expenseCategoryMapper.insert(expenseCategory);
        List<Integer> expenseCategoryIdList = new ArrayList<>();
        expenseCategoryIdList.add(expenseCategory.getExpenseCategoryId());
        expenseCategoryService.deleteExpenseCategory(expenseCategoryIdList);
    }
}