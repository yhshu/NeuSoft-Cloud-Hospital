package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Prescription;
import com.neusoft.medical.bean.PrescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PrescriptionMapper {
    long countByExample(PrescriptionExample example);

    int deleteByExample(PrescriptionExample example);

    @Delete({
        "delete from hospital.prescription",
        "where presciption_id = #{presciptionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer presciptionId);

    @Insert({
        "insert into hospital.prescription (presciption_id, registration_id, ",
        "registration_name, doctor_id, ",
        "content, valid, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{presciptionId,jdbcType=INTEGER}, #{registrationId,jdbcType=INTEGER}, ",
        "#{registrationName,jdbcType=VARCHAR}, #{doctorId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    int insert(Prescription record);

    int insertSelective(Prescription record);

    List<Prescription> selectByExample(PrescriptionExample example);

    @Select({
        "select",
        "presciption_id, registration_id, registration_name, doctor_id, content, valid, ",
        "reserve1, reserve2, reserve3",
        "from hospital.prescription",
        "where presciption_id = #{presciptionId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.PrescriptionMapper.BaseResultMap")
    Prescription selectByPrimaryKey(Integer presciptionId);

    int updateByExampleSelective(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByExample(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByPrimaryKeySelective(Prescription record);

    @Update({
        "update hospital.prescription",
        "set registration_id = #{registrationId,jdbcType=INTEGER},",
          "registration_name = #{registrationName,jdbcType=VARCHAR},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where presciption_id = #{presciptionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Prescription record);
}