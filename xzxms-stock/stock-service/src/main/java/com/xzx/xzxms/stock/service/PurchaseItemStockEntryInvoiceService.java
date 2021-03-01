package com.xzx.xzxms.stock.service;

import com.xzx.xzxms.stock.vo.PurchaseItemStockEntryInvoiceVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/2/26 17:20
 * @Version 1.0
 */
public interface PurchaseItemStockEntryInvoiceService {
    /**
     * 根据采购合同Id查找采购项验收、入库信息
     * @param contractId
     * @return
     */
    List<PurchaseItemStockEntryInvoiceVO> findPurchaseItemStockEntryInvoiceByContractId(@Param("contractId") Long contractId);
}
