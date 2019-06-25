package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.DailySettlement;
import com.neusoft.medical.bean.DailySettlementExample;
import com.neusoft.medical.dao.DailySettlementMapper;
import com.neusoft.medical.service.registration.DailySettlementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DailySettlementServiceImpl implements DailySettlementService {
    @Resource
    private DailySettlementMapper dailySettlementMapper;

    @Override
    public PageInfo<DailySettlement> selectAllDailySettlementList(Integer currentPage, Integer pageSize) {
        List<DailySettlement> dailySettlementList = null;
        try {
            PageHelper.startPage(currentPage, pageSize);

            DailySettlementExample dailySettlementExample = new DailySettlementExample();
            dailySettlementExample.or().andValidEqualTo(1);

            dailySettlementList = dailySettlementMapper.selectByExample(dailySettlementExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PageInfo<>(dailySettlementList);
    }

    @Override
    public PageInfo<DailySettlement> selectDailySettlementList(Date startDatetimeConverted, Date endDatetimeConverted, Integer collectorId, Integer currentPage, Integer pageSize) {
        // todo
        return null;
    }
}
