package com.neusoft.medical.dao;

import com.neusoft.medical.bean.ExpenseCategory;
import com.neusoft.medical.bean.ExpenseCategoryExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ExpenseCategoryMapper {
    long countByExample(ExpenseCategoryExample example);

    int deleteByExample(ExpenseCategoryExample example);

    @Delete({
        "delete from hospital.expense_category",
        "where expense_category_id = #{expenseCategoryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer expenseCategoryId);

    @Insert({
        "insert into hospital.expense_category (expense_code, expense_name, ",
        "valid, reserve1, ",
        "reserve2, reserve3)",
        "values (#{expenseCode,jdbcType=VARCHAR}, #{expenseName,jdbcType=VARCHAR}, ",
        "#{valid,jdbcType=INTEGER}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{reserve3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="expenseCategoryId", before=false, resultType=Integer.class)
    int insert(ExpenseCategory record);

    int insertSelective(ExpenseCategory record);

    List<ExpenseCategory> selectByExample(ExpenseCategoryExample example);

    @Select({
        "select",
        "expense_category_id, expense_code, expense_name, valid, reserve1, reserve2, ",
        "reserve3",
        "from hospital.expense_category",
        "where expense_category_id = #{expenseCategoryId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.ExpenseCategoryMapper.BaseResultMap")
    ExpenseCategory selectByPrimaryKey(Integer expenseCategoryId);

    int updateByExampleSelective(@Param("record") ExpenseCategory record, @Param("example") ExpenseCategoryExample example);

    int updateByExample(@Param("record") ExpenseCategory record, @Param("example") ExpenseCategoryExample example);

    int updateByPrimaryKeySelective(ExpenseCategory record);

    @Update({
        "update hospital.expense_category",
        "set expense_code = #{expenseCode,jdbcType=VARCHAR},",
          "expense_name = #{expenseName,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "reserve3 = #{reserve3,jdbcType=VARCHAR}",
        "where expense_category_id = #{expenseCategoryId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ExpenseCategory record);
}