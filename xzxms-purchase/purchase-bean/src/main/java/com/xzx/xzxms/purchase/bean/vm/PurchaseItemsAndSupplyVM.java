package com.xzx.xzxms.purchase.bean.vm;


import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;

public class PurchaseItemsAndSupplyVM  extends PurchaseItems {

    private PurchaseSupply purchaseSupply;
    private String purchaseProName;

    public String getPurchaseProName() {
        return purchaseProName;
    }

    public void setPurchaseProName(String purchaseProName) {
        this.purchaseProName = purchaseProName;
    }

    public PurchaseSupply getPurchaseSupply() {
        return purchaseSupply;
    }

    public void setPurchaseSupply(PurchaseSupply purchaseSupply) {
        this.purchaseSupply = purchaseSupply;
    }
}
