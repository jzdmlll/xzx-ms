package com.xzx.xzxms.purchase.vm;

import com.xzx.xzxms.inquiry.bean.SysProDetailWithBLOBs;
import com.xzx.xzxms.purchase.bean.PurchaseItems;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/28 10:45
 * @修改人：
 * @修改时间：2020/12/28 10:45
 * @修改描述：默认描述
 */
public class PurchaseItemsListVM {
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
