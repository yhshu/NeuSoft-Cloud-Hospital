package com.neusoft.medical.controller.basicInfo;

import com.neusoft.medical.service.basicInfo.SchedulingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {
    @Resource
    private SchedulingService schedulingService;


}
