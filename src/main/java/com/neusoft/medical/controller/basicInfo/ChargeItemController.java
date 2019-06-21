package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.basicInfo.ChargeItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

@RestController
@RequestMapping("/charge_item")
public class ChargeItemController {
    @Resource
    private ChargeItemService chargeItemService;

    @GetMapping("/select")
    public ResultDTO<PageInfo<ChargeItem>> selectChargeItem(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "departmentIdList[]") Integer[] departmentIdList
    ) {
        PageInfo<ChargeItem> chargeItemPageInfo = null;
        try {
            chargeItemPageInfo = chargeItemService.selectChargeItemByDepartmentIdWithPaging(Arrays.asList(departmentIdList), currentPage, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(chargeItemPageInfo);
    }

    @PutMapping("/save")
    public ResultDTO<Boolean> saveChargeItem(
            @RequestParam(value = "chargeItemId") Integer chargeItemId,
            @RequestParam(value = "chargeItemCode") String chargeItemCode,
            @RequestParam(value = "nameZh") String nameZh,
            @RequestParam(value = "specification") String specification,
            @RequestParam(value = "price") Double price,
            @RequestParam(value = "expenseCategoryId") Integer expenseCategoryId,
            @RequestParam(value = "departmentId") Integer departmentId,
            @RequestParam(value = "nameEn", required = false) String nameEn,
            @RequestParam(value = "namePinyin") String namePinyin
    ) {
        boolean res;
        try {
            res = chargeItemService.saveChargeItem(chargeItemId, chargeItemCode, nameZh, specification, price, expenseCategoryId, departmentId, namePinyin, nameEn);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

//    @DeleteMapping("/delete")
//    public ResultDTO<Boolean>
}
