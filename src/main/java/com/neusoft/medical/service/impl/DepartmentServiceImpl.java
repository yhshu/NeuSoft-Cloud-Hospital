package com.neusoft.medical.service.impl;

import com.neusoft.medical.Util.database.ConstantConverter;
import com.neusoft.medical.bean.Department;
import com.neusoft.medical.bean.DepartmentExample;
import com.neusoft.medical.dao.ConstantTypeMapper;
import com.neusoft.medical.dao.DepartmentMapper;
import com.neusoft.medical.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private ConstantTypeMapper constantTypeMapper;

    @Autowired
    private ConstantConverter constantConverter;


    @Override
    public List<Department> findAllDepartment() {
        DepartmentExample departmentExample = new DepartmentExample();
        List<Department> departmentList = departmentMapper.selectByExample(departmentExample);
        // todo 替换科室分类中的常量
//        try {
//            constantConverter.listCodeToName((List) departmentList, "DeptCategory", "category");  // 替换科室分类中的常量
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return departmentList;
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
