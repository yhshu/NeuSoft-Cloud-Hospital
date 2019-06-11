package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.*;
import com.neusoft.medical.service.SchedulingService;

import java.util.List;

public class SchedulingServiceImpl implements SchedulingService {


    @Override
    public List<Doctor> findCurrentAvailableDoctor(int departmentId) {
        DoctorExample doctorExample = new DoctorExample();
        DoctorExample.Criteria criteria = doctorExample.createCriteria();
        criteria.andValidEqualTo(1);
//        criteria.and
        SchedulingInfoExample example = new SchedulingInfoExample();
        SchedulingInfoExample.Criteria criteria1 = example.createCriteria();

        return null;
    }
}
