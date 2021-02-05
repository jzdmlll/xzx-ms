package com.xzx.xzxms.equipment.dto;/**
 * @Author sunny
 * @Date 2021/2/1 17:07
 * @Version 1.0
 */

import com.xzx.xzxms.equipment.bean.EquipmentInvoice;
import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

/**
 *@ClassName InvoiceUploadDTO
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public class InvoiceUploadDTO {

    private EquipmentInvoice equipmentInvoice;
    private List<SysFile> files;

    public EquipmentInvoice getEquipmentInvoice() {
        return equipmentInvoice;
    }

    public void setEquipmentInvoice(EquipmentInvoice equipmentInvoice) {
        this.equipmentInvoice = equipmentInvoice;
    }

    public List<SysFile> getFiles() {
        return files;
    }

    public void setFiles(List<SysFile> files) {
        this.files = files;
    }
}
