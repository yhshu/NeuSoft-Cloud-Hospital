package com.neusoft.medical.dao;

import com.neusoft.medical.bean.RegistrationInfo;
import com.neusoft.medical.bean.RegistrationInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface RegistrationInfoMapper {
    int countByExample(RegistrationInfoExample example);

    int deleteByExample(RegistrationInfoExample example);

    @Insert({
        "insert into registration_info (id, medical_record_no, ",
        "patient_name, gender, ",
        "age, birthday, ",
        "registration_category, medical_category, ",
        "identity_card_no, family_address, ",
        "registration_date, visit_date, ",
        "department_id, doctor_id, ",
        "registration_source, settle_accounts_category, ",
        "is_visited, status, expense, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{id,jdbcType=INTEGER}, #{medicalRecordNo,jdbcType=CHAR}, ",
        "#{patientName,jdbcType=VARCHAR}, #{gender,jdbcType=CHAR}, ",
        "#{age,jdbcType=INTEGER}, #{birthday,jdbcType=TIMESTAMP}, ",
        "#{registrationCategory,jdbcType=CHAR}, #{medicalCategory,jdbcType=CHAR}, ",
        "#{identityCardNo,jdbcType=CHAR}, #{familyAddress,jdbcType=VARCHAR}, ",
        "#{registrationDate,jdbcType=TIMESTAMP}, #{visitDate,jdbcType=TIMESTAMP}, ",
        "#{departmentId,jdbcType=INTEGER}, #{doctorId,jdbcType=INTEGER}, ",
        "#{registrationSource,jdbcType=CHAR}, #{settleAccountsCategory,jdbcType=CHAR}, ",
        "#{isVisited,jdbcType=CHAR}, #{status,jdbcType=CHAR}, #{expense,jdbcType=DECIMAL}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    int insert(RegistrationInfo record);

    int insertSelective(RegistrationInfo record);

    List<RegistrationInfo> selectByExample(RegistrationInfoExample example);

    int updateByExampleSelective(@Param("record") RegistrationInfo record, @Param("example") RegistrationInfoExample example);

    int updateByExample(@Param("record") RegistrationInfo record, @Param("example") RegistrationInfoExample example);
}