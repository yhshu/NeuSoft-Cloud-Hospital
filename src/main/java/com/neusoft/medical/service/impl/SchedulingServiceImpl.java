package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.DepartmentExample;
import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.DoctorExample;
import com.neusoft.medical.service.SchedulingService;

import java.util.List;

public class SchedulingServiceImpl implements SchedulingService {


    @Override
    public List<Doctor> findCurrentAvailableDoctor(int departmentId) {
        DoctorExample doctorExample = new DoctorExample();
        DoctorExample.Criteria criteria = doctorExample.createCriteria();
        criteria.andValidEqualTo(1);
//        criteria.and
        return null;
    }
}
