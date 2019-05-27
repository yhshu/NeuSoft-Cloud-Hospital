package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Prescription;
import com.neusoft.medical.bean.PrescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface PrescriptionMapper {
    int countByExample(PrescriptionExample example);

    int deleteByExample(PrescriptionExample example);

    @Insert({
        "insert into prescription (presciption_id, registration_id, ",
        "registration_name, doctor_id, ",
        "reserve1, reserve2, ",
        "reserve3, content)",
        "values (#{presciptionId,jdbcType=INTEGER}, #{registrationId,jdbcType=INTEGER}, ",
        "#{registrationName,jdbcType=VARCHAR}, #{doctorId,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Prescription record);

    int insertSelective(Prescription record);

    List<Prescription> selectByExampleWithBLOBs(PrescriptionExample example);

    List<Prescription> selectByExample(PrescriptionExample example);

    int updateByExampleSelective(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByExampleWithBLOBs(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByExample(@Param("record") Prescription record, @Param("example") PrescriptionExample example);
}