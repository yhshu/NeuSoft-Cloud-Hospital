package com.neusoft.medical.service.impl;

import com.neusoft.medical.bean.ChargeForm;
import com.neusoft.medical.dao.ChargeFormMapper;
import com.neusoft.medical.service.doctorWorkstation.DisposalService;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DisposalServiceImplTest {

    @Resource
    DisposalService disposalService;
    @Resource
    ChargeFormMapper chargeFormMapper;

    @Test
    public void saveDisposal() {
        disposalService.saveDisposal("");
    }

    @Test
    public void selectDisposalItemListInChargeItemByDepartmentId() {
        disposalService.selectDisposalItemListInChargeItemByDepartmentId(1);
    }

    @Test
    public void selectHistoryDisposal() {
        disposalService.selectHistoryDisposal(1);
    }

    @Test
    public void selectUnpaidDisposal() {
        disposalService.selectUnpaidDisposal(1);
    }

    @Test
    public void selectDisposal() {
        List<Integer> payStateList = new ArrayList<>();
        disposalService.selectDisposal(1,payStateList);
    }

    @Test
    public void updateDisposal() {
        disposalService.updateDisposal("");
    }

    @Test
    public void deleteDisposalEntry() {
        List<Integer> chargeEntryIdList = new ArrayList<>();
        disposalService.deleteDisposalEntry(chargeEntryIdList);
    }

    @Test
    public void deleteDisposal() {
        List<Integer> chargeFormIdList = new ArrayList<>();
        disposalService.deleteDisposal(chargeFormIdList);
    }

    @Test
    public void selectDisposalTemplate() {
        disposalService.selectDisposalTemplate(1,1);
    }

    @Test
    public void chargeFormListToJson() {
        List<ChargeForm> chargeFormList = new ArrayList<ChargeForm>();
        disposalService.chargeFormListToJson(chargeFormList);
    }
}