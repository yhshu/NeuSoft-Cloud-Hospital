package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Disease;
import com.neusoft.medical.bean.DiseaseCategory;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.basicInfo.DiagnosticCatalogService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 诊断目录控制器
 */
@RestController
@RequestMapping("/diagnostic_catalog")
public class DiagnosticCatalogController {
    private Logger log = Logger.getLogger(String.valueOf(DiagnosticCatalogController.class));

    @Resource
    private DiagnosticCatalogService diagnosticCatalogService;

    /**
     * 请求所有疾病种类信息
     * 按需求不分页显示
     *
     * @return 所有疾病种类信息
     */
    @GetMapping(value = "/list_disease_category")
    public ResultDTO<List<DiseaseCategory>> findAllDiseaseCategory() throws ExecutionException, InterruptedException {
        System.out.println("findAllDiseaseCategory: " + "查询疾病分类目录");
        List<DiseaseCategory> diseaseCategoryList = diagnosticCatalogService.findAllDiseaseCategory().get();
        return new ResultDTO<>(diseaseCategoryList);
    }

    /**
     * 请求指定页的疾病信息
     *
     * @param currentPage       当前页码
     * @param pageSize          页面大小
     * @param diseaseCategoryId 疾病种类编号
     * @return 指定大小和页码的疾病信息
     */
    @GetMapping(value = "/list_disease")
    public ResultDTO<PageInfo<Disease>> selectDiseaseByPage(
            @RequestParam(value = "currentPage") int currentPage,
            @RequestParam(value = "pageSize") int pageSize,
            @RequestParam(value = "diseaseCategoryId") int diseaseCategoryId) {
        System.out.println("DiagnosticCatalogController: " + "分页查询疾病信息");
        System.out.println("currentPage: " + currentPage + ", pageSize: " + pageSize + " , diseaseCategoryId: " + diseaseCategoryId);

        PageInfo<Disease> diseasePageInfo = diagnosticCatalogService.selectDiseaseByPage(currentPage, pageSize, diseaseCategoryId);
        return new ResultDTO<>(diseasePageInfo);
    }

    /**
     * 添加疾病信息
     *
     * @param diseaseIcd      　疾病编码
     * @param diseaseName     　疾病名称
     * @param diseaseCode     　疾病拼音码
     * @param diseaseCategory 　疾病种类
     * @return 新增的疾病信息
     */
    @PostMapping(value = "/add")
    public ResultDTO<Disease> addDisease(
            @RequestParam(value = "diseaseIcd") String diseaseIcd,
            @RequestParam(value = "diseaseName") String diseaseName,
            @RequestParam(value = "diseaseCode") String diseaseCode,
            @RequestParam(value = "diseaseCategory") Integer diseaseCategory) {
        System.out.println("addDisease: " + "新增疾病");
        Disease added = diagnosticCatalogService.addDisease(new Disease(null, diseaseCode, diseaseName, diseaseIcd, diseaseCategory, 1));
        return new ResultDTO<>(added);
    }

    /**
     * 更新疾病信息
     *
     * @param diseaseId       疾病编号
     * @param diseaseIcd      疾病编码
     * @param diseaseName     疾病名称
     * @param diseaseCode     疾病拼音码
     * @param diseaseCategory 疾病种类
     * @return 操作结果
     */
    @PutMapping(value = "/update")
    public ResultDTO<Boolean> updateDisease(
            @RequestParam(value = "diseaseId") Integer diseaseId,
            @RequestParam(value = "diseaseIcd") String diseaseIcd,
            @RequestParam(value = "diseaseName") String diseaseName,
            @RequestParam(value = "diseaseCode") String diseaseCode,
            @RequestParam(value = "diseaseCategory") Integer diseaseCategory
    ) {
        try {
            diagnosticCatalogService.updateDisease(new Disease(diseaseId, diseaseIcd, diseaseName, diseaseCode, diseaseCategory, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(Boolean.TRUE);
    }

    /**
     * 删除疾病信息
     *
     * @param diseaseIdList 疾病编号列表
     * @return 操作结果
     */
    @DeleteMapping(value = "/delete")
    public ResultDTO<Boolean> deleteDisease(
            @RequestParam(value = "diseaseIdList[]") Integer[] diseaseIdList
    ) {
        try {
            System.out.println(Arrays.toString(diseaseIdList));
            diagnosticCatalogService.deleteDisease(Arrays.asList(diseaseIdList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }
}
