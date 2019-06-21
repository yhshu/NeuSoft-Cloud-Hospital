package com.neusoft.medical.dao;

import com.neusoft.medical.bean.PrescriptionEntry;
import com.neusoft.medical.bean.PrescriptionEntryExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PrescriptionEntryMapper {
    long countByExample(PrescriptionEntryExample example);

    int deleteByExample(PrescriptionEntryExample example);

    @Delete({
        "delete from hospital.prescription_entry",
        "where prescription_entry_id = #{prescriptionEntryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer prescriptionEntryId);

    @Insert({
        "insert into hospital.prescription_entry (medicine_id, prescription_id, ",
        "unit_price, total_price, ",
        "nums, medicine_usage, ",
        "medicine_dosage, medicine_frequency, ",
        "medicine_number_day, skin_test, ",
        "skin_test_result, pay_state, ",
        "doctor_advice, valid, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{medicineId,jdbcType=INTEGER}, #{prescriptionId,jdbcType=INTEGER}, ",
        "#{unitPrice,jdbcType=DOUBLE}, #{totalPrice,jdbcType=DOUBLE}, ",
        "#{nums,jdbcType=INTEGER}, #{medicineUsage,jdbcType=VARCHAR}, ",
        "#{medicineDosage,jdbcType=VARCHAR}, #{medicineFrequency,jdbcType=VARCHAR}, ",
        "#{medicineNumberDay,jdbcType=VARCHAR}, #{skinTest,jdbcType=VARCHAR}, ",
        "#{skinTestResult,jdbcType=VARCHAR}, #{payState,jdbcType=INTEGER}, ",
        "#{doctorAdvice,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="prescriptionEntryId", before=false, resultType=Integer.class)
    int insert(PrescriptionEntry record);

    int insertSelective(PrescriptionEntry record);

    List<PrescriptionEntry> selectByExample(PrescriptionEntryExample example);

    @Select({
        "select",
        "prescription_entry_id, medicine_id, prescription_id, unit_price, total_price, ",
        "nums, medicine_usage, medicine_dosage, medicine_frequency, medicine_number_day, ",
        "skin_test, skin_test_result, pay_state, doctor_advice, valid, reserve1, reserve2, ",
        "reserve3",
        "from hospital.prescription_entry",
        "where prescription_entry_id = #{prescriptionEntryId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.PrescriptionEntryMapper.BaseResultMap")
    PrescriptionEntry selectByPrimaryKey(Integer prescriptionEntryId);

    int updateByExampleSelective(@Param("record") PrescriptionEntry record, @Param("example") PrescriptionEntryExample example);

    int updateByExample(@Param("record") PrescriptionEntry record, @Param("example") PrescriptionEntryExample example);

    int updateByPrimaryKeySelective(PrescriptionEntry record);

    @Update({
        "update hospital.prescription_entry",
        "set medicine_id = #{medicineId,jdbcType=INTEGER},",
          "prescription_id = #{prescriptionId,jdbcType=INTEGER},",
          "unit_price = #{unitPrice,jdbcType=DOUBLE},",
          "total_price = #{totalPrice,jdbcType=DOUBLE},",
          "nums = #{nums,jdbcType=INTEGER},",
          "medicine_usage = #{medicineUsage,jdbcType=VARCHAR},",
          "medicine_dosage = #{medicineDosage,jdbcType=VARCHAR},",
          "medicine_frequency = #{medicineFrequency,jdbcType=VARCHAR},",
          "medicine_number_day = #{medicineNumberDay,jdbcType=VARCHAR},",
          "skin_test = #{skinTest,jdbcType=VARCHAR},",
          "skin_test_result = #{skinTestResult,jdbcType=VARCHAR},",
          "pay_state = #{payState,jdbcType=INTEGER},",
          "doctor_advice = #{doctorAdvice,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where prescription_entry_id = #{prescriptionEntryId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PrescriptionEntry record);
}