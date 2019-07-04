package com.neusoft.medical.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
    /**
     * 保存处置申请（新增或更新）
     *
     * @param disposalJson 处置项目信息，json 字符串
     * @return 操作结果
     * disposalJson 包含的属性：
     * - chargeFormId 收费单编号（新增时不填，更新时必填）
     * - registrationId 挂号单编号
     * - chargeFormName 处置单名称
     * - saveState 保存状态（暂存 0；正式提交 1；全院模板 2；科室模板 3；医生个人模板 4）
     * - chargeEntryList 处置项目列表，json 数组
     * 在 chargeEntryList 数组中，每个元素的属性：
     * - chargeItemId 处置项目作为收费项目的编号
     * - nums 处置项目的数量
     * - doctorAdvice 医嘱
     */
    public void saveDisposal() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("chargeFormId",1);
        jsonObject.addProperty("registration",2);
        jsonObject.addProperty("chargeFormName","处置");
        jsonObject.addProperty("saveState",1);

        JsonArray chargeEntryListJsonArray = new JsonArray();
        JsonObject chargeEntryJsonObject = new JsonObject();
        chargeEntryJsonObject.addProperty("chargeItemId",33);
        chargeEntryJsonObject.addProperty("nums",5);
        jsonObject.add("chargeEntryList",chargeEntryListJsonArray);

        disposalService.saveDisposal(jsonObject.toString());
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
    /**
     * 执行处置
     * 更改处置状态，修改收费项目的尚未交付数量
     * 处置项目被全部执行完，修改 charge_form 的执行状态
     *
     * @param disposalJson 处置信息，json 字符串
     * @return 操作结果
     * <p>
     * disposalJson 包含的属性：
     * - chargeFormId 处置项目单编号
     * - chargeEntryList 处置项目列表，json 数组
     * chargeEntryList 数组包含的属性：
     * - chargeEntryId 处置项目作为收费项目的编号
     * - not_given_nums 在执行处置后，尚未交付的项目数量，（不修改填-1）
     */
    public void updateDisposal() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("chargeFormId",1);

        JsonArray chargeEntryJsonArray = new JsonArray();
        JsonObject chargeEntryJsonObject = new JsonObject();
        chargeEntryJsonObject.addProperty("chargeEntryId",5);
        chargeEntryJsonObject.addProperty("not_give_nums",2);
        chargeEntryJsonArray.add(chargeEntryJsonObject);
        jsonObject.add("chargeEntryList",chargeEntryJsonArray);

        disposalService.updateDisposal(jsonObject.toString());
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