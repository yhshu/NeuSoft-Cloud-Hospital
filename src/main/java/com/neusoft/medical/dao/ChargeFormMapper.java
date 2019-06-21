package com.neusoft.medical.dao;

import com.neusoft.medical.bean.ChargeForm;
import com.neusoft.medical.bean.ChargeFormExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ChargeFormMapper {
    long countByExample(ChargeFormExample example);

    int deleteByExample(ChargeFormExample example);

    @Delete({
        "delete from hospital.charge_form",
        "where charge_form_id = #{chargeFormId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer chargeFormId);

    @Insert({
        "insert into hospital.charge_form (charge_form_name, registration_id, ",
        "save_state, pay_state, ",
        "execution_state, valid, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{chargeFormName,jdbcType=VARCHAR}, #{registrationId,jdbcType=INTEGER}, ",
        "#{saveState,jdbcType=INTEGER}, #{payState,jdbcType=INTEGER}, ",
        "#{executionState,jdbcType=INTEGER}, #{valid,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="chargeFormId", before=false, resultType=Integer.class)
    int insert(ChargeForm record);

    int insertSelective(ChargeForm record);

    List<ChargeForm> selectByExample(ChargeFormExample example);

    @Select({
        "select",
        "charge_form_id, charge_form_name, registration_id, save_state, pay_state, execution_state, ",
        "valid, reserve1, reserve2, reserve3",
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
        "set charge_form_name = #{chargeFormName,jdbcType=VARCHAR},",
          "registration_id = #{registrationId,jdbcType=INTEGER},",
          "save_state = #{saveState,jdbcType=INTEGER},",
          "pay_state = #{payState,jdbcType=INTEGER},",
          "execution_state = #{executionState,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where charge_form_id = #{chargeFormId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ChargeForm record);
}