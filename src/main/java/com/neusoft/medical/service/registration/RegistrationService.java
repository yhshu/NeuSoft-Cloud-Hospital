package com.neusoft.medical.service.registration;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.bean.Registration;

import java.util.List;

public interface RegistrationService {

    /**
     * 提交挂号信息
     * 1. 新增挂号
     * 2. 新增患者信息
     * 3. 新增病历记录
     *
     * @param record 挂号记录
     * @return 提交的挂号记录
     * @throws Exception 操作异常
     */
    Registration addRegistration(Registration record) throws Exception;


    /**
     * 分页获取挂号信息
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @return 分页的挂号信息
     */
    PageInfo<Registration> listRegistration(int currentPage, int pageSize);

    /**
     * 获取挂号信息
     *
     * @param registrationId 挂号单编号
     * @return 挂号信息
     */
    Registration selectRegistrationByPrimaryKey(Integer registrationId);

    /**
     * 按挂号单编号获取患者的历史挂号列表
     *
     * @param registrationId 挂号单编号
     * @return 患者的历史挂号信息
     */
    List<Registration> historyRegistrationList(int registrationId);

    /**
     * 按挂号单编号获取患者的历史挂号单编号列表
     *
     * @param registrationId 挂号单编号
     * @return 患者的历史挂号单编号列表
     */
    List<Integer> historyRegistrationIdList(int registrationId);

    /**
     * 按挂号单编号获取患者信息
     *
     * @param registrationId 挂号单编号
     * @return 患者信息
     */
    Patient selectPatientByRegistrationId(int registrationId);
}
