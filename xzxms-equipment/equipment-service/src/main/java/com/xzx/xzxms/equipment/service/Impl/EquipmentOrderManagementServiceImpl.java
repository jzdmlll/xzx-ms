package com.xzx.xzxms.equipment.service.Impl;

import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.equipment.bean.EquipmentContractOrder;
import com.xzx.xzxms.equipment.bean.EquipmentOrder;
import com.xzx.xzxms.equipment.bean.EquipmentOrderStatus;
import com.xzx.xzxms.equipment.bean.EquipmentOrderStatusExample;
import com.xzx.xzxms.equipment.dao.EquipmentContractOrderMapper;
import com.xzx.xzxms.equipment.dao.EquipmentOrderMapper;
import com.xzx.xzxms.equipment.dao.EquipmentOrderStatusMapper;
import com.xzx.xzxms.equipment.dao.extend.EquipmentOrderManagementExtendMapper;
import com.xzx.xzxms.equipment.dto.EquipmentContractOrderDTO;
import com.xzx.xzxms.equipment.dto.EquipmentOrderDTO;
import com.xzx.xzxms.equipment.service.EquipmentOrderManagementService;
import com.xzx.xzxms.equipment.vo.EquipmentContractVO;
import com.xzx.xzxms.equipment.vo.EquipmentItemVO;
import com.xzx.xzxms.equipment.vo.EquipmentOrderVO;
import com.xzx.xzxms.equipment.vo.EquipmentProjectVO;
import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.bean.PurchaseContractExample;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseItemsExample;
import com.xzx.xzxms.purchase.dao.PurchaseContractMapper;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/24 12:08
 * @修改人：
 * @修改时间：2021/1/24 12:08
 * @修改描述：默认描述
 */
@Service
public class EquipmentOrderManagementServiceImpl implements EquipmentOrderManagementService {

    @Resource
    EquipmentOrderManagementExtendMapper equipmentOrderManagementExtendMapper;

    @Resource
    EquipmentOrderMapper equipmentOrderMapper;

    @Resource
    EquipmentContractOrderMapper equipmentContractOrderMapper;

    @Resource
    PurchaseItemsMapper purchaseItemsMapper;

    @Resource
    EquipmentOrderStatusMapper equipmentOrderStatusMapper;

    @Resource
    PurchaseContractMapper purchaseContractMapper;

    /**
     * 周嘉玮
     * 1、获取所有的采购项目名，及其id
     */
    @Override
    public List<EquipmentProjectVO> findAllPurchaseProjectService() {
        List<EquipmentProjectVO> allPurchaseProject = equipmentOrderManagementExtendMapper.findAllPurchaseProject();
        return allPurchaseProject;
    }

    /**
     * 周嘉玮
     * 2、根据项目id查询该项目下所有已生效合同
     */
    @Override
    public List<EquipmentContractVO> findAllEffectContractsByProjectIdService(Long projectId) {
        List<EquipmentContractVO> allEffectContracts = equipmentOrderManagementExtendMapper.findAllEffectContractsByProjectId(projectId);
        return allEffectContracts;
    }

    /**
     * 周嘉玮
     * 3、根据合同id查询该合同下所有购买项信息
     */
    @Override
    public List<EquipmentItemVO> findAllItemInfosByContractIdService(Long contractId) {
        List<EquipmentItemVO> allItemInfos = equipmentOrderManagementExtendMapper.findAllItemInfosByContractId(contractId);
        for (EquipmentItemVO allItemInfo : allItemInfos) {
            // 总价 = 购买数量 * 供货商提供的单价
            allItemInfo.setTotalPrice(allItemInfo.getNumber() * allItemInfo.getPrice());
        }
        return allItemInfos;
    }

