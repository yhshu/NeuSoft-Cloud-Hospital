package com.neusoft.medical.dao;

import com.neusoft.medical.bean.ChargeForm;
import com.neusoft.medical.bean.ChargeFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ChargeFormMapper {
    long countByExample(ChargeFormExample example);

    int deleteByExample(ChargeFormExample example);

    @Delete({
        "delete from hospital.charge_form",
        "where charge_form_id = #{chargeFormId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer chargeFormId);

    @Insert({
        "insert into hospital.charge_form (charge_form_id, registration_id, ",
        "charge_item_id, item_count, ",
        "uncharged_nums, made_time, ",
        "valid, department_id, ",
        "doctor_id, collector_id, ",
        "not_given_nums, reserve1, ",
        "reserve2, reserve3)",
        "values (#{chargeFormId,jdbcType=INTEGER}, #{registrationId,jdbcType=INTEGER}, ",
        "#{chargeItemId,jdbcType=INTEGER}, #{itemCount,jdbcType=INTEGER}, ",
        "#{unchargedNums,jdbcType=INTEGER}, #{madeTime,jdbcType=TIMESTAMP}, ",
        "#{valid,jdbcType=INTEGER}, #{departmentId,jdbcType=INTEGER}, ",
        "#{doctorId,jdbcType=INTEGER}, #{collectorId,jdbcType=INTEGER}, ",
        "#{notGivenNums,jdbcType=INTEGER}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    int insert(ChargeForm record);

    int insertSelective(ChargeForm record);

    List<ChargeForm> selectByExample(ChargeFormExample example);

    @Select({
        "select",
        "charge_form_id, registration_id, charge_item_id, item_count, uncharged_nums, ",
        "made_time, valid, department_id, doctor_id, collector_id, not_given_nums, reserve1, ",
        "reserve2, reserve3",
        "from hospital.charge_form",
        "where charge_form_id = #{chargeFormId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.ChargeFormMapper.BaseResultMap")
    ChargeForm selectByPrimaryKey(Integer chargeFormId);

    int updateByExampleSelective(@Param("record") ChargeForm record, @Param("example") ChargeFormExample example);

    int updateByExample(@Param("record") ChargeForm record, @Param("example") ChargeFormExample example);

    int updateByPrimaryKeySelective(ChargeForm record);

    @Update({
        "update hospital.charge_form",
        "set registration_id = #{registrationId,jdbcType=INTEGER},",
          "charge_item_id = #{chargeItemId,jdbcType=INTEGER},",
          "item_count = #{itemCount,jdbcType=INTEGER},",
          "uncharged_nums = #{unchargedNums,jdbcType=INTEGER},",
          "made_time = #{madeTime,jdbcType=TIMESTAMP},",
          "valid = #{valid,jdbcType=INTEGER},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "collector_id = #{collectorId,jdbcType=INTEGER},",
          "not_given_nums = #{notGivenNums,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where charge_form_id = #{chargeFormId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ChargeForm record);
}