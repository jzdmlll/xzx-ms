package com.xzx.xzxms.purchase.dto;

import com.xzx.xzxms.purchase.bean.PurchaseItems;

import java.util.List;

/**
 * @Author Lzc
 * @Date 2021/1/12 15:51
 * @Version 1.0
 */
public class PurchaseItemsExcelImportDTO {

    private List<PurchaseItems> purchaseItems;

    public List<PurchaseItems> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(List<PurchaseItems> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }
}
