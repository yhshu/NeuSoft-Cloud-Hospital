package com.neusoft.medical.service;

import com.neusoft.medical.bean.Registration;

public interface RegistrationInfoService {

    /**
     * 提交挂号信息
     *
     * @param record 挂号记录
     * @return 提交的挂号记录
     */
    Registration addRegistration(Registration record);
}
