package com.xzx.xzxms.purchase.vm;/**
 * @Author sunny
 * @Date 2020/12/30 13:50
 * @Version 1.0
 */

import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.purchase.bean.PurchaseContract;

import java.util.List;

/**
 *@ClassName QuotePurchaseVM
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public class QuotePurchaseVM {

    private List<Quote> quoteList;
    private PurchaseContract purchaseContract;

    public List<Quote> getQuoteList() {
        return quoteList;
    }

    public void setQuoteList(List<Quote> quoteList) {
        this.quoteList = quoteList;
    }

    public PurchaseContract getPurchaseContract() {
        return purchaseContract;
    }

    public void setPurchaseContract(PurchaseContract purchaseContract) {
        this.purchaseContract = purchaseContract;
    }
}
