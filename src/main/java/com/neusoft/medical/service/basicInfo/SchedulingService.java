package com.neusoft.medical.service.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Doctor;

import java.util.Date;
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

    PageInfo<String> selectSchedulingRule(Integer currentPage, Integer pageSize);

    PageInfo<String> selectSchedulingInfo(Integer currentPage, Integer pageSize);

    boolean saveSchedulingRule(Integer schedulingRuleId, Integer weekday, Integer departmentId, Integer doctorId, Integer registrationCategoryId, Integer noon, Integer limitation, Integer accountId);

    boolean generateSchedulingInfo(Date startDate, Date endDate);

    boolean saveSchedulingInfo(Integer schedulingInfoId, Date schedulingTime, Integer departmentId, Integer doctorId, Integer registrationCategoryId, Integer valid, Integer noon, Integer limitation, Integer remainNums);

    boolean deleteSchedulingRule(List<Integer> schedulingRuleIdList);

    boolean deleteSchedulingInfo(List<Integer> schedulingInfoIdList);
}
