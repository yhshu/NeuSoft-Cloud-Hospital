package com.neusoft.medical.dao;

import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.bean.ChargeItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ChargeItemMapper {
    long countByExample(ChargeItemExample example);

    int deleteByExample(ChargeItemExample example);

    @Delete({
        "delete from hospital.charge_item",
        "where charge_item_id = #{chargeItemId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer chargeItemId);

    @Insert({
        "insert into hospital.charge_item (charge_item_id, charge_item_code, ",
        "name_zh, charge_item_format, ",
        "price, exp_class_id, ",
        "department_id, name_pinyin, ",
        "recode_type, creation_time, ",
        "charge_time, nums, ",
        "name_en, valid, reserve1, ",
        "reserve2, reserve3)",
        "values (#{chargeItemId,jdbcType=INTEGER}, #{chargeItemCode,jdbcType=VARCHAR}, ",
        "#{nameZh,jdbcType=VARCHAR}, #{chargeItemFormat,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=DECIMAL}, #{expClassId,jdbcType=INTEGER}, ",
        "#{departmentId,jdbcType=INTEGER}, #{namePinyin,jdbcType=VARCHAR}, ",
        "#{recodeType,jdbcType=INTEGER}, #{creationTime,jdbcType=DATE}, ",
        "#{chargeTime,jdbcType=TIMESTAMP}, #{nums,jdbcType=INTEGER}, ",
        "#{nameEn,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    int insert(ChargeItem record);

    int insertSelective(ChargeItem record);

    List<ChargeItem> selectByExample(ChargeItemExample example);

    @Select({
        "select",
        "charge_item_id, charge_item_code, name_zh, charge_item_format, price, exp_class_id, ",
        "department_id, name_pinyin, recode_type, creation_time, charge_time, nums, name_en, ",
        "valid, reserve1, reserve2, reserve3",
        "from hospital.charge_item",
        "where charge_item_id = #{chargeItemId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.ChargeItemMapper.BaseResultMap")
    ChargeItem selectByPrimaryKey(Integer chargeItemId);

    int updateByExampleSelective(@Param("record") ChargeItem record, @Param("example") ChargeItemExample example);

    int updateByExample(@Param("record") ChargeItem record, @Param("example") ChargeItemExample example);

    int updateByPrimaryKeySelective(ChargeItem record);

    @Update({
        "update hospital.charge_item",
        "set charge_item_code = #{chargeItemCode,jdbcType=VARCHAR},",
          "name_zh = #{nameZh,jdbcType=VARCHAR},",
          "charge_item_format = #{chargeItemFormat,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "exp_class_id = #{expClassId,jdbcType=INTEGER},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "name_pinyin = #{namePinyin,jdbcType=VARCHAR},",
          "recode_type = #{recodeType,jdbcType=INTEGER},",
          "creation_time = #{creationTime,jdbcType=DATE},",
          "charge_time = #{chargeTime,jdbcType=TIMESTAMP},",
          "nums = #{nums,jdbcType=INTEGER},",
          "name_en = #{nameEn,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where charge_item_id = #{chargeItemId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ChargeItem record);
}