package com.neusoft.medical.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.MedicineMapper;
import com.neusoft.medical.dao.PrescriptionItemMapper;
import com.neusoft.medical.dao.PrescriptionMapper;
import com.neusoft.medical.service.doctorWorkstation.PrescriptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Resource
    private MedicineMapper medicineMapper;
    @Resource
    private PrescriptionMapper prescriptionMapper;
    @Resource
    private PrescriptionItemMapper prescriptionItemMapper;

    @Override
    public List<Medicine> selectMedicine() {
        List<Medicine> medicineList;
        try {
            MedicineExample medicineExample = new MedicineExample();
            MedicineExample.Criteria criteria = medicineExample.createCriteria();
            criteria.andValidEqualTo(1);
            medicineList = medicineMapper.selectByExample(medicineExample);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return medicineList;
    }

    @Override
    public List<Medicine> searchMedicine(Integer resultNumber, String query) {
        List<Medicine> medicineList;
        try {
            MedicineExample medicineExample = new MedicineExample();
            medicineExample.or().andValidEqualTo(1).andNameZhLike(query);
            medicineExample.or().andValidEqualTo(1).andNamePinyinLike(query);
            medicineExample.setDistinct(true);
            medicineList = medicineMapper.selectByExample(medicineExample);
            medicineList = medicineList.subList(0, resultNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return medicineList;
    }

    @Override
    public List<Medicine> commonMedicine(Integer medicineNumber) {
        MedicineExample medicineExample = new MedicineExample();
        medicineExample.or().andValidEqualTo(1);
        List<Medicine> medicineList = medicineMapper.selectByExample(medicineExample);
        return medicineList.subList(0, medicineNumber);
    }

    @Override
    public boolean savePrescription(String prescriptionJson) {
        // 首先获取 json 字符串中的各变量
        // 然后将信息存储到数据库中

        try {
            JsonObject prescriptionJsonObject = new JsonParser().parse(prescriptionJson).getAsJsonObject();
            int prescriptionId = prescriptionJsonObject.getAsJsonPrimitive("prescriptionId").getAsInt();
            String prescriptionName = prescriptionJsonObject.getAsJsonPrimitive("prescriptionName").getAsString();
            int registrationId = prescriptionJsonObject.getAsJsonPrimitive("registrationId").getAsInt();
            int saveState = prescriptionJsonObject.getAsJsonPrimitive("saveState").getAsInt();

            if (prescriptionId == -1) {
                // 新增处方
                Prescription record = new Prescription(null, prescriptionName, registrationId, saveState, 1, null, null, null);
                prescriptionMapper.insert(record);
                if (record.getPrescriptionId() == null)
                    throw new Exception("prescriptionId is still null after trying to insert the database.");
                prescriptionId = record.getPrescriptionId();
            } else {
                // 更新现有处方
                Prescription record = new Prescription(prescriptionId, prescriptionName, registrationId, saveState, 1, null, null, null);
                PrescriptionExample prescriptionExample = new PrescriptionExample();
                prescriptionExample.or().andValidEqualTo(1).andPrescriptionIdEqualTo(prescriptionId);
                prescriptionMapper.updateByExampleSelective(record, prescriptionExample);
            }

            JsonArray medicineJsonArray = prescriptionJsonObject.getAsJsonArray("medicine");

            // 使之前的处方药物项失效
            PrescriptionItem prescriptionItemRecord = new PrescriptionItem();
            prescriptionItemRecord.setValid(0);
            PrescriptionItemExample prescriptionItemExample = new PrescriptionItemExample();
            prescriptionItemExample.or().andValidEqualTo(1).andPrescriptionIdEqualTo(prescriptionId);
            prescriptionItemMapper.updateByExampleSelective(prescriptionItemRecord, prescriptionItemExample);

            // 遍历处方药品，逐条存储
            for (int i = 0; i < medicineJsonArray.size(); i++) {
                JsonObject medicineJsonObject = medicineJsonArray.get(i).getAsJsonObject();
                int medicineId = medicineJsonObject.getAsJsonPrimitive("medicineId").getAsInt();
                String medicineUsage = medicineJsonObject.getAsJsonPrimitive("medicineUsage").getAsString();
                String medicineDosage = medicineJsonObject.getAsJsonPrimitive("medicineDosage").getAsString();
                String medicineFrequency = medicineJsonObject.getAsJsonPrimitive("medicineFrequency").getAsString();
                String medicineNumberDay = medicineJsonObject.getAsJsonPrimitive("medicineNumberDay").getAsString();
                int medicineQuantity = medicineJsonObject.getAsJsonPrimitive("medicineQuantity").getAsInt();
                String skinTest = medicineJsonObject.getAsJsonPrimitive("skinTest").getAsString();
                String skinTestResult = medicineJsonObject.getAsJsonPrimitive("skinTestResult").getAsString();

                prescriptionItemMapper.insert(new PrescriptionItem(null, medicineId, prescriptionId, medicineUsage, medicineDosage, medicineFrequency, medicineNumberDay, medicineQuantity, skinTest, skinTestResult, 1, null, null, null));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
