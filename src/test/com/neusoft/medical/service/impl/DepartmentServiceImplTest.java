package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Department;
import com.neusoft.medical.service.basicInfo.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void selectDepartment() {
        Department department = new Department(99,"code","name",45,1,1,null,null,null);
        List<Integer> list = new ArrayList<>();
        list.add(department.getDepartmentId());
        departmentService.selectDepartment(1,20,list);
    }

    @Test
    public void deleteDepartmentByPrimaryKey() {
        Department department = new Department(99,"code","name",45,1,1,null,null,null);
        List<Integer> list = new ArrayList<>();
        list.add(department.getDepartmentId());
        departmentService.deleteDepartmentByPrimaryKey(list);
    }

    @Test
    public void updateDepartmentByPrimaryKey() {
        Department department = new Department(99,"code","name",45,1,1,null,null,null);
        departmentService.updateDepartmentByPrimaryKey(department);
    }
}