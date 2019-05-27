package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Examination;
import com.neusoft.medical.bean.ExaminationExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ExaminationMapper {
    int countByExample(ExaminationExample example);

    int deleteByExample(ExaminationExample example);

    @Insert({
        "insert into examination (examination_id, registration_name, ",
        "registration_id, charge_item_id, ",
        "result, reserve1, ",
        "reserve2, reserve3, ",
        "doctor_id, department_id)",
        "values (#{examinationId,jdbcType=INTEGER}, #{registrationName,jdbcType=VARCHAR}, ",
        "#{registrationId,jdbcType=INTEGER}, #{chargeItemId,jdbcType=INTEGER}, ",
        "#{result,jdbcType=VARCHAR}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR}, ",
        "#{doctorId,jdbcType=INTEGER}, #{departmentId,jdbcType=INTEGER})"
    })
    int insert(Examination record);

    int insertSelective(Examination record);

    List<Examination> selectByExample(ExaminationExample example);

    int updateByExampleSelective(@Param("record") Examination record, @Param("example") ExaminationExample example);

    int updateByExample(@Param("record") Examination record, @Param("example") ExaminationExample example);
}