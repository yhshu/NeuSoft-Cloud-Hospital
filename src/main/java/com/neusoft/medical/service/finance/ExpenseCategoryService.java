package com.neusoft.medical.service.finance;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ExpenseCategory;

public interface ExpenseCategoryService {

    PageInfo<ExpenseCategory> selectExpenseCategory(Integer currentPage, Integer pageSize);

    boolean saveExpenseCategory(String expenseCategoryJson);
}