    /**
     * 周嘉玮
     * 4.1、新添合同订单跟踪信息
     */
    @Transactional
    @Override
    public String insertEquipmentContractOrderService(EquipmentContractOrderDTO equipmentContractOrderDTO) {
        // 获取合同id
        Long contractId = equipmentContractOrderDTO.getContractId();
        // 1、根据contract_id从purchase_contract表中获取数据
        PurchaseContractExample purchaseContractExample = new PurchaseContractExample();
        purchaseContractExample.createCriteria().andIdEqualTo(contractId).andIsActiveEqualTo(1).andContractStatusEqualTo(1);
        List<PurchaseContract> purchaseContracts = purchaseContractMapper.selectByExample(purchaseContractExample);
        // 判断是否存在该合同
        if (purchaseContracts.size() > 0){
            // contract_id在合同表中是唯一的，所以当存在查询结果时，集合中只存在一条数据
            PurchaseContract purchaseContract = purchaseContracts.get(0);
            // 判断该合同是否已经生成了订单跟踪
            if (purchaseContract.getContactOrderId() == null){
                EquipmentContractOrder equipmentContractOrder = equipmentContractOrderDTO.getEquipmentContractOrder();
                // 生成主键id
                Long contractOrderId = IDUtils.getId();
                equipmentContractOrder.setId(contractOrderId);
                // 生成跟踪订单默认为未完成--0
                equipmentContractOrder.setOrderStatus(0);
                // 录入时间
                equipmentContractOrder.setTime(new Date().getTime());
                // 设置为有效数据
                equipmentContractOrder.setIsActive(1);
                // 插入数据库表equipment_contract_order
                equipmentContractOrderMapper.insert(equipmentContractOrder);
                // 绑定合同订单跟踪id
                purchaseContract.setContactOrderId(contractOrderId);
                purchaseContractMapper.updateByExampleSelective(purchaseContract, purchaseContractExample);
                return "success";
            }else {
                return "该合同已存在订单跟踪";
            }
        }else {
//            throw new CustomerException("查无此合同！");
            return "查无此合同！";
        }
    }

    /**
     * 周嘉玮
     * 4.2、根据合同id获取该合同的订单跟踪信息
     */
    @Override
    public List<EquipmentContractOrder> findEquipmentContractOrderInfoByContractIdService(Long contractId) {
//        EquipmentContractOrderExample equipmentContractOrderExample = new EquipmentContractOrderExample();
//        // 根据条件查询
//        equipmentContractOrderExample.createCriteria().andContractIdEqualTo(contractId).andIsActiveEqualTo(1);
//        List<EquipmentContractOrder> equipmentContractOrders = equipmentContractOrderMapper.selectByExample(equipmentContractOrderExample);
//        return equipmentContractOrders;
        return null;
    }

    /**
     * 周嘉玮
     * 4.3、新添购买项订单跟踪
     */
    @Transactional
    @Override
    public String insertEquipmentOrderService(EquipmentOrderDTO equipmentOrderDTO) {
        if (equipmentOrderDTO.getEquipmentOrders().size() > 0){
            // 首先判断该设备是否可以生成订单跟踪，根据合同id去合同表中查询是否已生成了合同订单跟踪
            // 根据contract_id从purchase_contract表中获取数据
            PurchaseContractExample purchaseContractExample = new PurchaseContractExample();
            purchaseContractExample.createCriteria().andIdEqualTo(equipmentOrderDTO.getContractId()).andIsActiveEqualTo(1).andContractStatusEqualTo(1);
            List<PurchaseContract> purchaseContracts = purchaseContractMapper.selectByExample(purchaseContractExample);
            // 判断是否存在该合同
            if (purchaseContracts.size() > 0){
                // contract_id在合同表中是唯一的，所以当存在查询结果时，集合中只存在一条数据
                PurchaseContract purchaseContract = purchaseContracts.get(0);
                // 判断该合同是否已经生成了订单跟踪         已生成
                if (purchaseContract.getContactOrderId() != null){
                    // 获取合同订单跟踪id
                    Long contractOrderId = purchaseContract.getContactOrderId();
                    for (EquipmentOrder equipmentOrder : equipmentOrderDTO.getEquipmentOrders()) {
                        // 根据item_id从purchase_items表中获取数据
                        PurchaseItemsExample purchaseItemsExample = new PurchaseItemsExample();
                        purchaseItemsExample.createCriteria().andIdEqualTo(equipmentOrder.getItemId()).andIsActiveEqualTo(1);
                        List<PurchaseItems> purchaseItems = purchaseItemsMapper.selectByExample(purchaseItemsExample);
                        if (purchaseItems.size() > 0) {
                            // item_id在采购项表中是唯一的，所以当存在查询结果时，集合中只存在一条数据
                            PurchaseItems purchaseItem = purchaseItems.get(0);
                            // 判断该采购项是否已经生成了订单跟踪  未生成
                            if (purchaseItem.getOrderId() == null) {
                                // 生成主键
                                Long orderId = IDUtils.getId();
                                equipmentOrder.setId(orderId);
                                // 绑定合同订单跟踪id
                                equipmentOrder.setContractOrderId(contractOrderId);
                                // 录入时间
                                equipmentOrder.setTime(new Date().getTime());
                                // 是否有效 0-无效；1-有效
                                equipmentOrder.setIsActive(1);
                                // 插入数据库表equipment_order
                                equipmentOrderMapper.insert(equipmentOrder);
                                // 在purchase_items表中绑定order_id
                                PurchaseItems purchaseItems1 = new PurchaseItems();
                                purchaseItems1.setOrderId(orderId);
                                purchaseItemsMapper.updateByExampleSelective(purchaseItems1, purchaseItemsExample);
                            } else {
                                return "该采购项已存在订单跟踪";
                            }
                        } else {
                            return "查无此项！";
                        }
                    }
                    return "success";
                }else {
                    return "该合同已未生成订单跟踪，请先生成合同订单跟踪！";
                }
            }else {
                return "查无此合同！";
            }
        }else {
            return "error";
        }
    }

