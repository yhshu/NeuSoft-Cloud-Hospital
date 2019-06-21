package com.neusoft.medical.dao;

import com.neusoft.medical.bean.UserAuth;
import com.neusoft.medical.bean.UserAuthExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserAuthMapper {
    long countByExample(UserAuthExample example);

    int deleteByExample(UserAuthExample example);

    @Delete({
        "delete from hospital..user_auth",
        "where user_auth_id = #{userAuthId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userAuthId);

    @Insert({
        "insert into hospital..user_auth (user_id, auth_id, ",
        "valid, operation_time)",
        "values (#{userId,jdbcType=INTEGER}, #{authId,jdbcType=INTEGER}, ",
        "#{valid,jdbcType=INTEGER}, #{operationTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userAuthId", before=false, resultType=Integer.class)
    int insert(UserAuth record);

    int insertSelective(UserAuth record);

    List<UserAuth> selectByExample(UserAuthExample example);

    @Select({
        "select",
        "user_auth_id, user_id, auth_id, valid, operation_time",
        "from hospital..user_auth",
        "where user_auth_id = #{userAuthId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.UserAuthMapper.BaseResultMap")
    UserAuth selectByPrimaryKey(Integer userAuthId);

    int updateByExampleSelective(@Param("record") UserAuth record, @Param("example") UserAuthExample example);

    int updateByExample(@Param("record") UserAuth record, @Param("example") UserAuthExample example);

    int updateByPrimaryKeySelective(UserAuth record);

    @Update({
        "update hospital..user_auth",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "auth_id = #{authId,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER},",
          "operation_time = #{operationTime,jdbcType=TIMESTAMP}",
        "where user_auth_id = #{userAuthId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserAuth record);
}