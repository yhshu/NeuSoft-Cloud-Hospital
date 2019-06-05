package com.neusoft.medical.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Disease;
import com.neusoft.medical.service.DiagnosticCatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.logging.Logger;

/**
 * 诊断目录控制器
 */
@Controller
@RequestMapping("/diagnostic_catalog")
public class DiagnosticCatalogController {
    private Logger log = Logger.getLogger(String.valueOf(DiagnosticCatalogController.class));

    private DiagnosticCatalogService diagnosticCatalogService;

    @ResponseBody
    @RequestMapping(value = "/list_disease_category", consumes = "application/json", produces = "application/json")
    public Map findAllDiseaseCategory() {
        // todo
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/list_disease", consumes = "application/json", produces = "application/json")
    public PageInfo<Disease> selectDiseaseByPage(@RequestBody Map map) {
        return diagnosticCatalogService.selectDiseaseByPage((int) map.get("currentPage"), (int) map.get("pageSize"));
    }

}
