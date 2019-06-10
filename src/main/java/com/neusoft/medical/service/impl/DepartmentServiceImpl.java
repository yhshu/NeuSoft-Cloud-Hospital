package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Department;
import com.neusoft.medical.bean.DepartmentExample;
import com.neusoft.medical.dao.DepartmentMapper;
import com.neusoft.medical.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAllDepartment() {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andValidEqualTo(1);
        return departmentMapper.selectByExample(departmentExample);
    }

    @Override
    public PageInfo<Department> selectDepartment(Integer currentPage, Integer pageSize, List<Integer> departmentCategory) {
        PageHelper.startPage(currentPage, pageSize);

        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andValidEqualTo(1);
        if (departmentCategory != null) { // 查找指定科室类别的科室信息
            criteria.andCategoryIn(departmentCategory);
        }

        List<Department> departmentList = departmentMapper.selectByExample(departmentExample);

        return new PageInfo<>(departmentList);
    }

    @Override
    public Department addDepartment(Department record) {
        int effectRow = departmentMapper.insert(record);
        System.out.println("addDepartment 新增记录 " + effectRow + " 项");
        return departmentMapper.selectByPrimaryKey(record.getDepartmentId());
    }

    @Override
    public int deleteDepartmentByPrimaryKey(List<Integer> departmentIdList) {
        Department record = new Department();
        record.setValid(0);

        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDepartmentIdIn(departmentIdList);
        criteria.andValidEqualTo(1);  // 仅查找有效的记录

        int effectRow = departmentMapper.updateByExampleSelective(record, departmentExample);
        System.out.println("deleteDepartmentByPrimaryKey 删除记录 " + effectRow + " 项");
        return effectRow;
    }

    @Override
    public Department updateDepartmentByPrimaryKey(Department record) {
        int effectRow = departmentMapper.updateByPrimaryKey(record);
        System.out.println("updateDepartmentByPrimaryKey 修改记录 " + effectRow + " 项");
        return departmentMapper.selectByPrimaryKey(record.getDepartmentId());
    }
}
