package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Registration;
import com.neusoft.medical.bean.RegistrationExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RegistrationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    int countByExample(RegistrationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    int deleteByExample(RegistrationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    @Delete({
        "delete from hospital.registration",
        "where registration_id = #{registrationId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer registrationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    @Insert({
        "insert into hospital.registration (registration_id, patient_name, ",
        "patient_id, gender, ",
        "age, birthday, registration_category, ",
        "medical_category, identity_card_no, ",
        "registration_status, visit_date, ",
        "registration_date, department_id, ",
        "doctor_id, registration_source, ",
        "settle_accounts_category, is_visited, ",
        "valid, family_address, ",
        "collector_id, total_charge, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{registrationId,jdbcType=INTEGER}, #{patientName,jdbcType=VARCHAR}, ",
        "#{patientId,jdbcType=INTEGER}, #{gender,jdbcType=CHAR}, ",
        "#{age,jdbcType=INTEGER}, #{birthday,jdbcType=DATE}, #{registrationCategory,jdbcType=CHAR}, ",
        "#{medicalCategory,jdbcType=CHAR}, #{identityCardNo,jdbcType=BIGINT}, ",
        "#{registrationStatus,jdbcType=CHAR}, #{visitDate,jdbcType=TIMESTAMP}, ",
        "#{registrationDate,jdbcType=TIMESTAMP}, #{departmentId,jdbcType=INTEGER}, ",
        "#{doctorId,jdbcType=INTEGER}, #{registrationSource,jdbcType=CHAR}, ",
        "#{settleAccountsCategory,jdbcType=CHAR}, #{isVisited,jdbcType=CHAR}, ",
        "#{valid,jdbcType=INTEGER}, #{familyAddress,jdbcType=VARCHAR}, ",
        "#{collectorId,jdbcType=INTEGER}, #{totalCharge,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    int insert(Registration record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    int insertSelective(Registration record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    List<Registration> selectByExample(RegistrationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    @Select({
        "select",
        "registration_id, patient_name, patient_id, gender, age, birthday, registration_category, ",
        "medical_category, identity_card_no, registration_status, visit_date, registration_date, ",
        "department_id, doctor_id, registration_source, settle_accounts_category, is_visited, ",
        "valid, family_address, collector_id, total_charge, reserve1, reserve2, reserve3",
        "from hospital.registration",
        "where registration_id = #{registrationId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Registration selectByPrimaryKey(Integer registrationId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    int updateByExampleSelective(@Param("record") Registration record, @Param("example") RegistrationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    int updateByExample(@Param("record") Registration record, @Param("example") RegistrationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    int updateByPrimaryKeySelective(Registration record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.registration
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    @Update({
        "update hospital.registration",
        "set patient_name = #{patientName,jdbcType=VARCHAR},",
          "patient_id = #{patientId,jdbcType=INTEGER},",
          "gender = #{gender,jdbcType=CHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "birthday = #{birthday,jdbcType=DATE},",
          "registration_category = #{registrationCategory,jdbcType=CHAR},",
          "medical_category = #{medicalCategory,jdbcType=CHAR},",
          "identity_card_no = #{identityCardNo,jdbcType=BIGINT},",
          "registration_status = #{registrationStatus,jdbcType=CHAR},",
          "visit_date = #{visitDate,jdbcType=TIMESTAMP},",
          "registration_date = #{registrationDate,jdbcType=TIMESTAMP},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "registration_source = #{registrationSource,jdbcType=CHAR},",
          "settle_accounts_category = #{settleAccountsCategory,jdbcType=CHAR},",
          "is_visited = #{isVisited,jdbcType=CHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "family_address = #{familyAddress,jdbcType=VARCHAR},",
          "collector_id = #{collectorId,jdbcType=INTEGER},",
          "total_charge = #{totalCharge,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where registration_id = #{registrationId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Registration record);
}