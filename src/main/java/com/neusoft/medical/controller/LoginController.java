package com.neusoft.medical.controller;

import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/sign_in")
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

    /**
     * 获取权限
     *
     * @param userName 用户名
     * @param token    登录验证成功后获得的 token
     * @return 用户权限
     */
    @PostMapping("/permission")
    public ResultDTO<String> permission(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "token") String token
    ) {
        String res = null;
        try {
            res = loginService.permissionRequest(userName, token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(res);
    }
}
