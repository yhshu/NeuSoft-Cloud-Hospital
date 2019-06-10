package com.neusoft.medical.service;

import com.neusoft.medical.bean.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 找到所有科室
     *
     * @return 所有科室信息
     */
    List<Department> findAllDepartment();

    /**
     * 新增一个科室
     *
     * @param record 新增的科室信息
     * @return
     */
    Department addDepartment(Department record);

    /**
     * 按主键删除科室信息
     *
     * @param key 主键
     * @return 删除的记录数量
     */
    int deleteDepartmentByPrimaryKey(int[] departmentIdList);

    /**
     * 按主键修改科室信息
     *
     * @param record 科室信息
     * @return 修改后的科室信息
     */
    Department updateDepartmentByPrimaryKey(Department record);
}
