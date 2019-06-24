package com.neusoft.medical.service.registration;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.DailySettlement;

public interface DailySettlementService {

    PageInfo<DailySettlement> selectAllDailySettlementList(Integer currentPage, Integer pageSize);
}
