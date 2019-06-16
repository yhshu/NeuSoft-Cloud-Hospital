package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.SettlementCategory;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.basicInfo.SettlementCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/settlement_category")
public class SettlementCategoryController {
    @Resource
    private SettlementCategoryService settlementCategoryService;

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
}
