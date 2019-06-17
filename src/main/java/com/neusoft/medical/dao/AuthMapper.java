package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Auth;
import com.neusoft.medical.example.AuthExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AuthMapper {
    long countByExample(AuthExample example);

    int deleteByExample(AuthExample example);

    @Delete({
        "delete from hospital.auth",
        "where auth_id = #{authId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer authId);

    @Insert({
        "insert into hospital.auth (auth_name, auth_description, ",
        "valid)",
        "values (#{authName,jdbcType=VARCHAR}, #{authDescription,jdbcType=VARCHAR}, ",
        "#{valid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="authId", before=false, resultType=Integer.class)
    int insert(Auth record);

    int insertSelective(Auth record);

    List<Auth> selectByExample(AuthExample example);

    @Select({
        "select",
        "auth_id, auth_name, auth_description, valid",
        "from hospital.auth",
        "where auth_id = #{authId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.AuthMapper.BaseResultMap")
    Auth selectByPrimaryKey(Integer authId);

    int updateByExampleSelective(@Param("record") Auth record, @Param("example") AuthExample example);

    int updateByExample(@Param("record") Auth record, @Param("example") AuthExample example);

    int updateByPrimaryKeySelective(Auth record);

    @Update({
        "update hospital.auth",
        "set auth_name = #{authName,jdbcType=VARCHAR},",
          "auth_description = #{authDescription,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where auth_id = #{authId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Auth record);
}