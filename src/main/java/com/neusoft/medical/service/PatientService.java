package com.neusoft.medical.service;

import com.neusoft.medical.bean.Patient;

import java.util.List;

public interface PatientService {
    /**
     * 查询所有患者
     *
     * @return 患者信息列表
     */
    List<Patient> findAll();

    /**
     * 删除多项患者信息
     *
     * @param ids 患者ID数组
     */
    void multiDelete(Integer[] ids);
}
