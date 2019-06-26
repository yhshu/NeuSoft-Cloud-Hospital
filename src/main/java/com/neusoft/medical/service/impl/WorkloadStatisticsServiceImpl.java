package com.neusoft.medical.service.impl;

import com.neusoft.medical.service.WorkloadStatisticsService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WorkloadStatisticsServiceImpl implements WorkloadStatisticsService {

    @Override
    public String techDoctorWorkloadStatistics(Date startDatetimeConverted, Date endDatetimeConverted, Integer doctorId) {
        // todo
        return null;
    }

    @Override
    public String outpatientDoctorWorkloadStatistics(Date startDatetimeConverted, Date endDatetimeConverted, Integer doctorId) {
        // todo
        return null;
    }
}
