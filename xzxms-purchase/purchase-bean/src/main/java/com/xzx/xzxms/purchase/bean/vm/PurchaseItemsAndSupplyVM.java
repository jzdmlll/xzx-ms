package com.xzx.xzxms.purchase.bean.vm;

import com.xzx.xzxms.inquiry.bean.Supplier;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;

public class PurchaseItemsAndSupplyVM  extends PurchaseItems {
    private PurchaseSupply purchaseSupply;
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }





    public PurchaseSupply getPurchaseSupply() {
        return purchaseSupply;
    }

    public void setPurchaseSupply(PurchaseSupply purchaseSupply) {
        this.purchaseSupply = purchaseSupply;
    }
}
