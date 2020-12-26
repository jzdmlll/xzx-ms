package com.xzx.xzxms.purchase.vm;

/**
 * @author：ZJW
 * @title：采购供应商
 * @date：2020/12/23 11:05
 * @修改人：
 * @修改时间：2020/12/23 11:05
 * @修改描述：默认描述
 */
public class PurchaseSupplierVM {
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
