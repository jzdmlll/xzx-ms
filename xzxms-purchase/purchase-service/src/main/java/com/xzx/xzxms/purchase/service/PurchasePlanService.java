package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;
import com.xzx.xzxms.purchase.dto.PurchaseItemsDTO;
import com.xzx.xzxms.purchase.dto.PurchaseItemsExcelImportDTO;
import com.xzx.xzxms.purchase.dto.PurchaseItemsListDTO;
import com.xzx.xzxms.purchase.vo.PurchaseItemsVO;
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
    List<PurchaseItemsVO> findItemsByProjectIdService(Long projectId);

    /**
     * 根据项目id及其详情项id修改其是否需要询价
     * @param purchaseItemsDTO
     * @return
     */
    String updateItemsInquiryService(PurchaseItemsDTO purchaseItemsDTO);

    /**
     * 当购买项购买数量拆分，新增一条该购买项信息
     * @param purchaseItems
     * @param itemNum
     */
    String insertItemService(PurchaseItems purchaseItems, Double itemNum);

    /**
     * 根据购买项id查找其供应商
     * @param id
     * @return
     */
    List<PurchaseSupply> findPurchasingSupplierByItemIdService(Long id);

    /**
     * 新增询价项目,新增询价商品
     * @param purchaseItemsList
     * @return
     */
    String insertSysProDetailService(PurchaseItemsListDTO purchaseItemsList);

    /**
     * 新增单个采购计划项
     * @param purchaseItems
     */
    void addPurchaseItem(PurchaseItems purchaseItems);

    /**
     * 修改采购计划项
     * @param purchaseItems
     */
    void updatePurchaseItem(PurchaseItems purchaseItems);

    /**
     * Execl导入采购计划
     * @param purchaseItemsDTO
     */
    void excelPurchaseItems(PurchaseItemsExcelImportDTO purchaseItemsDTO);

    /**
     * 检查采购计划项序号是否存在(查询数量)
     * @param projectId
     * @param serialNum
     * @return
     */
    int checkSerialNumberIsExists(Long projectId, Integer serialNum);

    /**
     * Lzc
     * 批量逻辑删除采购项
     * @param purchaseItemIds 采购项 ID数组
     */
    void logicDeletePurchaseItems(Long[] purchaseItemIds);

    /**
     * 询价结果发往采购
     * @param quoteIds
     */
    void inquiryResultSendPurchase(Long[] quoteIds, Long operator);
}
