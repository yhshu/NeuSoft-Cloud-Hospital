package com.neusoft.medical.service.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Doctor;

import java.util.List;

public interface AccountService {

    String TYPE_OUTPATIENT_DOCTOR = "00";   // 门诊医生
    String TYPE_TECH_DOCTOR = "01";         // 医技医生
    String TYPE_COLLECTOR_STAFF = "10";     // 医院收费员
    String TYPE_PHARMACY_STAFF = "11";      // 药房操作员
    String TYPE_FINANCIAL_STAFF = "12";     // 财务管理员
    String TYPE_REGISTRATION_STAFF = "13";  // 挂号管理员

    /**
     * 分页、分类查找帐号信息
     *
     * @param currentPage  当前页码
     * @param pageSize     页面大小
     * @param accountScope 查找的帐号范围
     * @return 指定范围的帐号信息
     */
    PageInfo<String> selectAccount(Integer currentPage, Integer pageSize, List<String> accountScope);

    /**
     * 分页、分类查找医生信息（门诊医生、医技医生）
     *
     * @param currentPage  当前页码
     * @param pageSize     页面大小
     * @param accountScope 查找的医生范围
     * @return 指定范围的医生信息
     */
    PageInfo<Doctor> selectDoctor(Integer currentPage, Integer pageSize, List<String> accountScope);

    /**
     * 添加帐号
     * 密码存储在数据库前进行加密
     *
     * @param userName     帐号用户名
     * @param userPassword 帐号密码
     * @param accountType  用户类型
     *                     门诊医生 00
     *                     医技医生 01
     *                     医院收费员 10
     *                     药房操作员 11
     *                     财务管理员 12
     *                     挂号管理员 13
     * @return 操作结果
     */
    boolean addAccount(String userName, String userPassword, String accountType);

    boolean updateAccount(int accountId, String userName, String userPassword, String accountType);

    boolean deleteAccount(List<Integer> accountIdList);
}
