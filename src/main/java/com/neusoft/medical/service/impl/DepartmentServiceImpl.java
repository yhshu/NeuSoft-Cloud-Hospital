package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.Department;
import com.neusoft.medical.bean.DepartmentExample;
import com.neusoft.medical.dao.DepartmentMapper;
import com.neusoft.medical.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAllDepartment() {
        DepartmentExample departmentExample = new DepartmentExample();
        return departmentMapper.selectByExample(departmentExample);
    }

    @Override
    public Department addDepartment(Department record) {
        int effectRow = departmentMapper.insert(record);
        System.out.println("addDepartment 新增记录 " + effectRow + " 项");
        return departmentMapper.selectByPrimaryKey(record.getDepartmentId());
    }

    @Override
    public boolean deleteDepartmentByPrimaryKey(int departmentId) {
        try {
            departmentMapper.deleteByPrimaryKey(departmentId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Department updateDepartmentByPrimaryKey(Department record) {
        int effectRow = departmentMapper.updateByPrimaryKey(record);
        System.out.println("updateDepartmentByPrimaryKey 修改记录 " + effectRow + " 项");
        return departmentMapper.selectByPrimaryKey(record.getDepartmentId());
    }
}
