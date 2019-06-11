package com.neusoft.medical.service;

import com.neusoft.medical.bean.Doctor;

import java.util.List;

/**
 * 排班规则维护与排版信息
 */
public interface SchedulingService {

    /**
     * 找到指定科室的当前被排班的医生列表
     *
     * @param departmentId 科室编号
     * @return 可用医生列表
     */
    List<Doctor> findCurrentAvailableDoctor(int departmentId);
}
