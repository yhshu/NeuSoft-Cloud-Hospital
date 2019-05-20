package com.neusoft.medical.service.impl;

import edu.neu.medical.hospital.bean.Doctor;
import edu.neu.medical.hospital.bean.DoctorExample;
import edu.neu.medical.hospital.dao.DoctorMapper;
import edu.neu.medical.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorMapper doctorMapper;
    public List<Doctor> findAll(){
        return  doctorMapper.selectByExample(new DoctorExample());
    }
}
