package com.neusoft.medical.service.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Disease;
import com.neusoft.medical.bean.DiseaseCategory;

import java.util.List;
import java.util.concurrent.Future;

public interface DiagnosticCatalogService {

    Future<List<DiseaseCategory>> findAllDiseaseCategory();

    PageInfo<Disease> selectDiseaseByPage(int currentPage, int pageSize, int diseaseCategoryId);

    Disease addDisease(Disease record);

    boolean updateDisease(Disease record);

    boolean deleteDisease(List<Integer> diseaseIdList);
}