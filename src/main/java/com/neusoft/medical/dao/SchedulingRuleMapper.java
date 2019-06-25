package com.neusoft.medical.dao;

import com.neusoft.medical.bean.SchedulingRule;
import com.neusoft.medical.bean.SchedulingRuleExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SchedulingRuleMapper {
    long countByExample(SchedulingRuleExample example);

    int deleteByExample(SchedulingRuleExample example);

    @Delete({
        "delete from hospital.scheduling_rule",
        "where scheduling_rule_id = #{schedulingRuleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer schedulingRuleId);

    @Insert({
        "insert into hospital.scheduling_rule (weekday, department_id, ",
        "doctor_id, registration_category_id, ",
        "noon, limitation, ",
        "operation_account_id, operation_date, ",
        "valid)",
        "values (#{weekday,jdbcType=INTEGER}, #{departmentId,jdbcType=INTEGER}, ",
        "#{doctorId,jdbcType=INTEGER}, #{registrationCategoryId,jdbcType=INTEGER}, ",
        "#{noon,jdbcType=INTEGER}, #{limitation,jdbcType=INTEGER}, ",
        "#{operationAccountId,jdbcType=INTEGER}, #{operationDate,jdbcType=DATE}, ",
        "#{valid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="schedulingRuleId", before=false, resultType=Integer.class)
    int insert(SchedulingRule record);

    int insertSelective(SchedulingRule record);

    List<SchedulingRule> selectByExample(SchedulingRuleExample example);

    @Select({
        "select",
        "scheduling_rule_id, weekday, department_id, doctor_id, registration_category_id, ",
        "noon, limitation, operation_account_id, operation_date, valid",
        "from hospital.scheduling_rule",
        "where scheduling_rule_id = #{schedulingRuleId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.SchedulingRuleMapper.BaseResultMap")
    SchedulingRule selectByPrimaryKey(Integer schedulingRuleId);

    int updateByExampleSelective(@Param("record") SchedulingRule record, @Param("example") SchedulingRuleExample example);

    int updateByExample(@Param("record") SchedulingRule record, @Param("example") SchedulingRuleExample example);

    int updateByPrimaryKeySelective(SchedulingRule record);

    @Update({
        "update hospital.scheduling_rule",
        "set weekday = #{weekday,jdbcType=INTEGER},",
          "department_id = #{departmentId,jdbcType=INTEGER},",
          "doctor_id = #{doctorId,jdbcType=INTEGER},",
          "registration_category_id = #{registrationCategoryId,jdbcType=INTEGER},",
          "noon = #{noon,jdbcType=INTEGER},",
          "limitation = #{limitation,jdbcType=INTEGER},",
          "operation_account_id = #{operationAccountId,jdbcType=INTEGER},",
          "operation_date = #{operationDate,jdbcType=DATE},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where scheduling_rule_id = #{schedulingRuleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SchedulingRule record);
}