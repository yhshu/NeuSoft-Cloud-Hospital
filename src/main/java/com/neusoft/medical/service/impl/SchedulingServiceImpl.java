package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.SchedulingRuleExample;
import com.neusoft.medical.service.SchedulingService;

import java.util.List;

public class SchedulingServiceImpl implements SchedulingService {

    // 符合条件的医生需要满足
    // 1. 有效的排班计划
    // 2. 排班计划在今天
    // 3. 符合指定的科室
    // 4. 今天有剩余的挂号限额
    @Override
    public List<Doctor> findCurrentAvailableDoctor(int departmentId) {
        SchedulingRuleExample schedulingRuleExample = new SchedulingRuleExample();
        SchedulingRuleExample.Criteria criteria = schedulingRuleExample.createCriteria();
        criteria.andValidEqualTo(1);
        criteria.andDepartmentIdEqualTo(departmentId);
        // todo
        return null;
    }
}
