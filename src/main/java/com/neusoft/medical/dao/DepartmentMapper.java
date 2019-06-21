package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Department;
import com.neusoft.medical.bean.DepartmentExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentMapper {
    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    @Delete({
        "delete from hospital.department",
        "where department_id = #{departmentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer departmentId);

    @Insert({
        "insert into hospital.department (department_code, department_name, ",
        "category, type, ",
        "valid, reserve1, ",
        "reserve2, reserve3)",
        "values (#{departmentCode,jdbcType=VARCHAR}, #{departmentName,jdbcType=VARCHAR}, ",
        "#{category,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{valid,jdbcType=INTEGER}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="departmentId", before=false, resultType=Integer.class)
    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    @Select({
        "select",
        "department_id, department_code, department_name, category, type, valid, reserve1, ",
        "reserve2, reserve3",
        "from hospital.department",
        "where department_id = #{departmentId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.DepartmentMapper.BaseResultMap")
    Department selectByPrimaryKey(Integer departmentId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    @Update({
        "update hospital.department",
        "set department_code = #{departmentCode,jdbcType=VARCHAR},",
          "department_name = #{departmentName,jdbcType=VARCHAR},",
          "category = #{category,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where department_id = #{departmentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Department record);
}