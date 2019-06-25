package com.neusoft.medical.dao;

import com.neusoft.medical.bean.AccountTypePermission;
import com.neusoft.medical.bean.AccountTypePermissionExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccountTypePermissionMapper {
    long countByExample(AccountTypePermissionExample example);

    int deleteByExample(AccountTypePermissionExample example);

    @Delete({
        "delete from hospital.account_type_permission",
        "where account_type_permission_id = #{accountTypePermissionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer accountTypePermissionId);

    @Insert({
        "insert into hospital.account_type_permission (account_type, permission_id, ",
        "valid)",
        "values (#{accountType,jdbcType=INTEGER}, #{permissionId,jdbcType=INTEGER}, ",
        "#{valid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="accountTypePermissionId", before=false, resultType=Integer.class)
    int insert(AccountTypePermission record);

    int insertSelective(AccountTypePermission record);

    List<AccountTypePermission> selectByExample(AccountTypePermissionExample example);

    @Select({
        "select",
        "account_type_permission_id, account_type, permission_id, valid",
        "from hospital.account_type_permission",
        "where account_type_permission_id = #{accountTypePermissionId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.AccountTypePermissionMapper.BaseResultMap")
    AccountTypePermission selectByPrimaryKey(Integer accountTypePermissionId);

    int updateByExampleSelective(@Param("record") AccountTypePermission record, @Param("example") AccountTypePermissionExample example);

    int updateByExample(@Param("record") AccountTypePermission record, @Param("example") AccountTypePermissionExample example);

    int updateByPrimaryKeySelective(AccountTypePermission record);

    @Update({
        "update hospital.account_type_permission",
        "set account_type = #{accountType,jdbcType=INTEGER},",
          "permission_id = #{permissionId,jdbcType=INTEGER},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where account_type_permission_id = #{accountTypePermissionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AccountTypePermission record);
}