package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Account;
import com.neusoft.medical.bean.AccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {
    long countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    @Delete({
        "delete from hospital..account",
        "where account_id = #{accountId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer accountId);

    @Insert({
        "insert into hospital..account (account_id, user_name, ",
        "user_password, valid, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{accountId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
        "#{userPassword,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    @Select({
        "select",
        "account_id, user_name, user_password, valid, reserve1, reserve2, reserve3",
        "from hospital..account",
        "where account_id = #{accountId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.AccountMapper.BaseResultMap")
    Account selectByPrimaryKey(Integer accountId);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    @Update({
        "update hospital..account",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "user_password = #{userPassword,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where account_id = #{accountId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Account record);
}