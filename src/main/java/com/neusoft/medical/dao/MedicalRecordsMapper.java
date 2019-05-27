package com.neusoft.medical.dao;

import com.neusoft.medical.bean.MedicalRecords;
import com.neusoft.medical.bean.MedicalRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface MedicalRecordsMapper {
    int countByExample(MedicalRecordsExample example);

    int deleteByExample(MedicalRecordsExample example);

    @Insert({
        "insert into medical_records (medical_records_id, registration_id, ",
        "main_info, current_disease, ",
        "current_treatment, preliminary_western, ",
        "preliminary_chinese, reserve1, ",
        "reserve2, reserve3)",
        "values (#{medicalRecordsId,jdbcType=INTEGER}, #{registrationId,jdbcType=INTEGER}, ",
        "#{mainInfo,jdbcType=VARCHAR}, #{currentDisease,jdbcType=VARCHAR}, ",
        "#{currentTreatment,jdbcType=VARCHAR}, #{preliminaryWestern,jdbcType=VARCHAR}, ",
        "#{preliminaryChinese,jdbcType=VARCHAR}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    int insert(MedicalRecords record);

    int insertSelective(MedicalRecords record);

    List<MedicalRecords> selectByExample(MedicalRecordsExample example);

    int updateByExampleSelective(@Param("record") MedicalRecords record, @Param("example") MedicalRecordsExample example);

    int updateByExample(@Param("record") MedicalRecords record, @Param("example") MedicalRecordsExample example);
}