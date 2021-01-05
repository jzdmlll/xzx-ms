package com.xzx.xzxms.purchase.dto;

import com.xzx.xzxms.purchase.bean.PurchaseContract;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/5 11:21
 * @修改人：
 * @修改时间：2021/1/5 11:21
 * @修改描述：默认描述
 */
public class PurchaseContractDTO {
    private PurchaseContract purchaseContract;
    private List<Long> itemIds;

    public PurchaseContract getPurchaseContract() {
        return purchaseContract;
    }

    public void setPurchaseContract(PurchaseContract purchaseContract) {
        this.purchaseContract = purchaseContract;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
}
