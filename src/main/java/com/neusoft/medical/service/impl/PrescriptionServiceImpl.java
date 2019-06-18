package com.neusoft.medical.service.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neusoft.medical.bean.Medicine;
import com.neusoft.medical.bean.MedicineExample;
import com.neusoft.medical.dao.MedicineMapper;
import com.neusoft.medical.dao.PrescriptionItemMapper;
import com.neusoft.medical.service.doctorWorkstation.PrescriptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Resource
    private MedicineMapper medicineMapper;
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
//            int saveState = prescriptionJsonObject

//                    * - saveState 保存状态（暂存 0；正式提交 1；全院模板 2；科室模板 3；医生个人模板 4）
//     * - medicine 处方中包含的药物清单，json 数组
//     * <p>
//     * - medicine 数组中每个元素包含的属性：
//     * - medicineId 处方药品编号
//                    * - medicineUsage 药品用途
//                    * - medicineDosage 药品用量
//                    * - medicineFrequency 药品使用频率
//                    * - medicineNumberDay 药品使用天数
//                    * - medicineQuantity 药品数量
//                    * - skinTest 皮试
//                    * - skinTestResult 皮试结果
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
