package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.DepartmentExample;
import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.DoctorExample;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Resource
    private DoctorMapper doctorMapper;

    @Override
    public List<Doctor> findAllDoctor() {
        DoctorExample doctorExample = new DoctorExample();
        DoctorExample.Criteria criteria = doctorExample.createCriteria();
        criteria.andValidEqualTo(1);
        return doctorMapper.selectByExample(doctorExample);
    }
}
