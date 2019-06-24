package com.neusoft.medical.service.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Account;
import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.Staff;

import java.util.List;

public interface AccountService {

    /**
     * 分页、分类查找帐号信息
     *
     * @param currentPage  当前页码
     * @param pageSize     页面大小
     * @param accountScope 查找的帐号范围
     * @return 指定范围的帐号信息
     * <p>
     * 返回的用户信息列表中，每项用户信息包含以下字段：
     * - accountId 帐户编号
     * - userName 用户名
     * - accountType 用户类型
     * - realName 真实姓名
     * - departmentId　 所属科室编号
     * - departmentName　所属科室名称
     * 对于医生，还包含
     * - jobTitle 职称
     * - doctorScheduling 是否参与排班
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
     *
     * @param userName         帐号用户名
     * @param userPassword     帐号密码
     * @param accountType      用户类型
     *                         门诊医生 00
     *                         医技医生 01
     *                         医院收费员 10
     *                         药房操作员 11
     *                         财务管理员 12
     *                         挂号管理员 13
     * @param realName         真实姓名
     * @param departmentId     科室编号
     * @param jobTitle         医生职称
     * @param doctorScheduling 医生是否参与排班
     * @return 操作结果
     */
    boolean addAccount(String userName, String userPassword, String accountType, String realName, int departmentId, String jobTitle, int doctorScheduling);

    /**
     * 更新帐号
     *
     * @param accountId        帐号编号
     * @param userName         帐号用户名
     * @param userPassword     帐号密码
     * @param realName         真实姓名
     * @param departmentId     科室编号
     * @param jobTitle         医生职称
     * @param doctorScheduling 医生是否参与排班
     * @return 操作结果
     */
    boolean updateAccount(int accountId, String userName, String userPassword, String realName, int departmentId, String jobTitle, Integer doctorScheduling);

    /**
     * 删除帐号
     *
     * @param accountIdList 帐号编号列表
     * @return 操作结果
     */
    boolean deleteAccount(List<Integer> accountIdList);

    /**
     * 按用户名查找帐号信息
     * 注意，该函数将查询到数据库中加密后的用户密码
     *
     * @param userName 用户名
     * @return 帐户信息
     */
    Account selectAccountByUserName(String userName);

    /**
     * 按帐户编号查找工作人员信息
     *
     * @param accountId 帐户编号
     * @return 工作人员信息
     */
    Staff selectStaffByAccountId(Integer accountId);
}
