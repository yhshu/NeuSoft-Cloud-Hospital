package com.neusoft.medical.dao;

import com.neusoft.medical.bean.ChargeForm;
import com.neusoft.medical.bean.ChargeFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ChargeFormMapper {
    int countByExample(ChargeFormExample example);

    int deleteByExample(ChargeFormExample example);

    @Insert({
        "insert into charge_form (charge_form_id, registration_id, ",
        "charge_item_id, item_count, ",
        "uncharged_nums, made_time, ",
        "reserve1, reserve2, ",
        "reserve3, department_id, ",
        "doctor_id, collector_id, ",
        "not_given_nums)",
        "values (#{chargeFormId,jdbcType=INTEGER}, #{registrationId,jdbcType=INTEGER}, ",
        "#{chargeItemId,jdbcType=INTEGER}, #{itemCount,jdbcType=INTEGER}, ",
        "#{unchargedNums,jdbcType=INTEGER}, #{madeTime,jdbcType=TIMESTAMP}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR}, #{departmentId,jdbcType=INTEGER}, ",
        "#{doctorId,jdbcType=INTEGER}, #{collectorId,jdbcType=INTEGER}, ",
        "#{notGivenNums,jdbcType=INTEGER})"
    })
    int insert(ChargeForm record);

    int insertSelective(ChargeForm record);

    List<ChargeForm> selectByExample(ChargeFormExample example);

    int updateByExampleSelective(@Param("record") ChargeForm record, @Param("example") ChargeFormExample example);

    int updateByExample(@Param("record") ChargeForm record, @Param("example") ChargeFormExample example);
}