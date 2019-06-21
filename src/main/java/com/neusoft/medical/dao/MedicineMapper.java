package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Medicine;
import com.neusoft.medical.bean.MedicineExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MedicineMapper {
    long countByExample(MedicineExample example);

    int deleteByExample(MedicineExample example);

    @Delete({
        "delete from hospital..medicine",
        "where medicine_id = #{medicineId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer medicineId);

    @Insert({
        "insert into hospital..medicine (medicine_code, name_zh, ",
        "medicine_specification, medicine_unit, ",
        "medicine_manufacturer, medicine_dosage_id, ",
        "medicine_type_id, medicine_price, ",
        "name_pinyin, creation_time, ",
        "nums, name_en, valid, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{medicineCode,jdbcType=VARCHAR}, #{nameZh,jdbcType=VARCHAR}, ",
        "#{medicineSpecification,jdbcType=VARCHAR}, #{medicineUnit,jdbcType=VARCHAR}, ",
        "#{medicineManufacturer,jdbcType=VARCHAR}, #{medicineDosageId,jdbcType=INTEGER}, ",
        "#{medicineTypeId,jdbcType=INTEGER}, #{medicinePrice,jdbcType=DECIMAL}, ",
        "#{namePinyin,jdbcType=VARCHAR}, #{creationTime,jdbcType=DATE}, ",
        "#{nums,jdbcType=INTEGER}, #{nameEn,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="medicineId", before=false, resultType=Integer.class)
    int insert(Medicine record);

    int insertSelective(Medicine record);

    List<Medicine> selectByExample(MedicineExample example);

    @Select({
        "select",
        "medicine_id, medicine_code, name_zh, medicine_specification, medicine_unit, ",
        "medicine_manufacturer, medicine_dosage_id, medicine_type_id, medicine_price, ",
        "name_pinyin, creation_time, nums, name_en, valid, reserve1, reserve2, reserve3",
        "from hospital..medicine",
        "where medicine_id = #{medicineId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.MedicineMapper.BaseResultMap")
    Medicine selectByPrimaryKey(Integer medicineId);

    int updateByExampleSelective(@Param("record") Medicine record, @Param("example") MedicineExample example);

    int updateByExample(@Param("record") Medicine record, @Param("example") MedicineExample example);

    int updateByPrimaryKeySelective(Medicine record);

    @Update({
        "update hospital..medicine",
        "set medicine_code = #{medicineCode,jdbcType=VARCHAR},",
          "name_zh = #{nameZh,jdbcType=VARCHAR},",
          "medicine_specification = #{medicineSpecification,jdbcType=VARCHAR},",
          "medicine_unit = #{medicineUnit,jdbcType=VARCHAR},",
          "medicine_manufacturer = #{medicineManufacturer,jdbcType=VARCHAR},",
          "medicine_dosage_id = #{medicineDosageId,jdbcType=INTEGER},",
          "medicine_type_id = #{medicineTypeId,jdbcType=INTEGER},",
          "medicine_price = #{medicinePrice,jdbcType=DECIMAL},",
          "name_pinyin = #{namePinyin,jdbcType=VARCHAR},",
          "creation_time = #{creationTime,jdbcType=DATE},",
          "nums = #{nums,jdbcType=INTEGER},",
          "name_en = #{nameEn,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where medicine_id = #{medicineId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Medicine record);
}