package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.bean.PatientExample;
import com.neusoft.medical.dao.PatientMapper;
import com.neusoft.medical.service.OutpatientMedicalRecordService;

import javax.annotation.Resource;
import java.util.List;

public class OutpatientMedicalRecordServiceImpl implements OutpatientMedicalRecordService {
    @Resource
    private PatientMapper patientMapper;


    @Override
    public Patient selectPatientByRegistrationId(int registrationId) {
//        Patient patient;
//        try {
//            patient = patientMapper.();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        return patient;
//
//        try {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
        return null;
    }

    @Override
    public List<Patient> selectPatientByPatientName(String patientName) {
        PatientExample patientExample = new PatientExample();
        PatientExample.Criteria criteria = patientExample.createCriteria();
        criteria.andValidEqualTo(1); // 有效的患者信息
        criteria.andPatientNameLike(patientName); // 包含姓名

        return patientMapper.selectByExample(patientExample);
    }

}
