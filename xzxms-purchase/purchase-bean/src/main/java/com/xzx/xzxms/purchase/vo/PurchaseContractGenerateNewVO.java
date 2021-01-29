package com.xzx.xzxms.purchase.vo;/**
 * @Author sunny
 * @Date 2021/1/29 13:42
 * @Version 1.0
 */

import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;

/**
 *@ClassName PurchaseContractGenerateNewVO
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public class PurchaseContractGenerateNewVO extends PurchaseItems {

    private PurchaseSupply purchaseSupply;

    public PurchaseSupply getPurchaseSupply() {
        return purchaseSupply;
    }

    public void setPurchaseSupply(PurchaseSupply purchaseSupply) {
        this.purchaseSupply = purchaseSupply;
    }
}
