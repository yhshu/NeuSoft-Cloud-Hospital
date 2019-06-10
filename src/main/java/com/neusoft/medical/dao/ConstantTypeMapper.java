package com.neusoft.medical.dao;

import com.neusoft.medical.bean1.ConstantType;
import com.neusoft.medical.bean1.ConstantTypeExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ConstantTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.constant_type
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    long countByExample(ConstantTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.constant_type
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    int deleteByExample(ConstantTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.constant_type
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    @Delete({
        "delete from hospital.constant_type",
        "where constant_type_id = #{constantTypeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer constantTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.constant_type
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    @Insert({
        "insert into hospital.constant_type (constant_type_id, constant_type_code, ",
        "constant_type_name, valid)",
        "values (#{constantTypeId,jdbcType=INTEGER}, #{constantTypeCode,jdbcType=VARCHAR}, ",
        "#{constantTypeName,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER})"
    })
    int insert(ConstantType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.constant_type
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    int insertSelective(ConstantType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.constant_type
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    List<ConstantType> selectByExample(ConstantTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.constant_type
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    @Select({
        "select",
        "constant_type_id, constant_type_code, constant_type_name, valid",
        "from hospital.constant_type",
        "where constant_type_id = #{constantTypeId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao1.ConstantTypeMapper.BaseResultMap")
    ConstantType selectByPrimaryKey(Integer constantTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.constant_type
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    int updateByExampleSelective(@Param("record") ConstantType record, @Param("example") ConstantTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.constant_type
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    int updateByExample(@Param("record") ConstantType record, @Param("example") ConstantTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.constant_type
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    int updateByPrimaryKeySelective(ConstantType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital.constant_type
     *
     * @mbg.generated Mon Jun 10 18:44:57 CST 2019
     */
    @Update({
        "update hospital.constant_type",
        "set constant_type_code = #{constantTypeCode,jdbcType=VARCHAR},",
          "constant_type_name = #{constantTypeName,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where constant_type_id = #{constantTypeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ConstantType record);
}