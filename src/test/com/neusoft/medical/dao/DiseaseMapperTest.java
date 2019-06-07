package com.neusoft.medical.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Disease;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class DiseaseMapperTest {
    private DiseaseMapper diseaseMapper;
    private SqlSession session;

    @Before
    public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream, "mysql");
        session = factory.openSession();
        diseaseMapper = session.getMapper(DiseaseMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        session.commit();
        session.close();
    }

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
    }
}