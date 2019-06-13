package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.bean.RegistrationExample;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.dao.RegistrationMapper;
import com.neusoft.medical.service.OutpatientMedicalRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class OutpatientMedicalRecordServiceImpl implements OutpatientMedicalRecordService {

    @Resource
    private RegistrationMapper registrationMapper;

    @Resource
    private DoctorMapper doctorMapper;

    public final int REGIST_SCOPE_ALL = 0;
    public final int REGIST_SCOPE_DOCTOR = 1;
    public final int REGIST_SCOPE_DEPRAT = 2;

    @Override
    public List<Registration> waitingRegistrationList(int registrationScope, int doctorId) {
        RegistrationExample registrationExample = new RegistrationExample();
        try {
            RegistrationExample.Criteria criteria = registrationExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andIsVisitedEqualTo("0");
            if (registrationScope == REGIST_SCOPE_DOCTOR) {
                criteria.andDoctorIdEqualTo(doctorId);
            }
            if (registrationScope == REGIST_SCOPE_DEPRAT) {
                Doctor doctor = doctorMapper.selectByPrimaryKey(doctorId);
                int departmentId = doctor.getDepartment();
                criteria.andDepartmentIdEqualTo(departmentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CopyOnWriteArrayList<>();
        }
        return registrationMapper.selectByExample(registrationExample);
    }

    @Override
    public List<Registration> visitedRegistrationList(int registrationScope, int doctorId) {
        RegistrationExample registrationExample = new RegistrationExample();
        try {
            RegistrationExample.Criteria criteria = registrationExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andIsVisitedEqualTo("1");
            if (registrationScope == REGIST_SCOPE_DOCTOR) {
                criteria.andDoctorIdEqualTo(doctorId);
            }
            if (registrationScope == REGIST_SCOPE_DEPRAT) {
                Doctor doctor = doctorMapper.selectByPrimaryKey(doctorId);
                int departmentId = doctor.getDepartment();
                criteria.andDepartmentIdEqualTo(departmentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CopyOnWriteArrayList<>();
        }
        return registrationMapper.selectByExample(registrationExample);
    }
}
