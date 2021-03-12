package com.xzx.xzxms.purchase.vo;/**
 * @Author sunny
 * @Date 2021/3/12 14:16
 * @Version 1.0
 */

import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;

/**
 *@ClassName SupplyByContractIdVO
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public class SupplyByContractIdVO extends PurchaseItems {

    private PurchaseSupply purchaseSupply;

    public PurchaseSupply getPurchaseSupply() {
        return purchaseSupply;
    }

    public void setPurchaseSupply(PurchaseSupply purchaseSupply) {
        this.purchaseSupply = purchaseSupply;
    }
}
