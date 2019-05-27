package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Patient;
import com.neusoft.medical.bean.PatientExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface PatientMapper {
    int countByExample(PatientExample example);

    int deleteByExample(PatientExample example);

    @Insert({
        "insert into patient (patient_id, patient_name, ",
        "birth_date, allergies, ",
        "identify_card_no, social_security_card_no, ",
        "family_address, alive, ",
        "reserve1, reserve2, ",
        "reserve3, gender)",
        "values (#{patientId,jdbcType=INTEGER}, #{patientName,jdbcType=VARCHAR}, ",
        "#{birthDate,jdbcType=DATE}, #{allergies,jdbcType=VARCHAR}, ",
        "#{identifyCardNo,jdbcType=INTEGER}, #{socialSecurityCardNo,jdbcType=VARCHAR}, ",
        "#{familyAddress,jdbcType=VARCHAR}, #{alive,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR}, #{gender,jdbcType=CHAR})"
    })
    int insert(Patient record);

    int insertSelective(Patient record);

    List<Patient> selectByExample(PatientExample example);

    int updateByExampleSelective(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByExample(@Param("record") Patient record, @Param("example") PatientExample example);
}