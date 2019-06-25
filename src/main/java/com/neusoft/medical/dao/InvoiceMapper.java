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
        "insert into hospital.invoice (invoice_title, collector_id, ",
        "pay_time, invoice_amount, ",
        "self_pay, account_pay, ",
        "reimbursement_pay, discounted, ",
        "invoice_state, valid)",
        "values (#{invoiceTitle,jdbcType=VARCHAR}, #{collectorId,jdbcType=INTEGER}, ",
        "#{payTime,jdbcType=TIMESTAMP}, #{invoiceAmount,jdbcType=DOUBLE}, ",
        "#{selfPay,jdbcType=DOUBLE}, #{accountPay,jdbcType=DOUBLE}, ",
        "#{reimbursementPay,jdbcType=DOUBLE}, #{discounted,jdbcType=DOUBLE}, ",
        "#{invoiceState,jdbcType=INTEGER}, #{valid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="invoiceId", before=false, resultType=Integer.class)
    int insert(Invoice record);

    int insertSelective(Invoice record);

    List<Invoice> selectByExample(InvoiceExample example);

    @Select({
        "select",
        "invoice_id, invoice_title, collector_id, pay_time, invoice_amount, self_pay, ",
        "account_pay, reimbursement_pay, discounted, invoice_state, valid",
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
          "collector_id = #{collectorId,jdbcType=INTEGER},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "invoice_amount = #{invoiceAmount,jdbcType=DOUBLE},",
          "self_pay = #{selfPay,jdbcType=DOUBLE},",
          "account_pay = #{accountPay,jdbcType=DOUBLE},",
          "reimbursement_pay = #{reimbursementPay,jdbcType=DOUBLE},",
          "discounted = #{discounted,jdbcType=DOUBLE},",
          "invoice_state = #{invoiceState,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where invoice_id = #{invoiceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Invoice record);
}