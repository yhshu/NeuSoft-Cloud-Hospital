package com.neusoft.medical.service.basicInfo;

import com.neusoft.medical.bean.Doctor;

import java.util.List;

public interface DoctorService {

    /**
     * 获取包含所有医生的列表
     *
     * @return 医生信息列表
     */
    List<Doctor> findAllDoctor();

    /**
     * 获取指定医生的同科室的所有医生列表
     *
     * @param doctorId 医生编号
     * @return 同科室医生列表
     */
    List<Doctor> selectDepartmentDoctorListByDoctorId(Integer doctorId);

    /**
     * 获取指定医生的同科室的医生编号列表
     *
     * @param doctorId 医生编号
     * @return 同科室医生编号列表
     */
    List<Integer> selectDepartmentDoctorIdListByDoctorId(Integer doctorId);
}
