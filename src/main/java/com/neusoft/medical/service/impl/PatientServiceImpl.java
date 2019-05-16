package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.dao.PatientDao;
import com.neusoft.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientDao patientDao;


    @Override
    public List<Patient> findAll() {
        return patientDao.findAll();
    }

    @Override
    public void multiDelete(Integer[] ids) {
        patientDao.multiDelete(ids);
    }
}
