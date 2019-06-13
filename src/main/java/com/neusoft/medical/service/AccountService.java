package com.neusoft.medical.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Account;

public interface AccountService {

PageInfo<Account> selectAccount (Integer currentPage, Integer pageSize);
}
