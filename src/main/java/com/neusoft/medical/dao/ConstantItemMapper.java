package com.neusoft.medical.dao;

import com.neusoft.medical.bean.ConstantItem;
import com.neusoft.medical.example.ConstantItemExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ConstantItemMapper {
    long countByExample(ConstantItemExample example);

    int deleteByExample(ConstantItemExample example);

    @Delete({
        "delete from hospital.constant_item",
        "where constant_item_id = #{constantItemId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer constantItemId);

    @Insert({
        "insert into hospital.constant_item (constant_type_id, constant_code, ",
        "constant_name, valid)",
        "values (#{constantTypeId,jdbcType=INTEGER}, #{constantCode,jdbcType=VARCHAR}, ",
        "#{constantName,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="constantItemId", before=false, resultType=Integer.class)
    int insert(ConstantItem record);

    int insertSelective(ConstantItem record);

    List<ConstantItem> selectByExample(ConstantItemExample example);

    @Select({
        "select",
        "constant_item_id, constant_type_id, constant_code, constant_name, valid",
        "from hospital.constant_item",
        "where constant_item_id = #{constantItemId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.ConstantItemMapper.BaseResultMap")
    ConstantItem selectByPrimaryKey(Integer constantItemId);

    int updateByExampleSelective(@Param("record") ConstantItem record, @Param("example") ConstantItemExample example);

    int updateByExample(@Param("record") ConstantItem record, @Param("example") ConstantItemExample example);

    int updateByPrimaryKeySelective(ConstantItem record);

    @Update({
        "update hospital.constant_item",
        "set constant_type_id = #{constantTypeId,jdbcType=INTEGER},",
          "constant_code = #{constantCode,jdbcType=VARCHAR},",
          "constant_name = #{constantName,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where constant_item_id = #{constantItemId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ConstantItem record);
}