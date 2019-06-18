package com.neusoft.medical.controller.doctorWorkstation;

import com.neusoft.medical.bean.Medicine;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.doctorWorkstation.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 成药处方、草药处方 控制器
 */
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Resource
    private PrescriptionService prescriptionService;

    /**
     * 获取所有药品列表
     * 药品数量较多，可能增加网络和浏览器的负担
     *
     * @return 包含所有药品信息的列表
     */
    @GetMapping("/list_medicine")
    public ResultDTO<List<Medicine>> selectMedicine() {
        List<Medicine> medicineList = null;
        try {
            medicineList = prescriptionService.selectMedicine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(medicineList);
    }

    /**
     * 通过中文名称或拼音搜索药品信息
     *
     * @param resultNumber 最大结果数量
     * @param query        搜索关键词
     * @return
     */
    @GetMapping("/search_medicine")
    public ResultDTO<List<Medicine>> searchMedicine(
            @RequestParam(value = "resultNumber") Integer resultNumber,
            @RequestParam(value = "query") String query
    ) {
        List<Medicine> medicineList = null;
        try {
            medicineList = prescriptionService.searchMedicine(resultNumber, query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(medicineList);
    }

    /**
     * 保存处方（三种保存状态：暂存、提交、存为模板）
     *
     * @param prescriptionJson 表示处方信息的 json 字符串
     * @return 操作结果
     * 该 json 字符串包含的属性：
     * - prescriptionId 处方编号（可空）
     * - prescriptionName 处方名称
     * - registrationId 挂号编号
     * - save_state 保存状态（暂存 0；正式提交 1；模板 2）
     * - medicine 处方中包含的药物清单，json 数组
     * <p>
     * - medicine 数组中每个元素包含的属性：
     * - medicineId 处方药品编号
     * - medicineUsage 药品用途
     * - medicineDosage 药品用量
     * - medicineFrequency 药品使用频率
     * - medicineNumberDay 药品使用天数
     * - medicineQuantity 药品数量
     * - skinTest 皮试
     * - skinTestResult 皮试结果
     */
    @PostMapping("/save_prescription")
    public ResultDTO<Boolean> savePrescription(
            @RequestParam(value = "prescriptionJson") String prescriptionJson
    ) {
        try {
            prescriptionService.savePrescription(prescriptionJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }

    /**
     * 获取常用药品
     *
     * @param medicineNumber 常用药品的数量
     * @return 常用药品信息列表
     */
    @GetMapping("/common_medicine")
    public ResultDTO<List<Medicine>> commonMedicine(@RequestParam(value = "medicineNumber") Integer medicineNumber) {
        List<Medicine> medicineList = null;
        try {
            medicineList = prescriptionService.commonMedicine(medicineNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(medicineList);
    }


}