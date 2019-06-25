package com.neusoft.medical.controller.registration;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.Util.DateTimeConverter;
import com.neusoft.medical.bean.DailySettlement;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.registration.DailySettlementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/daily_settlement")
public class DailySettlementController {
    @Resource
    private DailySettlementService dailySettlementService;
    @Resource
    private DateTimeConverter dateTimeConverter;

    /**
     * 获取所有日结信息列表
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @return 分页的日结信息
     */
    @GetMapping("/select_all_daily_settlement")
    public ResultDTO<PageInfo<DailySettlement>> selectAllDailySettlementList(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        PageInfo<DailySettlement> res = null;
        try {
            res = dailySettlementService.selectAllDailySettlementList(currentPage, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(res);
    }

    /**
     * 获取指定起止时间和收费员的日结记录列表
     * 日期格式 yyyy-MM-dd HH:mm:ss
     *
     * @param startDatetime 统计的开始时间
     * @param endDatetime   统计的结束时间
     * @param collectorId   收费员编号
     * @param currentPage   当前页码
     * @param pageSize      页面大小
     * @return 日结记录列表
     */
    @GetMapping("/select_daily_settlement")
    public ResultDTO<PageInfo<DailySettlement>> selectDailySettlementList(
            @RequestParam(value = "startDatetime", required = false) String startDatetime,
            @RequestParam(value = "endDatetime", required = false) String endDatetime,
            @RequestParam(value = "collectorId") Integer collectorId,
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize) {

        PageInfo<DailySettlement> dailySettlementPageInfo = null;

        try {
            Date startDatetimeConverted = dateTimeConverter.convert(startDatetime);
            Date endDatetimeConverted = dateTimeConverter.convert(endDatetime);
            dailySettlementPageInfo = dailySettlementService.selectDailySettlementList(startDatetimeConverted, endDatetimeConverted, collectorId, currentPage, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(dailySettlementPageInfo);
    }

    /**
     * 生成收费员的日结记录
     *
     * @param collectorId 收费员编号
     * @return 操作结果
     */
    @GetMapping("/generate")
    public ResultDTO<Boolean> generateDailySettlement(
            @RequestParam(value = "collectorId") Integer collectorId
    ) {
        // todo
        return null;
    }

    /**
     * 按日结记录获取日结明细
     *
     * @param dailySettlementId 日结记录编号
     * @param currentPage       当前页码
     * @param pageSize          页面大小
     * @return 分页的日结明细
     */
    @GetMapping("/select_daily_settlement_detail")
    public ResultDTO<PageInfo<String>> selectDailySettlementDetail(
            @RequestParam(value = "daily_settlement_id") Integer dailySettlementId,
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize) {
        try {
            // todo
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取日结单信息
     *
     * @param dailySettlementId 日结记录编号
     * @return 日结单信息，json 字符串
     */
    @GetMapping("daily_settlement_document")
    public ResultDTO<String> dailySettlementDocument(
            @RequestParam(value = "dailySettlementId") Integer dailySettlementId
    ) {
        return null;
    }

    @GetMapping("/check")
    public ResultDTO<Boolean> checkDailySettlement(
            @RequestParam(value = "dailySettlementId") Integer dailySettlementId
    ) {
        return null;
    }

}
