package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.RegistrationCategory;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.basicInfo.RegistrationCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 挂号级别管理 控制器
 */
@RestController
@RequestMapping("/registration_category")
public class RegistrationCategoryController {

    @Resource
    private RegistrationCategoryService registrationCategoryService;

    /**
     * 获取挂号级别列表
     *
     * @param currentPage 当前页码
     * @param pageSize    页面大小
     * @return 分页的挂号级别信息
     */
    @GetMapping("/list")
    public ResultDTO<PageInfo<RegistrationCategory>> selectRegistrationCategory(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        PageInfo<RegistrationCategory> registrationCategoryPageInfo = null;
        try {
            registrationCategoryPageInfo = registrationCategoryService.selectRegistrationCategory(currentPage, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(registrationCategoryPageInfo);
    }

    /**
     * 添加挂号级别
     *
     * @param registrationCategoryName 挂号级别名称
     * @param isDefault                是否为默认挂号级别（是1 否0）
     * @param sequenceNo               挂号级别序列号
     * @param registrationFee          挂号费用
     * @return 操作结果
     */
    @PostMapping("/add")
    public ResultDTO<Boolean> addRegistrationCategory(
            @RequestParam(value = "registrationCategoryName") String registrationCategoryName,
            @RequestParam(value = "isDefault") Boolean isDefault,
            @RequestParam(value = "sequenceNo") Integer sequenceNo,
            @RequestParam(value = "registrationFee") Double registrationFee
    ) {
        try {
            registrationCategoryService.addRegistrationCategory(registrationCategoryName, isDefault, sequenceNo, registrationFee);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }

    /**
     * 按主键更新挂号级别
     *
     * @param registrationCategoryId   挂号级别编号
     * @param registrationCategoryName 挂号级别名称
     * @param isDefault                是否为默认挂号级别（是1 否0）
     * @param sequenceNo               挂号级别序列号
     * @param registrationFee          挂号费用
     * @return 操作结果
     */
    @PutMapping("/update")
    public ResultDTO<Boolean> updateRegistrationCategory(
            @RequestParam(value = "registrationCategoryId") Integer registrationCategoryId,
            @RequestParam(value = "registrationCategoryName") String registrationCategoryName,
            @RequestParam(value = "isDefault") Boolean isDefault,
            @RequestParam(value = "sequenceNo") Integer sequenceNo,
            @RequestParam(value = "registrationFee") Double registrationFee
    ) {
        try {
            registrationCategoryService.updateRegistrationCategoryByPrimaryKey(registrationCategoryId, registrationCategoryName, isDefault, sequenceNo, registrationFee);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }

    @DeleteMapping("/delete")
    public ResultDTO<Boolean> deleteRegistrationCategoryByPrimaryKey(
            @RequestParam(value = "registrationCategoryIdList[]") Integer[] registrationCategoryIdList
    ) {
        try {
            registrationCategoryService.deleteRegistrationCategoryByPrimaryKey(Arrays.asList(registrationCategoryIdList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(Boolean.TRUE);
    }
}
