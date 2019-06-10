package com.neusoft.medical.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 帐户登录控制器
 */
@Controller
public class LoginController {
    private Logger log = Logger.getLogger(LoginController.class);
    /**
     * 访问首页
     *
     * @param model 模型
     * @return jsp 页面
     */
    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }
    /**
     * 帐号登录验证
     */
    @RequestMapping("/login")
    public void login() {
        log.info("Login successful.");
    }
}
