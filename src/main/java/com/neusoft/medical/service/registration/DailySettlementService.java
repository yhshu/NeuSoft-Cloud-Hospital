package com.neusoft.medical.service.registration;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.DailySettlement;

import java.util.Date;

public interface DailySettlementService {

    PageInfo<DailySettlement> selectAllDailySettlementList(Integer currentPage, Integer pageSize);


    PageInfo<DailySettlement> selectDailySettlementList(Date startDatetimeConverted, Date endDatetimeConverted, Integer collectorId, Integer currentPage, Integer pageSize);

    PageInfo<String> selectDailySettlementDetail(Integer dailySettlementId, Integer currentPage, Integer pageSize);

    String dailySettlementDocument(Integer dailySettlementId);

    boolean checkDailySettlement(Integer dailySettlementId);

    boolean generateDailySettlement(Integer collectorId, Date endDatetime);
}
