package com.xzx.xzxms.equipment.dao.extend;

import com.xzx.xzxms.equipment.vo.EquipmentStorageVO;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/4 15:41
 * @修改人：
 * @修改时间：2021/2/4 15:41
 * @修改描述：默认描述
 */
public interface EquipmentStorageManagementExtendMapper {
    /**
     * 周嘉玮
     * new 4、根据所传条件查询库存信息
     */
    List<EquipmentStorageVO> findStorageInfos(EquipmentStorageVO equipmentStorageVO);
}
