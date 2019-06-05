package com.neusoft.medical.controller;

import com.neusoft.medical.service.DiagnosticCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

/**
 * 诊断目录控制器
 */
@Controller
@RequestMapping("/diagnostic_catalog")
public class DiagnosticCatalogController {
    private Logger log = Logger.getLogger(DiagnosticCatalogController.class);

    private DiagnosticCatalogService diagnosticCatalogService;

    @RequestMapping(value = "/list_disease_category", consumes = "application/json")
    public String findAllDiseaseCategory() {
    }

    @RequestMapping(value = "/list_disease", consumes = "application/json")
    public String selectDiseaseByPage() {

    }

}
