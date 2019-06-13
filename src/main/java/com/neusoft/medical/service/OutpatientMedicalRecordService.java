package com.neusoft.medical.service;

import com.neusoft.medical.bean.Patient;

import java.util.List;

/**
 * 门诊医生工作站
 * 门诊病历首页
 */
public interface OutpatientMedicalRecordService {
    /**
     * 根据挂号编号获取患者信息
     *
     * @param registrationId      挂号编号
     * @param patientScope 患者搜索范围：所有患者 0，本医生患者 1，本科室患者 2
     * @param doctorId            医生编号
     * @return 患者信息
     */
    Patient selectPatientByRegistrationId(int registrationId, int patientScope, int doctorId);

    /**
     * 根据患者姓名搜索患者信息
     * 支持子串搜索
     *
     * @param patientName         患者姓名
     * @param patientScope 患者搜索范围：所有患者 0，本医生患者 1，本科室患者 2
     * @param doctorId            医生编号
     * @return 患者信息
     */
    List<Patient> selectPatientByPatientName(String patientName, int patientScope, int doctorId);
}
