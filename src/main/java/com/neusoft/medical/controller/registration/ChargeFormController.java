package com.neusoft.medical.controller.registration;


import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeForm;
import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.ChargeFormService;
import com.neusoft.medical.service.ChargeItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 挂号收费控制器
 */
@RestController
@RequestMapping("/charge_form")
public class ChargeFormController {
    @Resource
    private ChargeFormService chargeFormService;

    @Resource
    private ChargeItemService chargeItemService;

    /**
     * 按挂号编号获取收费账单
     *
     * @param currentPage    当前页码
     * @param pageSize       每页大小
     * @param registrationId 挂号编号
     * @return 分页的收费账单
     */
    @GetMapping("/list")
    public ResultDTO<PageInfo<ChargeForm>> selectChargeForm(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "registrationId") Integer registrationId) {
        System.out.println("ChargeFormController 按挂号编号获取收费账单");
        PageInfo<ChargeForm> chargeFormPageInfo = chargeFormService.selectChargeFormByRegistrationId(currentPage, pageSize, registrationId);
        return new ResultDTO<>(chargeFormPageInfo);
    }

    /**
     * 按科室编号 获取 该科室的收费项目
     *
     * @param departmentId 科室编号
     * @return 该科室的收费项目列表
     */
    @GetMapping("/list_charge_item")
    public ResultDTO<List<ChargeItem>> selectChargeItemByDepartmentId(
            @RequestParam(value = "departmentId") Integer departmentId
    ) {
        System.out.println("ChargeFormController 按科室编号获取该科室的收费项目");
        List<ChargeItem> chargeItemList = chargeItemService.selectChargeItemByDepartmentId(departmentId);
        return new ResultDTO<>(chargeItemList);
    }

    /**
     * 添加收费项目到收费账单中
     *
     * @param chargeItemId   收费项目编号
     * @param registrationId 挂号编号
     * @param itemCount      收费项目计数
     * @param collectorId    收费员编号
     * @return 添加成功 true；添加失败 false
     */
    @GetMapping("/add_charge_item_to_form")
    public ResultDTO<Boolean> addChargeItemToForm(
            @RequestParam("chargeItemId") Integer chargeItemId,
            @RequestParam("registrationId") Integer registrationId,
            @RequestParam("itemCount") Integer itemCount,
            @RequestParam("collectorId") Integer collectorId
    ) {
        System.out.println("ChargeFormController 按科室编号获取该科室的收费项目");
        try {
            chargeFormService.addChargeItemToForm(chargeItemId, registrationId, itemCount, collectorId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }


    @DeleteMapping("/delete_charge_item_in_form")
    public ResultDTO<Boolean> deleteChargeItemInForm(@RequestParam("chargeItemIdList[]") Integer[] chargeItemIdList) {
        System.out.println("ChargeFormController 按科室编号列表删除收费项目");
        try {
            chargeFormService.deleteChargeItemInForm(Arrays.asList(chargeItemIdList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }
}
