package com.xzx.xzxms.purchase.vo;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/8 14:53
 * @修改人：
 * @修改时间：2021/1/8 14:53
 * @修改描述：默认描述
 */
public class PurchaseSupplierVO {
    private Integer serialNumber;
    private String name;

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PurchaseSupplierVM{" +
                "serialNumber=" + serialNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
