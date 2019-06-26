package com.neusoft.medical.service.impl;

import com.google.gson.JsonObject;
import com.neusoft.medical.bean.ChargeForm;
import com.neusoft.medical.bean.Examination;
import com.neusoft.medical.bean.Prescription;
import com.neusoft.medical.bean.PrescriptionExample;
import com.neusoft.medical.service.WorkloadStatisticsService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkloadStatisticsServiceImpl implements WorkloadStatisticsService {

    @Override
    public String outpatientDoctorWorkloadStatistics(Date startDatetime, Date endDatetime, Integer doctorId) {
        // todo
        JsonObject workloadStatistics = new JsonObject();
//        workloadStatistics.addProperty("patientNums", ); // 患者数量


        return null;
    }

    @Override
    public String techDoctorWorkloadStatistics(Date startDatetime, Date endDatetime, Integer doctorId) {
        // todo
        return null;
    }

    @Override
    public String departmentWorkloadFinancialStatistics(Date startDatetime, Date endDatetime) {
        // todo
        return null;
    }

    @Override
    public String doctorWorkloadFinancialStatistics(Date startDatetime, Date endDatetime) {
        // todo
        return null;
    }

    List<Prescription> selectPrescripionList(Date startDate, Date endDate, Integer doctorId) {
        PrescriptionExample prescriptionExample = new PrescriptionExample();
        prescriptionExample.or().andValidEqualTo(1).andDoctorIdEqualTo(doctorId);
        return null;
    }

    List<Examination> selectExaminationList(Date startDate, Date endDate, Integer doctorId) {
// todo
        return null;
    }

    List<ChargeForm> selectChargeFormList(Date startDate, Date endDate, Integer doctorId) {
        // todo
        return null;
    }
}
