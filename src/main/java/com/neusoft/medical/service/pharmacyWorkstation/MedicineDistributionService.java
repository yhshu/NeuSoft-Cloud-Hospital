package com.neusoft.medical.service.pharmacyWorkstation;

public interface MedicineDistributionService {

    String selectPrescriptionEntryList(int registrationId);

    Boolean prescriptionEntryDelivery(String prescriptionEntryListJson);
}