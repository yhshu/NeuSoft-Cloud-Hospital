package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Invoice;
import com.neusoft.medical.bean.InvoiceExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface InvoiceMapper {
    long countByExample(InvoiceExample example);

    int deleteByExample(InvoiceExample example);

    @Delete({
        "delete from hospital.invoice",
        "where invoice_id = #{invoiceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer invoiceId);

    @Insert({
        "insert into hospital.invoice (invoice_title, invoice_nums, ",
        "collector_id, registration_id, ",
        "pay_time, invoice_amount, ",
        "self_pay, account_pay, ",
        "reimbursement_pay, discounted, ",
        "invoice_state, prescription_fee, ",
        "examination_fee, disposal_fee, ",
        "registration_fee, valid)",
        "values (#{invoiceTitle,jdbcType=VARCHAR}, #{invoiceNums,jdbcType=INTEGER}, ",
        "#{collectorId,jdbcType=INTEGER}, #{registrationId,jdbcType=INTEGER}, ",
        "#{payTime,jdbcType=TIMESTAMP}, #{invoiceAmount,jdbcType=DOUBLE}, ",
        "#{selfPay,jdbcType=DOUBLE}, #{accountPay,jdbcType=DOUBLE}, ",
        "#{reimbursementPay,jdbcType=DOUBLE}, #{discounted,jdbcType=DOUBLE}, ",
        "#{invoiceState,jdbcType=INTEGER}, #{prescriptionFee,jdbcType=DOUBLE}, ",
        "#{examinationFee,jdbcType=DOUBLE}, #{disposalFee,jdbcType=DOUBLE}, ",
        "#{registrationFee,jdbcType=DOUBLE}, #{valid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="invoiceId", before=false, resultType=Integer.class)
    int insert(Invoice record);

    int insertSelective(Invoice record);

    List<Invoice> selectByExample(InvoiceExample example);

    @Select({
        "select",
        "invoice_id, invoice_title, invoice_nums, collector_id, registration_id, pay_time, ",
        "invoice_amount, self_pay, account_pay, reimbursement_pay, discounted, invoice_state, ",
        "prescription_fee, examination_fee, disposal_fee, registration_fee, valid",
        "from hospital.invoice",
        "where invoice_id = #{invoiceId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.InvoiceMapper.BaseResultMap")
    Invoice selectByPrimaryKey(Integer invoiceId);

    int updateByExampleSelective(@Param("record") Invoice record, @Param("example") InvoiceExample example);

    int updateByExample(@Param("record") Invoice record, @Param("example") InvoiceExample example);

    int updateByPrimaryKeySelective(Invoice record);

    @Update({
        "update hospital.invoice",
        "set invoice_title = #{invoiceTitle,jdbcType=VARCHAR},",
          "invoice_nums = #{invoiceNums,jdbcType=INTEGER},",
          "collector_id = #{collectorId,jdbcType=INTEGER},",
          "registration_id = #{registrationId,jdbcType=INTEGER},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "invoice_amount = #{invoiceAmount,jdbcType=DOUBLE},",
          "self_pay = #{selfPay,jdbcType=DOUBLE},",
          "account_pay = #{accountPay,jdbcType=DOUBLE},",
          "reimbursement_pay = #{reimbursementPay,jdbcType=DOUBLE},",
          "discounted = #{discounted,jdbcType=DOUBLE},",
          "invoice_state = #{invoiceState,jdbcType=INTEGER},",
          "prescription_fee = #{prescriptionFee,jdbcType=DOUBLE},",
          "examination_fee = #{examinationFee,jdbcType=DOUBLE},",
          "disposal_fee = #{disposalFee,jdbcType=DOUBLE},",
          "registration_fee = #{registrationFee,jdbcType=DOUBLE},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where invoice_id = #{invoiceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Invoice record);
}