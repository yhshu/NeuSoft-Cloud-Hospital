package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.ChargeFormExample;
import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.dao.ChargeFormMapper;
import com.neusoft.medical.dao.PatientMapper;
import com.neusoft.medical.dao.RegistrationMapper;
import com.neusoft.medical.service.pharmacyWorkstation.MedicineDistributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MedicineDistributeServiceImpl implements MedicineDistributeService {
    @Resource
    private PatientMapper patientMapper;
    @Resource
    private RegistrationMapper registrationMapper;
    @Resource
    private ChargeFormMapper chargeFormMapper;

    @Override
    public Patient selectPatient(int registrationId) {
        Registration registration = registrationMapper.selectByPrimaryKey(registrationId);
        return patientMapper.selectByPrimaryKey(registration.getPatientId());
    }

    @Override
    public String selectChargeFormList(int registrationId) {
        ChargeFormExample chargeFormExample = new ChargeFormExample();
//        chargeFormExample.or().andValidEqualTo(1).andRegistrationIdEqualTo();
        // todo
        return null;

    }
}
