package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Medicine;
import com.neusoft.medical.bean.MedicineExample;
import com.neusoft.medical.dao.MedicineMapper;
import com.neusoft.medical.service.doctorWorkstation.PrescriptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Resource
    private MedicineMapper medicineMapper;

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
}
