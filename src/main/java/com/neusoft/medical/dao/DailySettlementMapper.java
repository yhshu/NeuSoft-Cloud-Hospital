package com.neusoft.medical.dao;

import com.neusoft.medical.bean.DailySettlement;
import com.neusoft.medical.bean.DailySettlementExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DailySettlementMapper {
    long countByExample(DailySettlementExample example);

    int deleteByExample(DailySettlementExample example);

    @Delete({
        "delete from hospital.daily_settlement",
        "where daily_settlement_id = #{dailySettlementId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer dailySettlementId);

    @Insert({
        "insert into hospital.daily_settlement (collector_account_id, collector_real_name, ",
        "daily_settlement_date)",
        "values (#{collectorAccountId,jdbcType=INTEGER}, #{collectorRealName,jdbcType=VARCHAR}, ",
        "#{dailySettlementDate,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="dailySettlementId", before=false, resultType=Integer.class)
    int insert(DailySettlement record);

    int insertSelective(DailySettlement record);

    List<DailySettlement> selectByExample(DailySettlementExample example);

    @Select({
        "select",
        "daily_settlement_id, collector_account_id, collector_real_name, daily_settlement_date",
        "from hospital.daily_settlement",
        "where daily_settlement_id = #{dailySettlementId,jdbcType=INTEGER}"
    })
    @ResultMap("com.neusoft.medical.dao.DailySettlementMapper.BaseResultMap")
    DailySettlement selectByPrimaryKey(Integer dailySettlementId);

    int updateByExampleSelective(@Param("record") DailySettlement record, @Param("example") DailySettlementExample example);

    int updateByExample(@Param("record") DailySettlement record, @Param("example") DailySettlementExample example);

    int updateByPrimaryKeySelective(DailySettlement record);

    @Update({
        "update hospital.daily_settlement",
        "set collector_account_id = #{collectorAccountId,jdbcType=INTEGER},",
          "collector_real_name = #{collectorRealName,jdbcType=VARCHAR},",
          "daily_settlement_date = #{dailySettlementDate,jdbcType=TIMESTAMP}",
        "where daily_settlement_id = #{dailySettlementId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DailySettlement record);
}