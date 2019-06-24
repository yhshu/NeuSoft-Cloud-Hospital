package com.neusoft.medical.service.impl;

import com.neusoft.medical.dao.PrescriptionMapper;
import com.neusoft.medical.service.pharmacyWorkstation.MedicineDistributionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MedicineDistributionServiceImpl implements MedicineDistributionService {
    @Resource
    private PrescriptionMapper prescriptionMapper;

    @Override
    public String selectPrescriptionEntryList(int registrationId) {
//        PrescriptionExample prescriptionExample = new PrescriptionExample();
//        prescriptionExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId);
//
//        List<Prescription> prescriptionList = prescriptionMapper.selectByExample(prescriptionExample);
//        for (Prescription prescription : prescriptionList) {
//
//        }
        return null;
    }

    @Override
    public Boolean prescriptionEntryDelivery(String prescriptionEntryListJson) {
        // todo
        return null;
    }
}
