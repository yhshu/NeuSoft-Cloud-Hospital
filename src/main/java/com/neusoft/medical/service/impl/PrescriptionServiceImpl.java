package com.neusoft.medical.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.dao.MedicineMapper;
import com.neusoft.medical.dao.PrescriptionItemMapper;
import com.neusoft.medical.dao.PrescriptionMapper;
import com.neusoft.medical.service.doctorWorkstation.PrescriptionService;
import com.neusoft.medical.service.registration.RegistrationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Resource
    private MedicineMapper medicineMapper;
    @Resource
    private PrescriptionMapper prescriptionMapper;
    @Resource
    private PrescriptionItemMapper prescriptionItemMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private RegistrationService registrationService;

    private Gson gson = new Gson();

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
            int registrationId = -1;
            int doctorId = -1;
            int saveState = prescriptionJsonObject.getAsJsonPrimitive("saveState").getAsInt();
            if (saveState == SAVE_TEMP || saveState == SAVE_FORMAL) {
                // 暂存或正式提交
                registrationId = prescriptionJsonObject.getAsJsonPrimitive("registrationId").getAsInt();
            } else {
                // 存为模板
                doctorId = prescriptionJsonObject.getAsJsonPrimitive("doctorId").getAsInt();
            }

            if (prescriptionId == -1) {
                // 新增处方
                Prescription record = new Prescription(null, prescriptionName, registrationId, saveState, doctorId, 1, null, null, null);
                prescriptionMapper.insert(record);
                if (record.getPrescriptionId() == null)
                    throw new Exception("prescriptionId is still null after trying to insert the database.");
                prescriptionId = record.getPrescriptionId();
            } else {
                // 更新现有处方
                Prescription record = new Prescription(prescriptionId, prescriptionName, registrationId, saveState, doctorId, 1, null, null, null);
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

    @Override
    public String selectHistoryPrescription(Integer registrationId) {
        /*
         实现过程：
         1. 按挂号单编号获取相同患者的挂号单编号列表
         2. 找到每项挂号对应的历史处方
         3. 找到每项处方对应的处方药品列表
         4. 将数据转换为 json 字符串返回
         */

        String res = null;
        try {
            // 按挂号单编号获取相同患者的挂号单编号列表
            List<Integer> registrationIdList = registrationService.historyRegistratioinIdList(registrationId);

            // 找到每项挂号对应的历史处方
            PrescriptionExample prescriptionExample = new PrescriptionExample();
            prescriptionExample.or().andValidEqualTo(1).andRegistrationIdIn(registrationIdList).andSaveStateEqualTo(SAVE_FORMAL);
            prescriptionExample.or().andValidEqualTo(1).andRegistrationIdIn(registrationIdList).andSaveStateEqualTo(SAVE_TEMP);
            List<Prescription> prescriptionList = prescriptionMapper.selectByExample(prescriptionExample);

            res = prescriptionListToJson(prescriptionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public String selectPrescriptionTemplate(Integer prescriptionScope, Integer doctorId) {
        String res = null;
        try {
            if (prescriptionScope != SAVE_HOSPITAL_TEMPLATE && prescriptionScope != SAVE_DEPART_TEMPLATE && prescriptionScope != SAVE_DOCTOR_TEMPLATE) {
                System.out.println("关于模板搜索范围的参数非法");
                return null;
            }

            PrescriptionExample prescriptionExample = new PrescriptionExample();
            PrescriptionExample.Criteria prescriptionExampleCriteria = prescriptionExample.createCriteria();
            prescriptionExampleCriteria.andValidEqualTo(1).andSaveStateEqualTo(prescriptionScope);
            if (prescriptionScope == SAVE_DEPART_TEMPLATE) {
                // 科室模板
                DoctorExample doctorExample = new DoctorExample();
                DoctorExample.Criteria doctorExampleCriteria = doctorExample.createCriteria();
                doctorExampleCriteria.andValidEqualTo(1);
                doctorExampleCriteria.andDepartmentIdEqualTo(doctorMapper.selectByPrimaryKey(doctorId).getDepartmentId());
                List<Doctor> doctorList = doctorMapper.selectByExample(doctorExample);
                List<Integer> doctorIdList = new CopyOnWriteArrayList<>();
                for (Doctor doctor : doctorList) {
                    doctorIdList.add(doctor.getDoctorId());
                }

                prescriptionExampleCriteria.andDoctorIdIn(doctorIdList);
            } else if (prescriptionScope == SAVE_DOCTOR_TEMPLATE) {
                // 医生个人模板
                prescriptionExampleCriteria.andDoctorIdEqualTo(doctorId);
            }

            List<Prescription> prescriptionList = prescriptionMapper.selectByExample(prescriptionExample);
            res = prescriptionListToJson(prescriptionList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public String prescriptionListToJson(List<Prescription> prescriptionList) {
        String res = null;
        try {
            JsonArray prescriptionMedicineJsonArray = new JsonArray();
            for (Prescription prescription : prescriptionList) {
                JsonObject prescriptionJsonObject = gson.toJsonTree(prescription).getAsJsonObject();

                // 找到每项处方对应的药品信息
                PrescriptionItemExample prescriptionItemExample = new PrescriptionItemExample();
                prescriptionItemExample.or().andValidEqualTo(1).andPrescriptionItemIdEqualTo(prescription.getPrescriptionId());
                List<PrescriptionItem> prescriptionItemList = prescriptionItemMapper.selectByExample(prescriptionItemExample);

                prescriptionJsonObject.addProperty("medicine", gson.toJsonTree(prescriptionItemList).toString());
                prescriptionMedicineJsonArray.add(prescriptionJsonObject);
            }
            res = prescriptionMedicineJsonArray.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean deletePrescription(List<Integer> prescriptionIdList) {
        // 将处方和处方药品清单置为无效
        try {
            PrescriptionExample prescriptionExample = new PrescriptionExample();
            prescriptionExample.or().andValidEqualTo(1).andPrescriptionIdIn(prescriptionIdList);
            List<Prescription> prescriptionList = prescriptionMapper.selectByExample(prescriptionExample);

            for (Prescription prescription : prescriptionList) {
                // 将处方和处方药品置为无效
                Prescription prescriptionRecord = new Prescription();
                prescriptionRecord.setValid(0);
                prescriptionRecord.setPrescriptionId(prescription.getPrescriptionId());
                prescriptionMapper.updateByPrimaryKeySelective(prescriptionRecord);

                PrescriptionItem prescriptionItemRecord = new PrescriptionItem();
                prescriptionItemRecord.setValid(0);
                PrescriptionItemExample prescriptionItemExample = new PrescriptionItemExample();  // 该处方的药品清单
                prescriptionItemExample.or().andValidEqualTo(1).andPrescriptionIdEqualTo(prescription.getPrescriptionId());
                prescriptionItemMapper.updateByExampleSelective(prescriptionItemRecord, prescriptionItemExample);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
