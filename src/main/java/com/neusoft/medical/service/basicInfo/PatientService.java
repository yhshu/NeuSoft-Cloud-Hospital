package com.neusoft.medical.service.basicInfo;

import com.neusoft.medical.bean.Patient;

public interface PatientService {

    /**
     * 按身份证号查找患者信息
     *
     * @param identifyCardNo 患者身份证号
     * @return 如果找到，返回患者信息；如果未找到，返回null
     */
    Patient selectPatientByIdentityCardNo(String identifyCardNo);
}
