package com.xzx.xzxms.stock.vo;/**
 * @Author sunny
 * @Date 2021/2/8 14:48
 * @Version 1.0
 */

import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;

/**
 *@ClassName StockCheckVO
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public class StockCheckVO extends PurchaseItems {

    private PurchaseSupply purchaseSupply;
    private Double notSignedNum;

    public PurchaseSupply getPurchaseSupply() {
        return purchaseSupply;
    }

    public void setPurchaseSupply(PurchaseSupply purchaseSupply) {
        this.purchaseSupply = purchaseSupply;
    }

    public Double getNotSignedNum() {
        return notSignedNum;
    }

    public void setNotSignedNum(Double notSignedNum) {
        this.notSignedNum = notSignedNum;
    }
}
