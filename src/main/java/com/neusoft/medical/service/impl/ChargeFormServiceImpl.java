package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeForm;
import com.neusoft.medical.bean.ChargeFormExample;
import com.neusoft.medical.dao.ChargeFormMapper;
import com.neusoft.medical.service.ChargeFormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChargeFormServiceImpl implements ChargeFormService {
    @Resource
    private ChargeFormMapper chargeFormMapper;

    @Override
    public PageInfo<ChargeForm> selectChargeFormByRegistrationId(Integer currentPage, Integer pageSize, Integer registrationId) {
        PageHelper.startPage(currentPage, pageSize);

        ChargeFormExample chargeFormExample = new ChargeFormExample();
        ChargeFormExample.Criteria criteria = chargeFormExample.createCriteria();
        criteria.andValidEqualTo(1);
        criteria.andRegistrationIdEqualTo(registrationId);
        List<ChargeForm> chargeFormList = chargeFormMapper.selectByExample(chargeFormExample);

        return new PageInfo<>(chargeFormList);
    }
}
