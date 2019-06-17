package com.neusoft.medical.service.basicInfo;

import com.github.pagehelper.PageInfo;
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
     * 分页、分类查找科室信息
     *
     * @param currentPage        当前页，不可为空
     * @param pageSize           页面大小，不可为空
     * @param departmentCategory 科室类别，可为空，默认为所有科室类别
     * @return 指定范围的科室信息
     */
    PageInfo<Department> selectDepartment(Integer currentPage, Integer pageSize, List<Integer> departmentCategory);

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
     * @param departmentIdList 主键列表
     * @return 删除的记录数
     */
    int deleteDepartmentByPrimaryKey(List<Integer> departmentIdList);

    /**
     * 按主键修改科室信息
     *
     * @param record 科室信息
     * @return 修改后的科室信息
     */
    Department updateDepartmentByPrimaryKey(Department record);
}
