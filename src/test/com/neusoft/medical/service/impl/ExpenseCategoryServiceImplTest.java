package com.neusoft.medical.service.impl;

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
    public void saveExpenseCategory() {
        expenseCategoryService.saveExpenseCategory("");
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