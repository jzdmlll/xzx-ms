package com.xzx.xzxms.equipment.service;/**
 * @Author sunny
 * @Date 2021/2/1 17:03
 * @Version 1.0
 */

import com.xzx.xzxms.equipment.bean.EquipmentInvoice;
import com.xzx.xzxms.equipment.vo.InvoiceVO;
import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

/**
 *@ClassName InvoiceService
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface InvoiceService {

    /**
     * 发票上传
     * @param equipmentInvoice
     * @param files
     */
    void invoiceUpload(EquipmentInvoice equipmentInvoice, List<SysFile> files);

    /**
     * 发票查询
     * @param contractId
     * @return
     */
    List<InvoiceVO> findInvoice(Long contractId);
}
