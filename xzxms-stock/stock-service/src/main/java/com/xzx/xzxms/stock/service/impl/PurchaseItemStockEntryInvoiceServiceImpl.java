package com.xzx.xzxms.stock.service.impl;

import com.xzx.xzxms.stock.bean.StockCheck;
import com.xzx.xzxms.stock.bean.StockEntry;
import com.xzx.xzxms.stock.dao.extend.PurchaseItemStockEntryInvoiceExtendMapper;
import com.xzx.xzxms.stock.service.PurchaseItemStockEntryInvoiceService;
import com.xzx.xzxms.stock.vo.PurchaseItemStockEntryInvoiceVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/2/26 17:21
 * @Version 1.0
 */
@Service
public class PurchaseItemStockEntryInvoiceServiceImpl implements PurchaseItemStockEntryInvoiceService {
    @Resource
    private PurchaseItemStockEntryInvoiceExtendMapper purchaseItemStockEntryInvoiceExtendMapper;
    @Override
    public List<PurchaseItemStockEntryInvoiceVO> findPurchaseItemStockEntryInvoiceByContractId(Long contractId) {
        List<PurchaseItemStockEntryInvoiceVO> PurchaseItemStockEntryInvoiceVOS =
                purchaseItemStockEntryInvoiceExtendMapper.findPurchaseItemStockEntryInvoiceByContractId(contractId);

        for (PurchaseItemStockEntryInvoiceVO entryInvoiceVO : PurchaseItemStockEntryInvoiceVOS) {
            Double checkNum = 0D;
            Double entryNum = 0D;
            for ( StockCheck stockCheck : entryInvoiceVO.getStockChecks() ) {
                checkNum += stockCheck.getCheckNumber();
            }
            for ( StockEntry stockEntry : entryInvoiceVO.getStockEntries() ) {
                entryNum += stockEntry.getEntryNumber();
            }
            entryInvoiceVO.setCheckNum(checkNum);
            entryInvoiceVO.setEntryNum(entryNum);
        }

        return PurchaseItemStockEntryInvoiceVOS;
    }
}
