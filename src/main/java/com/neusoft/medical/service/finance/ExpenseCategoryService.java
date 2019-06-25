package com.neusoft.medical.service.finance;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ExpenseCategory;

import java.util.List;

/**
 * 费用科目管理 服务
 */
public interface ExpenseCategoryService {

    PageInfo<ExpenseCategory> selectExpenseCategory(Integer currentPage, Integer pageSize);

    boolean saveExpenseCategory(String expenseCategoryJson);

    boolean deleteExpenseCategory(List<Integer> expenseCategoryIdList);
}
