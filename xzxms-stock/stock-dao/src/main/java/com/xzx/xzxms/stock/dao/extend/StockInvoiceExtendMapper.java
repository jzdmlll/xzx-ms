package com.xzx.xzxms.stock.dao.extend;

import com.xzx.xzxms.stock.vo.StockInvoiceVO;

import java.util.List;

/**
 * @Author sunny
 * @Date 2021/2/7 17:32
 * @Version 1.0
 */
public interface StockInvoiceExtendMapper {

    /**
     * sunny
     * 根据合同ID查询出所有的发票图片
     * @param contractId
     * @return
     */
    List<StockInvoiceVO> findInvoiceByContractId(Long contractId);
}
