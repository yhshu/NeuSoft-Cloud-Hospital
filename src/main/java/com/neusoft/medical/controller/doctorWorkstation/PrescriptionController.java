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
     * 保存处方（暂存、提交或存为模板）
     *
     * @param prescriptionJson 表示处方信息的 json 字符串
     * @return 操作结果
     * 该 json 字符串包含的属性：
     * - prescriptionId
     * - prescriptionName
     */
    @PostMapping("/save_prescription")
    public ResultDTO<Boolean> savePrescription(
            @RequestParam(value = "prescriptionJson") String prescriptionJson
    ) {
        return null;
    }
}