package com.xzx.xzxms.equipment.dto;

import com.xzx.xzxms.equipment.bean.EquipmentOrder;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/2 15:42
 * @修改人：
 * @修改时间：2021/2/2 15:42
 * @修改描述：默认描述
 */
public class EquipmentOrderDTO {
    private List<EquipmentOrder> equipmentOrders;
    private Long contractId;

    public List<EquipmentOrder> getEquipmentOrders() {
        return equipmentOrders;
    }

    public void setEquipmentOrders(List<EquipmentOrder> equipmentOrders) {
        this.equipmentOrders = equipmentOrders;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
}
