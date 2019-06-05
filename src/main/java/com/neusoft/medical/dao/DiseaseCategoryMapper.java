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
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    int countByExample(DiseaseCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    int deleteByExample(DiseaseCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    @Delete({
        "delete from hospital..disease_category",
        "where disease_id = #{diseaseId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer diseaseId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    @Insert({
        "insert into hospital..disease_category (disease_id, disease_code, ",
        "disease_name, sequence_no, ",
        "disease_type, valid)",
        "values (#{diseaseId,jdbcType=INTEGER}, #{diseaseCode,jdbcType=VARCHAR}, ",
        "#{diseaseName,jdbcType=VARCHAR}, #{sequenceNo,jdbcType=INTEGER}, ",
        "#{diseaseType,jdbcType=INTEGER}, #{valid,jdbcType=INTEGER})"
    })
    int insert(DiseaseCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    int insertSelective(DiseaseCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    List<DiseaseCategory> selectByExample(DiseaseCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    @Select({
        "select",
        "disease_id, disease_code, disease_name, sequence_no, disease_type, valid",
        "from hospital..disease_category",
        "where disease_id = #{diseaseId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    DiseaseCategory selectByPrimaryKey(Integer diseaseId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    int updateByExampleSelective(@Param("record") DiseaseCategory record, @Param("example") DiseaseCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    int updateByExample(@Param("record") DiseaseCategory record, @Param("example") DiseaseCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    int updateByPrimaryKeySelective(DiseaseCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..disease_category
     *
     * @mbggenerated Wed Jun 05 11:50:09 CST 2019
     */
    @Update({
        "update hospital..disease_category",
        "set disease_code = #{diseaseCode,jdbcType=VARCHAR},",
          "disease_name = #{diseaseName,jdbcType=VARCHAR},",
          "sequence_no = #{sequenceNo,jdbcType=INTEGER},",
          "disease_type = #{diseaseType,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where disease_id = #{diseaseId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DiseaseCategory record);

    /**
     * This method was generated manually by Shu Yiheng.
     * This method is used for testing and works with PageHelper.
     *
     * @return A list of DiseaseCategory
     */
    public List<DiseaseCategory> selectByPageAndSelections();
}