package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.Util.converter.StringToDateConverter;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.basicInfo.SchedulingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;

/**
 * 医生排班管理 控制器
 * 包括排班规则制定和排班计划生成
 */
@RestController
@RequestMapping("/scheduling")
public class SchedulingController {
    @Resource
    private SchedulingService schedulingService;

    private StringToDateConverter stringToDateConverter = new StringToDateConverter();

    /**
     * 分页获取排班计划
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @return 分页的排班计划
     */
    @GetMapping("/select_rule")
    public ResultDTO<PageInfo<String>> selectSchedulingRule(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        PageInfo<String> schedulingRulePageInfo = null;
        try {
            schedulingRulePageInfo = schedulingService.selectSchedulingRule(currentPage, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(schedulingRulePageInfo);
    }

    /**
     * 添加排班计划
     *
     * @param schedulingRuleId       排班计划编号；新增时不填，修改时必填
     * @param weekday                排班星期：星期日 0，星期六 6
     * @param departmentId           排班医生所在科室的编号
     * @param doctorId               排班医生的编号
     * @param registrationCategoryId 挂号类别，详见 registration_category 表
     * @param noon                   午别：全天 0；上午 1；下午 2
     * @param limitation             排班限额
     * @param accountId              操作员的帐号
     * @return 操作结果
     */
    @GetMapping("/save_rule")
    public ResultDTO<Boolean> saveSchedulingRule(
            @RequestParam(value = "schedulingRuleId", required = false) Integer schedulingRuleId,
            @RequestParam(value = "weekday") Integer weekday,
            @RequestParam(value = "departmentId") Integer departmentId,
            @RequestParam(value = "doctorId") Integer doctorId,
            @RequestParam(value = "registrationCategoryId") Integer registrationCategoryId,
            @RequestParam(value = "noon") Integer noon,
            @RequestParam(value = "limitation") Integer limitation,
            @RequestParam(value = "accountId") Integer accountId
    ) {
        boolean res;
        try {
            res = schedulingService.saveSchedulingRule(schedulingRuleId, weekday, departmentId, doctorId, registrationCategoryId, noon, limitation, accountId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

    /**
     * 删除排班规则
     * 这将导致由该规则生成的排班计划无效，无效的排班计划仍将显示在排班计划列表中
     *
     * @param schedulingRuleIdList 排班规则编号列表
     * @return 操作结果
     */
    @DeleteMapping("/delete_rule")
    public ResultDTO<Boolean> deleteSchedulingRule(
            @RequestParam(value = "schedulingRuleIdList[]") Integer[] schedulingRuleIdList
    ) {
        boolean res;
        try {
            res = schedulingService.deleteSchedulingRule(Arrays.asList(schedulingRuleIdList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }


    /**
     * 生成排班计划
     * 只能生成未来的排班计划，生成的排班计划可以修改
     * 排班计划可以重复生成，在指定的时间段内替换之前生成的排班计划
     * 历史排班计划不能被修改，或替换
     * 日期格式 yyyy-MM-dd
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 操作结果
     */
    @GetMapping("/generate_info")
    public ResultDTO<Boolean> generateSchedulingInfo(
            @RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "endDate") String endDate
    ) {
        boolean res;
        try {
            Date startDateConverted = stringToDateConverter.convert(startDate);
            Date endDateConverted = stringToDateConverter.convert(endDate);
            res = schedulingService.generateSchedulingInfo(startDateConverted, endDateConverted);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

    @GetMapping("/select_info")
    public ResultDTO<PageInfo<String>> selectSchedulingInfo(
            @RequestParam("currentPage") Integer currentPage,
            @RequestParam("pageSize") Integer pageSize
    ) {
        PageInfo<String> schedulingInfoPageInfo = null;
        try {
            schedulingInfoPageInfo = schedulingService.selectSchedulingInfo(currentPage, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(schedulingInfoPageInfo);
    }

    /**
     * 保存排班计划
     * 历史排班计划不能修改，只能新增或修改未来的排班计划
     *
     * @param schedulingInfoId       排班计划编号，新增时不填，更新时必填
     * @param schedulingTime         排班时间，不得早于当前日期
     * @param departmentId           科室编号
     * @param doctorId               医生编号
     * @param registrationCategoryId 挂号类别编号
     * @param valid                  排班计划有效位
     * @param noon                   午别：全天 0；上午 1；下午 2
     * @param limitation             排班限额
     * @param remainNums             剩余号数
     * @return 操作结果
     */
    @PutMapping("/update_info")
    public ResultDTO<Boolean> saveSchedulingInfo(
            @RequestParam(value = "schedulingInfoId", required = false) Integer schedulingInfoId,
            @RequestParam(value = "schedulingTime") String schedulingTime,
            @RequestParam(value = "departmentId") Integer departmentId,
            @RequestParam(value = "doctorId") Integer doctorId,
            @RequestParam(value = "registrationCategoryId") Integer registrationCategoryId,
            @RequestParam(value = "valid") Integer valid,
            @RequestParam(value = "noon") Integer noon,
            @RequestParam(value = "limitation") Integer limitation,
            @RequestParam(value = "remainNums") Integer remainNums
    ) {
        boolean res;
        try {
            Date schedulingTimeConverted = stringToDateConverter.convert(schedulingTime);
            res = schedulingService.saveSchedulingInfo(schedulingInfoId, schedulingTimeConverted, departmentId, doctorId, registrationCategoryId, valid, noon, limitation, remainNums);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

    @DeleteMapping("/delete_info")
    public ResultDTO<Boolean> deleteSchedulingInfo(
            @RequestParam(value = "schedulingInfoIdList[]") Integer[] schedulingInfoIdList
    ) {
        boolean res;
        try {
            res = schedulingService.deleteSchedulingInfo(Arrays.asList(schedulingInfoIdList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }
}
