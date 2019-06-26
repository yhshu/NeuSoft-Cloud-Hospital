package com.neusoft.medical.service;

import java.util.Date;

public interface WorkloadStatisticsService {
    String techDoctorWorkloadStatistics(Date startDatetime, Date endDatetime, Integer doctorId);

    String outpatientDoctorWorkloadStatistics(Date startDatetime, Date endDatetime, Integer doctorId);

    String departmentWorkloadFinancialStatistics(Date startDatetime, Date endDatetime);

    String doctorWorkloadFinancialStatistics(Date startDatetime, Date endDatetime);
}
