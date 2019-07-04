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
    private WorkloadStatisticsService workloadStatisticsService;

    @Test
    public void outpatientDoctorWorkloadStatistics() {
        Date now = new Date();
        Date startDate = new Date(now.getTime() - 1000 * 60 * 60 * 24 * 7);// 一周以前
        for (int i = 1; i < 50; i++)
            workloadStatisticsService.outpatientDoctorWorkloadStatistics(startDate, now, i);
    }

    @Test
    public void techDoctorWorkloadStatistics() {
        Date now = new Date();
        Date startDate = new Date(now.getTime() - 1000 * 60 * 60 * 24 * 7);
        for (int i = 1; i < 50; i++)
            workloadStatisticsService.techDoctorWorkloadStatistics(startDate, now, i);
    }

    @Test
    public void departmentWorkloadFinancialStatistics() {
        Date now = new Date();
        Date startDate = new Date(now.getTime() - 1000 * 60 * 60 * 24 * 7);
        for (int i = 1; i < 50; i++)
        workloadStatisticsService.departmentWorkloadFinancialStatistics(startDate,now);
    }

    @Test
    public void doctorWorkloadFinancialStatistics() {
        Date now = new Date();
        Date startDate = new Date(now.getTime() - 1000 * 60 * 60 * 24 * 7);
        workloadStatisticsService.doctorWorkloadFinancialStatistics(startDate,now);
    }
}