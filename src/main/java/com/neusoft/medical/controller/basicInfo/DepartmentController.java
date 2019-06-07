package com.neusoft.medical.controller.basicInfo;

import com.neusoft.medical.bean.Department;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * 科室管理控制器
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private Logger log = Logger.getLogger(String.valueOf(DepartmentController.class));

    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询部门信息
     *
     * @return 部门信息列表
     */
    @GetMapping(value = "/list")
    public ResultDTO<List<Department>> findAllDepartment() {
        System.out.println("DepartmentController: " + "查询部门列表");
        List<Department> departmentList = departmentService.findAllDepartment();
        return new ResultDTO<>(departmentList);
    }

    /**
     * 新增部门
     *
     * @return 操作结果
     */
    @PostMapping(value = "/add")
    public ResultDTO<Department> addDepartment(@RequestBody Department record) {
        System.out.println("DepartmentController: " + "新增部门");
        Department added = departmentService.addDepartment(record);
        return new ResultDTO<>(added);
    }

    /**
     * 按主键删除部门信息
     *
     * @return 操作结果
     */
    @DeleteMapping(value = "/delete")
    public ResultDTO<Boolean> deleteDepartmentByPrimaryKey(@RequestParam(value = "department_id") int departmentId) {
        System.out.println("DepartmentController: " + "按主键删除部门信息");
        Boolean res = departmentService.deleteDepartmentByPrimaryKey(departmentId);
        return new ResultDTO<>(res);
    }

    /**
     * 按主键修改部门信息
     *
     * @param record 部门信息
     * @return 修改后的部门信息
     */
    @PutMapping(value = "/update")
    public ResultDTO<Department> updateDepartmentByPrimaryKey(@RequestBody Department record) {
        System.out.println("DepartmentController: " + "按主键修改部门信息");
        Department updated = departmentService.updateDepartmentByPrimaryKey(record);
        return new ResultDTO<>(updated);
    }
}
