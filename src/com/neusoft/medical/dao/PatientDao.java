package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Patient;

import java.util.List;

/**
 * 患者信息 数据访问对象
 */
public interface PatientDao {
    /**
     * 查找所有患者
     *
     * @return 所有患者的列表
     */
    List<Patient> findAll();

    /**
     * 通过ID查找患者
     *
     * @param id 患者ID
     * @return 查询到的唯一患者
     */
    Patient findById(int id);

    /**
     * 添加患者信息
     *
     * @param patient 患者信息
     */
    void add(Patient patient);

    /**
     * 更新患者信息
     *
     * @param patient 患者信息
     */
    void update(Patient patient);

    /**
     * 删除患者信息
     *
     * @param id 患者ID
     */
    void deleteById(int id);
}
