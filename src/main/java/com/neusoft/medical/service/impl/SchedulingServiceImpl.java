package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.DoctorExample;
import com.neusoft.medical.bean.SchedulingInfo;
import com.neusoft.medical.bean.SchedulingInfoExample;
import com.neusoft.medical.dao.DoctorMapper;
import com.neusoft.medical.dao.SchedulingInfoMapper;
import com.neusoft.medical.service.SchedulingService;
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
    private DoctorMapper doctorMapper;

    // 符合条件的医生需要满足
    // 1. 有效的排班计划
    // 2. 排班计划在今天
    // 3. 符合指定的科室
    // 4. 今天有剩余的挂号限额
    @Override
    public List<Doctor> findCurrentAvailableDoctor(int departmentId) {
        SchedulingInfoExample schedulingInfoExample = new SchedulingInfoExample();
        SchedulingInfoExample.Criteria schedulingInfoExampleCriteriateria = schedulingInfoExample.createCriteria();
        schedulingInfoExampleCriteriateria.andValidEqualTo(1);  // 有效的排班计划
        schedulingInfoExampleCriteriateria.andDepartmentIdEqualTo(departmentId); // 指定的科室
        Date today = new Date();  // 今天日期
        schedulingInfoExampleCriteriateria.andSchedulingTimeEqualTo(today); // 排班在今天
        schedulingInfoExampleCriteriateria.andRemainNumsGreaterThan(0); // 剩余限额大于 0
        List<SchedulingInfo> schedulingInfoList = schedulingInfoMapper.selectByExample(schedulingInfoExample);

        // 获得可用医生的编号后，获取医生信息的列表
        // 首先构建可用医生的编号列表
        List<Integer> doctorIdList = new CopyOnWriteArrayList<>();
        for (SchedulingInfo schedulingInfo : schedulingInfoList) {
            doctorIdList.add(schedulingInfo.getDepartmentId());
        }
        // 然后获取医生信息列表
        DoctorExample doctorExample = new DoctorExample();
        DoctorExample.Criteria doctorExampleCriteria = doctorExample.createCriteria();
        doctorExampleCriteria.andValidEqualTo(1);
        doctorExampleCriteria.andDoctorIdIn(doctorIdList);
        return doctorMapper.selectByExample(doctorExample);
    }
}
