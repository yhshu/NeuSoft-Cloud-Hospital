package com.neusoft.medical.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.neusoft.medical.bean.Prescription;
import com.neusoft.medical.bean.PrescriptionEntry;
import com.neusoft.medical.bean.PrescriptionEntryExample;
import com.neusoft.medical.bean.PrescriptionExample;
import com.neusoft.medical.dao.PrescriptionEntryMapper;
import com.neusoft.medical.dao.PrescriptionMapper;
import com.neusoft.medical.service.pharmacyWorkstation.MedicineDistributionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MedicineDistributionServiceImpl implements MedicineDistributionService {
    @Resource
    private PrescriptionMapper prescriptionMapper;
    @Resource
    private PrescriptionEntryMapper prescriptionEntryMapper;

    private Gson gson = new Gson();

    @Override
    public String selectPrescriptionEntryList(int registrationId) {
        // 首先根据病历号获取该挂号的所有处方，然后针对每一项处方找到处方项列表
        // 将每一个处方项添加到 json 数组中返回

        JsonArray prescriptionEntryListJsonArray = new JsonArray();

        PrescriptionExample prescriptionExample = new PrescriptionExample();
        prescriptionExample.or().andValidEqualTo(1).andRegistrationIdEqualTo(registrationId);

        List<Prescription> prescriptionList = prescriptionMapper.selectByExample(prescriptionExample);
        for (Prescription prescription : prescriptionList) {
            PrescriptionEntryExample prescriptionEntryExample = new PrescriptionEntryExample();
            prescriptionEntryExample.or().andValidEqualTo(1).andPrescriptionIdEqualTo(prescription.getPrescriptionId());

            List<PrescriptionEntry> prescriptionEntryList = prescriptionEntryMapper.selectByExample(prescriptionEntryExample);
            for (PrescriptionEntry prescriptionEntry : prescriptionEntryList) {
                prescriptionEntryListJsonArray.add(gson.toJsonTree(prescriptionEntry));
            }
        }
        return prescriptionEntryListJsonArray.toString();
    }

    @Override
    public Boolean prescriptionEntryDelivery(String prescriptionEntryListJson) {
        // todo
        return null;
    }
}
