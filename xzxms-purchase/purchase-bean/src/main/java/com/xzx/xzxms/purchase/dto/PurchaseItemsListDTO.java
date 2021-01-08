package com.xzx.xzxms.purchase.dto;

import com.xzx.xzxms.inquiry.bean.SysProDetailWithBLOBs;
import com.xzx.xzxms.purchase.bean.PurchaseItems;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/8 15:20
 * @修改人：
 * @修改时间：2021/1/8 15:20
 * @修改描述：默认描述
 */
public class PurchaseItemsListDTO {
    private List<PurchaseItems> purchaseItemsList;
    private SysProDetailWithBLOBs sysProDetailWithBLOBs;
    public List<PurchaseItems> getPurchaseItemsList() {
        return purchaseItemsList;
    }

    public void setPurchaseItemsList(List<PurchaseItems> purchaseItemsList) {
        this.purchaseItemsList = purchaseItemsList;
    }

    public SysProDetailWithBLOBs getSysProDetailWithBLOBs() {
        return sysProDetailWithBLOBs;
    }

    public void setSysProDetailWithBLOBs(SysProDetailWithBLOBs sysProDetailWithBLOBs) {
        this.sysProDetailWithBLOBs = sysProDetailWithBLOBs;
    }
}
