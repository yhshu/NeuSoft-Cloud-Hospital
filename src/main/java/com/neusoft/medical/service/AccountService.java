package com.neusoft.medical.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Account;
import com.neusoft.medical.bean.Doctor;

import java.util.List;

public interface AccountService {

    /**
     * 分页、分类查找帐号信息
     *
     * @param currentPage  当前页码
     * @param pageSize     页面大小
     * @param accountScope 查找的帐号范围
     * @return 指定范围的帐号信息
     */
    PageInfo<Account> selectAccount(Integer currentPage, Integer pageSize, List<String> accountScope);

    /**
     * 分页、分类查找医生信息（门诊医生、医技医生）
     *
     * @param currentPage  当前页码
     * @param pageSize     页面大小
     * @param accountScope 查找的医生范围
     * @return 指定范围的医生信息
     */
    PageInfo<Doctor> selectDoctor(Integer currentPage, Integer pageSize, List<String> accountScope);
}
