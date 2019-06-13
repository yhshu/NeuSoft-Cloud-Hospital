package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.bean.PatientExample;
import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.dao.PatientMapper;
import com.neusoft.medical.dao.RegistrationMapper;
import com.neusoft.medical.service.OutpatientMedicalRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OutpatientMedicalRecordServiceImpl implements OutpatientMedicalRecordService {
    @Resource
    private PatientMapper patientMapper;

    @Resource
    private RegistrationMapper registrationMapper;

    @Resource
    private DoctorMapper doctorMapper;

    public final int PATIENT_SCOPE_ALL = 0;
    public final int PATIENT_SCOPE_DOCTOR = 1;
    public final int PATIENT_SCOPE_DEPART = 2;

    @Override
    public Patient selectPatientByRegistrationId(int registrationId, int patientScope, int doctorId) {
        try {
            Registration registration = registrationMapper.selectByPrimaryKey(registrationId);
            if (registration.getValid() == 0)
                return null;
            if (patientScope == PATIENT_SCOPE_DOCTOR && registration.getDoctorId() != doctorId)
                return null;
            if (patientScope == PATIENT_SCOPE_DEPART) {
                Doctor doctor = doctorMapper.selectByPrimaryKey(doctorId);
                if (!registration.getDepartmentId().equals(doctor.getDepartment()))
                    return null;
            }
            int patientId = registration.getPatientId();

            Patient patient = patientMapper.selectByPrimaryKey(patientId);
            if (patient.getValid() == 0)
                return null;
            return patient;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Patient> selectPatientByPatientName(String patientName, int patientScope, int doctorId) {
        PatientExample patientExample = new PatientExample();
        PatientExample.Criteria criteria = patientExample.createCriteria();
        criteria.andValidEqualTo(1); // 有效的患者信息
        criteria.andPatientNameLike(patientName); // 包含姓名
        // todo

        return patientMapper.selectByExample(patientExample);
    }

}
