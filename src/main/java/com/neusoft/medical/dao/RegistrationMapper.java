package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.example.RegistrationExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RegistrationMapper {
    long countByExample(RegistrationExample example);

    int deleteByExample(RegistrationExample example);

    @Delete({
        "delete from hospital.registration",
        "where registration_id = #{registrationId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer registrationId);

    @Insert({
        "insert into hospital.registration (patient_name, patient_id, ",
        "gender, age, birthday, ",
        "registration_category, medical_category, ",
        "identity_card_no, registration_status, ",
        "visit_date, registration_date, ",
        "department_id, doctor_id, ",
        "registration_source, settle_accounts_category, ",
        "is_visited, family_address, ",
        "collector_id, total_charge, ",
        "valid, reserve1, ",
        "reserve2, reserve3)",
        "values (#{patientName,jdbcType=VARCHAR}, #{patientId,jdbcType=INTEGER}, ",
        "#{gender,jdbcType=CHAR}, #{age,jdbcType=INTEGER}, #{birthday,jdbcType=DATE}, ",
        "#{registrationCategory,jdbcType=CHAR}, #{medicalCategory,jdbcType=CHAR}, ",
        "#{identityCardNo,jdbcType=CHAR}, #{registrationStatus,jdbcType=CHAR}, ",
        "#{visitDate,jdbcType=TIMESTAMP}, #{registrationDate,jdbcType=TIMESTAMP}, ",
        "#{departmentId,jdbcType=INTEGER}, #{doctorId,jdbcType=INTEGER}, ",
        "#{registrationSource,jdbcType=CHAR}, #{settleAccountsCategory,jdbcType=CHAR}, ",
        "#{isVisited,jdbcType=CHAR}, #{familyAddress,jdbcType=VARCHAR}, ",
        "#{collectorId,jdbcType=INTEGER}, #{totalCharge,jdbcType=INTEGER}, ",
        "#{valid,jdbcType=INTEGER}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="registrationId", before=false, resultType=Integer.class)
    int insert(Registration record);

    int insertSelective(Registration record);

    List<Registration> selectByExample(RegistrationExample example);

    @Select({
        "select",
        "registration_id, patient_name, patient_id, gender, age, birthday, registration_category, ",
        "medical_category, identity_card_no, registration_status, visit_date, registration_date, ",
        "department_id, doctor_id, registration_source, settle_accounts_category, is_visited, ",
        "family_address, collector_id, total_charge, valid, reserve1, reserve2, reserve3",
        "from hospital.registration",
        "where registration_id = #{registrationId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.RegistrationMapper.BaseResultMap")
    Registration selectByPrimaryKey(Integer registrationId);

    int updateByExampleSelective(@Param("record") Registration record, @Param("example") RegistrationExample example);

    int updateByExample(@Param("record") Registration record, @Param("example") RegistrationExample example);

    int updateByPrimaryKeySelective(Registration record);

    @Update({
        "update hospital.registration",
        "set patient_name = #{patientName,jdbcType=VARCHAR},",
          "patient_id = #{patientId,jdbcType=INTEGER},",
          "gender = #{gender,jdbcType=CHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "birthday = #{birthday,jdbcType=DATE},",
          "registration_category = #{registrationCategory,jdbcType=CHAR},",
          "medical_category = #{medicalCategory,jdbcType=CHAR},",
          "identity_card_no = #{identityCardNo,jdbcType=CHAR},",
          "registration_status = #{registrationStatus,jdbcType=CHAR},",
          "visit_date = #{visitDate,jdbcType=TIMESTAMP},",
          "registration_date = #{registrationDate,jdbcType=TIMESTAMP},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "registration_source = #{registrationSource,jdbcType=CHAR},",
          "settle_accounts_category = #{settleAccountsCategory,jdbcType=CHAR},",
          "is_visited = #{isVisited,jdbcType=CHAR},",
          "family_address = #{familyAddress,jdbcType=VARCHAR},",
          "collector_id = #{collectorId,jdbcType=INTEGER},",
          "total_charge = #{totalCharge,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where registration_id = #{registrationId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Registration record);
}