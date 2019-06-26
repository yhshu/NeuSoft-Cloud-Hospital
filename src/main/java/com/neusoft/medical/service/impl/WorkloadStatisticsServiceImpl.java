package com.neusoft.medical.service.impl;

import com.google.gson.JsonObject;
import com.neusoft.medical.bean.ChargeForm;
import com.neusoft.medical.bean.Examination;
import com.neusoft.medical.service.WorkloadStatisticsService;
import com.neusoft.medical.service.doctorWorkstation.PrescriptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WorkloadStatisticsServiceImpl implements WorkloadStatisticsService {
    @Resource
    private PrescriptionService prescriptionService;

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


    List<Examination> selectExaminationList(Date startDate, Date endDate, Integer doctorId) {
// todo
        return null;
    }

    List<ChargeForm> selectChargeFormList(Date startDate, Date endDate, Integer doctorId) {
        // todo
        return null;
    }
}
