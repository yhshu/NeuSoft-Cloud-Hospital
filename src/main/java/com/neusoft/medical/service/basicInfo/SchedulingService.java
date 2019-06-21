package com.neusoft.medical.service.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.bean.SchedulingInfo;

import java.util.List;

/**
 * 排班规则维护与排版信息
 */
public interface SchedulingService {

    /**
     * 找到指定科室的当前被排班的医生列表
     *
     * @param departmentId 科室编号
     * @return 可用医生列表
     */
    List<Doctor> findCurrentAvailableDoctor(int departmentId);

    PageInfo<SchedulingInfo> selectSchedulingRule(Integer currentPage, Integer pageSize);

    boolean saveSchedulingRule(Integer schedulingRuleId, Integer weekday, Integer departmentId, Integer doctorId, Integer registrationCategoryId, Integer noon, Integer limitation, Integer accountId);

    boolean generateSchedulingInfo(String startDate, String endDate);

    boolean saveSchedulingInfo(Integer schedulingInfoId, String schedulingTime, Integer departmentId, Integer doctorId, Integer registrationCategoryId, Integer valid, Integer noon, Integer limitation, Integer remainNums);
}