    /**
     * 周嘉玮
     * 4.4、获取购买项订单跟踪详情
     */
    @Transactional
    @Override
    public EquipmentOrderVO findEquipmentOrderInfoByItemIdService(Long itemId) {
        EquipmentOrderVO equipmentOrderInfo = equipmentOrderManagementExtendMapper.findEquipmentOrderInfoByItemId(itemId);
        // 获取设备订单跟踪主键id
        Long id = equipmentOrderInfo.getId();
        // 获取应到货数量
        Double schedulerArrivalNum =  equipmentOrderInfo.getSchedulerArrivalNum();
        // 剩余签收数量
        Double notSignNum = 0.0;
        // 已签收数量
        Double alreadySignNum = 0.0;

        // 根据id从equipment_order_status中获取所有real_sign_num（实际签收数量）---（已签收数量）
        EquipmentOrderStatusExample equipmentOrderStatusExample = new EquipmentOrderStatusExample();
        equipmentOrderStatusExample.createCriteria().andOrderIdEqualTo(id).andIsActiveEqualTo(1);
        List<EquipmentOrderStatus> equipmentOrderStatuses = equipmentOrderStatusMapper.selectByExample(equipmentOrderStatusExample);
        // 当无查询结果时，说明该设备无签收记录
        if (equipmentOrderStatuses.size() == 0){
            // 剩余签收数量 = 应到货数量
            notSignNum = equipmentOrderInfo.getSchedulerArrivalNum();
            equipmentOrderInfo.setNotSignNum(notSignNum);
            // 当有查询结果时
        }else if (equipmentOrderStatuses.size() > 0){
            // 遍历查询结果
            for (EquipmentOrderStatus equipmentOrderStatus : equipmentOrderStatuses) {
                // 累加已签收数量
                alreadySignNum = alreadySignNum + equipmentOrderStatus.getRealSignNum();
            }
            // 剩余签收数量 = 应到货数量 - 已签收数量
            notSignNum = equipmentOrderInfo.getSchedulerArrivalNum() - alreadySignNum;
            equipmentOrderInfo.setNotSignNum(notSignNum);
        }

        return equipmentOrderInfo;
    }

