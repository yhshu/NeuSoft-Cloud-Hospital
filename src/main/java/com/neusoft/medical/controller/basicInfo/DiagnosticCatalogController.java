package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Disease;
import com.neusoft.medical.bean.DiseaseCategory;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.DiagnosticCatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

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
    public ResultDTO<List<DiseaseCategory>> findAllDiseaseCategory() {
        System.out.println("findAllDiseaseCategory: " + "查询疾病分类目录");
        List<DiseaseCategory> diseaseCategoryList = diagnosticCatalogService.findAllDiseaseCategory();
        return new ResultDTO<>(diseaseCategoryList);
    }

    /**
     * 请求指定页的疾病信息
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小spring
     * @return 指定大小和页码的疾病信息
     */
    @GetMapping(value = "/list_disease")
    public ResultDTO<PageInfo<Disease>> selectDiseaseByPage(@RequestParam(value = "current_page") int currentPage, @RequestParam(value = "page_size") int pageSize, @RequestParam(value = "disease_category") int diseaseCategoryId) {
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
     * @return
     */
    public ResultDTO<Disease> addDisease(@RequestParam(value = "diseaseIcd") String diseaseIcd, @RequestParam(value = "diseaseName") String diseaseName, @RequestParam(value = "dis400easeCode") String diseaseCode, @RequestParam(value = "diseaseCategory") String diseaseCategory) {
        return null;
    }
}
