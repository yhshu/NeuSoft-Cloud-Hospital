package com.neusoft.medical.service;

import com.neusoft.medical.bean.Registration;

import java.util.List;

/**
 * 门诊医生工作站
 * 门诊病历首页
 */
public interface OutpatientMedicalRecordService {
    /**
     * 获取医生的待诊患者列表
     *
     * @param registrationScope 查询的挂号范围
     * @param doctorId          医生编号
     * @return 待诊患者列表
     */
    List<Registration> waitingRegistrationList(int registrationScope, int doctorId);

    /**
     * 获取医生的已诊患者列表
     *
     * @param registrationScope 查询的挂号范围
     * @param doctorId          医生编号
     * @return 已诊患者列表
     */
    List<Registration> visitedRegistrationList(int registrationScope, int doctorId);
}
