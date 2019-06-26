package com.neusoft.medical.controller.finance;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ExpenseCategory;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.finance.ExpenseCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 费用科目管理
 */
@RestController
@RequestMapping("/expense_category")
public class ExpenseCategoryController {
    @Resource
    private ExpenseCategoryService expenseCategoryService;

    /**
     * 获取分页的费用科目列表
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @return 分页的费用科目列表
     */
    @GetMapping("/select")
    public ResultDTO<PageInfo<ExpenseCategory>> selectExpenseCategory(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        PageInfo<ExpenseCategory> expenseCategoryPageInfo = null;
        try {
            expenseCategoryPageInfo = expenseCategoryService.selectExpenseCategory(currentPage, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(expenseCategoryPageInfo);
    }

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
    @PostMapping("/save")
    public ResultDTO<Boolean> saveExpenseCategory(@RequestParam(value = "expenseCategoryJson") String expenseCategoryJson) {
        boolean res;
        try {
            res = expenseCategoryService.saveExpenseCategory(expenseCategoryJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

    /**
     * 删除费用科目信息
     *
     * @param expenseCategoryIdList 费用科目编号列表
     * @return 操作结果
     */
    @DeleteMapping("/delete")
    public ResultDTO<Boolean> deleteExpenseCategory(@RequestParam(value = "expenseCategoryIdList[]") Integer[] expenseCategoryIdList) {
        boolean res;
        try {
            res = expenseCategoryService.deleteExpenseCategory(Arrays.asList(expenseCategoryIdList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }
}
