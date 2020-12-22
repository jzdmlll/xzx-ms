package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.purchase.vm.PurchaseItemsVM;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/21 15:13
 * @修改人：
 * @修改时间：2020/12/21 15:13
 * @修改描述：默认描述
 */
@Repository
public interface PurchasePlanService {
    /**
     * 根据项目id查询该项目下的所有购买项
     * @param projectId
     * @return
     */
    List<PurchaseItemsVM> findItemsByProjectIdService(String projectId);


    /**
     * 根据项目id及其详情项id修改其是否需要询价
     * @param projectId
     * @param idList
     * @return
     */
    String updateItemsInquiryService(String projectId, List<Long> idList);
}
