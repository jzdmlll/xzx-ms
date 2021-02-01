package com.xzx.xzxms.equipment.vo;

/**
 * @author：ZJW
 * @title：用于获取每个项目下已通过审核的合同
 * @date：2021/1/24 15:02
 * @修改人：
 * @修改时间：2021/1/24 15:02
 * @修改描述：默认描述
 */
public class EquipmentContractVO {
    private Long id;
    private String contractName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    @Override
    public String toString() {
        return "EquipmentContractVO{" +
                "id=" + id +
                ", contractName='" + contractName + '\'' +
                '}';
    }
}
