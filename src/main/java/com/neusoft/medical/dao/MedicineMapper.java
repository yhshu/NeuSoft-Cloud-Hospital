package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Medicine;
import com.neusoft.medical.bean.MedicineExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface MedicineMapper {
    int countByExample(MedicineExample example);

    int deleteByExample(MedicineExample example);

    @Insert({
        "insert into medicine (medicine_id, name_zh, ",
        "name_en, price, origin, ",
        "nums, name_pinyin, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{medicineId,jdbcType=INTEGER}, #{nameZh,jdbcType=VARCHAR}, ",
        "#{nameEn,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, #{origin,jdbcType=VARCHAR}, ",
        "#{nums,jdbcType=INTEGER}, #{namePinyin,jdbcType=VARCHAR}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    int insert(Medicine record);

    int insertSelective(Medicine record);

    List<Medicine> selectByExample(MedicineExample example);

    int updateByExampleSelective(@Param("record") Medicine record, @Param("example") MedicineExample example);

    int updateByExample(@Param("record") Medicine record, @Param("example") MedicineExample example);
}