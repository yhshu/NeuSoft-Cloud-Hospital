package com.neusoft.medical.dao;

import com.neusoft.medical.bean.ConstantType;
import com.neusoft.medical.bean.ConstantTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ConstantTypeMapper {
    long countByExample(ConstantTypeExample example);

    int deleteByExample(ConstantTypeExample example);

    @Delete({
        "delete from hospital..constant_type",
        "where constant_type_id = #{constantTypeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer constantTypeId);

    @Insert({
        "insert into hospital..constant_type (constant_type_id, constant_type_code, ",
        "constant_type_name, valid)",
        "values (#{constantTypeId,jdbcType=INTEGER}, #{constantTypeCode,jdbcType=VARCHAR}, ",
        "#{constantTypeName,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER})"
    })
    int insert(ConstantType record);

    int insertSelective(ConstantType record);

    List<ConstantType> selectByExample(ConstantTypeExample example);

    @Select({
        "select",
        "constant_type_id, constant_type_code, constant_type_name, valid",
        "from hospital..constant_type",
        "where constant_type_id = #{constantTypeId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.ConstantTypeMapper.BaseResultMap")
    ConstantType selectByPrimaryKey(Integer constantTypeId);

    int updateByExampleSelective(@Param("record") ConstantType record, @Param("example") ConstantTypeExample example);

    int updateByExample(@Param("record") ConstantType record, @Param("example") ConstantTypeExample example);

    int updateByPrimaryKeySelective(ConstantType record);

    @Update({
        "update hospital..constant_type",
        "set constant_type_code = #{constantTypeCode,jdbcType=VARCHAR},",
          "constant_type_name = #{constantTypeName,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where constant_type_id = #{constantTypeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ConstantType record);
}