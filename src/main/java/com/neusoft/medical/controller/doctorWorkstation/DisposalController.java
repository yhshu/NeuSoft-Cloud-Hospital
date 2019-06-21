package com.neusoft.medical.controller.doctorWorkstation;

import com.neusoft.medical.bean.ChargeItem;
import com.neusoft.medical.dto.ResultDTO;
import com.neusoft.medical.service.doctorWorkstation.DisposalService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/disposal")
public class DisposalController {
    @Resource
    private DisposalService disposalService;

    /**
     * 新增处置申请
     *
     * @param disposalJson 处置项目信息，json 字符串
     * @return 操作结果
     * disposalJson 包含的属性：
     * - registrationId 挂号单编号
     * - chargeEntryList 处置项目列表，json 数组
     * 在 chargeEntryList 数组中，每个元素的属性：
     * - chargeItemId 处置项目作为收费项目的编号
     * - nums 处置项目的数量
     */
    @GetMapping("/add")
    public ResultDTO<Boolean> addDisposal(
            @RequestParam(value = "disposalJson") String disposalJson
    ) {
        boolean res;
        try {
            res = disposalService.addDisposal(disposalJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

    /**
     * 根据科室编号获取收费项目中的处置项目
     *
     * @param departmentId 科室编号
     * @return 指定科室的收费项目中的处置项目列表
     */
    @GetMapping("/select_disposal_list")
    public ResultDTO<List<ChargeItem>> selectDisposalItemListInChargeItemByDepartmentId(
            @RequestParam(value = "departmentId") Integer departmentId
    ) {
        List<ChargeItem> res = null;
        try {
            res = disposalService.selectDisposalItemListInChargeItemByDepartmentId(departmentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(res);
    }

    /**
     * 按挂号单编号获取历史处置项目（所有处置状态）
     *
     * @param registrationId 挂号单编号
     * @return 历史处置项目，json 数组
     */
    @GetMapping("/history_disposal")
    public ResultDTO<String> selectHistoryDisposal(
            @RequestParam(value = "registrationId") Integer registrationId
    ) {
        String res = null;
        try {
            res = disposalService.selectHistoryDisposal(registrationId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultDTO<>(res);
    }

    /**
     * 执行处置
     * 更改处置状态，修改收费项目的尚未交付数量
     * 处置项目被全部执行完，修改 charge_form 的执行状态
     *
     * @param disposalJson 处置信息，json 字符串
     * @return 操作结果
     * <p>
     * disposalJson 包含的属性：
     * - chargeEntryList 处置项目列表，json 数组
     * chargeEntryList 数组包含的属性：
     * - not_given_nums 在执行处置后，尚未交付的项目数量，（不修改填-1）
     */
    @GetMapping("/update")
    public ResultDTO<Boolean> updateDisposal(
            @RequestParam(value = "disposalJson") String disposalJson) {
        boolean res;
        try {
            res = disposalService.updateDisposal(disposalJson);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO<>(Boolean.FALSE);
        }
        return new ResultDTO<>(res);
    }

    /**
     * 删除处置项目
     * 由医生执行
     * 只有尚未交付的项目可删除
     *
     * @param chargeEntryIdList 删除的处置项目编号列表
     * @return 操作结果
     */
    @DeleteMapping("/delete")
    public ResultDTO<Boolean> deleteDisposal(@RequestParam(value = "chargeEntryIdList[]") Integer[] chargeEntryIdList) {
        // todo
        return null;
    }
}
