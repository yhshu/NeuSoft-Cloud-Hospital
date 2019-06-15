package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.RegistrationCategory;
import com.neusoft.medical.dto.ResultDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 挂号级别管理 控制器
 */
@RestController
@RequestMapping("/registration_category")
public class registrationCategoryController {

    @GetMapping("/list")
    public ResultDTO<PageInfo<RegistrationCategory>> selectRegistrationCategory(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        PageInfo<RegistrationCategory> registrationCategoryPageInfo = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(registrationCategoryPageInfo);
    }
}
