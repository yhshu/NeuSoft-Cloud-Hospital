package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.SettlementCategory;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.basicInfo.SettlementCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

@RestController
@RequestMapping("/settlement_category")
public class SettlementCategoryController {
    @Resource
    private SettlementCategoryService settlementCategoryService;

    /**
     * 分页获取结算类别
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @return 分页的结算类别信息
     */
    @GetMapping("/list")
    public ResultDTO<PageInfo<SettlementCategory>> selectSettlementCategory(
            @RequestParam("currentPage") Integer currentPage,
            @RequestParam("pageSize") Integer pageSize
    ) {
        PageInfo<SettlementCategory> settlementCategoryPageInfo = null;
        try {
            settlementCategoryPageInfo = settlementCategoryService.selectSettlementCategory(currentPage, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(settlementCategoryPageInfo);
    }

    /**
     * 保存结算类别信息
     * 包括新增或更新
     *
     * @param settlementCategoryId   结算类别编号（新增时不填，更新时必填）
     * @param settlementCategoryName 结算类别名称
     * @return 操作结果
     */
    @PostMapping("/save")
    public ResultDTO<Boolean> saveSettlementCategory(
            @RequestParam(value = "settlementCategoryId", required = false) Integer settlementCategoryId,
            @RequestParam(value = "settlementCategoryName") String settlementCategoryName
    ) {
        boolean res;
        try {
            res = settlementCategoryService.saveSettlementCategory(settlementCategoryId, settlementCategoryName);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

    @DeleteMapping("/delete")
    public ResultDTO<Boolean> deleteSettlementCategory(
            @RequestParam(value = "settlementCategoryIdList[]") Integer[] settlementCategoryIdList
    ) {
        boolean res;
        try {
            res = settlementCategoryService.deleteSettlementCategory(Arrays.asList(settlementCategoryIdList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }
}
