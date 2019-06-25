package com.neusoft.medical.dao;

import com.neusoft.medical.bean.DailySettlementDetail;
import com.neusoft.medical.bean.DailySettlementDetailExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DailySettlementDetailMapper {
    long countByExample(DailySettlementDetailExample example);

    int deleteByExample(DailySettlementDetailExample example);

    @Delete({
        "delete from hospital.daily_settlement_detail",
        "where daily_settlement_detail_id = #{dailySettlementDetailId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer dailySettlementDetailId);

    @Insert({
        "insert into hospital.daily_settlement_detail (invoice_nums, registration_id, ",
        "patient_name, invoice_total_amount, ",
        "self_pay, account_pay, ",
        "reimbursement_pay, discounted, ",
        "daily_settlement_detail_state, settlement_category_id, ",
        "valid)",
        "values (#{invoiceNums,jdbcType=INTEGER}, #{registrationId,jdbcType=INTEGER}, ",
        "#{patientName,jdbcType=VARCHAR}, #{invoiceTotalAmount,jdbcType=DOUBLE}, ",
        "#{selfPay,jdbcType=DOUBLE}, #{accountPay,jdbcType=DOUBLE}, ",
        "#{reimbursementPay,jdbcType=DOUBLE}, #{discounted,jdbcType=DOUBLE}, ",
        "#{dailySettlementDetailState,jdbcType=INTEGER}, #{settlementCategoryId,jdbcType=INTEGER}, ",
        "#{valid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="dailySettlementDetailId", before=false, resultType=Integer.class)
    int insert(DailySettlementDetail record);

    int insertSelective(DailySettlementDetail record);

    List<DailySettlementDetail> selectByExample(DailySettlementDetailExample example);

    @Select({
        "select",
        "daily_settlement_detail_id, invoice_nums, registration_id, patient_name, invoice_total_amount, ",
        "self_pay, account_pay, reimbursement_pay, discounted, daily_settlement_detail_state, ",
        "settlement_category_id, valid",
        "from hospital.daily_settlement_detail",
        "where daily_settlement_detail_id = #{dailySettlementDetailId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.DailySettlementDetailMapper.BaseResultMap")
    DailySettlementDetail selectByPrimaryKey(Integer dailySettlementDetailId);

    int updateByExampleSelective(@Param("record") DailySettlementDetail record, @Param("example") DailySettlementDetailExample example);

    int updateByExample(@Param("record") DailySettlementDetail record, @Param("example") DailySettlementDetailExample example);

    int updateByPrimaryKeySelective(DailySettlementDetail record);

    @Update({
        "update hospital.daily_settlement_detail",
        "set invoice_nums = #{invoiceNums,jdbcType=INTEGER},",
          "registration_id = #{registrationId,jdbcType=INTEGER},",
          "patient_name = #{patientName,jdbcType=VARCHAR},",
          "invoice_total_amount = #{invoiceTotalAmount,jdbcType=DOUBLE},",
          "self_pay = #{selfPay,jdbcType=DOUBLE},",
          "account_pay = #{accountPay,jdbcType=DOUBLE},",
          "reimbursement_pay = #{reimbursementPay,jdbcType=DOUBLE},",
          "discounted = #{discounted,jdbcType=DOUBLE},",
          "daily_settlement_detail_state = #{dailySettlementDetailState,jdbcType=INTEGER},",
          "settlement_category_id = #{settlementCategoryId,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where daily_settlement_detail_id = #{dailySettlementDetailId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DailySettlementDetail record);
}