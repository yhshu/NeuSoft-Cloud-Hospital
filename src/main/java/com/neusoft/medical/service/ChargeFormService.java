package com.neusoft.medical.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeForm;

public interface ChargeFormService {

    /**
     * 按挂号编号获取收费项目
     *
     * @param registrationId 挂号编号
     * @return 分页的收费项目列表
     */
    PageInfo<ChargeForm> selectChargeFormByRegistrationId(Integer currentPage, Integer pageSize, Integer registrationId);
}
