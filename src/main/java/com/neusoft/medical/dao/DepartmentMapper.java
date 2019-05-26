package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Department;
import com.neusoft.medical.bean.DepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    @Insert({
        "insert into department (id, name, ",
        "type, category, ",
        "sub_type)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=INTEGER}, #{category,jdbcType=INTEGER}, ",
        "#{subType,jdbcType=INTEGER})"
    })
    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);
}