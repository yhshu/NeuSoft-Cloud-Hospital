package com.neusoft.medical.controller.basicInfo;

import com.neusoft.medical.bean.Account;
import com.neusoft.medical.dto.ResultDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户管理控制器
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping('/select_account')
    public ResultDTO<List<Account>> selectAccount(
            @RequestParam(value = "accountScope") Integer accountScope
    ) {
//        return new ResultDTO<>(); todo
        return null;
    }
}
