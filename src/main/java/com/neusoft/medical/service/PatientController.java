package com.neusoft.medical.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("patient")
public class PatientController {
    private Logger log = Logger.getLogger(PatientController.class);

    @RequestMapping(value = "/add", method = {RequestMethod.GET}, params = {"name"})
    public void add() {
    }

    @RequestMapping(value = "/find")
    public void find() {
    }

    @RequestMapping("/update")
    public void update() {
    }

    @RequestMapping("/delete")
    public void delete() {
    }
}
