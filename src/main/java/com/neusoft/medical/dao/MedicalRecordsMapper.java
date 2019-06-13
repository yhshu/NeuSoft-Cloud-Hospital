package com.neusoft.medical.dao;

import com.neusoft.medical.bean.MedicalRecords;
import com.neusoft.medical.bean.MedicalRecordsExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MedicalRecordsMapper {
    long countByExample(MedicalRecordsExample example);

    int deleteByExample(MedicalRecordsExample example);

    @Delete({
        "delete from hospital.medical_records",
        "where medical_records_id = #{medicalRecordsId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer medicalRecordsId);

    @Insert({
        "insert into hospital.medical_records (medical_records_id, registration_id, ",
        "main_info, current_disease, ",
        "past_disease, physical_exam, ",
        "auxiliary_exam, preliminary_western, ",
        "preliminary_chinese, opinion, ",
        "valid, save_state, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{medicalRecordsId,jdbcType=INTEGER}, #{registrationId,jdbcType=INTEGER}, ",
        "#{mainInfo,jdbcType=VARCHAR}, #{currentDisease,jdbcType=VARCHAR}, ",
        "#{pastDisease,jdbcType=VARCHAR}, #{physicalExam,jdbcType=VARCHAR}, ",
        "#{auxiliaryExam,jdbcType=VARCHAR}, #{preliminaryWestern,jdbcType=VARCHAR}, ",
        "#{preliminaryChinese,jdbcType=VARCHAR}, #{opinion,jdbcType=VARCHAR}, ",
        "#{valid,jdbcType=INTEGER}, #{saveState,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    int insert(MedicalRecords record);

    int insertSelective(MedicalRecords record);

    List<MedicalRecords> selectByExample(MedicalRecordsExample example);

    @Select({
        "select",
        "medical_records_id, registration_id, main_info, current_disease, past_disease, ",
        "physical_exam, auxiliary_exam, preliminary_western, preliminary_chinese, opinion, ",
        "valid, save_state, reserve1, reserve2, reserve3",
        "from hospital.medical_records",
        "where medical_records_id = #{medicalRecordsId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.MedicalRecordsMapper.BaseResultMap")
    MedicalRecords selectByPrimaryKey(Integer medicalRecordsId);

    int updateByExampleSelective(@Param("record") MedicalRecords record, @Param("example") MedicalRecordsExample example);

    int updateByExample(@Param("record") MedicalRecords record, @Param("example") MedicalRecordsExample example);

    int updateByPrimaryKeySelective(MedicalRecords record);

    @Update({
        "update hospital.medical_records",
        "set registration_id = #{registrationId,jdbcType=INTEGER},",
          "main_info = #{mainInfo,jdbcType=VARCHAR},",
          "current_disease = #{currentDisease,jdbcType=VARCHAR},",
          "past_disease = #{pastDisease,jdbcType=VARCHAR},",
          "physical_exam = #{physicalExam,jdbcType=VARCHAR},",
          "auxiliary_exam = #{auxiliaryExam,jdbcType=VARCHAR},",
          "preliminary_western = #{preliminaryWestern,jdbcType=VARCHAR},",
          "preliminary_chinese = #{preliminaryChinese,jdbcType=VARCHAR},",
          "opinion = #{opinion,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "save_state = #{saveState,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where medical_records_id = #{medicalRecordsId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MedicalRecords record);
}