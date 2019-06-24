package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.Util.MathUtil;
import com.neusoft.medical.bean.ChargeEntry;
import com.neusoft.medical.bean.ChargeEntryExample;
import com.neusoft.medical.dao.ChargeEntryMapper;
import com.neusoft.medical.dao.ChargeItemMapper;
import com.neusoft.medical.service.registration.ChargeEntryService;
import com.neusoft.medical.service.registration.RegistrationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.neusoft.medical.Util.Constant.PAY_STATE_NOT_CHARGED;

@Service
public class ChargeEntryServiceImpl implements ChargeEntryService {
    @Resource
    private ChargeEntryMapper chargeEntryMapper;

    @Resource
    private ChargeItemMapper chargeItemMapper;

    @Resource
    private RegistrationService registrationService;

    @Override
    public PageInfo<ChargeEntry> selectChargeEntryByRegistrationId(Integer currentPage, Integer pageSize, Integer registrationId, Date startDate, Date endDate, Integer chargeEntryCategory) {
        PageHelper.startPage(currentPage, pageSize);

        ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
        ChargeEntryExample.Criteria criteria = chargeEntryExample.createCriteria();
        criteria.andValidEqualTo(1); // 有效记录
        criteria.andRegistrationIdEqualTo(registrationId); // 挂号编号
        if (startDate != null) // 起始时间
            criteria.andMadeTimeGreaterThan(startDate);
        if (endDate != null) // 结束时间
            criteria.andMadeTimeLessThan(endDate);

        if (chargeEntryCategory == PAY_STATE_NOT_CHARGED)
            criteria.andUnchargedNumsNotEqualTo(0);
        else if (chargeEntryCategory == Constant.PAY_STATE_CHARGED)
            criteria.andUnchargedNumsEqualTo(0);

        List<ChargeEntry> chargeEntryList = chargeEntryMapper.selectByExample(chargeEntryExample);

        for (ChargeEntry chargeEntry : chargeEntryList) {
            // 保留位1：收费项目规格
            // 保留位2：收费项目单价
            // 保留位3：收费项目名称

            chargeEntry.setReserve1(chargeItemMapper.selectByPrimaryKey(chargeEntry.getChargeItemId()).getSpecification());
            chargeEntry.setReserve2(chargeItemMapper.selectByPrimaryKey(chargeEntry.getChargeItemId()).getPrice().toString());
            chargeEntry.setReserve3(chargeItemMapper.selectByPrimaryKey(chargeEntry.getChargeItemId()).getNameZh());
        }

        return new PageInfo<>(chargeEntryList);
    }

    @Override
    public boolean addChargeEntryToForm(int chargeItemId, int registrationId, int itemCount, int collectorId, String doctorAdvice, int examinationId, int chargeFormId) {
        try {
            // 获取添加到收费账单中的所需字段
            Date currentDate = new Date();
            int departmentId = registrationService.selectRegistrationByPrimaryKey(registrationId).getDepartmentId();
            int doctorId = registrationService.selectRegistrationByPrimaryKey(registrationId).getDoctorId();
            double unitPrice = chargeItemMapper.selectByPrimaryKey(chargeItemId).getPrice();
            chargeEntryMapper.insert(new ChargeEntry(null, registrationId, chargeFormId, chargeItemId, examinationId, MathUtil.doubleSetScale(unitPrice, 2), MathUtil.doubleSetScale(unitPrice * itemCount, 2), itemCount, itemCount, itemCount, PAY_STATE_NOT_CHARGED, currentDate, departmentId, doctorId, collectorId, 1, doctorAdvice, null, null, null));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteChargeItemInForm(List<Integer> chargeItemIdList) {
        try {
            ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
            ChargeEntryExample.Criteria criteria = chargeEntryExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andChargeEntryIdIn(chargeItemIdList);
            chargeEntryMapper.deleteByExample(chargeEntryExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean payBill(List<Integer> chargeEntryIdList) {
        try {
            ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
            ChargeEntryExample.Criteria criteria = chargeEntryExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andChargeEntryIdIn(chargeEntryIdList);

            ChargeEntry record = new ChargeEntry();
            record.setUnchargedNums(0);
            chargeEntryMapper.updateByExampleSelective(record, chargeEntryExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
