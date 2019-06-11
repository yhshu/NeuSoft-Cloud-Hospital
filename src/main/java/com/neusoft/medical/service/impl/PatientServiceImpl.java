package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.bean.PatientExample;
import com.neusoft.medical.dao.PatientMapper;
import com.neusoft.medical.service.PatientService;

import javax.annotation.Resource;
import java.util.List;

public class PatientServiceImpl implements PatientService {

    @Resource
    private PatientMapper patientMapper;

    @Override
    public Patient selectPatientByIdentifyCardNo(String identifyCardNo) {
        PatientExample patientExample = new PatientExample();
        PatientExample.Criteria criteria = patientExample.createCriteria();
        criteria.andIdentifyCardNoEqualTo(identifyCardNo);
        List<Patient> patientList = patientMapper.selectByExample(patientExample);
        if (patientList.size() == 0) return null; // 尚未记录该患者信息
        if (patientList.size() > 1) {
            System.out.println("selectPatientByIdentifyCardNo: 患者身份证号重复");
            return null;
        }
        return patientList.get(0);
    }
}
