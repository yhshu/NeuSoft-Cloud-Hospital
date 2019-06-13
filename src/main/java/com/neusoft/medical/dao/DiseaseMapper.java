package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Disease;
import com.neusoft.medical.bean.DiseaseExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DiseaseMapper {
    long countByExample(DiseaseExample example);

    int deleteByExample(DiseaseExample example);

    @Delete({
        "delete from hospital.disease",
        "where disease_id = #{diseaseId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer diseaseId);

    @Insert({
        "insert into hospital.disease (disease_id, disease_ICD, ",
        "disease_name, disease_code, ",
        "disease_category, valid)",
        "values (#{diseaseId,jdbcType=INTEGER}, #{diseaseIcd,jdbcType=VARCHAR}, ",
        "#{diseaseName,jdbcType=VARCHAR}, #{diseaseCode,jdbcType=VARCHAR}, ",
        "#{diseaseCategory,jdbcType=INTEGER}, #{valid,jdbcType=INTEGER})"
    })
    int insert(Disease record);

    int insertSelective(Disease record);

    List<Disease> selectByExample(DiseaseExample example);

    @Select({
        "select",
        "disease_id, disease_ICD, disease_name, disease_code, disease_category, valid",
        "from hospital.disease",
        "where disease_id = #{diseaseId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.DiseaseMapper.BaseResultMap")
    Disease selectByPrimaryKey(Integer diseaseId);

    int updateByExampleSelective(@Param("record") Disease record, @Param("example") DiseaseExample example);

    int updateByExample(@Param("record") Disease record, @Param("example") DiseaseExample example);

    int updateByPrimaryKeySelective(Disease record);

    @Update({
        "update hospital.disease",
        "set disease_ICD = #{diseaseIcd,jdbcType=VARCHAR},",
          "disease_name = #{diseaseName,jdbcType=VARCHAR},",
          "disease_code = #{diseaseCode,jdbcType=VARCHAR},",
          "disease_category = #{diseaseCategory,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where disease_id = #{diseaseId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Disease record);
}