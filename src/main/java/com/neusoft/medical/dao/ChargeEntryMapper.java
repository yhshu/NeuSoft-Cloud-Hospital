package com.neusoft.medical.dao;

import com.neusoft.medical.bean.ChargeEntry;
import com.neusoft.medical.bean.ChargeEntryExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ChargeEntryMapper {
    long countByExample(ChargeEntryExample example);

    int deleteByExample(ChargeEntryExample example);

    @Delete({
        "delete from hospital.charge_entry",
        "where charge_entry_id = #{chargeEntryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer chargeEntryId);

    @Insert({
        "insert into hospital.charge_entry (registration_id, charge_form_id, ",
        "charge_item_id, unit_price, ",
        "total_price, nums, ",
        "uncharged_nums, not_given_nums, ",
        "pay_state, made_time, ",
        "department_id, doctor_id, ",
        "collector_id, valid, ",
        "doctor_advice, reserve1, ",
        "reserve2, reserve3)",
        "values (#{registrationId,jdbcType=INTEGER}, #{chargeFormId,jdbcType=INTEGER}, ",
        "#{chargeItemId,jdbcType=INTEGER}, #{unitPrice,jdbcType=DOUBLE}, ",
        "#{totalPrice,jdbcType=DOUBLE}, #{nums,jdbcType=INTEGER}, ",
        "#{unchargedNums,jdbcType=INTEGER}, #{notGivenNums,jdbcType=INTEGER}, ",
        "#{payState,jdbcType=INTEGER}, #{madeTime,jdbcType=TIMESTAMP}, ",
        "#{departmentId,jdbcType=INTEGER}, #{doctorId,jdbcType=INTEGER}, ",
        "#{collectorId,jdbcType=INTEGER}, #{valid,jdbcType=INTEGER}, ",
        "#{doctorAdvice,jdbcType=VARCHAR}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="chargeEntryId", before=false, resultType=Integer.class)
    int insert(ChargeEntry record);

    int insertSelective(ChargeEntry record);

    List<ChargeEntry> selectByExample(ChargeEntryExample example);

    @Select({
        "select",
        "charge_entry_id, registration_id, charge_form_id, charge_item_id, unit_price, ",
        "total_price, nums, uncharged_nums, not_given_nums, pay_state, made_time, department_id, ",
        "doctor_id, collector_id, valid, doctor_advice, reserve1, reserve2, reserve3",
        "from hospital.charge_entry",
        "where charge_entry_id = #{chargeEntryId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.ChargeEntryMapper.BaseResultMap")
    ChargeEntry selectByPrimaryKey(Integer chargeEntryId);

    int updateByExampleSelective(@Param("record") ChargeEntry record, @Param("example") ChargeEntryExample example);

    int updateByExample(@Param("record") ChargeEntry record, @Param("example") ChargeEntryExample example);

    int updateByPrimaryKeySelective(ChargeEntry record);

    @Update({
        "update hospital.charge_entry",
        "set registration_id = #{registrationId,jdbcType=INTEGER},",
          "charge_form_id = #{chargeFormId,jdbcType=INTEGER},",
          "charge_item_id = #{chargeItemId,jdbcType=INTEGER},",
          "unit_price = #{unitPrice,jdbcType=DOUBLE},",
          "total_price = #{totalPrice,jdbcType=DOUBLE},",
          "nums = #{nums,jdbcType=INTEGER},",
          "uncharged_nums = #{unchargedNums,jdbcType=INTEGER},",
          "not_given_nums = #{notGivenNums,jdbcType=INTEGER},",
          "pay_state = #{payState,jdbcType=INTEGER},",
          "made_time = #{madeTime,jdbcType=TIMESTAMP},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "collector_id = #{collectorId,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER},",
          "doctor_advice = #{doctorAdvice,jdbcType=VARCHAR},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where charge_entry_id = #{chargeEntryId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ChargeEntry record);
}