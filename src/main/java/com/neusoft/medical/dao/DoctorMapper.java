package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.DoctorExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DoctorMapper {
    long countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    @Delete({
        "delete from hospital.doctor",
        "where doctor_id = #{doctorId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer doctorId);

    @Insert({
        "insert into hospital.doctor (doctor_id, doctor_name, ",
        "department, type, ",
        "job_title, account_id, ",
        "valid, doctor_scheduling, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{doctorId,jdbcType=INTEGER}, #{doctorName,jdbcType=VARCHAR}, ",
        "#{department,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{jobTitle,jdbcType=VARCHAR}, #{accountId,jdbcType=INTEGER}, ",
        "#{valid,jdbcType=INTEGER}, #{doctorScheduling,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    @Select({
        "select",
        "doctor_id, doctor_name, department, type, job_title, account_id, valid, doctor_scheduling, ",
        "reserve1, reserve2, reserve3",
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
          "department = #{department,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "job_title = #{jobTitle,jdbcType=VARCHAR},",
          "account_id = #{accountId,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER},",
          "doctor_scheduling = #{doctorScheduling,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where doctor_id = #{doctorId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Doctor record);
}