package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.bean.RegistrationExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface RegistrationMapper {
    int countByExample(RegistrationExample example);

    int deleteByExample(RegistrationExample example);

    @Insert({
        "insert into registration (registration_id, patient_name, ",
        "gender, age, birthday, ",
        "registration_category, medical_category, ",
        "identity_card_no, family_address, ",
        "registration_date, visit_date, ",
        "department_id, doctor_id, ",
        "registration_source, settle_accounts_category, ",
        "is_visited, registration_status, ",
        "valid, reserve2, ",
        "reserve3, reserve1, ",
        "patient_id, collector_id)",
        "values (#{registrationId,jdbcType=INTEGER}, #{patientName,jdbcType=VARCHAR}, ",
        "#{gender,jdbcType=CHAR}, #{age,jdbcType=INTEGER}, #{birthday,jdbcType=TIMESTAMP}, ",
        "#{registrationCategory,jdbcType=CHAR}, #{medicalCategory,jdbcType=CHAR}, ",
        "#{identityCardNo,jdbcType=CHAR}, #{familyAddress,jdbcType=VARCHAR}, ",
        "#{registrationDate,jdbcType=TIMESTAMP}, #{visitDate,jdbcType=TIMESTAMP}, ",
        "#{departmentId,jdbcType=INTEGER}, #{doctorId,jdbcType=INTEGER}, ",
        "#{registrationSource,jdbcType=CHAR}, #{settleAccountsCategory,jdbcType=CHAR}, ",
        "#{isVisited,jdbcType=CHAR}, #{registrationStatus,jdbcType=CHAR}, ",
        "#{valid,jdbcType=INTEGER}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{patientId,jdbcType=INTEGER}, #{collectorId,jdbcType=INTEGER})"
    })
    int insert(Registration record);

    int insertSelective(Registration record);

    List<Registration> selectByExample(RegistrationExample example);

    int updateByExampleSelective(@Param("record") Registration record, @Param("example") RegistrationExample example);

    int updateByExample(@Param("record") Registration record, @Param("example") RegistrationExample example);
}