package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.basicInfo.ChargeItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

@RestController
@RequestMapping("/charge_item")
public class ChargeItemController {
    @Resource
    private ChargeItemService chargeItemService;

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
}
