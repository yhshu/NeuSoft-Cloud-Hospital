package com.neusoft.medical.service.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeItem;

import java.util.List;

public interface ChargeItemService {

    List<ChargeItem> selectChargeItemByDepartmentId(int departmentId);

    PageInfo<ChargeItem> selectChargeItemByDepartmentIdWithPaging(List<Integer> departmentId, int currentPage, int pageSize);

    boolean saveChargeItem(Integer chargeItemId, String chargeItemCode, String nameZh, String specification, Double price, Integer expenseCategoryId, Integer departmentId, String namePinyin, String nameEn);
}
