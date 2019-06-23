package com.neusoft.medical.controller;

import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 帐户登录控制器
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    private Logger logger = Logger.getLogger(LoginController.class);

    @Resource
    private LoginService loginService;

    /**
     * 帐户登录验证
     *
     * @param userName     用户名
     * @param userPassword 密码
     * @return 操作结果
     */
    @RequestMapping("/sign_in")
    public ResultDTO<String> signIn(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "userPassword") String userPassword
    ) {
        String res = null;
        try {
            res = loginService.signIn(userName, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(res);
    }
}
