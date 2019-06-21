package com.neusoft.medical.service.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeItem;

import java.util.List;

public interface ChargeItemService {

    List<ChargeItem> selectChargeItemByDepartmentId(int departmentId);

    PageInfo<ChargeItem> selectChargeItemByDepartmentIdWithPaging(List<Integer> departmentId, int currentPage, int pageSize);
}
