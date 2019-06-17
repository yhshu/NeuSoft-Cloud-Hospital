package com.neusoft.medical.dao;

import com.neusoft.medical.bean.RegistrationCategory;
import com.neusoft.medical.example.RegistrationCategoryExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RegistrationCategoryMapper {
    long countByExample(RegistrationCategoryExample example);

    int deleteByExample(RegistrationCategoryExample example);

    @Delete({
        "delete from hospital.registration_category",
        "where registration_category_id = #{registrationCategoryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer registrationCategoryId);

    @Insert({
        "insert into hospital.registration_category (registration_category_name, is_default, ",
        "sequence_no, registration_fee, ",
        "valid)",
        "values (#{registrationCategoryName,jdbcType=VARCHAR}, #{isDefault,jdbcType=BIT}, ",
        "#{sequenceNo,jdbcType=INTEGER}, #{registrationFee,jdbcType=DOUBLE}, ",
        "#{valid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="registrationCategoryId", before=false, resultType=Integer.class)
    int insert(RegistrationCategory record);

    int insertSelective(RegistrationCategory record);

    List<RegistrationCategory> selectByExample(RegistrationCategoryExample example);

    @Select({
        "select",
        "registration_category_id, registration_category_name, is_default, sequence_no, ",
        "registration_fee, valid",
        "from hospital.registration_category",
        "where registration_category_id = #{registrationCategoryId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.RegistrationCategoryMapper.BaseResultMap")
    RegistrationCategory selectByPrimaryKey(Integer registrationCategoryId);

    int updateByExampleSelective(@Param("record") RegistrationCategory record, @Param("example") RegistrationCategoryExample example);

    int updateByExample(@Param("record") RegistrationCategory record, @Param("example") RegistrationCategoryExample example);

    int updateByPrimaryKeySelective(RegistrationCategory record);

    @Update({
        "update hospital.registration_category",
        "set registration_category_name = #{registrationCategoryName,jdbcType=VARCHAR},",
          "is_default = #{isDefault,jdbcType=BIT},",
          "sequence_no = #{sequenceNo,jdbcType=INTEGER},",
          "registration_fee = #{registrationFee,jdbcType=DOUBLE},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where registration_category_id = #{registrationCategoryId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RegistrationCategory record);
}