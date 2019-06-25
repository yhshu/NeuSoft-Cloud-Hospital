package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        return false;
    }
}
