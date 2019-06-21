package com.neusoft.medical.service.doctorWorkstation;

import com.neusoft.medical.bean.ChargeItem;

import java.util.List;

public interface DisposalService {
    boolean addDisposal(String disposalJson);

    List<ChargeItem> selectDisposalItemListInChargeItemByDepartmentId(int departmentId);

    String selectHistoryDisposal(Integer registrationId);

    boolean updateDisposal(String disposalJson);
}
