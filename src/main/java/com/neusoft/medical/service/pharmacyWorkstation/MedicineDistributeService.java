package com.neusoft.medical.service.pharmacyWorkstation;

import com.neusoft.medical.bean.Patient;

/**
 * 门诊发药服务
 */
public interface MedicineDistributeService {
    /**
     * 按挂号单编号获取患者信息
     *
     * @param registrationId 挂号单编号
     * @return 患者信息
     */
    Patient selectPatient(int registrationId);

    /**
     * 按挂号单编号获取药品列表
     *
     * @param registrationId 挂号单编号
     * @return 药品列表，json 字符串
     */
    String selectChargeFormList(int registrationId);
}
