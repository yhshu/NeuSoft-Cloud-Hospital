package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Department;
import com.neusoft.medical.bean.DepartmentExample;
import com.neusoft.medical.dao.DepartmentMapper;
import com.neusoft.medical.service.DepartmentService;
import edu.neu.medical.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAll() {
        return departmentMapper.selectByExample(new DepartmentExample());
    }
}
