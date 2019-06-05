package com.neusoft.medical.dao;

import com.neusoft.medical.bean.ExpenseClass;
import com.neusoft.medical.bean.ExpenseClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ExpenseClassMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..expense_class
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    int countByExample(ExpenseClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..expense_class
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    int deleteByExample(ExpenseClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..expense_class
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    @Delete({
        "delete from hospital..expense_class",
        "where expense_class_id = #{expenseClassId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer expenseClassId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..expense_class
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    @Insert({
        "insert into hospital..expense_class (expense_class_id, expense_code, ",
        "expense_name, valid)",
        "values (#{expenseClassId,jdbcType=INTEGER}, #{expenseCode,jdbcType=VARCHAR}, ",
        "#{expenseName,jdbcType=VARCHAR}, #{valid,jdbcType=INTEGER})"
    })
    int insert(ExpenseClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..expense_class
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    int insertSelective(ExpenseClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..expense_class
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    List<ExpenseClass> selectByExample(ExpenseClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..expense_class
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    @Select({
        "select",
        "expense_class_id, expense_code, expense_name, valid",
        "from hospital..expense_class",
        "where expense_class_id = #{expenseClassId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    ExpenseClass selectByPrimaryKey(Integer expenseClassId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..expense_class
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    int updateByExampleSelective(@Param("record") ExpenseClass record, @Param("example") ExpenseClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..expense_class
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    int updateByExample(@Param("record") ExpenseClass record, @Param("example") ExpenseClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..expense_class
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    int updateByPrimaryKeySelective(ExpenseClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hospital..expense_class
     *
     * @mbggenerated Tue Jun 04 18:07:53 CST 2019
     */
    @Update({
        "update hospital..expense_class",
        "set expense_code = #{expenseCode,jdbcType=VARCHAR},",
          "expense_name = #{expenseName,jdbcType=VARCHAR},",
          "valid = #{valid,jdbcType=INTEGER}",
        "where expense_class_id = #{expenseClassId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ExpenseClass record);
}