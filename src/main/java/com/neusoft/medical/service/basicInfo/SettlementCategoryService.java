package com.neusoft.medical.service.basicInfo;

import com.github.pagehelper.PageInfo;
import com.neusoft.medical.bean.SettlementCategory;

import java.util.List;

/**
 * 结算类别管理 服务
 */
public interface SettlementCategoryService {
    PageInfo<SettlementCategory> selectSettlementCategory(int currentPage, int pageSize);

    boolean deleteSettlementCategory(List<Integer> settlementCategoryIdList);

    boolean saveSettlementCategory(Integer settlementCategoryId, String settlementCategoryName);
}
