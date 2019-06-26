package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Department;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.basicInfo.DepartmentService;
import com.neusoft.medical.service.impl.ConstantConverter;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 科室管理控制器
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private Logger logger = Logger.getLogger(DepartmentController.class);

    @Resource
    private DepartmentService departmentService;

    @Resource
    private ConstantConverter constantConverter;

    /**
     * 按分类和分页查询科室信息
     *
     * @return 分页、分类的科室信息列表
     */
    @GetMapping(value = "/list")
    public ResultDTO<PageInfo<Department>> selectDepartment(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "departmentCategory[]", required = false) Integer[] departmentCategory) {
        System.out.println("selectDepartment: " + "查询科室列表");
        PageInfo<Department> departmentList = departmentService.selectDepartment(currentPage, pageSize, Arrays.asList(departmentCategory));
        return new ResultDTO<>(departmentList);
    }

    /**
     * 新增科室
     *
     * @return 操作结果
     */
    @PostMapping(value = "/add")
    public ResultDTO<Department> addDepartment(
            @RequestParam(value = "category") Integer category,
            @RequestParam(value = "departmentCode") String departmentCode,
            @RequestParam(value = "departmentName") String departmentName) {
        System.out.println("addDepartment: " + "新增科室");
        Department added = departmentService.addDepartment(new Department(null, departmentCode, departmentName, category, null, 1, null, null, null));
        return new ResultDTO<>(added);
    }

    /**
     * 按主键删除科室信息
     *
     * @return 操作结果
     */
    @DeleteMapping(value = "/delete")
    public ResultDTO<Integer> deleteDepartmentByPrimaryKey(
            @RequestParam(value = "department_id_list[]") Integer[] departmentId) {
        System.out.println("DepartmentController: " + "按主键删除科室信息");
        List<Integer> departmentList = Arrays.asList(departmentId);
        int res = departmentService.deleteDepartmentByPrimaryKey(departmentList);
        return new ResultDTO<>(res);
    }

    /**
     * 按主键更新科室信息
     *
     * @param departmentId   科室编号，主键
     * @param category       科室类别
     * @param departmentCode 科室编码
     * @param departmentName 科室名称
     * @return 更新后的科室信息
     */
    @PutMapping(value = "/update")
    public ResultDTO<Department> updateDepartmentByPrimaryKey(
            @RequestParam(value = "departmentId") Integer departmentId,
            @RequestParam(value = "category") Integer category,
            @RequestParam(value = "departmentCode") String departmentCode,
            @RequestParam(value = "departmentName") String departmentName) {
        System.out.println("DepartmentController: " + "按主键修改科室信息");
        Department updated = departmentService.updateDepartmentByPrimaryKey(new Department(departmentId, departmentCode, departmentName, category, null, 1, null, null, null));
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

    /**
     * 查询科室信息
     *
     * @return 科室信息列表
     */
    @Deprecated // 该方法废弃，请使用 selectDepartment 方法
    @GetMapping(value = "/list_all_department")
    public ResultDTO<List<Department>> findAllDepartment() {
        System.out.println("DepartmentController: " + "查询科室列表");
        List<Department> departmentList = departmentService.findAllDepartment();
        return new ResultDTO<>(departmentList);
    }
}
