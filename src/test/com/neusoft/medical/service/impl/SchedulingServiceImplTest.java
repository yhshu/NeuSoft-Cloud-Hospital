package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.SchedulingInfo;
import com.neusoft.medical.bean.SchedulingRule;
import com.neusoft.medical.dao.SchedulingInfoMapper;
import com.neusoft.medical.dao.SchedulingRuleMapper;
import com.neusoft.medical.service.basicInfo.SchedulingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchedulingServiceImplTest {

    @Resource
    SchedulingService schedulingService;
    @Resource
    SchedulingInfoMapper schedulingInfoMapper;
    @Resource
    SchedulingRuleMapper schedulingRuleMapper;

    @Test
    public void findCurrentAvailableDoctor() {
        schedulingService.findCurrentAvailableDoctor(1);
    }

    @Test
    public void selectSchedulingRule() {
        schedulingService.selectSchedulingRule(1,20);
    }

    @Test
    public void selectSchedulingInfo() {
        schedulingService.selectSchedulingInfo(1,20);
    }

    @Test
    public void saveSchedulingRule() {
        schedulingService.saveSchedulingRule(1,5,1,1,5,1,1,1);
    }

    @Test
    public void generateSchedulingInfo() {
        Date today = new Date();
        Date starDate = new Date(today.getTime() - 1000 * 60 * 60 * 24 * 24);
        schedulingService.generateSchedulingInfo(starDate,today);
    }

    @Test
    public void saveSchedulingInfo() {
        schedulingService.saveSchedulingRule(1,5,1,1,5,1,1,1);
    }

    @Test
    public void deleteSchedulingRule() {
        Date today = new Date();
        Date date = new Date(today.getTime()- 1000 * 60 * 60 * 24 * 10);
        SchedulingRule schedulingRule = new SchedulingRule(1,1,1,1,1,1,1,1,date,1);
        schedulingRuleMapper.insert(schedulingRule);
        List<Integer> schedulingRuleList = new ArrayList<>();
        schedulingRuleList.add(schedulingRule.getSchedulingRuleId());
        schedulingService.deleteSchedulingRule(schedulingRuleList);
    }

    @Test
    public void deleteSchedulingInfo() {
        Date today = new Date();
        Date date = new Date(today.getTime()- 1000 * 60 * 60 * 24 * 10);
        SchedulingInfo schedulingInfo = new SchedulingInfo(1,date,1,1,1,1,1,1,1,1);
        List<Integer> schedulingInfoList = new ArrayList<>();
        schedulingInfoMapper.insert(schedulingInfo);
        schedulingInfoList.add(schedulingInfo.getSchedulingInfoId());
        schedulingService.deleteSchedulingInfo(schedulingInfoList);
    }
}