    /**
     * 周嘉玮
     * 5.1、单个签收  Single（单个）
     */
//    @Transactional
//    @Override
//    public String insertEquipmentOrderStatusSingleService(EquipmentOrderStatus equipmentOrderStatus) {
//        equipmentOrderStatus.setId(IDUtils.getId());
//        equipmentOrderStatus.setTime(new Date().getTime());
//        equipmentOrderStatus.setIsActive(1);
//
//        Long orderId = equipmentOrderStatus.getOrderId();
//        //根据order_id在equipment_order表中获取该订单的 scheduler_arrival_num（应到货数量）
//        EquipmentOrder equipmentOrderInfo = equipmentOrderManagementExtendMapper.findEquipmentOrderInfoByOrderId(orderId);
//        // 应到货数量
//        Double schedulerArrivalNum = 0.0;
//        if (equipmentOrderInfo != null && equipmentOrderInfo.getSchedulerArrivalNum() != null){
//            // 应到货数量
//            schedulerArrivalNum = equipmentOrderInfo.getSchedulerArrivalNum();
//        }else {
//            throw new CustomerException("该购买项无预定到货数量，请重新核对信息！");
//        }
//
//
//        // 根据OrderId从equipment_order_status中获取所有real_sign_num（实际签收数量）---（已签收数量）
//        EquipmentOrderStatusExample equipmentOrderStatusExample = new EquipmentOrderStatusExample();
//        equipmentOrderStatusExample.createCriteria().andOrderIdEqualTo(orderId).andIsActiveEqualTo(1);
//        List<EquipmentOrderStatus> equipmentOrderStatuses = equipmentOrderStatusMapper.selectByExample(equipmentOrderStatusExample);
//
//        // 剩余签收数量
//        Double notSignNum = 0.0;
//
//        // 已签收数量
//        Double alreadySignNum = 0.0;
//
//        // 本次签收数量
//        Double realSignNum = equipmentOrderStatus.getRealSignNum();
//
//        // 当无查询结果时，说明该购买项无签收记录
//        if (equipmentOrderStatuses.size() == 0){
//            // 剩余签收数量
//            notSignNum = schedulerArrivalNum;
//        }else if (equipmentOrderStatuses.size() > 0){
//            // 遍历集合将real_sign_num累加
//            for (EquipmentOrderStatus orderStatus : equipmentOrderStatuses) {
//                // 累加已签收数量
//                alreadySignNum = alreadySignNum + orderStatus.getRealSignNum();
//            }
//            // 剩余签收数量 = 应到货数量 -  签收数量累加
//            notSignNum = schedulerArrivalNum - alreadySignNum;
//        }
//
//        // 如果 剩余签收数量 >= 本次的签收数量 则正常走流程签收；
//        if (notSignNum >= realSignNum){
//            equipmentOrderStatusMapper.insert(equipmentOrderStatus);
//            // 如果 剩余签收数量 < 本次的签收数量 则抛出异常提示刷新页面
//        }else if (notSignNum < realSignNum){
//            throw new CustomerException("本次签收数量大于剩余签收数量，请刷新页面，重新填选！");
//        }
//        return "success";
//    }

