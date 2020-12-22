package com.xzx.xzxms.purchase.bean.vm;

import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.bean.PurchaseContractAttribute;

public class PurchaseContractAndContractAttributeVM extends PurchaseContractAttribute {
    private PurchaseContract purchaseContract;
    public PurchaseContract getPurchaseContract() {
        return purchaseContract;
    }

    public void setPurchaseContract(PurchaseContract purchaseContract) {
        this.purchaseContract = purchaseContract;
    }
}
