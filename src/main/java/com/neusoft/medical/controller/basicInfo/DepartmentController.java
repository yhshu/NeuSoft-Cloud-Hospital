package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.Util.database.ConstantConverter;
import com.neusoft.medical.bean.Department;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

/**
 * 科室管理控制器
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private Logger log = Logger.getLogger(String.valueOf(DepartmentController.class));

    @Resource
    private DepartmentService departmentService;

    @Resource
    private ConstantConverter constantConverter;

    /**
     * 查询科室信息
     *
     * @return 科室信息列表
     */
    @Deprecated
    @GetMapping(value = "/list_all_department")
    public ResultDTO<List<Department>> findAllDepartment() {
        System.out.println("DepartmentController: " + "查询科室列表");
        List<Department> departmentList = departmentService.findAllDepartment();
        return new ResultDTO<>(departmentList);
    }

    /**
     * 按分类和分页查询科室信息
     *
     * @return 分页、分类的科室信息列表
     */
    @GetMapping(value = "/list")
    public ResultDTO<PageInfo<Department>> selectDepartment(@RequestParam(value = "current_page") Integer currentPage, @RequestParam(value = "page_size") Integer pageSize, @RequestParam(value = "department_category", required = false) List<Integer> departmentCategory) {
        System.out.println("DepartmentController: " + "查询科室列表");
        PageInfo<Department> departmentList = departmentService.selectDepartment(currentPage, pageSize, departmentCategory);
        return new ResultDTO<>(departmentList);
    }

    /**
     * 新增科室
     *
     * @return 操作结果
     */
    @PostMapping(value = "/add")
    public ResultDTO<Department> addDepartment(@RequestBody Department record) {
        System.out.println("DepartmentController: " + "新增科室");
        Department added = departmentService.addDepartment(record);
        return new ResultDTO<>(added);
    }

    /**
     * 按主键删除科室信息
     *
     * @return 操作结果
     */
    @DeleteMapping(value = "/delete")
    public ResultDTO<Integer> deleteDepartmentByPrimaryKey(@RequestParam(value = "department_id_list") List<Integer> departmentId) {
        System.out.println("DepartmentController: " + "按主键删除科室信息");
        int res = departmentService.deleteDepartmentByPrimaryKey(departmentId);
        return new ResultDTO<>(res);
    }

    /**
     * 按主键修改科室信息
     *
     * @param record 科室信息
     * @return 修改后的科室信息
     */
    @PutMapping(value = "/update")
    public ResultDTO<Department> updateDepartmentByPrimaryKey(@RequestBody Department record) {
        System.out.println("DepartmentController: " + "按主键修改科室信息");
        Department updated = departmentService.updateDepartmentByPrimaryKey(record);
        return new ResultDTO<>(updated);
    }

    /**
     * 请求科室信息常量表
     *
     * @return 科室信息常量表
     */
    @GetMapping(value = "/const")
    public ResultDTO<List> departmentConstMap(@RequestParam(value = "constant_type_code") String constantTypeCode) {
        System.out.println("departmentConstMap: " + "获取科室信息常量表");
        return new ResultDTO<>(constantConverter.getConstantIdToNameList(constantTypeCode));
    }
}
