package com.neusoft.medical.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("patient")
public class PatientController {
    private Logger log = Logger.getLogger(PatientController.class);

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String addCall() {
        return "patient/add";
    }

    @RequestMapping(value = "/addOperate", method = {RequestMethod.POST}, params = {"name"})
    public String addOperate() {
        return "patient/list";
    }

    @RequestMapping(value = "/find", method = {RequestMethod.GET}, params = {"id"})
    public String find() {
        return "patient/list";
    }

    @RequestMapping("/update")
    public void update() {
    }

    @RequestMapping("/delete")
    public void delete() {
    }
}
