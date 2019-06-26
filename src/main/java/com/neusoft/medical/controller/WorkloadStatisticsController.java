package com.neusoft.medical.controller;

import com.neusoft.medical.dto.ResultDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 工作量统计 控制器
 */
@RestController
@RequestMapping("/workload_statistics")
public class WorkloadStatisticsController {

    /**
     * 医生个人工作量统计
     *
     * @param startDatetime 开始时间
     * @param endDatetime   结束时间
     * @param doctorId      医生编号
     * @return 医生个人工作量信息
     */
    @GetMapping("/doctor")
    public ResultDTO<String> doctorWorkLoadStatistics(
            @RequestParam(value = "startDatetime") String startDatetime,
            @RequestParam(value = "endDatetime") String endDatetime,
            @RequestParam(value = "doctorId") Integer doctorId
    ) {
        // todo
        return null;
    }
}
