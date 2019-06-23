package com.neusoft.medical.dao;

import com.neusoft.medical.bean.Permission;
import com.neusoft.medical.bean.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    @Delete({
        "delete from hospital.permission",
        "where permission_id = #{permissionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer permissionId);

    @Insert({
        "insert into hospital.permission (permission_name, permission_description, ",
        "valid)",
        "values (#{permissionName,jdbcType=VARCHAR}, #{permissionDescription,jdbcType=VARCHAR}, ",
        "#{valid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="permissionId", before=false, resultType=Integer.class)
    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    @Select({
        "select",
        "permission_id, permission_name, permission_description, valid",
        "from hospital.permission",
        "where permission_id = #{permissionId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.PermissionMapper.BaseResultMap")
    Permission selectByPrimaryKey(Integer permissionId);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    @Update({
        "update hospital.permission",
        "set permission_name = #{permissionName,jdbcType=VARCHAR},",
          "permission_description = #{permissionDescription,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where permission_id = #{permissionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Permission record);
}