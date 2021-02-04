package com.xzx.xzxms.purchase.bean.vm;

import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;

public class PurchaseItemsAndPurchaseSupplyVM extends PurchaseItems {
    private PurchaseSupply purchaseSupply;
    public PurchaseSupply getPurchaseSupply() {
        return purchaseSupply;
    }

    public void setPurchaseSupply(PurchaseSupply purchaseSupply) {
        this.purchaseSupply = purchaseSupply;
    }
}
