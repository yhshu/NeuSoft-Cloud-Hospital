package com.neusoft.medical.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Disease;
import com.neusoft.medical.bean.DiseaseCategory;

import java.util.List;

public interface DiagnosticCatalogService {

    List<DiseaseCategory> findAllDiseaseCategory();

    PageInfo<Disease> selectDiseaseByPage(int currentPage, int pageSize, int diseaseCategoryId);
}