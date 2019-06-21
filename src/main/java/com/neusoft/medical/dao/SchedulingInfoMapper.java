package com.neusoft.medical.dao;

import com.neusoft.medical.bean.SchedulingInfo;
import com.neusoft.medical.bean.SchedulingInfoExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SchedulingInfoMapper {
    long countByExample(SchedulingInfoExample example);

    int deleteByExample(SchedulingInfoExample example);

    @Delete({
        "delete from hospital.scheduling_info",
        "where scheduling_info_id = #{schedulingInfoId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer schedulingInfoId);

    @Insert({
        "insert into hospital.scheduling_info (scheduling_time, department_id, ",
        "doctor_id, registration_category_id, ",
        "noon, valid, limitation, ",
        "remain_nums)",
        "values (#{schedulingTime,jdbcType=DATE}, #{departmentId,jdbcType=INTEGER}, ",
        "#{doctorId,jdbcType=INTEGER}, #{registrationCategoryId,jdbcType=INTEGER}, ",
        "#{noon,jdbcType=INTEGER}, #{valid,jdbcType=INTEGER}, #{limitation,jdbcType=INTEGER}, ",
        "#{remainNums,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="schedulingInfoId", before=false, resultType=Integer.class)
    int insert(SchedulingInfo record);

    int insertSelective(SchedulingInfo record);

    List<SchedulingInfo> selectByExample(SchedulingInfoExample example);

    @Select({
        "select",
        "scheduling_info_id, scheduling_time, department_id, doctor_id, registration_category_id, ",
        "noon, valid, limitation, remain_nums",
        "from hospital.scheduling_info",
        "where scheduling_info_id = #{schedulingInfoId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.SchedulingInfoMapper.BaseResultMap")
    SchedulingInfo selectByPrimaryKey(Integer schedulingInfoId);

    int updateByExampleSelective(@Param("record") SchedulingInfo record, @Param("example") SchedulingInfoExample example);

    int updateByExample(@Param("record") SchedulingInfo record, @Param("example") SchedulingInfoExample example);

    int updateByPrimaryKeySelective(SchedulingInfo record);

    @Update({
        "update hospital.scheduling_info",
        "set scheduling_time = #{schedulingTime,jdbcType=DATE},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "registration_category_id = #{registrationCategoryId,jdbcType=INTEGER},",
          "noon = #{noon,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER},",
          "limitation = #{limitation,jdbcType=INTEGER},",
          "remain_nums = #{remainNums,jdbcType=INTEGER}",
        "where scheduling_info_id = #{schedulingInfoId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SchedulingInfo record);
}