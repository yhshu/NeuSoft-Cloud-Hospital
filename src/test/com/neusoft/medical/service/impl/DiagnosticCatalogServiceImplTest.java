package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.neusoft.medical.service.DiagnosticCatalogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiagnosticCatalogServiceImplTest {
    @Autowired
    DiagnosticCatalogService diagnosticCatalogService;

    @Test
    public void findAllDiseaseCategory() {
        // todo
    }

    @Test
    public void selectDiseaseByPage() {
        int currentPage = 1;
        int pageSize = 20;
        Random random = new Random();
        int diseaseCategoryId = random.nextInt();
        System.out.println("diagnosticCatalogService: " + diagnosticCatalogService.selectDiseaseByPage(currentPage, pageSize, diseaseCategoryId));
    }
}