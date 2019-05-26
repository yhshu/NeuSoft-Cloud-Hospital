package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.DoctorExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface DoctorMapper {
    int countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    @Insert({
        "insert into doctor (id, name, ",
        "department, type, ",
        "title, scheduling)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{department,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{title,jdbcType=INTEGER}, #{scheduling,jdbcType=INTEGER})"
    })
    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);
}