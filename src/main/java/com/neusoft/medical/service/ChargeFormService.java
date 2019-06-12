package com.neusoft.medical.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeForm;

import java.util.List;

public interface ChargeFormService {

    /**
     * 按挂号编号获取收费项目
     *
     * @param registrationId 挂号编号
     * @return 分页的收费项目列表
     */
    PageInfo<ChargeForm> selectChargeFormByRegistrationId(Integer currentPage, Integer pageSize, Integer registrationId);

    /**
     * 添加收费项目到收费账单中
     *
     * @param chargeItemId   收费项目编号
     * @param registrationId 挂号编号
     * @param itemCount      收费项目计数
     * @param collectorId    收费员编号
     * @return 添加成功 true；添加失败 false
     */
    boolean addChargeItemToForm(int chargeItemId, int registrationId, int itemCount, int collectorId);

    /**
     * 按收费项目编号列表 删除多个收费项目
     *
     * @param chargeItemIdList 收费项目编号
     * @return
     */
    boolean deleteChargeItemInForm(List<Integer> chargeItemIdList);
}
