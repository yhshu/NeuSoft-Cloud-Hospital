package com.neusoft.medical.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Registration;

public interface RegistrationInfoService {

    /**
     * 提交挂号信息
     *
     * @param record 挂号记录
     * @return 提交的挂号记录
     */
    Registration addRegistration(Registration record);


    /**
     * 分页获取挂号信息
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @return 分页的挂号信息
     */
    PageInfo<Registration> listRegistration(int currentPage, int pageSize);
}
