package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Examination;
import com.neusoft.medical.bean.ExaminationExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ExaminationMapper {
    long countByExample(ExaminationExample example);

    int deleteByExample(ExaminationExample example);

    @Delete({
        "delete from hospital..examination",
        "where examination_id = #{examinationId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer examinationId);

    @Insert({
        "insert into hospital..examination (examination_id, registration_name, ",
        "registration_id, charge_item_id, ",
        "result, doctor_id, ",
        "department_id, reserve1, ",
        "reserve2, reserve3, ",
        "valid)",
        "values (#{examinationId,jdbcType=INTEGER}, #{registrationName,jdbcType=VARCHAR}, ",
        "#{registrationId,jdbcType=INTEGER}, #{chargeItemId,jdbcType=INTEGER}, ",
        "#{result,jdbcType=VARCHAR}, #{doctorId,jdbcType=INTEGER}, ",
        "#{departmentId,jdbcType=INTEGER}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR}, ",
        "#{valid,jdbcType=INTEGER})"
    })
    int insert(Examination record);

    int insertSelective(Examination record);

    List<Examination> selectByExample(ExaminationExample example);

    @Select({
        "select",
        "examination_id, registration_name, registration_id, charge_item_id, result, ",
        "doctor_id, department_id, reserve1, reserve2, reserve3, valid",
        "from hospital..examination",
        "where examination_id = #{examinationId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.ExaminationMapper.BaseResultMap")
    Examination selectByPrimaryKey(Integer examinationId);

    int updateByExampleSelective(@Param("record") Examination record, @Param("example") ExaminationExample example);

    int updateByExample(@Param("record") Examination record, @Param("example") ExaminationExample example);

    int updateByPrimaryKeySelective(Examination record);

    @Update({
        "update hospital..examination",
        "set registration_name = #{registrationName,jdbcType=VARCHAR},",
          "registration_id = #{registrationId,jdbcType=INTEGER},",
          "charge_item_id = #{chargeItemId,jdbcType=INTEGER},",
          "result = #{result,jdbcType=VARCHAR},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where examination_id = #{examinationId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Examination record);
}