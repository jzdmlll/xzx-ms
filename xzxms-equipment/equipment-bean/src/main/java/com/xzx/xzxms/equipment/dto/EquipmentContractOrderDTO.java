package com.xzx.xzxms.equipment.dto;

import com.xzx.xzxms.equipment.bean.EquipmentContractOrder;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/2 14:12
 * @修改人：
 * @修改时间：2021/2/2 14:12
 * @修改描述：默认描述
 */
public class EquipmentContractOrderDTO {
    private EquipmentContractOrder equipmentContractOrder;
    private Long contractId;

    public EquipmentContractOrder getEquipmentContractOrder() {
        return equipmentContractOrder;
    }

    public void setEquipmentContractOrder(EquipmentContractOrder equipmentContractOrder) {
        this.equipmentContractOrder = equipmentContractOrder;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    @Override
    public String toString() {
        return "EquipmentContractOrderDTO{" +
                "equipmentContractOrder=" + equipmentContractOrder +
                ", contractId=" + contractId +
                '}';
    }
}
