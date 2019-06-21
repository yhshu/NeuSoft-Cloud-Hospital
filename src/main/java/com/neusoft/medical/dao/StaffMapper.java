package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Staff;
import com.neusoft.medical.bean.StaffExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StaffMapper {
    long countByExample(StaffExample example);

    int deleteByExample(StaffExample example);

    @Delete({
        "delete from hospital..staff",
        "where staff_id = #{staffId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer staffId);

    @Insert({
        "insert into hospital..staff (real_name, department_id, ",
        "account_id, account_type, ",
        "valid, reserve1, ",
        "reserve2, reserve3)",
        "values (#{realName,jdbcType=VARCHAR}, #{departmentId,jdbcType=INTEGER}, ",
        "#{accountId,jdbcType=INTEGER}, #{accountType,jdbcType=VARCHAR}, ",
        "#{valid,jdbcType=INTEGER}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="staffId", before=false, resultType=Integer.class)
    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExample(StaffExample example);

    @Select({
        "select",
        "staff_id, real_name, department_id, account_id, account_type, valid, reserve1, ",
        "reserve2, reserve3",
        "from hospital..staff",
        "where staff_id = #{staffId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.StaffMapper.BaseResultMap")
    Staff selectByPrimaryKey(Integer staffId);

    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByPrimaryKeySelective(Staff record);

    @Update({
        "update hospital..staff",
        "set real_name = #{realName,jdbcType=VARCHAR},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "account_id = #{accountId,jdbcType=INTEGER},",
          "account_type = #{accountType,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where staff_id = #{staffId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Staff record);
}