package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@Rollback
public class AccountMapperTest {
    private AccountMapper accountMapper;
    private SqlSession session;

@Before
public void setUp() throws  Exception{
    InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream, "mysql");
    session = factory.openSession();
    accountMapper = session.getMapper(AccountMapper.class);
}

@After
public void tearDown() throws  Exception{
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
    public void deleteByPrimaryKey() {//以主键删除
        Account account = new Account(2,"罗茜","123456",1,null,null,null);
        accountMapper.deleteByPrimaryKey(2);
        Assert.assertEquals(accountMapper.deleteByPrimaryKey(account.getAccountId()),2);
    }

    @Test
    public void insert() {//添加
        Account account = new Account(4,"卢本伟","123456",1,null,null,null);
        accountMapper.insert(account);
        Assert.assertEquals(accountMapper.selectByPrimaryKey(account.getAccountId()).getAccountId().intValue(),1);
        Assert.assertEquals(accountMapper.selectByPrimaryKey(account.getAccountId()).getUserName(),"卢本伟");
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {//以主键ID查找
        Account account = new Account(1,"蔡徐坤","123456",1,null,null,null);
        accountMapper.selectByPrimaryKey(1);
        Assert.assertEquals(accountMapper.selectByPrimaryKey(account.getAccountId()),1);
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
    public void updateByPrimaryKey() {//更新数据
        Account account = new Account(3,"许言","123456",1,null,null,null);
        accountMapper.insert(account);
        Assert.assertEquals(accountMapper.selectByPrimaryKey(account.getAccountId()).getAccountId().intValue(),3);
        Assert.assertEquals(accountMapper.selectByPrimaryKey(account.getAccountId()).getUserName(),"许言");

        account.setAccountId(3);
        account.setUserName("孙笑川");
        account.setUserPassword("123456");
        account.setReserve1(null);
        account.setReserve2(null);
        account.setReserve3(null);
        accountMapper.updateByPrimaryKey(account);
        Assert.assertEquals(accountMapper.selectByPrimaryKey(account.getAccountId()).getAccountId().intValue(),3);
        Assert.assertEquals(accountMapper.selectByPrimaryKey(account.getAccountId()).getUserName(),"孙笑川");

    }
}