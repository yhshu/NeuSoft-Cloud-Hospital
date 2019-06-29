package com.neusoft.medical.service.doctorWorkstation;

import com.neusoft.medical.bean.Medicine;
import com.neusoft.medical.bean.Prescription;

import java.util.List;

/**
 * 成药处方、草药处方 服务
 */
public interface PrescriptionService {

    /**
     * 获取所有药品列表
     * 药品数量较多，可能增加网络和浏览器的负担
     *
     * @return 包含所有药品信息的列表
     */
    List<Medicine> selectMedicine();

    /**
     * 通过中文名称或拼音搜索药品信息
     *
     * @param resultNumber 最大结果数量
     * @param query        搜索关键词
     * @return 中文名称或拼音符合关键词的药品信息列表
     */
    List<Medicine> searchMedicine(Integer resultNumber, String query);

    /**
     * 获取常用药品列表
     *
     * @param medicineNumber 获取的常用药品数量
     * @return 常用药品列表
     */
    List<Medicine> commonMedicine(Integer medicineNumber);

    /**
     * 保存处方（三种保存状态：暂存、提交、存为模板）
     *
     * @param prescriptionJson 表示处方信息的 json 字符串
     */
    boolean savePrescription(String prescriptionJson);

    /**
     * 获取历史处方（暂存 或 正式提交）
     *
     * @param registrationId 挂号编号
     * @return 历史处方列表，json 字符串列表
     */
    String selectHistoryPrescription(Integer registrationId);

    /**
     * 查询处方模板
     *
     * @param prescriptionScope 查询的处方模板的范围（所有 0；医生本人 1；医生所在科室 2）
     * @param doctorId          医生编号
     * @return 处方模板列表
     */
    String selectPrescriptionTemplate(Integer prescriptionScope, Integer doctorId);

    /**
     * 由处方列表获取处方信息 json 字符串
     * 字符串中除处方基本信息外，还包含处方药品列表的信息
     *
     * @param prescriptionList 处方列表
     * @return 包含处方药品信息的处方信息，json 字符串
     */
    String prescriptionListToJson(List<Prescription> prescriptionList);

    /**
     * 删除处方记录
     *
     * @param prescriptionIdList 处方编号列表
     * @return 操作结果
     */
    boolean deletePrescription(List<Integer> prescriptionIdList);

    /**
     * 按医生获取处方列表
     *
     * @param doctorId 医生编号
     * @return 医生的处方列表
     */
    List<Prescription> selectPrescriptionList(Integer doctorId);

}
