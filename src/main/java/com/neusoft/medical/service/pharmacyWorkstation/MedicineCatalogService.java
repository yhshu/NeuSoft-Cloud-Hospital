package com.neusoft.medical.service.pharmacyWorkstation;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MedicineCatalogService {
    PageInfo<String> selectMedicine(int currentPage, int pageSize);

    boolean saveMedicine(String medicineJson);

    boolean deleteMedicine(List<Integer> medicineIdList);
}
