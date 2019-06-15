package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.RegistrationCategory;
import com.neusoft.medical.bean.RegistrationCategoryExample;
import com.neusoft.medical.service.basicInfo.RegistrationCategoryService;

import java.util.List;

public class RegistrationCategoryServiceImpl implements RegistrationCategoryService {
    @Override
    public List<RegistrationCategory> selectRegistrationCategory() {
        RegistrationCategoryExample registrationCategoryExample = new RegistrationCategoryExample();
        RegistrationCategoryExample.Criteria criteria = registrationCategoryExample.createCriteria();

        return null;
    }
}
