package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Pathography;
import com.neusoft.medical.bean.PathographyExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface PathographyMapper {
    int countByExample(PathographyExample example);

    int deleteByExample(PathographyExample example);

    @Insert({
        "insert into pathography (pathography_id, patient_id, ",
        "physical_examination, pathography, ",
        "found_time, note, reserve1, ",
        "reserve2, reserve3)",
        "values (#{pathographyId,jdbcType=INTEGER}, #{patientId,jdbcType=INTEGER}, ",
        "#{physicalExamination,jdbcType=VARCHAR}, #{pathography,jdbcType=VARCHAR}, ",
        "#{foundTime,jdbcType=DATE}, #{note,jdbcType=VARCHAR}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    int insert(Pathography record);

    int insertSelective(Pathography record);

    List<Pathography> selectByExample(PathographyExample example);

    int updateByExampleSelective(@Param("record") Pathography record, @Param("example") PathographyExample example);

    int updateByExample(@Param("record") Pathography record, @Param("example") PathographyExample example);
}