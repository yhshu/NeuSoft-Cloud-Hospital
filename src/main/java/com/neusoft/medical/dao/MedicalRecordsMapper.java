package com.neusoft.medical.dao;

import com.neusoft.medical.bean.MedicalRecords;
import com.neusoft.medical.bean.MedicalRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface MedicalRecordsMapper {
    long countByExample(MedicalRecordsExample example);

    int deleteByExample(MedicalRecordsExample example);

    @Delete({
        "delete from hospital.medical_records",
        "where medical_records_id = #{medicalRecordsId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer medicalRecordsId);

    @Insert({
        "insert into hospital.medical_records (registration_id, main_info, ",
        "current_disease, past_disease, ",
        "physical_exam, auxiliary_exam, ",
        "opinion, valid, ",
        "save_state, doctor_id, ",
        "template_name, reserve1, ",
        "reserve2, reserve3)",
        "values (#{registrationId,jdbcType=INTEGER}, #{mainInfo,jdbcType=VARCHAR}, ",
        "#{currentDisease,jdbcType=VARCHAR}, #{pastDisease,jdbcType=VARCHAR}, ",
        "#{physicalExam,jdbcType=VARCHAR}, #{auxiliaryExam,jdbcType=VARCHAR}, ",
        "#{opinion,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER}, ",
        "#{saveState,jdbcType=INTEGER}, #{doctorId,jdbcType=INTEGER}, ",
        "#{templateName,jdbcType=VARCHAR}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="medicalRecordsId", before=false, resultType=Integer.class)
    int insert(MedicalRecords record);

    int insertSelective(MedicalRecords record);

    List<MedicalRecords> selectByExample(MedicalRecordsExample example);

    @Select({
        "select",
        "medical_records_id, registration_id, main_info, current_disease, past_disease, ",
        "physical_exam, auxiliary_exam, opinion, valid, save_state, doctor_id, template_name, ",
        "reserve1, reserve2, reserve3",
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
          "opinion = #{opinion,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "save_state = #{saveState,jdbcType=INTEGER},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "template_name = #{templateName,jdbcType=VARCHAR},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where medical_records_id = #{medicalRecordsId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MedicalRecords record);
}