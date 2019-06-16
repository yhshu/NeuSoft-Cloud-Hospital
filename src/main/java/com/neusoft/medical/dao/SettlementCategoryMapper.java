package com.neusoft.medical.dao;

import com.neusoft.medical.bean.SettlementCategory;
import com.neusoft.medical.bean.SettlementCategoryExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SettlementCategoryMapper {
    long countByExample(SettlementCategoryExample example);

    int deleteByExample(SettlementCategoryExample example);

    @Delete({
        "delete from hospital.settlement_category",
        "where settlement_category_id = #{settlementCategoryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer settlementCategoryId);

    @Insert({
        "insert into hospital.settlement_category (settlement_category_name, valid, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{settlementCategoryName,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="settlementCategoryId", before=false, resultType=Integer.class)
    int insert(SettlementCategory record);

    int insertSelective(SettlementCategory record);

    List<SettlementCategory> selectByExample(SettlementCategoryExample example);

    @Select({
        "select",
        "settlement_category_id, settlement_category_name, valid, reserve1, reserve2, ",
        "reserve3",
        "from hospital.settlement_category",
        "where settlement_category_id = #{settlementCategoryId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.SettlementCategoryMapper.BaseResultMap")
    SettlementCategory selectByPrimaryKey(Integer settlementCategoryId);

    int updateByExampleSelective(@Param("record") SettlementCategory record, @Param("example") SettlementCategoryExample example);

    int updateByExample(@Param("record") SettlementCategory record, @Param("example") SettlementCategoryExample example);

    int updateByPrimaryKeySelective(SettlementCategory record);

    @Update({
        "update hospital.settlement_category",
        "set settlement_category_name = #{settlementCategoryName,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where settlement_category_id = #{settlementCategoryId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SettlementCategory record);
}