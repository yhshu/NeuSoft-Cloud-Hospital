package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
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

    /**
     * 分页获取指定科室的收费项目信息
     *
     * @param currentPage      当前页码
     * @param pageSize         页面大小
     * @param departmentIdList 科室编号列表
     * @return 分页的指定科室的收费项目信息
     */
    @GetMapping("/select")
    public ResultDTO<PageInfo<String>> selectChargeItem(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "departmentIdList[]") Integer[] departmentIdList
    ) {
        PageInfo<String> chargeItemPageInfo = null;
        try {
            chargeItemPageInfo = chargeItemService.selectChargeItemByDepartmentIdWithPaging(Arrays.asList(departmentIdList), currentPage, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(chargeItemPageInfo);
    }

    /**
     * 保存收费项目信息
     * 新增或更新
     *
     * @param chargeItemId      收费项目编号（新增时不填，更新时必填）
     * @param chargeItemCode    收费项目代码
     * @param nameZh            中文名称
     * @param specification     规格
     * @param price             单价
     * @param expenseCategoryId 收费类别
     * @param departmentId      所属科室编号
     * @param nameEn            英文名称
     * @param namePinyin        中文名称的拼音
     * @return 操作结果
     */
    @PostMapping("/save")
    public ResultDTO<Boolean> saveChargeItem(
            @RequestParam(value = "chargeItemId", required = false) Integer chargeItemId,
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

    /**
     * 删除收费项目信息
     *
     * @param chargeItemIdList 收费项目编号列表
     * @return 操作结果
     */
    @DeleteMapping("/delete")
    public ResultDTO<Boolean> deleteChargeItem(
            @RequestParam(value = "chargeItemIdList[]") Integer[] chargeItemIdList
    ) {
        boolean res;
        try {
            res = chargeItemService.deleteChargeItem(Arrays.asList(chargeItemIdList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }
}
