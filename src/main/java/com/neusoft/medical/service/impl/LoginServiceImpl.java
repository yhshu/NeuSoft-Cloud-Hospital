package com.neusoft.medical.service.impl;

import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.bean.Account;
import com.neusoft.medical.bean.AccountExample;
import com.neusoft.medical.dao.AccountMapper;
import com.neusoft.medical.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    private Logger logger = Logger.getLogger(LoginService.class);

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private AccountMapper accountMapper;

    @Override
    public String signIn(String userName, String userPassword) {
        // 找到数据库中加密的用户密码，与用户当前输入的密码进行比对
        Account account = findAccountByUserName(userName);
        if (account == null)
            return Constant.SIGNIN_MISMATCH;

        if (bCryptPasswordEncoder.matches(userPassword, account.getUserPassword())) {
            logger.info("user " + userName + " successfully logged in");
            return Constant.SIGNIN_SUCCESS;
        } else {
            logger.info("password mismatch, username: " + userName + ", password" + userPassword);
            return Constant.SIGNIN_MISMATCH;
        }
    }

    /**
     * 私有函数
     * 注意，该函数将查询到数据库中加密后的用户密码
     *
     * @param userName 用户名
     * @return 帐户信息
     */
    private Account findAccountByUserName(String userName) {
        AccountExample accountExample = new AccountExample();
        accountExample.or().andValidEqualTo(1).andUserNameEqualTo(userName);

        List<Account> accountList = accountMapper.selectByExample(accountExample);

        if (accountList.isEmpty()) {
            logger.info("username " + userName + " does not exist");
            return null;

        } else if (accountList.size() > 1) {
            logger.error("username " + userName + " is duplicate, please check the uniqueness of the account table in the database");
            return null;
        }

        return accountList.get(0);
    }
}
