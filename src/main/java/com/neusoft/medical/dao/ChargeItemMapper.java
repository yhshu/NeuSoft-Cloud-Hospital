package com.neusoft.medical.dao;

import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.bean.ChargeItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ChargeItemMapper {
    int countByExample(ChargeItemExample example);

    int deleteByExample(ChargeItemExample example);

    @Insert({
        "insert into charge_item (charge_item_id, name_zh, ",
        "name_en, price, nums, ",
        "department_id, charge_time, ",
        "name_pinyin, reserve1, ",
        "reserve2, reserve3)",
        "values (#{chargeItemId,jdbcType=INTEGER}, #{nameZh,jdbcType=VARCHAR}, ",
        "#{nameEn,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, #{nums,jdbcType=INTEGER}, ",
        "#{departmentId,jdbcType=INTEGER}, #{chargeTime,jdbcType=TIMESTAMP}, ",
        "#{namePinyin,jdbcType=VARCHAR}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    int insert(ChargeItem record);

    int insertSelective(ChargeItem record);

    List<ChargeItem> selectByExample(ChargeItemExample example);

    int updateByExampleSelective(@Param("record") ChargeItem record, @Param("example") ChargeItemExample example);

    int updateByExample(@Param("record") ChargeItem record, @Param("example") ChargeItemExample example);
}