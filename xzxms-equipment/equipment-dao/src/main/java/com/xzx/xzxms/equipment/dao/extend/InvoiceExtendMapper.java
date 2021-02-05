package com.xzx.xzxms.equipment.dao.extend;/**
 * @Author sunny
 * @Date 2021/2/1 20:50
 * @Version 1.0
 */

import com.xzx.xzxms.equipment.vo.InvoiceVO;

import java.util.List;

/**
 *@ClassName InvoiceExtendMapper
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface InvoiceExtendMapper{

    /**
     * sunny
     * 根据合同ID查询出所有的发票图片
     * @param contractId
     * @return
     */
    List<InvoiceVO> findInvoiceByContractId(Long contractId);
}
