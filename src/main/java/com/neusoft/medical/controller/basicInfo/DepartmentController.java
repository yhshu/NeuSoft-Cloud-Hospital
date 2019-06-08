package com.neusoft.medical.controller.basicInfo;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.neusoft.medical.Util.database.ConstantConverter;
import com.neusoft.medical.bean.Department;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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

    @Autowired
    private ConstantConverter constantConverter;

    /**
     * 查询科室信息
     *
     * @return 科室信息列表
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
     * 按主键删除科室信息
     *
     * @return 操作结果
     */
    @DeleteMapping(value = "/delete")
    public ResultDTO<Boolean> deleteDepartmentByPrimaryKey(@RequestParam(value = "department_id") int departmentId) {
        System.out.println("DepartmentController: " + "按主键删除科室信息");
        Boolean res = departmentService.deleteDepartmentByPrimaryKey(departmentId);
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
    public ResultDTO<Map> departmentConstMap(@RequestParam(value = "constant_type_code") String constantTypeCode) {
        System.out.println("departmentConstMap: " + "获取科室信息常量表");
        return new ResultDTO<>(constantConverter.getConstantIdToNameMap(constantTypeCode));
    }
}
