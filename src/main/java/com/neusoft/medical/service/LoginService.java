package com.neusoft.medical.service;

public interface LoginService {
    /**
     * 用户登入
     *
     * @param userName 用户名
     * @param userPassword 密码
     * @return 登录成功 或 用户名密码不匹配
     */
    String signIn(String userName, String userPassword);
}
