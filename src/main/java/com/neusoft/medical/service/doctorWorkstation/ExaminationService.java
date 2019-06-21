package com.neusoft.medical.service.doctorWorkstation;

import com.neusoft.medical.bean.ChargeItem;

import java.util.List;

public interface ExaminationService {


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
    boolean addExamination(String examinationJson);

    /**
     * 根据科室编号获取收费项目中的检查项目
     *
     * @param departmentId 科室编号
     * @return 指定科室的收费项目中的检查项目列表
     */
    List<ChargeItem> selectExamListInChargeItemByDepartmentId(Integer departmentId);

    /**
     * 按挂号单编号获取历史检查项目（所有检查状态）
     *
     * @param registrationId 挂号单编号
     * @return 操作结果
     */
    String selectHistoryExam(int registrationId);

    /**
     * 执行检查
     * 更改检查状态，提交检查结果
     * <p>
     * 修改检查的临床印象、检查结果
     * 修改收费项目的尚未交付数量
     *
     * @param examinationJson 检查信息，json 字符串
     * @return 操作结果
     * <p>
     * examinationJson 中的属性包括：
     * - examinationId      检查检验编号
     * - clinicalImpression 临床印象
     * - examResult         检查结果
     * <p>
     * examinationJson 中包含的收费项目列表，属性名为 chargeEntryList
     * - chargeEntryId 收费项目编号
     * - notGivenNums  在执行检查检验后，尚未交付的项目数量
     */
    boolean updateExamResult(String examinationJson);

    boolean deleteUnpaidChargeEntry(List<Integer> chargeEntryIdList);
}
