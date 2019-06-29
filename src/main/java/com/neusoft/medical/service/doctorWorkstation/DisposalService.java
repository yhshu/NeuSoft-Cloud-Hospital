package com.neusoft.medical.service.doctorWorkstation;

import com.neusoft.medical.bean.ChargeForm;
import com.neusoft.medical.bean.ChargeItem;

import java.util.List;

public interface DisposalService {
    boolean saveDisposal(String disposalJson);

    List<ChargeItem> selectDisposalItemListInChargeItemByDepartmentId(int departmentId);

    String selectHistoryDisposal(Integer registrationId);

    boolean updateDisposal(String disposalJson);

    boolean deleteDisposalEntry(List<Integer> chargeEntryIdList);

    boolean deleteDisposal(List<Integer> chargeFormIdList);

    String selectDisposalTemplate(Integer disposalScope, Integer doctorId);

    String chargeFormListToJson(List<ChargeForm> chargeFormList);
}
