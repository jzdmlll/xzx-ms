package com.xzx.xzxms.purchase.dto;

import com.xzx.xzxms.purchase.bean.PurchaseItems;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/12 11:09
 * @修改人：
 * @修改时间：2021/1/12 11:09
 * @修改描述：默认描述
 */
public class PurchaseItemsDTO {
    private PurchaseItems purchaseItems;
    private List<Long> itemIds;

    public PurchaseItems getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(PurchaseItems purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
}
