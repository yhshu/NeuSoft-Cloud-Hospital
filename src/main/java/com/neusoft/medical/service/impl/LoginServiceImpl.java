package com.neusoft.medical.service.impl;

import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.bean.Account;
import com.neusoft.medical.dao.AccountMapper;
import com.neusoft.medical.service.LoginService;
import com.neusoft.medical.service.basicInfo.AccountService;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    private Logger logger = Logger.getLogger(LoginService.class);

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private AccountService accountService;

    @Override
    public String signIn(String userName, String userPassword) {
        // 找到数据库中加密的用户密码，与用户当前输入的密码进行比对
        Account account = accountService.selectAccountByUserName(userName);
        if (account == null)
            return Constant.SIGNIN_MISMATCH;

        if (bCryptPasswordEncoder.matches(userPassword, account.getUserPassword())) {
            logger.info("user " + userName + " successfully logged in");
            return Constant.SIGNIN_SUCCESS;
        } else {
            logger.info("password mismatch, username: " + userName + ", password: " + userPassword);
            return Constant.SIGNIN_MISMATCH;
        }
    }
}
