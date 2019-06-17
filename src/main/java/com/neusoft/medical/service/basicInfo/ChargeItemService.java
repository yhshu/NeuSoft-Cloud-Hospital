package com.neusoft.medical.service.basicInfo;

import com.neusoft.medical.bean.ChargeItem;

import java.util.List;

public interface ChargeItemService {

    List<ChargeItem> selectChargeItemByDepartmentId(int departmentId);
}
