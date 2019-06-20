package com.neusoft.medical.controller.registration;


import com.github.pagehelper.PageInfo;
import com.neusoft.medical.Util.DateConverter;
import com.neusoft.medical.bean.ChargeEntry;
import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.basicInfo.ChargeItemService;
import com.neusoft.medical.service.registration.ChargeEntryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 挂号收费控制器
 */
@RestController
@RequestMapping("/charge_form")
public class ChargeEntryController {
    @Resource
    private ChargeEntryService chargeEntryService;

    @Resource
    private ChargeItemService chargeItemService;

    @Resource
    private DateConverter dateConverter;

    /**
     * 按挂号编号获取收费账单
     *
     * @param currentPage         当前页码
     * @param pageSize            每页大小
     * @param registrationId      挂号编号
     * @param startDate           开始日期（可选）
     * @param endDate             结束日期（可选）
     * @param chargeEntryCategory 收费项目类别（0: 未完成支付； 1: 已完成支付; 2: 所有收费项目）
     * @return 分页的收费账单
     */
    @GetMapping("/list")
    public ResultDTO<PageInfo<ChargeEntry>> selectChargeEntry(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "registrationId") Integer registrationId,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "chargeFormCategory") Integer chargeEntryCategory
    ) {
        System.out.println("ChargeEntryController 按挂号编号获取收费账单");

        Date startDateConverted = null;
        Date endDateConverted = null;
        if (startDate != null)
            startDateConverted = dateConverter.convert(startDate);
        if (endDate != null)
            endDateConverted = dateConverter.convert(endDate);
        PageInfo<ChargeEntry> chargeEntryPageInfo = chargeEntryService.selectChargeEntryByRegistrationId(currentPage, pageSize, registrationId, startDateConverted, endDateConverted, chargeEntryCategory);

        return new ResultDTO<>(chargeEntryPageInfo);
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
        System.out.println("ChargeEntryController 按科室编号获取该科室的收费项目，科室编号：" + departmentId);
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
    public ResultDTO<Boolean> addChargeEntryToForm(
            @RequestParam("chargeItemId") Integer chargeItemId,
            @RequestParam("registrationId") Integer registrationId,
            @RequestParam("itemCount") Integer itemCount,
            @RequestParam("collectorId") Integer collectorId,
            @RequestParam("unitPrice") Double unitPrice,
            @RequestParam("doctorAdvice") String doctorAdvice
    ) {
        System.out.println("ChargeEntryController 添加收费项目到收费账单中");
        try {
            chargeEntryService.addChargeEntryToForm(chargeItemId, registrationId, itemCount, collectorId, unitPrice, doctorAdvice);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }

    /**
     * 按收费项目编号列表 删除多个收费项目
     *
     * @param chargeItemIdList 收费项目编号
     * @return 成功返回 true，失败返回 false
     */
    @DeleteMapping("/delete_charge_item_in_form")
    public ResultDTO<Boolean> deleteChargeEntryInForm(
            @RequestParam(value = "chargeItemIdList[]") Integer[] chargeItemIdList) {
        System.out.println("ChargeEntryController 按科室编号列表删除收费项目");
        try {
            chargeEntryService.deleteChargeItemInForm(Arrays.asList(chargeItemIdList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }

    /**
     * 患者支付收费项目
     *
     * @param chargeEntryIdList 被支付的收费项目编号
     * @return 支付成功 true，支付失败 false
     */
    @GetMapping("/pay_bill")
    public ResultDTO<Boolean> payBill(
            @RequestParam(value = "chargeItemIdList[]") Integer[] chargeEntryIdList) {
        try {
            chargeEntryService.payBill(Arrays.asList(chargeEntryIdList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }
}
