package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.example.PatientExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PatientMapper {
    long countByExample(PatientExample example);

    int deleteByExample(PatientExample example);

    @Delete({
        "delete from hospital.patient",
        "where patient_id = #{patientId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer patientId);

    @Insert({
        "insert into hospital.patient (patient_name, birth_date, ",
        "allergies, identity_card_no, ",
        "social_security_card_no, family_address, ",
        "gender, valid, reserve1, ",
        "reserve2, reserve3)",
        "values (#{patientName,jdbcType=VARCHAR}, #{birthDate,jdbcType=DATE}, ",
        "#{allergies,jdbcType=VARCHAR}, #{identityCardNo,jdbcType=CHAR}, ",
        "#{socialSecurityCardNo,jdbcType=VARCHAR}, #{familyAddress,jdbcType=VARCHAR}, ",
        "#{gender,jdbcType=CHAR}, #{valid,jdbcType=INTEGER}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="patientId", before=false, resultType=Integer.class)
    int insert(Patient record);

    int insertSelective(Patient record);

    List<Patient> selectByExample(PatientExample example);

    @Select({
        "select",
        "patient_id, patient_name, birth_date, allergies, identity_card_no, social_security_card_no, ",
        "family_address, gender, valid, reserve1, reserve2, reserve3",
        "from hospital.patient",
        "where patient_id = #{patientId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.PatientMapper.BaseResultMap")
    Patient selectByPrimaryKey(Integer patientId);

    int updateByExampleSelective(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByExample(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByPrimaryKeySelective(Patient record);

    @Update({
        "update hospital.patient",
        "set patient_name = #{patientName,jdbcType=VARCHAR},",
          "birth_date = #{birthDate,jdbcType=DATE},",
          "allergies = #{allergies,jdbcType=VARCHAR},",
          "identity_card_no = #{identityCardNo,jdbcType=CHAR},",
          "social_security_card_no = #{socialSecurityCardNo,jdbcType=VARCHAR},",
          "family_address = #{familyAddress,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=CHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where patient_id = #{patientId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Patient record);
}