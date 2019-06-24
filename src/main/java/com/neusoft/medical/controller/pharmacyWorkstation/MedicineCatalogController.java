package com.neusoft.medical.controller.pharmacyWorkstation;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.pharmacyWorkstation.MedicineCatalogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 药品目录管理
 */
@RestController
@RequestMapping("/medicine_catalog")
public class MedicineCatalogController {
    @Resource
    private MedicineCatalogService medicineCatalogService;

    /**
     * 分页获取药品信息
     *
     * @param currentPage 当期页码
     * @param pageSize    页面大小
     * @return 药品信息
     */
    @GetMapping("/select")
    public ResultDTO<PageInfo<String>> selectMedicine(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        PageInfo<String> res = null;
        try {
            res = medicineCatalogService.selectMedicine(currentPage, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(res);
    }

    /**
     * 保存药品信息
     *
     * @param medicineJson 药品信息 json 字符串
     * @return 操作结果
     * medicineJson 字符串中包含的属性：
     * - medicineId            药品编号（新增时不填，更新时必填）
     * - medicineCode          药品代码
     * - nameZh                中文名称
     * - medicineSpecification 规格
     * - medicineUnit          包装单位
     * - medicineManufacturer  制造商
     * - medicineDosageId      剂型编号
     * - medicineTypeId        类型编号
     * - medicinePrice         单价
     * - namePinyin            药品名称拼音
     * - nums                  库存数目
     * - nameEn                英文名称
     */
    @PostMapping("/save")
    public ResultDTO<Boolean> saveMedicine(
            @RequestParam(value = "medicineJson") String medicineJson
    ) {
        boolean res;
        try {
            res = medicineCatalogService.saveMedicine(medicineJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

    /**
     * 删除药品信息
     *
     * @param medicineIdList 药品编号列表
     * @return 操作结果
     */
    @DeleteMapping("/delete")
    public ResultDTO<Boolean> deleteMedicine(
            @RequestParam(value = "medicineIdList[]") Integer[] medicineIdList
    ) {
        boolean res;
        try {
            res = medicineCatalogService.deleteMedicine(Arrays.asList(medicineIdList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }
}
