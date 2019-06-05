package com.neusoft.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Disease;
import com.neusoft.medical.bean.DiseaseCategory;
import com.neusoft.medical.dao.DiseaseCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DiagnosticCatalogService {

    @Autowired
    DiseaseCategoryMapper diseaseCategoryMapper;

    @Autowired
    DiseaseCategory diseaseCategory;

    /**
     * 获取疾病种类列表
     *
     * @return 疾病种类列表
     */
    public List<DiseaseCategory> findAllDiseaseCategory() {

    }

    /**
     * 按页获取疾病信息
     *
     * @param currentPage 当前页
     * @param pageSize    每页大小
     * @return
     */
    public PageInfo<Disease> selectDiseaseByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Disease> diseaseList = diseaseCategoryMapper.selectByPageAndSelections();
        PageInfo<Disease> diseasePageInfo = new PageInfo<>();
        return diseasePageInfo;
    }

}
