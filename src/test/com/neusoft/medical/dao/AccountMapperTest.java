package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;

@RunWith(SpringJUnit4ClassRunner.class)//测试类不变的东西
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:generatorConfig.xml","classpath:SqlMapConfig.xml"})//配置文件
public class AccountMapperTest {
    private AccountMapper accountMapper;
    private SqlSession session;

    @Before
    public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream, "mysql");
        session = factory.openSession();
        accountMapper = session.getMapper(AccountMapper.class);
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
        int account = accountMapper.deleteByPrimaryKey(31);//选择要删除的主键
    }

    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void insert() {
        Account account = new Account(null, "username", "password", 1, null, null, null);//新增数据
        accountMapper.insert(account);
        System.out.println("新增了数据："+account.getAccountId()+"+"+account.getUserName());
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
        Account account = accountMapper.selectByPrimaryKey(10);//选择要查找的主键
        System.out.println("查找的数据："+account.getAccountId()+"+"+account.getUserName());
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
        Account account = accountMapper.selectByPrimaryKey(15);//选择要更新数据的主键
        System.out.println("更新前的数据"+account.getAccountId()+account.getUserName());
        account.setUserName("HUAWEI");//更新名字
        account.setValid(1);//更新valid
        account.setReserve1(null);
        account.setReserve2(null);
        account.setReserve3(null);
        accountMapper.updateByPrimaryKey(account);
        System.out.println("更新后的数据："+account.getAccountId()+"+"+account.getUserName());
    }
}