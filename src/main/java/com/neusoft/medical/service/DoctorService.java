package com.neusoft.medical.service;

import com.neusoft.medical.bean.Doctor;

import java.util.List;

public interface DoctorService {

    /**
     * 获取包含所有医生的列表
     *
     * @return 医生信息列表
     */
    List<Doctor> findAllDoctor();
}
