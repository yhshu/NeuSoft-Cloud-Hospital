package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.DailySettlement;
import com.neusoft.medical.service.registration.DailySettlementService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DailySettlementServiceImpl implements DailySettlementService {

    @Override
    public PageInfo<DailySettlement> selectAllDailySettlementList(Integer currentPage, Integer pageSize) {
        // todo
        return null;
    }

    @Override
    public PageInfo<DailySettlement> selectDailySettlementList(Date startDatetimeConverted, Date endDatetimeConverted, Integer collectorId, Integer currentPage, Integer pageSize) {
        // todo
        return null;
    }
}
