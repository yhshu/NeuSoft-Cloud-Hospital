package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.dao.SchedulingInfoMapper;
import com.neusoft.medical.dao.SchedulingRuleMapper;
import com.neusoft.medical.service.basicInfo.SchedulingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class SchedulingServiceImpl implements SchedulingService {
    @Resource
    private SchedulingInfoMapper schedulingInfoMapper;
    @Resource
    private SchedulingRuleMapper schedulingRuleMapper;
    @Resource
    private DoctorMapper doctorMapper;

    @Override
    public List<Doctor> findCurrentAvailableDoctor(int departmentId) {
        // 符合条件的医生需要满足
        // 1. 有效的排班计划
        // 2. 排班计划在今天
        // 3. 符合指定的科室
        // 4. 今天有剩余的挂号限额
        SchedulingInfoExample schedulingInfoExample = new SchedulingInfoExample();
        SchedulingInfoExample.Criteria schedulingInfoExampleCriteria = schedulingInfoExample.createCriteria();
        schedulingInfoExampleCriteria.andValidEqualTo(1);              // 有效的排班计划
        schedulingInfoExampleCriteria.andDepartmentIdEqualTo(departmentId); // 指定的科室

        Date todayDate = new Date();                                        // 今天日期
        schedulingInfoExampleCriteria.andSchedulingTimeBetween(
                new Date(todayDate.getTime() - 86400000),
                new Date(todayDate.getTime() + 86400000));                // 排班在今天
        schedulingInfoExampleCriteria.andRemainNumsGreaterThan(0);     // 剩余限额大于 0
        System.out.println("查询科室 #" + departmentId + " 当前可用医生");
        System.out.println("日期：" + todayDate);
        List<SchedulingInfo> schedulingInfoList = schedulingInfoMapper.selectByExample(schedulingInfoExample);

        // 获得可用医生的编号后，获取医生信息的列表
        // 首先构建可用医生的编号列表
        List<Integer> doctorIdList = new CopyOnWriteArrayList<>();
        for (SchedulingInfo schedulingInfo : schedulingInfoList) {
            doctorIdList.add(schedulingInfo.getDoctorId());
        }
        // 然后获取医生信息列表
        if (doctorIdList.isEmpty())  // 可用的医生为空，直接返回空列表
            return new CopyOnWriteArrayList<>();
        DoctorExample doctorExample = new DoctorExample();
        DoctorExample.Criteria doctorExampleCriteria = doctorExample.createCriteria();
        doctorExampleCriteria.andValidEqualTo(1);            // 有效的医生信息
        doctorExampleCriteria.andDoctorSchedulingEqualTo(1); // 参与排班的医生
        doctorExampleCriteria.andDoctorIdIn(doctorIdList);
        return doctorMapper.selectByExample(doctorExample);
    }

    @Override
    public PageInfo<SchedulingRule> selectSchedulingRule(Integer currentPage, Integer pageSize) {
        List<SchedulingRule> schedulingRuleList = null;
        try {
            PageHelper.startPage(currentPage, pageSize);

            SchedulingRuleExample schedulingRuleExample = new SchedulingRuleExample();
            schedulingRuleExample.or().andValidEqualTo(1);
            schedulingRuleList = schedulingRuleMapper.selectByExample(schedulingRuleExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert schedulingRuleList != null;
        return new PageInfo<>(schedulingRuleList);
    }

    @Override
    public PageInfo<SchedulingInfo> selectSchedulingInfo(Integer currentPage, Integer pageSize) {
        // todo
        return null;
    }

    @Override
    public boolean saveSchedulingRule(Integer schedulingRuleId, Integer weekday, Integer departmentId, Integer doctorId, Integer registrationCategoryId, Integer noon, Integer limitation, Integer accountId) {
        try {
            SchedulingRule schedulingRuleRecord = new SchedulingRule(null, weekday, departmentId, doctorId, registrationCategoryId, noon, limitation, accountId, new Date(), 1);
            if (schedulingRuleId != null) {
                // 新增排班规则
                schedulingRuleMapper.insert(schedulingRuleRecord);
            } else {
                // 更新排班规则
                schedulingRuleRecord.setSchedulingRuleId(schedulingRuleId);
                schedulingRuleMapper.updateByPrimaryKey(schedulingRuleRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean generateSchedulingInfo(Date startDate, Date endDate) {
        // todo
        return false;
    }

    @Override
    public boolean saveSchedulingInfo(Integer schedulingInfoId, Date schedulingTime, Integer departmentId, Integer doctorId, Integer registrationCategoryId, Integer valid, Integer noon, Integer limitation, Integer remainNums) {
        // todo
        return false;
    }

    @Override
    public boolean deleteSchedulingRule(List<Integer> schedulingRuleIdList) {
        // todo
        return false;
    }

    @Override
    public boolean deleteSchedulingInfo(List<Integer> schedulingInfoIdList) {
        // todo
        return false;
    }
}
