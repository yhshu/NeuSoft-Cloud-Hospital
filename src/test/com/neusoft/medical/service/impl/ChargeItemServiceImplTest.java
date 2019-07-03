package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.dao.ChargeItemMapper;
import com.neusoft.medical.service.basicInfo.ChargeItemService;
import com.qcloud.cos.transfer.Copy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChargeItemServiceImplTest {
    @Resource
    private ChargeItemService chargeItemService;
    @Resource
    private ChargeItemMapper chargeItemMapper;

    @Test
    public void selectChargeItemByDepartmentId() {
        for (int i = 1; i < 50; i++)
            chargeItemService.selectChargeItemByDepartmentId(i);
    }

    @Test
    public void selectChargeItemByDepartmentIdWithPaging() {
        List<Integer> departmentIdList = new CopyOnWriteArrayList<>();
        departmentIdList.add(1);
        chargeItemService.selectChargeItemByDepartmentIdWithPaging(departmentIdList, 1, 20);
    }

    @Test
    public void saveChargeItem() {
        chargeItemService.saveChargeItem(null, "code", "name", null, null, null, null, null, null);
    }

    @Test
    public void deleteChargeItem() {
        ChargeItem chargeItemRecord = new ChargeItem();
        chargeItemMapper.insert(chargeItemRecord);
        List<Integer> chargeItemIdList = new CopyOnWriteArrayList<>();
        chargeItemIdList.add(chargeItemRecord.getChargeItemId());
        chargeItemService.deleteChargeItem(chargeItemIdList);
    }
}