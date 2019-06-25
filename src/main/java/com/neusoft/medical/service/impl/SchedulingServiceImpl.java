package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.*;
import com.neusoft.medical.service.basicInfo.AccountService;
import com.neusoft.medical.service.basicInfo.SchedulingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
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
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private RegistrationMapper registrationMapper;
    @Resource
    private RegistrationCategoryMapper registrationCategoryMapper;
    @Resource
    private AccountService accountService;

    private Gson gson = new Gson();

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
        Date d1 = new Date(todayDate.getTime() / 86400000 * 86400000);
        Date d2 = new Date((todayDate.getTime() / 86400000 + 1) * 86400000 - 1);
        schedulingInfoExampleCriteria.andSchedulingTimeBetween(d1, d2);     // 排班在今天
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
    public PageInfo<String> selectSchedulingRule(Integer currentPage, Integer pageSize) {
        List<String> res = new CopyOnWriteArrayList<>();
        try {
            PageHelper.startPage(currentPage, pageSize);

            SchedulingRuleExample schedulingRuleExample = new SchedulingRuleExample();
            List<SchedulingRule> schedulingRuleList = schedulingRuleMapper.selectByExample(schedulingRuleExample);

            JsonArray schedulingRuleListJsonArray = gson.toJsonTree(schedulingRuleList).getAsJsonArray();
            for (JsonElement schedulingRuleJsonElement : schedulingRuleListJsonArray) {
                JsonObject schedulingRuleJsonObject = schedulingRuleJsonElement.getAsJsonObject();
                Integer departmentId = schedulingRuleJsonObject.get("departmentId").getAsInt();
                Integer doctorId = schedulingRuleJsonObject.get("doctorId").getAsInt();
                Integer operationAccountId = schedulingRuleJsonObject.get("operationAccountId").getAsInt();
                Integer registrationCategoryId = schedulingRuleJsonObject.get("registrationCategoryId").getAsInt();

                schedulingRuleJsonObject.addProperty("departmentName", departmentMapper.selectByPrimaryKey(departmentId).getDepartmentName());
                schedulingRuleJsonObject.addProperty("doctorName", doctorMapper.selectByPrimaryKey(doctorId).getDoctorName());
                schedulingRuleJsonObject.addProperty("registrationCategoryName", registrationCategoryMapper.selectByPrimaryKey(registrationCategoryId).getRegistrationCategoryName());
                schedulingRuleJsonObject.addProperty("operationAccountName", accountService.selectStaffByAccountId(operationAccountId).getRealName());
                res.add(schedulingRuleJsonObject.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PageInfo<>(res);
    }

    @Override
    public PageInfo<SchedulingInfo> selectSchedulingInfo(Integer currentPage, Integer pageSize) {
        List<SchedulingInfo> schedulingInfoList = null;
        try {
            PageHelper.startPage(currentPage, pageSize);

            SchedulingInfoExample schedulingInfoExample = new SchedulingInfoExample();
            schedulingInfoList = schedulingInfoMapper.selectByExample(schedulingInfoExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert schedulingInfoList != null;
        return new PageInfo<>(schedulingInfoList);
    }

    @Override
    public boolean saveSchedulingRule(Integer schedulingRuleId, Integer weekday, Integer departmentId, Integer doctorId, Integer registrationCategoryId, Integer noon, Integer limitation, Integer accountId) {
        try {
            SchedulingRule schedulingRuleRecord = new SchedulingRule(null, weekday, departmentId, doctorId, registrationCategoryId, noon, limitation, accountId, new Date(), 1);
            if (schedulingRuleId != null) {
                // 更新排班规则
                schedulingRuleRecord.setSchedulingRuleId(schedulingRuleId);
                schedulingRuleMapper.updateByPrimaryKeySelective(schedulingRuleRecord);
            } else {
                // 新增排班规则
                schedulingRuleMapper.insert(schedulingRuleRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean generateSchedulingInfo(Date startDate, Date endDate) {
        try {
            // 找到指定的起止时间之间且不早于当前时间的时间段中的所有排班规则
            SchedulingRuleExample schedulingRuleExample = new SchedulingRuleExample();
            schedulingRuleExample.or().andValidEqualTo(1);

            List<SchedulingRule> schedulingRuleList = schedulingRuleMapper.selectByExample(schedulingRuleExample);
            Date today = new Date();
            // 针对每项排班规则，生成对应的排班计划
            for (SchedulingRule schedulingRule : schedulingRuleList) {
                // 在当前日期与开始日期两者中取较晚的日期，该日期与结束日期之间的时间段为有效的排班时间段
                if (today.after(startDate)) startDate = today;
                if (startDate.after(endDate)) continue;

                Calendar calendar = Calendar.getInstance();
                calendar.setFirstDayOfWeek(Calendar.SUNDAY);

                Date curDate = new Date(startDate.getTime());
                while (curDate.before(endDate)) {
                    calendar.setTime(curDate);
                    curDate.setTime(curDate.getTime() + 86400000);
                    int curWeekday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
                    if (schedulingRule.getWeekday() == curWeekday) {  // 星期符合，排班
                        SchedulingInfo schedulingInfoRecord = new SchedulingInfo(null, curDate, schedulingRule.getSchedulingRuleId(), schedulingRule.getDepartmentId(), schedulingRule.getDoctorId(), schedulingRule.getRegistrationCategoryId(), schedulingRule.getNoon(), schedulingRule.getValid(), schedulingRule.getLimitation(), schedulingRule.getLimitation());
                        schedulingInfoMapper.insert(schedulingInfoRecord);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean saveSchedulingInfo(Integer schedulingInfoId, Date schedulingTime, Integer departmentId, Integer doctorId, Integer registrationCategoryId, Integer valid, Integer noon, Integer limitation, Integer remainNums) {
        try {
            SchedulingInfo schedulingInfoRecord = new SchedulingInfo(null, schedulingTime, null, departmentId, doctorId, registrationCategoryId, noon, valid, limitation, remainNums);
            if (schedulingInfoId == null) {
                // 新增排班计划
                schedulingInfoMapper.insert(schedulingInfoRecord);
            } else {
                // 更新排班计划
                schedulingInfoRecord.setSchedulingInfoId(schedulingInfoId);
                schedulingInfoMapper.updateByPrimaryKeySelective(schedulingInfoRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteSchedulingRule(List<Integer> schedulingRuleIdList) {
        try {
            SchedulingRuleExample schedulingRuleExample = new SchedulingRuleExample();
            schedulingRuleExample.or().andValidEqualTo(1).andSchedulingRuleIdIn(schedulingRuleIdList);

            SchedulingInfo schedulingInfoRecord = new SchedulingInfo();
            schedulingInfoRecord.setValid(0);
            SchedulingRule schedulingRuleRecord = new SchedulingRule();
            schedulingRuleRecord.setValid(0);

            SchedulingInfoExample schedulingInfoExample = new SchedulingInfoExample();
            schedulingInfoExample.or().andValidEqualTo(1).andSchedulingRuleIdIn(schedulingRuleIdList);

            schedulingInfoMapper.updateByExampleSelective(schedulingInfoRecord, schedulingInfoExample);
            schedulingRuleMapper.updateByExampleSelective(schedulingRuleRecord, schedulingRuleExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteSchedulingInfo(List<Integer> schedulingInfoIdList) {
        try {
            SchedulingInfoExample schedulingInfoExample = new SchedulingInfoExample();
            schedulingInfoExample.or().andValidEqualTo(1).andSchedulingInfoIdIn(schedulingInfoIdList);

            SchedulingInfo schedulingInfoRecord = new SchedulingInfo();
            schedulingInfoRecord.setValid(0);
            schedulingInfoMapper.updateByExampleSelective(schedulingInfoRecord, schedulingInfoExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
