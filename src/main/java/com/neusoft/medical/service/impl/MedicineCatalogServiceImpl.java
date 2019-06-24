package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.service.pharmacyWorkstation.MedicineCatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineCatalogServiceImpl implements MedicineCatalogService {
    @Override
    public PageInfo<String> selectMedicine(int currentPage, int pageSize) {
        // todo
        return null;
    }

    @Override
    public boolean addMedicine(String medicineJson) {
        // todo
        return false;
    }

    @Override
    public boolean deleteMedicine(List<Integer> medicineIdList) {
        // todo
        return false;
    }
}
