package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Disease;
import com.neusoft.medical.bean.DiseaseCategory;
import com.neusoft.medical.dao.DiseaseCategoryMapper;
import com.neusoft.medical.dao.DiseaseMapper;
import com.neusoft.medical.service.DiagnosticCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiagnosticCatalogServiceImpl implements DiagnosticCatalogService {
//    @Resource
//    private DiseaseCategoryMapper diseaseCategoryMapper;

    @Autowired
    private DiseaseMapper diseaseMapper;

    /**
     * 获取疾病种类列表
     *
     * @return 疾病种类列表
     */
    public List<DiseaseCategory> findAllDiseaseCategory() {
        return null;
    }

    /**
     * 按页获取疾病信息
     *
     * @param currentPage 当前页
     * @param pageSize    每页大小
     * @return 指定页的疾病信息
     */
    public PageInfo<Disease> selectDiseaseByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Disease> diseaseList = diseaseMapper.selectByPageAndSelections();
        PageInfo<Disease> diseasePageInfo = new PageInfo<>(diseaseList);
        return diseasePageInfo;
    }

}
