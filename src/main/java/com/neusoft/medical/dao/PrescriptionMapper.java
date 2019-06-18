package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Prescription;
import com.neusoft.medical.bean.PrescriptionExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PrescriptionMapper {
    long countByExample(PrescriptionExample example);

    int deleteByExample(PrescriptionExample example);

    @Delete({
        "delete from hospital.prescription",
        "where prescription_id = #{prescriptionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer prescriptionId);

    @Insert({
        "insert into hospital.prescription (prescription_name, registration_id, ",
        "save_state, valid, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{prescriptionName,jdbcType=VARCHAR}, #{registrationId,jdbcType=INTEGER}, ",
        "#{saveState,jdbcType=INTEGER}, #{valid,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="prescriptionId", before=false, resultType=Integer.class)
    int insert(Prescription record);

    int insertSelective(Prescription record);

    List<Prescription> selectByExample(PrescriptionExample example);

    @Select({
        "select",
        "prescription_id, prescription_name, registration_id, save_state, valid, reserve1, ",
        "reserve2, reserve3",
        "from hospital.prescription",
        "where prescription_id = #{prescriptionId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.PrescriptionMapper.BaseResultMap")
    Prescription selectByPrimaryKey(Integer prescriptionId);

    int updateByExampleSelective(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByExample(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByPrimaryKeySelective(Prescription record);

    @Update({
        "update hospital.prescription",
        "set prescription_name = #{prescriptionName,jdbcType=VARCHAR},",
          "registration_id = #{registrationId,jdbcType=INTEGER},",
          "save_state = #{saveState,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where prescription_id = #{prescriptionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Prescription record);
}