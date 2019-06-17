package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.example.DoctorExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DoctorMapper {
    long countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    @Delete({
        "delete from hospital.doctor",
        "where doctor_id = #{doctorId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer doctorId);

    @Insert({
        "insert into hospital.doctor (doctor_name, department_id, ",
        "job_title, account_id, ",
        "account_type, doctor_scheduling, ",
        "valid, reserve1, ",
        "reserve2, reserve3)",
        "values (#{doctorName,jdbcType=VARCHAR}, #{departmentId,jdbcType=INTEGER}, ",
        "#{jobTitle,jdbcType=VARCHAR}, #{accountId,jdbcType=INTEGER}, ",
        "#{accountType,jdbcType=VARCHAR}, #{doctorScheduling,jdbcType=INTEGER}, ",
        "#{valid,jdbcType=INTEGER}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="doctorId", before=false, resultType=Integer.class)
    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    @Select({
        "select",
        "doctor_id, doctor_name, department_id, job_title, account_id, account_type, ",
        "doctor_scheduling, valid, reserve1, reserve2, reserve3",
        "from hospital.doctor",
        "where doctor_id = #{doctorId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.DoctorMapper.BaseResultMap")
    Doctor selectByPrimaryKey(Integer doctorId);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByPrimaryKeySelective(Doctor record);

    @Update({
        "update hospital.doctor",
        "set doctor_name = #{doctorName,jdbcType=VARCHAR},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "job_title = #{jobTitle,jdbcType=VARCHAR},",
          "account_id = #{accountId,jdbcType=INTEGER},",
          "account_type = #{accountType,jdbcType=VARCHAR},",
          "doctor_scheduling = #{doctorScheduling,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where doctor_id = #{doctorId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Doctor record);
}