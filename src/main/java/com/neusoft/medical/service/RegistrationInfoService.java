package com.neusoft.medical.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Registration;

public interface RegistrationInfoService {

    /**
     * 提交挂号信息
     * 1. 新增挂号
     * 2. 新增患者信息
     * 3. 新增病历记录
     *
     * @param record 挂号记录
     * @return 提交的挂号记录
     */
    Registration addRegistration(Registration record) throws Exception;


    /**
     * 分页获取挂号信息
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @return 分页的挂号信息
     */
    PageInfo<Registration> listRegistration(int currentPage, int pageSize);

    /**
     * 获取挂号欧信息
     *
     * @param registrationId 挂号编号
     * @return 挂号信息
     */
    Registration selectRegistrationByPrimaryKey(Integer registrationId);
}
