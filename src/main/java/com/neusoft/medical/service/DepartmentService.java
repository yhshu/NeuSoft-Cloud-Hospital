package com.neusoft.medical.service;

import com.neusoft.medical.bean.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 找到所有部门
     *
     * @return 所有部门信息
     */
    List<Department> findAllDepartment();

    /**
     * 新增一个部门
     *
     * @param record 新增的部门信息
     * @return
     */
    Department addDepartment(Department record);

    /**
     * 按主键删除部门信息
     *
     * @param key 主键
     * @return 删除成功 true，失败 false
     */
    boolean deleteDepartmentByPrimaryKey(int departmentId);

    /**
     * 按主键修改部门信息
     *
     * @param record 部门信息
     * @return 修改后的部门信息
     */
    Department updateDepartmentByPrimaryKey(Department record);
}