    /**
     * 周嘉玮
     * 5.2、订单签收（批量）
     * 选择批量操作默认认为所选择的购买项：全部到货，并且全部合格，并且为同一个人签收，同一时刻到货
     */
//    @Transactional
//    @Override
//    public String insertEquipmentOrderStatusService(EquipmentOrderStatusDTO equipmentOrderStatusDTOS) {
//        // 剩余签收数量
//        Double notSignNum = 0.0;
//        // 已签收数量
//        Double schedulerArrivalNum = 0.0;
//
//        // 获取需要批量签收的所有购买项的订单跟踪id
//        List<Long> orderIds = equipmentOrderStatusDTOS.getOrderId();
//        for (Long orderId : orderIds) {
//            /*
//            在equipment_order表中获取该订单的 scheduler_arrival_num（应到货数量）、 unit_item（单位）、
//            project_id、contract_id、item_id、supplier_id；
//             */
//            EquipmentOrder equipmentOrderInfo = equipmentOrderManagementExtendMapper.findEquipmentOrderInfoByOrderId(orderId);
//            if (equipmentOrderInfo != null && equipmentOrderInfo.getSchedulerArrivalNum() != null){
//                // 应到货数量
//                schedulerArrivalNum = equipmentOrderInfo.getSchedulerArrivalNum();
//            }else {
//                throw new CustomerException("该购买项无预定到货数量，请重新核对信息！");
//            }
//            // 本次签收数量
//            Double realSignNum = 0.0;
//            // 合格数量
//            Double qualifiedNum = 0.0;
//            // 不合格数量
//            Double unqualifiedNum = 0.0;
//            // 已签收数量
//            Double alreadySignNum = 0.0;
//
//            Long id = IDUtils.getId();
//            EquipmentOrderStatus equipmentOrderStatus = new EquipmentOrderStatus();
//            equipmentOrderStatus.setId(id);
//            equipmentOrderStatus.setProjectId(equipmentOrderInfo.getProjectId());
//            equipmentOrderStatus.setContractId(equipmentOrderInfo.getContractId());
//            equipmentOrderStatus.setItemId(equipmentOrderInfo.getItemId());
//            equipmentOrderStatus.setSupplierId(equipmentOrderInfo.getSupplierId());
//            equipmentOrderStatus.setOrderId(orderId);
//            equipmentOrderStatus.setUnqualifiedNum(unqualifiedNum); // 批量签收默认认为无不合格产品
//            equipmentOrderStatus.setUnitItem(equipmentOrderInfo.getUnitItem());
//            equipmentOrderStatus.setRealSignTime(equipmentOrderStatusDTOS.getEquipmentOrderStatus().getRealSignTime());
//            equipmentOrderStatus.setSigner(equipmentOrderStatusDTOS.getEquipmentOrderStatus().getSigner());
//            equipmentOrderStatus.setSignerTel(equipmentOrderStatusDTOS.getEquipmentOrderStatus().getSignerTel());
//            equipmentOrderStatus.setRemark(equipmentOrderStatusDTOS.getEquipmentOrderStatus().getRemark());
//            equipmentOrderStatus.setOperator(equipmentOrderStatusDTOS.getEquipmentOrderStatus().getOperator());
//            equipmentOrderStatus.setTime(new Date().getTime());
//            equipmentOrderStatus.setIsActive(1);
//
//            // 根据OrderId从equipment_order_status中获取所有real_sign_num（实际签收数量）---（已签收数量）
//            EquipmentOrderStatusExample equipmentOrderStatusExample = new EquipmentOrderStatusExample();
//            equipmentOrderStatusExample.createCriteria().andOrderIdEqualTo(orderId).andIsActiveEqualTo(1);
//            List<EquipmentOrderStatus> equipmentOrderStatuses = equipmentOrderStatusMapper.selectByExample(equipmentOrderStatusExample);
//            // 当无查询结果时，说明该购买项无签收记录
//            if (equipmentOrderStatuses.size() == 0){
//                // 剩余签收数量 = 应到货数量
//                notSignNum = schedulerArrivalNum;
//                // 本次签收数量
//                realSignNum = notSignNum;
//                // 合格数量
//                qualifiedNum = notSignNum;
//
//                equipmentOrderStatus.setRealSignNum(realSignNum);
//                equipmentOrderStatus.setQualifiedNum(qualifiedNum);
//            } else if (equipmentOrderStatuses.size() > 0){
//                // 遍历查询结果
//                for (EquipmentOrderStatus orderStatus : equipmentOrderStatuses) {
//                    // 累加已签收数量
//                    alreadySignNum = alreadySignNum + orderStatus.getRealSignNum();
//                }
//                // 剩余签收数量 = 应到货数量 - 已签收数量
//                notSignNum = schedulerArrivalNum - alreadySignNum;
//                // 本次签收数量
//                realSignNum = notSignNum;
//                // 合格数量
//                qualifiedNum = notSignNum;
//                // 批量签收默认认为剩下未签收货物全部签收并且全部合格
//                equipmentOrderStatus.setRealSignNum(realSignNum);
//                equipmentOrderStatus.setQualifiedNum(qualifiedNum);
//            }
//
//            equipmentOrderStatusMapper.insert(equipmentOrderStatus);
//
//        }
//
//        return "success";
//    }


}
