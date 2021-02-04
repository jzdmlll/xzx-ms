package com.xzx.xzxms.equipment.dto;

import com.xzx.xzxms.equipment.bean.EquipmentInStorage;
import com.xzx.xzxms.equipment.bean.EquipmentStorage;
import com.xzx.xzxms.equipment.vo.EquipmentSignVO;

import java.util.List;

/**
 * @author：ZJW
 * @title：单个入库
 * @date：2021/2/3 15:52
 * @修改人：
 * @修改时间：2021/2/3 15:52
 * @修改描述：默认描述
 */
public class EquipmentInStorageDTO {
    private EquipmentStorage equipmentStorage;
    private EquipmentInStorage equipmentInStorage;

    public EquipmentStorage getEquipmentStorage() {
        return equipmentStorage;
    }

    public void setEquipmentStorage(EquipmentStorage equipmentStorage) {
        this.equipmentStorage = equipmentStorage;
    }

    public EquipmentInStorage getEquipmentInStorage() {
        return equipmentInStorage;
    }

    public void setEquipmentInStorage(EquipmentInStorage equipmentInStorage) {
        this.equipmentInStorage = equipmentInStorage;
    }
}
