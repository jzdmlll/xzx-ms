package com.xzx.xzxms.equipment.service;

import com.xzx.xzxms.equipment.bean.EquipmentFile;

import java.util.List;

/**
 * @author：ZJW
 * @title：文件图片上传
 * @date：2021/2/7 11:15
 * @修改人：
 * @修改时间：2021/2/7 11:15
 * @修改描述：默认描述
 */
public interface EquipmentFileService {

    /**
     * 1-履约保证金
     */
    String insertPerformanceFileService(List<EquipmentFile> fileList);
    /**
     * 2-供货发票
     */
    String insertSupplierInvoiceFileService(List<EquipmentFile> fileList);
    /**
     * 3-付款通知单
     */
    String insertPaymentNoticeFileService(List<EquipmentFile> fileList);
    /**
     * 4-实际付款
     */
    String insertActualPaymentFileService(List<EquipmentFile> fileList);

    /**
     * 公共方法
     */
    List<EquipmentFile> FileService(List<EquipmentFile> fileList);
}
