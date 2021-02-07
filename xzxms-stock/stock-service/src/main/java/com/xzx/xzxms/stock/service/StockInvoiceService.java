package com.xzx.xzxms.stock.service;

import com.xzx.xzxms.stock.bean.StockInvoice;
import com.xzx.xzxms.stock.vo.StockInvoiceVO;
import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

/**
 * @Author sunny
 * @Date 2021/2/7 17:13
 * @Version 1.0
 */

public interface StockInvoiceService {

    /**
     * 发票上传
     * @param stockInvoice
     * @param files
     */
    void invoiceUpload(StockInvoice stockInvoice, List<SysFile> files);

    /**
     * 发票查询
     * @param contractId
     * @return
     */
    List<StockInvoiceVO> findInvoice(Long contractId);
}
