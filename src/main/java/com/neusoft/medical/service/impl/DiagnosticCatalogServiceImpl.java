package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Disease;
import com.neusoft.medical.bean.DiseaseCategory;
import com.neusoft.medical.bean.DiseaseCategoryExample;
import com.neusoft.medical.bean.DiseaseExample;
import com.neusoft.medical.dao.DiseaseCategoryMapper;
import com.neusoft.medical.dao.DiseaseMapper;
import com.neusoft.medical.service.DiagnosticCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiagnosticCatalogServiceImpl implements DiagnosticCatalogService {
    @Resource
    private DiseaseCategoryMapper diseaseCategoryMapper;

    @Resource
    private DiseaseMapper diseaseMapper;

    /**
     * 获取疾病种类列表
     *
     * @return 疾病种类列表
     */
    public List<DiseaseCategory> findAllDiseaseCategory() {
        DiseaseCategoryExample diseaseCategoryExample = new DiseaseCategoryExample();
        return diseaseCategoryMapper.selectByExample(diseaseCategoryExample);
    }

    /**
     * 按页获取疾病信息
     *
     * @param currentPage 当前页
     * @param pageSize    每页大小
     * @return 指定页的疾病信息
     */
    public PageInfo<Disease> selectDiseaseByPage(int currentPage, int pageSize, int diseaseCategoryId) {
        PageHelper.startPage(currentPage, pageSize);

        DiseaseExample diseaseExample = new DiseaseExample();
        DiseaseExample.Criteria criteria=  diseaseExample.createCriteria();
        criteria.andDiseaseCategoryEqualTo(diseaseCategoryId);

        List<Disease> diseaseList = diseaseMapper.selectByExample(diseaseExample);
        return new PageInfo<>(diseaseList);
    }
}
