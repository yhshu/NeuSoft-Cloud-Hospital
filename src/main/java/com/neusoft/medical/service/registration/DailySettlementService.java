package com.neusoft.medical.service.registration;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.DailySettlement;

import java.util.Date;

public interface DailySettlementService {

    PageInfo<DailySettlement> selectAllDailySettlementList(Integer currentPage, Integer pageSize);

    PageInfo<DailySettlement> selectDailySettlementList(Date startDatetimeConverted, Date endDatetimeConverted, Integer collectorId, Integer currentPage, Integer pageSize);
}
