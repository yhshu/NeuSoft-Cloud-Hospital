package com.neusoft.medical.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Account;

import java.util.List;

public interface AccountService {

    /**
     * 分页、分类查找帐号信息
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @param accountType 帐号类型
     * @return 指定范围的帐号信息
     */
    PageInfo<Account> selectAccount(Integer currentPage, Integer pageSize, List<Integer> accountType);
}
