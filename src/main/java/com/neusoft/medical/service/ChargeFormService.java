package com.neusoft.medical.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeForm;

import java.util.Date;
import java.util.List;

public interface ChargeFormService {

    /**
     * 按挂号编号获取收费项目
     *
     * @param currentPage    当前页码
     * @param pageSize       页面大小
     * @param registrationId 挂号编号
     * @param startDate      开始日期（可选）
     * @param endDate        结束日期（可选）
     * @param chargeFormCategory
     * @return 分页的收费项目列表
     */
    PageInfo<ChargeForm> selectChargeFormByRegistrationId(Integer currentPage, Integer pageSize, Integer registrationId, Date startDate, Date endDate, Integer chargeFormCategory);

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
     * @return 删除成功 true；删除失败 false
     */
    boolean deleteChargeItemInForm(List<Integer> chargeItemIdList);

    /**
     * 患者支付收费项目
     *
     * @param chargeFormIdList 被支付的收费项目编号
     * @return 支付成功 true，支付失败 false
     */
    boolean payBill(List<Integer> chargeFormIdList);
}
