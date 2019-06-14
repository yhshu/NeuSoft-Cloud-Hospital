package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.ChargeForm;
import com.neusoft.medical.bean.ChargeFormExample;
import com.neusoft.medical.dao.ChargeFormMapper;
import com.neusoft.medical.dao.ChargeItemMapper;
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
    private ChargeItemMapper chargeItemMapper;

    @Resource
    private RegistrationService registrationService;

    @Override
    public PageInfo<ChargeForm> selectChargeFormByRegistrationId(Integer currentPage, Integer pageSize, Integer registrationId, Date startDate, Date endDate, Integer chargeFormCategory) {
        PageHelper.startPage(currentPage, pageSize);

        ChargeFormExample chargeFormExample = new ChargeFormExample();
        ChargeFormExample.Criteria criteria = chargeFormExample.createCriteria();
        criteria.andValidEqualTo(1); // 有效记录
        criteria.andRegistrationIdEqualTo(registrationId); // 挂号编号
        if (startDate != null) // 起始时间
            criteria.andMadeTimeGreaterThan(startDate);
        if (endDate != null) // 结束时间
            criteria.andMadeTimeLessThan(endDate);

        if (chargeFormCategory == CATEGORY_UNCHARGED)
            criteria.andUnchargedNumsNotEqualTo(0);
        else if (chargeFormCategory == CATEGORY_CHARGED)
            criteria.andUnchargedNumsEqualTo(0);

        List<ChargeForm> chargeFormList = chargeFormMapper.selectByExample(chargeFormExample);

        for (ChargeForm chargeForm : chargeFormList) {
            // 保留位1：收费项目规格
            // 保留位2：收费项目单价
            // 保留位3：收费项目名称

            chargeForm.setReserve1(chargeItemMapper.selectByPrimaryKey(chargeForm.getChargeItemId()).getSpecification());
            chargeForm.setReserve2(chargeItemMapper.selectByPrimaryKey(chargeForm.getChargeItemId()).getPrice().toString());
            chargeForm.setReserve3(chargeItemMapper.selectByPrimaryKey(chargeForm.getChargeItemId()).getNameZh());
        }

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

    @Override
    public boolean payBill(List<Integer> chargeFormIdList) {
        try {
            ChargeFormExample chargeFormExample = new ChargeFormExample();
            ChargeFormExample.Criteria criteria = chargeFormExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andChargeFormIdIn(chargeFormIdList);

            ChargeForm record = new ChargeForm();
            record.setUnchargedNums(0);
            chargeFormMapper.updateByExampleSelective(record, chargeFormExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
