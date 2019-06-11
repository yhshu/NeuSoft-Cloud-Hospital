package com.neusoft.medical.dao;

import com.neusoft.medical.bean.DiseaseCategory;
import com.neusoft.medical.bean.DiseaseCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DiseaseCategoryMapper {
    long countByExample(DiseaseCategoryExample example);

    int deleteByExample(DiseaseCategoryExample example);

    @Delete({
        "delete from hospital.disease_category",
        "where disease_id = #{diseaseId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer diseaseId);

    @Insert({
        "insert into hospital.disease_category (disease_id, disease_code, ",
        "disease_name, sequence_no, ",
        "disease_type, valid)",
        "values (#{diseaseId,jdbcType=INTEGER}, #{diseaseCode,jdbcType=VARCHAR}, ",
        "#{diseaseName,jdbcType=VARCHAR}, #{sequenceNo,jdbcType=INTEGER}, ",
        "#{diseaseType,jdbcType=INTEGER}, #{valid,jdbcType=INTEGER})"
    })
    int insert(DiseaseCategory record);

    int insertSelective(DiseaseCategory record);

    List<DiseaseCategory> selectByExample(DiseaseCategoryExample example);

    @Select({
        "select",
        "disease_id, disease_code, disease_name, sequence_no, disease_type, valid",
        "from hospital.disease_category",
        "where disease_id = #{diseaseId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.DiseaseCategoryMapper.BaseResultMap")
    DiseaseCategory selectByPrimaryKey(Integer diseaseId);

    int updateByExampleSelective(@Param("record") DiseaseCategory record, @Param("example") DiseaseCategoryExample example);

    int updateByExample(@Param("record") DiseaseCategory record, @Param("example") DiseaseCategoryExample example);

    int updateByPrimaryKeySelective(DiseaseCategory record);

    @Update({
        "update hospital.disease_category",
        "set disease_code = #{diseaseCode,jdbcType=VARCHAR},",
          "disease_name = #{diseaseName,jdbcType=VARCHAR},",
          "sequence_no = #{sequenceNo,jdbcType=INTEGER},",
          "disease_type = #{diseaseType,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where disease_id = #{diseaseId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DiseaseCategory record);
}