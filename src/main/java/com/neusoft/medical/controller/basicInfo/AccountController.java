package com.neusoft.medical.controller.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.Account;
import com.neusoft.medical.bean.Doctor;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 用户管理控制器
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    /**
     * 分页、分类查找帐号信息
     *
     * @param currentPage  当前页码
     * @param pageSize     页面大小
     * @param accountScope 查找的帐号范围，字符串数组
     *                     门诊医生 00
     *                     医技医生 01
     *                     医院收费员 10
     *                     药房操作员 11
     *                     财务管理员 12
     *                     挂号管理员 13
     * @return 指定范围的帐号信息
     */
    @GetMapping("/select_account")
    public ResultDTO<PageInfo<Account>> selectAccount(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "accountScope[]") String[] accountScope
    ) {
        PageInfo<Account> accountPageInfo = null;
        try {
            accountPageInfo = accountService.selectAccount(currentPage, pageSize, Arrays.asList(accountScope));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(accountPageInfo);
    }

    /**
     * 分页、分类查找医生信息
     *
     * @param currentPage  当前页码
     * @param pageSize     页面大小
     * @param accountScope 查找的帐号范围，字符串数组
     *                     门诊医生 00
     *                     医技医生 01
     * @return 指定范围的帐号信息
     */
    @GetMapping("/select_doctor")
    public ResultDTO<PageInfo<Doctor>> selectDoctor(
            @RequestParam(value = "currentPage") Integer currentPage,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "accountScope[]") String[] accountScope
    ) {
        PageInfo<Doctor> doctorPageInfo = null;
        try {
            doctorPageInfo = accountService.selectDoctor(currentPage, pageSize, Arrays.asList(accountScope));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(doctorPageInfo);
    }
}
