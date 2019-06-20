package com.neusoft.medical.controller.doctorWorkstation;

import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.doctorWorkstation.ExaminationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExaminationController {
    @Resource
    private ExaminationService examinationService;

    /**
     * 新增检查检验项目
     *
     * @param examinationJson 检查检验项目信息，json 字符串
     * @return 操作结果
     * examinationJson 中包含的属性如下：
     * - registrationId 挂号单编号
     * - saveState 保存状态（暂存 0；正式提交 1；全院模板 2；科室模板 3；医生个人模板 4）
     * - examName 检查名称
     * - clinicalImpression 临床印象
     * - requirement 目的和要求
     * - examResult 检验报告
     * - chargeEntryList 收费项目列表，以 json 数组表示
     * chargeEntryList 数组中的每项元素包含的属性如下：
     * - registrationId 挂号单编号
     * - chargeItemId 收费项目编号
     * - nums 收费项目计数
     * - collectorId 收费员编号
     * - doctorAdvice 医嘱
     */
    @GetMapping("/add")
    public ResultDTO<Boolean> addExamination(
            @RequestParam(value = "examinationJson") String examinationJson
    ) {
        try {
            examinationService.addExamination(examinationJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }

    /**
     * 根据科室编号获取收费项目中的检查项目
     *
     * @param departmentId 科室编号
     * @return 指定科室的收费项目中的检查项目列表
     */
    @GetMapping("/select_exam_list")
    public ResultDTO<List<ChargeItem>> selectExamItemListInChargeItemByDepartmentId(
            @RequestParam(value = "departmentId") Integer departmentId
    ) {
        List<ChargeItem> res = null;
        try {
            res = examinationService.selectExamListInChargeItemByDepartmentId(departmentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(res);
    }

}
