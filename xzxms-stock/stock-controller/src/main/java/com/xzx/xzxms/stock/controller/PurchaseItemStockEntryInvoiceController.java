package com.xzx.xzxms.stock.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.stock.service.PurchaseItemStockEntryInvoiceService;
import com.xzx.xzxms.stock.vo.PurchaseItemStockEntryInvoiceVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/2/26 17:23
 * @Version 1.0
 */
@RequestMapping("/stock/purchaseItemStockEntryInvoice")
@RestController
public class PurchaseItemStockEntryInvoiceController {
    @Resource
    private PurchaseItemStockEntryInvoiceService purchaseItemStockEntryInvoiceService;

    /**
     * 根据采购合同Id查找采购项验收、入库信息
     * @param contractId
     * @return
     */
    @GetMapping("findPurchaseItemStockEntryInvoiceByContractId")
    public Message findPurchaseItemStockEntryInvoiceByContractId(Long contractId) {
        List<PurchaseItemStockEntryInvoiceVO> purchaseItemStockEntryInvoiceVOS = purchaseItemStockEntryInvoiceService.findPurchaseItemStockEntryInvoiceByContractId(contractId);
        return MessageUtil.success("success", purchaseItemStockEntryInvoiceVOS);
    }
}
