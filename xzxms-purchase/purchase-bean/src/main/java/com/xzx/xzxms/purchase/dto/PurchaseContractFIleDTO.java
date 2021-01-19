package com.xzx.xzxms.purchase.dto;

import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.system.bean.SysFile;
import lombok.Data;

import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/1/19 10:52
 * @Version 1.0
 */
@Data
public class PurchaseContractFIleDTO {
    /**
     * purchaseContract 采购合同
     */
    private PurchaseContract purchaseContract;
    /**
     * fileList 文件List
     */
    private List<SysFile> fileList;
}
