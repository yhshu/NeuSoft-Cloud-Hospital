package com.neusoft.medical.dao;

import com.neusoft.medical.bean.PrescriptionItem;
import com.neusoft.medical.bean.PrescriptionItemExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PrescriptionItemMapper {
    long countByExample(PrescriptionItemExample example);

    int deleteByExample(PrescriptionItemExample example);

    @Delete({
        "delete from hospital.prescription_item",
        "where prescription_item_id = #{prescriptionItemId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer prescriptionItemId);

    @Insert({
        "insert into hospital.prescription_item (medicine_id, prescription_id, ",
        "medicine_usage, medicine_dosage, ",
        "medicine_frequency, medicine_number_day, ",
        "medicine_quantity, skin_test, ",
        "skin_test_result, save_state, ",
        "valid, reserve1, ",
        "reserve2, reserve3)",
        "values (#{medicineId,jdbcType=INTEGER}, #{prescriptionId,jdbcType=INTEGER}, ",
        "#{medicineUsage,jdbcType=VARCHAR}, #{medicineDosage,jdbcType=VARCHAR}, ",
        "#{medicineFrequency,jdbcType=VARCHAR}, #{medicineNumberDay,jdbcType=VARCHAR}, ",
        "#{medicineQuantity,jdbcType=INTEGER}, #{skinTest,jdbcType=VARCHAR}, ",
        "#{skinTestResult,jdbcType=VARCHAR}, #{saveState,jdbcType=INTEGER}, ",
        "#{valid,jdbcType=INTEGER}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="prescriptionItemId", before=false, resultType=Integer.class)
    int insert(PrescriptionItem record);

    int insertSelective(PrescriptionItem record);

    List<PrescriptionItem> selectByExample(PrescriptionItemExample example);

    @Select({
        "select",
        "prescription_item_id, medicine_id, prescription_id, medicine_usage, medicine_dosage, ",
        "medicine_frequency, medicine_number_day, medicine_quantity, skin_test, skin_test_result, ",
        "save_state, valid, reserve1, reserve2, reserve3",
        "from hospital.prescription_item",
        "where prescription_item_id = #{prescriptionItemId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.PrescriptionItemMapper.BaseResultMap")
    PrescriptionItem selectByPrimaryKey(Integer prescriptionItemId);

    int updateByExampleSelective(@Param("record") PrescriptionItem record, @Param("example") PrescriptionItemExample example);

    int updateByExample(@Param("record") PrescriptionItem record, @Param("example") PrescriptionItemExample example);

    int updateByPrimaryKeySelective(PrescriptionItem record);

    @Update({
        "update hospital.prescription_item",
        "set medicine_id = #{medicineId,jdbcType=INTEGER},",
          "prescription_id = #{prescriptionId,jdbcType=INTEGER},",
          "medicine_usage = #{medicineUsage,jdbcType=VARCHAR},",
          "medicine_dosage = #{medicineDosage,jdbcType=VARCHAR},",
          "medicine_frequency = #{medicineFrequency,jdbcType=VARCHAR},",
          "medicine_number_day = #{medicineNumberDay,jdbcType=VARCHAR},",
          "medicine_quantity = #{medicineQuantity,jdbcType=INTEGER},",
          "skin_test = #{skinTest,jdbcType=VARCHAR},",
          "skin_test_result = #{skinTestResult,jdbcType=VARCHAR},",
          "save_state = #{saveState,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where prescription_item_id = #{prescriptionItemId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PrescriptionItem record);
}