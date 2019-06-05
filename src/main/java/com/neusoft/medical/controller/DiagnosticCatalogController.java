package com.neusoft.medical.controller;

import com.neusoft.medical.service.DiagnosticCatalogService;
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

    @RequestMapping("/list_disease_category")
    public String findAllDiseaseCategory() {
    }

    @RequestMapping("/list_disease")
    public String findAllDisease() {

    }

}
