package com.neusoft.medical.controller;

import com.neusoft.medical.service.DepartmentService;
import com.neusoft.medical.service.DoctorService;
import com.neusoft.medical.service.RegistrationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 挂号信息控制器
 */
@Controller
public class RegistrationInfoController {
    @Autowired
    RegistrationInfoService registrationInfoService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    DepartmentService departmentService;
}
