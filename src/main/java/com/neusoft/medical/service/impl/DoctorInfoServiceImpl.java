package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.example.DoctorExample;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.service.basicInfo.DoctorInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DoctorInfoServiceImpl implements DoctorInfoService {
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
