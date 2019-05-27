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
        "insert into doctor (doctor_id, doctor_name, ",
        "department, type, ",
        "title, scheduling, ",
        "reserve1, reserve2, ",
        "reserve3, account_id)",
        "values (#{doctorId,jdbcType=INTEGER}, #{doctorName,jdbcType=VARCHAR}, ",
        "#{department,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{title,jdbcType=INTEGER}, #{scheduling,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR}, #{accountId,jdbcType=INTEGER})"
    })
    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);
}