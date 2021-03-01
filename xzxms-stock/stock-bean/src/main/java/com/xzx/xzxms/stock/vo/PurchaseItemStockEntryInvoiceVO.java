package com.xzx.xzxms.stock.vo;

import com.xzx.xzxms.purchase.bean.PurchaseSupply;
import com.xzx.xzxms.stock.bean.StockCheck;
import com.xzx.xzxms.stock.bean.StockEntry;

import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/2/26 15:26
 * @Version 1.0
 */
public class PurchaseItemStockEntryInvoiceVO extends PurchaseSupply {

    // 设备名
    private String name;
    // 验收记录
    List<StockCheck> stockChecks;
    // 入库记录
    List<StockEntry> stockEntries;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StockCheck> getStockChecks() {
        return stockChecks;
    }

    public void setStockChecks(List<StockCheck> stockChecks) {
        this.stockChecks = stockChecks;
    }

    public List<StockEntry> getStockEntries() {
        return stockEntries;
    }

    public void setStockEntries(List<StockEntry> stockEntries) {
        this.stockEntries = stockEntries;
    }
}
