package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Disease;
import com.neusoft.medical.bean.DiseaseCategory;
import com.neusoft.medical.bean.DiseaseCategoryExample;
import com.neusoft.medical.bean.DiseaseExample;
import com.neusoft.medical.dao.DiseaseCategoryMapper;
import com.neusoft.medical.dao.DiseaseMapper;
import com.neusoft.medical.service.basicInfo.DiagnosticCatalogService;
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
        diseaseCategoryExample.or().andValidEqualTo(1);
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
        DiseaseExample.Criteria criteria = diseaseExample.createCriteria();
        criteria.andDiseaseCategoryEqualTo(diseaseCategoryId).andValidEqualTo(1);

        List<Disease> diseaseList = diseaseMapper.selectByExample(diseaseExample);
        return new PageInfo<>(diseaseList);
    }

    /**
     * 新增的疾病信息
     *
     * @param record 提交的疾病信息
     * @return 新增的疾病信息
     */
    @Override
    public Disease addDisease(Disease record) {
        int effectRow = diseaseMapper.insert(record);
        System.out.println("addDisease 新增记录 " + effectRow + " 项");
        Disease res = null;
        try{
            res =  diseaseMapper.selectByPrimaryKey(record.getDiseaseId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean updateDisease(Disease record) {
        try {
            diseaseMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteDisease(List<Integer> diseaseIdList) {
        try {
            DiseaseExample diseaseExample = new DiseaseExample();
            DiseaseExample.Criteria criteria = diseaseExample.createCriteria();
            criteria.andValidEqualTo(1).andDiseaseIdIn(diseaseIdList);

            Disease diseaseRecord = new Disease();
            diseaseRecord.setValid(0);
            diseaseMapper.updateByExampleSelective(diseaseRecord, diseaseExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
