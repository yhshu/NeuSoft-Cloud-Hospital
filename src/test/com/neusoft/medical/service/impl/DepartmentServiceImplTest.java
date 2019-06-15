package com.neusoft.medical.service;

import com.neusoft.medical.bean.Department;
import com.neusoft.medical.service.basicInfo.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceImplTest {
    @Autowired
    private DepartmentService departmentService;

    @Test
    public void findAllDepartment() {
        System.out.println("findAllDepartment: " + departmentService.findAllDepartment());
    }

    @Test
    public void addDepartment() {
        Department department = new Department(null, "code", "name", 1, 1, 1, "", "", "");

        Department added = departmentService.addDepartment(department);
        System.out.println("addDepartment 返回值: " + added);
    }
}