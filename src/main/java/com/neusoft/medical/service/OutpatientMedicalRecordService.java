package com.neusoft.medical.service;

import com.neusoft.medical.bean.Patient;

/**
 * 门诊医生工作站
 * 门诊病历首页
 */
public interface OutpatientMedicalRecordService {

    Patient selectPatientByPatientId(int patientId);

    Patient selectPatientByPatientName(String patientName);
}
