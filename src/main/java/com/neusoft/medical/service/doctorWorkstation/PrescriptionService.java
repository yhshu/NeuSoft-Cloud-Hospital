package com.neusoft.medical.service.doctorWorkstation;

import com.neusoft.medical.bean.Medicine;

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
    void savePrescription(String prescriptionJson);
}
