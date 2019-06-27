package com.neusoft.medical.service;

public interface LoginService {
    /**
     * 用户登入
     *
     * @param userName     用户名
     * @param userPassword 密码
     * @return 登录成功 或 用户名密码不匹配
     */
    String signIn(String userName, String userPassword);

    /**
     * 获取权限
     *
     * @param userName 用户名
     * @param token    登录验证成功后获得的 token
     * @return 用户权限
     */
    String permissionRequest(String userName, String token);
}
