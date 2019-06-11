package com.neusoft.medical.service;

import com.neusoft.medical.bean.Doctor;

import java.util.List;

/**
 * 排班规则维护与排版信息
 */
public interface SchedulingService {

    List<Doctor> findCurrentAvailableDoctor();
}
