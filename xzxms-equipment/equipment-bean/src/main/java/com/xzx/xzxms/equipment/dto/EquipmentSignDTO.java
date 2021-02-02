package com.xzx.xzxms.equipment.dto;

/**
 * @author：ZJW
 * @title：用于签收、入库界面查询签收信息
 * @date：2021/2/1 9:58
 * @修改人：
 * @修改时间：2021/2/1 9:58
 * @修改描述：默认描述
 */
public class EquipmentSignDTO {
    private Long projectId;
    private Long contractId;
    private String item;
    private String Supplier;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }
}
