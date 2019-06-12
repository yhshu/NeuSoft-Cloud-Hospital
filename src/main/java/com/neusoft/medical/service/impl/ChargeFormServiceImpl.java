package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeForm;
import com.neusoft.medical.bean.ChargeFormExample;
import com.neusoft.medical.dao.ChargeFormMapper;
import com.neusoft.medical.service.ChargeFormService;
import com.neusoft.medical.service.RegistrationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ChargeFormServiceImpl implements ChargeFormService {
    @Resource
    private ChargeFormMapper chargeFormMapper;

    @Resource
    private RegistrationService registrationService;

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

    @Override
    public boolean addChargeItemToForm(int chargeItemId, int registrationId, int itemCount, int collectorId) {
        try {
            // 获取添加到收费账单中的所需字段
            Date currentDate = new Date();
            int departmentId = registrationService.selectRegistrationByPrimaryKey(registrationId).getDepartmentId();
            int doctorId = registrationService.selectRegistrationByPrimaryKey(registrationId).getDoctorId();
            chargeFormMapper.insert(new ChargeForm(null, registrationId, chargeItemId, itemCount, itemCount, currentDate, 1, departmentId, doctorId, collectorId, itemCount, null, null, null));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteChargeItemInForm(List<Integer> chargeItemIdList) {
        try {
            ChargeFormExample chargeFormExample = new ChargeFormExample();
            ChargeFormExample.Criteria criteria = chargeFormExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andChargeFormIdIn(chargeItemIdList);
            chargeFormMapper.deleteByExample(chargeFormExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
