package com.neusoft.medical.service.doctorWorkstation;

import com.neusoft.medical.bean.Medicine;

import java.util.List;

/**
 * 成药处方、草药处方 服务
 */
public interface PrescriptionService {

    List<Medicine> selectMedicine();
}
