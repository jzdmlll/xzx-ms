package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.inquiry.bean.SysProDetail;
import com.xzx.xzxms.inquiry.bean.SysProDetailWithBLOBs;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.vm.PurchaseItemsListVM;
import com.xzx.xzxms.purchase.vm.PurchaseItemsVM;
import com.xzx.xzxms.purchase.vm.PurchaseSupplierVM;
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
    List<PurchaseItemsVM> findItemsByProjectIdService(Long projectId);


    /**
     * 根据项目id及其详情项id修改其是否需要询价
     * @param projectId
     * @param idList
     * @return
     */
    String updateItemsInquiryService(Long projectId, List<Long> idList);

    /**
     * 当购买项购买数量拆分，新增一条该购买项信息
     * @param purchaseItems
     * @param itemNum
     */
    String insertItemService(PurchaseItems purchaseItems, int itemNum);

    List<PurchaseSupplierVM> findPurchasingSupplierByItemIdService(Long id);

    /**
     * 新增询价项目,新增询价商品
     * @param purchaseItemsList
     * @return
     */
    String insertSysProDetailService(PurchaseItemsListVM purchaseItemsList);
}