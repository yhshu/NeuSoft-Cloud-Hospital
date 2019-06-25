package com.neusoft.medical.dao;

import com.neusoft.medical.bean.RecordDisease;
import com.neusoft.medical.bean.RecordDiseaseExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RecordDiseaseMapper {
    long countByExample(RecordDiseaseExample example);

    int deleteByExample(RecordDiseaseExample example);

    @Delete({
        "delete from hospital.record_disease",
        "where record_disease_id = #{recordDiseaseId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer recordDiseaseId);

    @Insert({
        "insert into hospital.record_disease (medical_records_id, disease_id, ",
        "disease_ICD, disease_name, ",
        "main_disease, suspect, ",
        "incidence_date, valid, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{medicalRecordsId,jdbcType=INTEGER}, #{diseaseId,jdbcType=INTEGER}, ",
        "#{diseaseIcd,jdbcType=VARCHAR}, #{diseaseName,jdbcType=VARCHAR}, ",
        "#{mainDisease,jdbcType=INTEGER}, #{suspect,jdbcType=INTEGER}, ",
        "#{incidenceDate,jdbcType=DATE}, #{valid,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="recordDiseaseId", before=false, resultType=Integer.class)
    int insert(RecordDisease record);

    int insertSelective(RecordDisease record);

    List<RecordDisease> selectByExample(RecordDiseaseExample example);

    @Select({
        "select",
        "record_disease_id, medical_records_id, disease_id, disease_ICD, disease_name, ",
        "main_disease, suspect, incidence_date, valid, reserve1, reserve2, reserve3",
        "from hospital.record_disease",
        "where record_disease_id = #{recordDiseaseId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.RecordDiseaseMapper.BaseResultMap")
    RecordDisease selectByPrimaryKey(Integer recordDiseaseId);

    int updateByExampleSelective(@Param("record") RecordDisease record, @Param("example") RecordDiseaseExample example);

    int updateByExample(@Param("record") RecordDisease record, @Param("example") RecordDiseaseExample example);

    int updateByPrimaryKeySelective(RecordDisease record);

    @Update({
        "update hospital.record_disease",
        "set medical_records_id = #{medicalRecordsId,jdbcType=INTEGER},",
          "disease_id = #{diseaseId,jdbcType=INTEGER},",
          "disease_ICD = #{diseaseIcd,jdbcType=VARCHAR},",
          "disease_name = #{diseaseName,jdbcType=VARCHAR},",
          "main_disease = #{mainDisease,jdbcType=INTEGER},",
          "suspect = #{suspect,jdbcType=INTEGER},",
          "incidence_date = #{incidenceDate,jdbcType=DATE},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where record_disease_id = #{recordDiseaseId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RecordDisease record);
}