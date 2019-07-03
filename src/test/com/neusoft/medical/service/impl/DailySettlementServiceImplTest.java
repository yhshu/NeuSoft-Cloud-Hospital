package com.neusoft.medical.service.impl;

import com.neusoft.medical.service.registration.DailySettlementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DailySettlementServiceImplTest {

    @Resource
    DailySettlementService dailySettlementService;

    @Test
    public void selectAllDailySettlementList() {
        dailySettlementService.selectAllDailySettlementList(1,20);
    }

    @Test
    public void selectDailySettlementList() {
        Date today = new Date();
        Date startDate = new Date(today.getTime() - 1000 * 60 * 60 * 24 * 30);  // 一个月之前
        dailySettlementService.selectDailySettlementList(startDate,today,1,1,20);
    }

    @Test
    public void selectDailySettlementDetail() {
        dailySettlementService.selectDailySettlementDetail(1,1,20);
    }

    @Test
    public void dailySettlementDocument() {
        dailySettlementService.dailySettlementDocument(1);
    }

    @Test
    public void checkDailySettlement() {
        dailySettlementService.checkDailySettlement(1);
    }

    @Test
    public void generateDailySettlement() {
        Date today = new Date();
        dailySettlementService.generateDailySettlement(1,today);
    }
}