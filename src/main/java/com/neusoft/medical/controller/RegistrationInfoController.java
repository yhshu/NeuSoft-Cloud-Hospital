package com.neusoft.medical.controller;

import com.neusoft.medical.service.DepartmentService;
import com.neusoft.medical.service.DoctorService;
import com.neusoft.medical.service.RegistrationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 挂号信息控制器
 */
@Controller
public class RegistrationInfoController {
    @Autowired
    private RegistrationInfoService registrationInfoService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DepartmentService departmentService;
}
