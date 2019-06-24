package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neusoft.medical.bean.Medicine;
import com.neusoft.medical.bean.MedicineExample;
import com.neusoft.medical.dao.MedicineMapper;
import com.neusoft.medical.service.pharmacyWorkstation.MedicineCatalogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class MedicineCatalogServiceImpl implements MedicineCatalogService {
    @Resource
    private MedicineMapper medicineMapper;

    private Gson gson = new Gson();

    @Override
    public PageInfo<String> selectMedicine(int currentPage, int pageSize) {
        List<String> medicineListJson = new CopyOnWriteArrayList<>();
        try {
            PageHelper.startPage(currentPage, pageSize);

            MedicineExample medicineExample = new MedicineExample();
            medicineExample.or().andValidEqualTo(1);

            List<Medicine> medicineList = medicineMapper.selectByExample(medicineExample);
            for (Medicine medicine : medicineList) {
                String medicineJson = gson.toJson(medicine);
                medicineListJson.add(medicineJson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PageInfo<>(medicineListJson);
    }

    @Override
    public boolean saveMedicine(String medicineJson) {
        try {
            JsonObject medicineJsonObject = new JsonParser().parse(medicineJson).getAsJsonObject();
            Integer medicineId = medicineJsonObject.get("medicineId").getAsInt();
            String medicineCode = medicineJsonObject.get("medicineCode").getAsString();
            String nameZh = medicineJsonObject.get("nameZh").getAsString();
            String medicineSpecification = medicineJsonObject.get("medicineSpecification").getAsString();
            String medicineUnit = medicineJsonObject.get("medicineUnit").getAsString();
            String medicineManufacturer = medicineJsonObject.get("medicineManufacturer").getAsString();
            Integer medicineDosageId = medicineJsonObject.get("medicineDosageId").getAsInt();
            Integer medicineTypeId = medicineJsonObject.get("medicineTypeId").getAsInt();
            Double medicinePrice = medicineJsonObject.get("medicinePrice").getAsDouble();
            String namePinyin = medicineJsonObject.get("namePinyin").getAsString();
            Integer nums = medicineJsonObject.get("nums").getAsInt();
            String nameEn = medicineJsonObject.get("nameEn").getAsString();

            Medicine medicineRecord = new Medicine(null, medicineCode, nameZh, medicineSpecification, medicineUnit, medicineManufacturer, medicineDosageId, medicineTypeId, medicinePrice, namePinyin, null, nums, nameEn, 1, null, null, null);

            if (medicineId != null) {
                // 更新药品信息
                medicineRecord.setMedicineId(medicineId);
                medicineMapper.updateByPrimaryKeySelective(medicineRecord);
            } else {
                // 新增药品信息
                medicineRecord.setCreationTime(new Date());
                medicineMapper.insert(medicineRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteMedicine(List<Integer> medicineIdList) {
        try {
            MedicineExample medicineExample = new MedicineExample();
            medicineExample.or().andValidEqualTo(1).andMedicineIdIn(medicineIdList);

            Medicine medicineRecord = new Medicine();
            medicineRecord.setValid(0);

            medicineMapper.updateByExampleSelective(medicineRecord,medicineExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
