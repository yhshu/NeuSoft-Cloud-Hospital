package com.neusoft.medical.controller.finance;

import com.neusoft.medical.bean.ExpenseCategory;
import com.neusoft.medical.dto.ResultDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 费用科目管理
 */
@RestController
@RequestMapping("/expense_category")
public class ExpenseCategoryController {

    /**
     * 获取分页的费用科目列表
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @return 分页的费用科目列表
     */
    public ResultDTO<ExpenseCategory> selectExpenseCategory(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        // todo
        return null;
    }

    /**
     * 保存费用科目
     *
     * @param expenseCategoryJson 费用科目信息，json 字符串
     * @return 操作结果
     */
    public ResultDTO<Boolean> saveExpenseCategory(String expenseCategoryJson) {
        // todo
        return null;
    }

    /**
     * 删除费用科目信息
     *
     * @param expenseCategoryIdList 费用科目编号列表
     * @return 操作结果
     */
    public ResultDTO<Boolean> deleteExpenseCategory(@RequestParam(value = "expenseCategoryIdList[]") Integer[] expenseCategoryIdList) {
        // todo
        return null;
    }
}
