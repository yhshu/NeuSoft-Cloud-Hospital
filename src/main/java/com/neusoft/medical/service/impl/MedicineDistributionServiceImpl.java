package com.neusoft.medical.service.impl;

import com.neusoft.medical.service.pharmacyWorkstation.MedicineDistributionService;
import org.springframework.stereotype.Service;

@Service
public class MedicineDistributionServiceImpl implements MedicineDistributionService {
    @Override
    public String selectPrescriptionEntryList(int registrationId) {
        // todo
        return null;
    }

    @Override
    public Boolean prescriptionEntryDelivery(String prescriptionEntryListJson) {
        // todo
        return null;
    }
}
