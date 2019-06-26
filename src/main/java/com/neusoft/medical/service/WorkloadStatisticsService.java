package com.neusoft.medical.service;

import java.util.Date;

public interface WorkloadStatisticsService {
    String techDoctorWorkloadStatistics(Date startDatetimeConverted, Date endDatetimeConverted, Integer doctorId);

    String outpatientDoctorWorkloadStatistics(Date startDatetimeConverted, Date endDatetimeConverted, Integer doctorId);
}
