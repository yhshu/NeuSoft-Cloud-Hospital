package com.neusoft.medical.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Patient;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PatientDaoTest {
    private PatientDao patientDao;
    private SqlSession session;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findAll() {
        PageHelper.startPage(10, 20);
        List<Patient> patientList = patientDao.findAll();
        PageInfo<Patient> patientPageInfo = new PageInfo<>(patientList);
        patientList = patientPageInfo.getList();
        System.out.println(patientPageInfo.getPageSize());
        System.out.println(patientPageInfo.getPageNum());
        System.out.println(patientPageInfo.getPages());

        for (Patient patient : patientList) {
            System.out.println(patient);
        }
    }

}