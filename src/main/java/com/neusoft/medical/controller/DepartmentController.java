package com.neusoft.medical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

/**
 * 科室管理控制器
 */
@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping("/department")
public class DepartmentController {
    private Logger log = Logger.getLogger(String.valueOf(DepartmentController.class));

    @RequestMapping("/add")
    public String add() {
        return "department/add";
    }
}
