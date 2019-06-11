package com.neusoft.medical.dao;

import com.neusoft.medical.bean.ExpenseCategory;
import com.neusoft.medical.bean.ExpenseCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ExpenseCategoryMapper {
    long countByExample(ExpenseCategoryExample example);

    int deleteByExample(ExpenseCategoryExample example);

    @Delete({
        "delete from hospital.expense_category",
        "where expense_category_id = #{expenseCategoryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer expenseCategoryId);

    @Insert({
        "insert into hospital.expense_category (expense_category_id, expense_code, ",
        "expense_name, valid, ",
        "reserve1, reserve2, ",
        "reserve3)",
        "values (#{expenseCategoryId,jdbcType=INTEGER}, #{expenseCode,jdbcType=VARCHAR}, ",
        "#{expenseName,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER}, ",
        "#{reserve1,jdbcType=VARCHAR}, #{reserve2,jdbcType=VARCHAR}, ",
        "#{reserve3,jdbcType=VARCHAR})"
    })
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