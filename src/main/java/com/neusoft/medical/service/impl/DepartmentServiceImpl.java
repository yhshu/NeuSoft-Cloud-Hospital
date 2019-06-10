package com.neusoft.medical.service.impl;

import com.neusoft.medical.Util.database.ConstantConverter;
import com.neusoft.medical.bean.Department;
import com.neusoft.medical.bean.DepartmentExample;
import com.neusoft.medical.dao.ConstantTypeMapper;
import com.neusoft.medical.dao.DepartmentMapper;
import com.neusoft.medical.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private ConstantTypeMapper constantTypeMapper;

    @Resource
    private ConstantConverter constantConverter;


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
    public int deleteDepartmentByPrimaryKey(int[] departmentIdList) {
        int effectRow = 0;
        try {
            for (int departmentId : departmentIdList) {
                effectRow += departmentMapper.deleteByPrimaryKey(departmentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return effectRow;
    }

    @Override
    public Department updateDepartmentByPrimaryKey(Department record) {
        int effectRow = departmentMapper.updateByPrimaryKey(record);
        System.out.println("updateDepartmentByPrimaryKey 修改记录 " + effectRow + " 项");
        return departmentMapper.selectByPrimaryKey(record.getDepartmentId());
    }
}
