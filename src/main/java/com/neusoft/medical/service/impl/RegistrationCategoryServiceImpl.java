package com.neusoft.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.RegistrationCategory;
import com.neusoft.medical.bean.RegistrationCategoryExample;
import com.neusoft.medical.dao.RegistrationCategoryMapper;
import com.neusoft.medical.service.basicInfo.RegistrationCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegistrationCategoryServiceImpl implements RegistrationCategoryService {
    @Resource
    private RegistrationCategoryMapper registrationCategoryMapper;

    @Override
    public PageInfo<RegistrationCategory> selectRegistrationCategory(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);

        RegistrationCategoryExample registrationCategoryExample = new RegistrationCategoryExample();
        RegistrationCategoryExample.Criteria criteria = registrationCategoryExample.createCriteria();
        criteria.andValidEqualTo(1);  // 有效的挂号级别记录
        return new PageInfo<>(registrationCategoryMapper.selectByExample(registrationCategoryExample));
    }

    @Override
    public boolean addRegistrationCategory(String registrationCategoryName, boolean isDefault, int sequenceNo, double registrationFee) {
        try {
            if (isDefault) {
                RegistrationCategoryExample registrationCategoryExample = new RegistrationCategoryExample();
                registrationCategoryExample.or().andValidEqualTo(1);
                registrationCategoryMapper.updateByExampleSelective(new RegistrationCategory(null, null, false, null, null, null), registrationCategoryExample);
            }
            registrationCategoryMapper.insert(new RegistrationCategory(null, registrationCategoryName, isDefault, sequenceNo, registrationFee, 1));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateRegistrationCategoryByPrimaryKey(int registrationCategoryId, String registrationCategoryName, boolean isDefault, int sequenceNo, double registrationFee) {
        try {
            if (isDefault) {
                RegistrationCategoryExample registrationCategoryExample = new RegistrationCategoryExample();
                registrationCategoryExample.or().andValidEqualTo(1);
                registrationCategoryMapper.updateByExampleSelective(new RegistrationCategory(null, null, false, null, null, null), registrationCategoryExample);
            }
            RegistrationCategory record = new RegistrationCategory(registrationCategoryId, registrationCategoryName, isDefault, sequenceNo, registrationFee, 1);
            registrationCategoryMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteRegistrationCategoryByPrimaryKey(List<Integer> registrationCategoryId) {
        try {
            RegistrationCategoryExample registrationCategoryExample = new RegistrationCategoryExample();
            RegistrationCategoryExample.Criteria criteria = registrationCategoryExample.createCriteria();
            criteria.andValidEqualTo(1);
            criteria.andRegistrationCategoryIdIn(registrationCategoryId);

            RegistrationCategory record = new RegistrationCategory();
            record.setValid(0);  // 将挂号级别记录的有效位置为无效
            registrationCategoryMapper.updateByExampleSelective(record, registrationCategoryExample);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<RegistrationCategory> selectAllRegistrationCategory() {
        List<RegistrationCategory> registrationCategoryList = null;
        try {
            RegistrationCategoryExample registrationCategoryExample = new RegistrationCategoryExample();
            registrationCategoryExample.or().andValidEqualTo(1);

            registrationCategoryList = registrationCategoryMapper.selectByExample(registrationCategoryExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registrationCategoryList;
    }
}
