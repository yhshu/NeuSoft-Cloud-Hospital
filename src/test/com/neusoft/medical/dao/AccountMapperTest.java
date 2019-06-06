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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:generatorConfig.xml","classpath:SqlMapConfig.xml"})
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
        int account = accountMapper.deleteByPrimaryKey(31);
    }

    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void insert() {
        Account account = new Account(null, "username", "password", 1, null, null, null);
        accountMapper.insert(account);
        System.out.println(account.getAccountId()+"+"+account.getUserName());
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
        Account account = accountMapper.selectByPrimaryKey(10);
        System.out.println(account.getAccountId()+"+"+account.getUserName());
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
        Account account = accountMapper.selectByPrimaryKey(15);
        account.setUserName("HUAWEI");
        account.setValid(1);
        account.setReserve1(null);
        account.setReserve2(null);
        account.setReserve3(null);
        accountMapper.updateByPrimaryKey(account);
        System.out.println(account.getAccountId()+"+"+account.getUserName());
    }
}