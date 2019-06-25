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
        "insert into hospital.invoice (expense_category_id, registration_id, ",
        "collector_id, pay_time, ",
        "pay_amount, valid)",
        "values (#{expenseCategoryId,jdbcType=INTEGER}, #{registrationId,jdbcType=INTEGER}, ",
        "#{collectorId,jdbcType=INTEGER}, #{payTime,jdbcType=TIMESTAMP}, ",
        "#{payAmount,jdbcType=DOUBLE}, #{valid,jdbcType=BIT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="invoiceId", before=false, resultType=Integer.class)
    int insert(Invoice record);

    int insertSelective(Invoice record);

    List<Invoice> selectByExample(InvoiceExample example);

    @Select({
        "select",
        "invoice_id, expense_category_id, registration_id, collector_id, pay_time, pay_amount, ",
        "valid",
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
        "set expense_category_id = #{expenseCategoryId,jdbcType=INTEGER},",
          "registration_id = #{registrationId,jdbcType=INTEGER},",
          "collector_id = #{collectorId,jdbcType=INTEGER},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "pay_amount = #{payAmount,jdbcType=DOUBLE},",
          "valid = #{valid,jdbcType=BIT}",
        "where invoice_id = #{invoiceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Invoice record);
}