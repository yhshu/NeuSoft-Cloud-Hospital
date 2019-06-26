package com.neusoft.medical.service.impl;

import com.neusoft.medical.service.WorkloadStatisticsService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WorkloadStatisticsServiceImpl implements WorkloadStatisticsService {

    @Override
    public String outpatientDoctorWorkloadStatistics(Date startDatetime, Date endDatetime, Integer doctorId) {
        // todo
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
}
