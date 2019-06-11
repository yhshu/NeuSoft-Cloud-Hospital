package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Disease;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)//测试类不变的东西
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:generatorConfig.xml","classpath:SqlMapConfig.xml"})//配置文件
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
    public void deleteByPrimaryKey() {
        int disease = diseaseMapper.deleteByPrimaryKey(501);
    }

    @Test
    public void insert() {
        Disease disease = new Disease(null,"XXX","你好蔡","A99.99",99,null);
        diseaseMapper.insert(disease);
        System.out.println("新增了数据："+disease.getDiseaseId()+"+"+disease.getDiseaseCode());
    }

    @Test
    public void selectByPrimaryKey() {
        int disease = diseaseMapper.deleteByPrimaryKey(501);
    }

    @Test
    public void updateByPrimaryKey() {
        Disease disease = diseaseMapper.selectByPrimaryKey(1);
        disease.setDiseaseCode("xxx");
        disease.setDiseaseCategory(1);
        disease.setDiseaseIcd("xxx");
        disease.setDiseaseName("xxx");
        disease.setValid(1);
        diseaseMapper.updateByPrimaryKey(disease);
    }
}