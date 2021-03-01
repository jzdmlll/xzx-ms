package com.xzx.xzxms.stock.dao.extend;

import com.xzx.xzxms.stock.vo.PurchaseItemStockEntryInvoiceVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/2/26 15:53
 * @Version 1.0
 */
public interface PurchaseItemStockEntryInvoiceExtendMapper {
    /**
     * 根据采购合同Id查找采购项验收、入库信息
     * @param contractId
     * @return
     */
    List<PurchaseItemStockEntryInvoiceVO> findPurchaseItemStockEntryInvoiceByContractId(@Param("contractId") Long contractId);
}
