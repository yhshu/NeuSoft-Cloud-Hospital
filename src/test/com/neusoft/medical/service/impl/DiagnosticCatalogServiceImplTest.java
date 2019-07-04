package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Disease;
import com.neusoft.medical.service.basicInfo.DiagnosticCatalogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiagnosticCatalogServiceImplTest {
    @Autowired
    DiagnosticCatalogService diagnosticCatalogService;

    @Test
    public void findAllDiseaseCategory() {
        diagnosticCatalogService.findAllDiseaseCategory();
    }

    @Test
    public void selectDiseaseByPage() {
        int currentPage = 1;
        int pageSize = 20;
        Random random = new Random();
        int diseaseCategoryId = random.nextInt();
        System.out.println("diagnosticCatalogService: " + diagnosticCatalogService.selectDiseaseByPage(currentPage, pageSize, diseaseCategoryId));
    }

    @Test
    public void addDisease() {
        Disease disease = new Disease(99,"diseaselcd","Name","Code",99,1);
        diagnosticCatalogService.addDisease(disease);
    }

    @Test
    public void updateDisease() {
        Disease disease = new Disease(99,"diseaselcd","Name","Code",99,1);
        diagnosticCatalogService.updateDisease(disease);
    }

    @Test
    public void deleteDisease() {
        Disease disease = new Disease(99,"diseaselcd","Name","Code",99,1);
        List<Integer> list = new ArrayList<>();
        list.add(disease.getDiseaseId());
        diagnosticCatalogService.deleteDisease(list);
    }
}