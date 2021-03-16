package com.xzx.xzxms.purchase.vo;/**
 * @Author sunny
 * @Date 2021/3/16 16:22
 * @Version 1.0
 */

import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;

/**
 *@ClassName SaleItemsVO
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public class SaleItemsVO extends PurchaseItems {

    private PurchaseSupply purchaseSupply;

    public PurchaseSupply getPurchaseSupply() {
        return purchaseSupply;
    }

    public void setPurchaseSupply(PurchaseSupply purchaseSupply) {
        this.purchaseSupply = purchaseSupply;
    }
}
