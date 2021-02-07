package com.xzx.xzxms.stock.dto;

import com.xzx.xzxms.stock.bean.StockInvoice;
import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

/**
 * @Author sunny
 * @Date 2021/2/7 18:43
 * @Version 1.0
 */

public class StockInvoiceDTO {

    private StockInvoice stockInvoice;
    private List<SysFile> files;

    public StockInvoice getStockInvoice() {
        return stockInvoice;
    }

    public void setStockInvoice(StockInvoice stockInvoice) {
        this.stockInvoice = stockInvoice;
    }

    public List<SysFile> getFiles() {
        return files;
    }

    public void setFiles(List<SysFile> files) {
        this.files = files;
    }
}
