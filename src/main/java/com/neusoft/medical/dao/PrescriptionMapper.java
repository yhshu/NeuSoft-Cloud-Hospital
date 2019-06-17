package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Prescription;
import com.neusoft.medical.example.PrescriptionExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PrescriptionMapper {
    long countByExample(PrescriptionExample example);

    int deleteByExample(PrescriptionExample example);

    @Delete({
        "delete from hospital.prescription",
        "where prescription_id = #{prescriptionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer prescriptionId);

    @Insert({
        "insert into hospital.prescription (registration_id, registration_name, ",
        "doctor_id, content, ",
        "valid, reserve1, ",
        "reserve2, reserve3)",
        "values (#{registrationId,jdbcType=INTEGER}, #{registrationName,jdbcType=VARCHAR}, ",
        "#{doctorId,jdbcType=INTEGER}, #{content,jdbcType=VARCHAR}, ",
        "#{valid,jdbcType=INTEGER}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="prescriptionId", before=false, resultType=Integer.class)
    int insert(Prescription record);

    int insertSelective(Prescription record);

    List<Prescription> selectByExample(PrescriptionExample example);

    @Select({
        "select",
        "prescription_id, registration_id, registration_name, doctor_id, content, valid, ",
        "reserve1, reserve2, reserve3",
        "from hospital.prescription",
        "where prescription_id = #{prescriptionId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.PrescriptionMapper.BaseResultMap")
    Prescription selectByPrimaryKey(Integer prescriptionId);

    int updateByExampleSelective(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByExample(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByPrimaryKeySelective(Prescription record);

    @Update({
        "update hospital.prescription",
        "set registration_id = #{registrationId,jdbcType=INTEGER},",
          "registration_name = #{registrationName,jdbcType=VARCHAR},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where prescription_id = #{prescriptionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Prescription record);
}