package com.neusoft.medical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

/**
 * 诊断目录控制器
 */
@Controller
@RequestMapping("DiagnosticCatelog")
public class DiagnosticCatalogController {
    private Logger log = Logger.getLogger(DiagnosticCatalogController.class);
}
