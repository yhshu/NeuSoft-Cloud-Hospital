package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Pathography;
import com.neusoft.medical.bean.PathographyExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PathographyMapper {
    long countByExample(PathographyExample example);

    int deleteByExample(PathographyExample example);

    @Delete({
        "delete from hospital..pathography",
        "where pathography_id = #{pathographyId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer pathographyId);

    @Insert({
        "insert into hospital..pathography (pathography_id, patient_id, ",
        "physical_examination, pathography, ",
        "found_time, note, valid, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{pathographyId,jdbcType=INTEGER}, #{patientId,jdbcType=INTEGER}, ",
        "#{physicalExamination,jdbcType=VARCHAR}, #{pathography,jdbcType=VARCHAR}, ",
        "#{foundTime,jdbcType=DATE}, #{note,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
    int insert(Pathography record);

    int insertSelective(Pathography record);

    List<Pathography> selectByExample(PathographyExample example);

    @Select({
        "select",
        "pathography_id, patient_id, physical_examination, pathography, found_time, note, ",
        "valid, reserve1, reserve2, reserve3",
        "from hospital..pathography",
        "where pathography_id = #{pathographyId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.PathographyMapper.BaseResultMap")
    Pathography selectByPrimaryKey(Integer pathographyId);

    int updateByExampleSelective(@Param("record") Pathography record, @Param("example") PathographyExample example);

    int updateByExample(@Param("record") Pathography record, @Param("example") PathographyExample example);

    int updateByPrimaryKeySelective(Pathography record);

    @Update({
        "update hospital..pathography",
        "set patient_id = #{patientId,jdbcType=INTEGER},",
          "physical_examination = #{physicalExamination,jdbcType=VARCHAR},",
          "pathography = #{pathography,jdbcType=VARCHAR},",
          "found_time = #{foundTime,jdbcType=DATE},",
          "note = #{note,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where pathography_id = #{pathographyId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Pathography record);
}