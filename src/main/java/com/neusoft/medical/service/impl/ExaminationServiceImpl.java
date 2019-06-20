package com.neusoft.medical.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.bean.ChargeItemExample;
import com.neusoft.medical.dao.ChargeItemMapper;
import com.neusoft.medical.service.doctorWorkstation.ExaminationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Resource
    private ChargeItemMapper chargeItemMapper;

    private Gson gson = new Gson();

    @Override
    public boolean addExamination(String examinationJson) {
        JsonObject examinationJsonObject = gson.toJsonTree(examinationJson).getAsJsonObject();

        return false;
    }

    @Override
    public List<ChargeItem> selectExamListInChargeItemByDepartmentId(Integer departmentId) {
        ChargeItemExample chargeItemExample = new ChargeItemExample();
        ChargeItemExample.Criteria criteria = chargeItemExample.createCriteria();
        criteria.andValidEqualTo(1);
        criteria.andDepartmentIdEqualTo(departmentId);
        criteria.andExpenseCategoryIdEqualTo(EXPENSE_CATEGORY_EXAM);

        return chargeItemMapper.selectByExample(chargeItemExample);
    }
}
