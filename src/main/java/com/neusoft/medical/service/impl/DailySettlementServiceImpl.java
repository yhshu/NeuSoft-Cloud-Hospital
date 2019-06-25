package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.DailySettlement;
import com.neusoft.medical.service.registration.DailySettlementService;
import org.springframework.stereotype.Service;

@Service
public class DailySettlementServiceImpl implements DailySettlementService {

    @Override
    public PageInfo<DailySettlement> selectAllDailySettlementList(Integer currentPage, Integer pageSize) {
        // todo
        return null;
    }
}
