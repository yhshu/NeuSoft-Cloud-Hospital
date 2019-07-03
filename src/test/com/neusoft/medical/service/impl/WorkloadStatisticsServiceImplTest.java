package com.neusoft.medical.service.impl;

import com.neusoft.medical.service.WorkloadStatisticsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkloadStatisticsServiceImplTest {

    @Resource
    WorkloadStatisticsService workloadStatisticsService;

    @Test
    public void outpatientDoctorWorkloadStatistics() {
        Date today = new Date();
        Date startDate = new Date(today.getTime() - 1000 * 60 * 60 * 24 * 30);  // 一个月之前
        workloadStatisticsService.outpatientDoctorWorkloadStatistics(startDate,today,1);
    }

    @Test
    public void techDoctorWorkloadStatistics() {
        Date today = new Date();
        Date startDate = new Date(today.getTime() - 1000 * 60 * 60 * 24 * 30);  // 一个月之前
        workloadStatisticsService.techDoctorWorkloadStatistics(startDate,today,1);
    }

    @Test
    public void departmentWorkloadFinancialStatistics() {
        Date today = new Date();
        Date startDate = new Date(today.getTime() - 1000 * 60 * 60 * 24 * 30);  // 一个月之前
        workloadStatisticsService.departmentWorkloadFinancialStatistics(startDate,today);
    }

    @Test
    public void doctorWorkloadFinancialStatistics() {
        Date today = new Date();
        Date startDate = new Date(today.getTime() - 1000 * 60 * 60 * 24 * 30);  // 一个月之前
        workloadStatisticsService.doctorWorkloadFinancialStatistics(startDate,today);
    }
}