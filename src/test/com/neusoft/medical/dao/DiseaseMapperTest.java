package com.neusoft.medical.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Disease;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiseaseMapperTest {
    @Autowired
    private DiseaseMapper diseaseMapper;

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectByPageAndSelections() {
        int currentPage = 1;
        int pageSize = 20;
        PageHelper.startPage(currentPage, pageSize);
        List<Disease> diseaseList = diseaseMapper.selectByPageAndSelections();
        PageInfo<Disease> diseasePageInfo = new PageInfo<>(diseaseList);
        System.out.println(diseasePageInfo);
    }
}