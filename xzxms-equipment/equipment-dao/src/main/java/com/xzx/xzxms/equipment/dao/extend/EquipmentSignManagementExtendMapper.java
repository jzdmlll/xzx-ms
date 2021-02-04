package com.xzx.xzxms.equipment.dao.extend;

import com.xzx.xzxms.equipment.bean.EquipmentOrder;
import com.xzx.xzxms.equipment.dto.EquipmentSignDTO;
import com.xzx.xzxms.equipment.vo.EquipmentSignVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author：ZJW
 * @title：订单签收、入库管理界面
 * @date：2021/1/29 15:46
 * @修改人：
 * @修改时间：2021/1/29 15:46
 * @修改描述：默认描述
 */
public interface EquipmentSignManagementExtendMapper {
    /**
     * 周嘉玮
     * 根据前端所传条件查询需签收、入库的购买项信息
     */
    List<EquipmentSignVO> findSignInfos(EquipmentSignDTO equipmentSignDTO);

    /**
     * 周嘉玮
     * 根据order_id获取其订单跟踪信息
     */
    EquipmentOrder findEquipmentOrderInfoByOrderId(@Param("orderId") Long orderId);
}
