package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Medicine;
import com.neusoft.medical.service.doctorWorkstation.PrescriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Override
    public List<Medicine> selectMedicine() {
        // todo
        return null;
    }
}
