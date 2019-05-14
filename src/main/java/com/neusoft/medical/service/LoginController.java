package com.neusoft.medical.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")

public class LoginController {
    private Logger log = Logger.getLogger(LoginController.class);

    @RequestMapping("/login")

    public void login() {

        log.info("Login successful.");
    }
}
