package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Staff;
import com.neusoft.medical.bean.StaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface StaffMapper {
    int countByExample(StaffExample example);

    int deleteByExample(StaffExample example);

    @Insert({
        "insert into staff (staff_id, department_name, ",
        "department_id, type, ",
        "reserve1, reserve2, ",
        "reserve3, account_id)",
        "values (#{staffId,jdbcType=INTEGER}, #{departmentName,jdbcType=VARCHAR}, ",
        "#{departmentId,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR}, #{accountId,jdbcType=INTEGER})"
    })
    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExample(StaffExample example);

    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);
}