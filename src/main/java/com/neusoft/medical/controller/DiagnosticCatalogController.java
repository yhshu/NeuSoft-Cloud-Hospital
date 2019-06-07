package com.neusoft.medical.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Disease;
import com.neusoft.medical.service.DiagnosticCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

/**
 * 诊断目录控制器
 */
@RestController
@RequestMapping("/diagnostic_catalog")
public class DiagnosticCatalogController {
    private Logger log = Logger.getLogger(String.valueOf(DiagnosticCatalogController.class));

    @Autowired
    private DiagnosticCatalogService diagnosticCatalogService;

    @RequestMapping(value = "/list_disease_category", method = RequestMethod.POST)
    public Map findAllDiseaseCategory() {
        // todo
        return null;
    }

    /**
     * 请求指定页的疾病信息
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @return 指定大小和页码的疾病信息
     */
    @RequestMapping(value = "/list_disease", method = RequestMethod.GET)
    public PageInfo<Disease> selectDiseaseByPage(@RequestParam(value = "current_page") int currentPage, @RequestParam(value = "page_size") int pageSize) {
        System.out.println("DiagnosticCatalogController: " + "分页查询疾病信息");

        PageInfo<Disease> diseasePageInfo = diagnosticCatalogService.selectDiseaseByPage(currentPage, pageSize);

        return diseasePageInfo;
    }

}
