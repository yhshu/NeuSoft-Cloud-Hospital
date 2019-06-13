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
     * @param registrationId 挂号编号
     * @return 患者信息
     */
    Patient selectPatientByRegistrationId(int registrationId);

    /**
     * 根据患者姓名搜索患者信息
     * 支持子串搜索
     *
     * @param patientName 患者姓名
     * @return 患者信息
     */
    List<Patient> selectPatientByPatientName(String patientName);
}
