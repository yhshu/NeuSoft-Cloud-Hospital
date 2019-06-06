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
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.InputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Rollback(true)
public class AccountMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
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

    }

    @Test
    public void deleteByPrimaryKey() {
        accountMapper.deleteByPrimaryKey(20);
    }

    @Test
    public void insert() {
        Account account = new Account(null, "测试2", "test2", 1, null, null, null);
        accountMapper.insert(account);
        System.out.println(account.getAccountId()+account.getUserName());
        /*int accountId = account.getAccountId();
        Assert.assertEquals(accountMapper.selectByPrimaryKey(accountId).getAccountId().intValue(), accountId);
        Assert.assertEquals(accountMapper.selectByPrimaryKey(accountId).getUserName(), account.getUserName());*/
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
        Account account = accountMapper.selectByPrimaryKey(1);
        System.out.println(account.getUserName());
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
        Account account = accountMapper.selectByPrimaryKey(16);
        account.setUserName("小米");
        account.setUserPassword("xx-smile");
        account.setValid(1);
        accountMapper.updateByPrimaryKey(account);
        System.out.println(account.getUserName());
        /*Assert.assertEquals(accountMapper.selectByPrimaryKey(account.getAccountId()).getAccountId().intValue(),2);
        Assert.assertEquals(accountMapper.selectByPrimaryKey(account.getAccountId()).getUserName(),"HUAWEI");*/
    }
}