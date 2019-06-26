package com.neusoft.medical.controller;

import com.neusoft.medical.Util.DateTimeConverter;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.WorkloadStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 工作量统计 控制器
 */
@RestController
@RequestMapping("/workload_statistics")
public class WorkloadStatisticsController {
    @Resource
    private WorkloadStatisticsService workloadStatisticsService;
    @Resource
    private DateTimeConverter dateTimeConverter;

    /**
     * 临床医生个人工作量统计
     * 日期格式 yyyy-MM-dd HH:mm:ss
     *
     * @param startDatetime 开始时间
     * @param endDatetime   结束时间
     * @param doctorId      医生编号
     * @return 临床医生个人工作量数据
     */
    @GetMapping("/outpatient_doctor")
    public ResultDTO<String> outpatientDoctorWorkloadStatistics(
            @RequestParam(value = "startDatetime") String startDatetime,
            @RequestParam(value = "endDatetime") String endDatetime,
            @RequestParam(value = "doctorId") Integer doctorId
    ) {
        String res = null;
        try {
            Date startDatetimeConverted = dateTimeConverter.convert(startDatetime);
            Date endDatetimeConverted = dateTimeConverter.convert(endDatetime);
            res = workloadStatisticsService.outpatientDoctorWorkloadStatistics(startDatetimeConverted, endDatetimeConverted, doctorId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(res);
    }

    /**
     * 医技医生个人工作量统计
     * 日期格式 yyyy-MM-dd HH:mm:ss
     *
     * @param startDatetime 开始时间
     * @param endDatetime   结束时间
     * @param doctorId      医生编号
     * @return 医技医生个人工作量数据
     */
    @GetMapping("/tech_doctor")
    public ResultDTO<String> techDoctorWorkloadStatistics(
            @RequestParam(value = "startDatetime") String startDatetime,
            @RequestParam(value = "endDatetime") String endDatetime,
            @RequestParam(value = "doctorId") Integer doctorId
    ) {
        String res = null;
        try {
            Date startDatetimeConverted = dateTimeConverter.convert(startDatetime);
            Date endDatetimeConverted = dateTimeConverter.convert(endDatetime);
            res = workloadStatisticsService.techDoctorWorkloadStatistics(startDatetimeConverted, endDatetimeConverted, doctorId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(res);
    }

    /**
     * 门诊科室工作量统计
     * <p>
     * 日期格式 yyyy-MM-dd HH:mm:ss
     *
     * @param startDatetime 开始时间
     * @param endDatetime   结束时间
     * @return 各科室工作量统计数据
     */
    @GetMapping("/department")
    public ResultDTO<String> outpatientDepartmentWorkloadStatistics(
            @RequestParam(value = "startDatetime") String startDatetime,
            @RequestParam(value = "endDatetime") String endDatetime
    ) {
// todo
        return null;
    }
}
