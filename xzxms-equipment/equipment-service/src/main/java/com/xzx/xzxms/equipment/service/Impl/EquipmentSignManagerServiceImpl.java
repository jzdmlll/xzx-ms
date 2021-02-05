package com.xzx.xzxms.equipment.service.Impl;

import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.equipment.bean.*;
import com.xzx.xzxms.equipment.dao.EquipmentInStorageMapper;
import com.xzx.xzxms.equipment.dao.EquipmentOrderStatusMapper;
import com.xzx.xzxms.equipment.dao.EquipmentStorageMapper;
import com.xzx.xzxms.equipment.dao.extend.EquipmentSignManagementExtendMapper;
import com.xzx.xzxms.equipment.dto.EquipmentInStorageDTO;
import com.xzx.xzxms.equipment.dto.EquipmentInStorageListDTO;
import com.xzx.xzxms.equipment.dto.EquipmentOrderStatusDTO;
import com.xzx.xzxms.equipment.dto.EquipmentSignDTO;
import com.xzx.xzxms.equipment.service.EquipmentSignManagementService;
import com.xzx.xzxms.equipment.vo.EquipmentSignVO;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseItemsExample;
import com.xzx.xzxms.purchase.bean.PurchaseSupply;
import com.xzx.xzxms.purchase.bean.PurchaseSupplyExample;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.PurchaseSupplyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/1 11:02
 * @修改人：
 * @修改时间：2021/2/1 11:02
 * @修改描述：默认描述
 */
@Service
public class EquipmentSignManagerServiceImpl implements EquipmentSignManagementService {

    @Resource
    EquipmentSignManagementExtendMapper equipmentSignManagementExtendMapper;

    @Resource
    EquipmentOrderStatusMapper equipmentOrderStatusMapper;

    @Resource
    EquipmentInStorageMapper equipmentInStorageMapper;

    @Resource
    PurchaseItemsMapper purchaseItemsMapper;

    @Resource
    PurchaseSupplyMapper purchaseSupplyMapper;

    @Resource
    EquipmentStorageMapper equipmentStorageMapper;

    /**
     * 周嘉玮
     * new 1、根据前端所传条件查询需签收、入库的购买项信息
     */
    @Transactional
    @Override
    public List<EquipmentSignVO> findSignInfosService(EquipmentSignDTO equipmentSignDTO) {

//        要显示 已签收量，剩余签收量，已入库量，剩余可入库量

        // 获取所有已生成订单跟踪的购买项信息
        List<EquipmentSignVO> signInfos = equipmentSignManagementExtendMapper.findSignInfos(equipmentSignDTO);

        if (signInfos.size() > 0){
            for (EquipmentSignVO signInfo : signInfos) {
                // 获取设备订单跟踪主键order_id
                Long orderId = signInfo.getOrderId();
                // 获取应到货数量
                Double schedulerArrivalNum =  signInfo.getNumber();
                // 已签收数量
                Double alreadySignNum = 0.0;
                // 剩余签收数量
                Double notSignNum = 0.0;
                // 已入库量
                Double alreadyInStorageNum = 0.0;
                // 剩余可入库量
                Double notInStorageNum = 0.0;

                // 根据order_id从equipment_order_status中获取所有real_sign_num（实际签收数量）---（已签收数量）
                EquipmentOrderStatusExample equipmentOrderStatusExample = new EquipmentOrderStatusExample();
                equipmentOrderStatusExample.createCriteria().andOrderIdEqualTo(orderId).andIsActiveEqualTo(1);
                List<EquipmentOrderStatus> equipmentOrderStatuses = equipmentOrderStatusMapper.selectByExample(equipmentOrderStatusExample);
                // 当无查询结果时，说明该设备无签收记录
                if (equipmentOrderStatuses.size() == 0){
                    // 已签收量 = 0
                    signInfo.setAlreadySignNum(alreadySignNum);
                    // 剩余签收数量 = 应到货数量
                    notSignNum = schedulerArrivalNum;
                    signInfo.setNotSignNum(notSignNum);
                    // 已入库量 = 已签收量 = 0
                    signInfo.setAlreadyInStorageNum(alreadyInStorageNum);
                    // 剩余可入库量 = 已签收量 - 已入库量 = 0
                    signInfo.setNotInStorageNum(notInStorageNum);

                    // 当有查询结果时
                }else if (equipmentOrderStatuses.size() > 0){
                    // 遍历查询结果
                    for (EquipmentOrderStatus equipmentOrderStatus : equipmentOrderStatuses) {
                        // 累加已签收数量
                        alreadySignNum = alreadySignNum + equipmentOrderStatus.getRealSignNum();
                    }
                    // 已签收数量
                    signInfo.setAlreadySignNum(alreadySignNum);
                    // 剩余签收数量 = 应到货数量 - 已签收数量
                    notSignNum = schedulerArrivalNum - alreadySignNum;
                    signInfo.setNotSignNum(notSignNum);

                    // 根据order_id从equipment_in_storage中获取所有number（已入库量）
                    EquipmentInStorageExample equipmentInStorageExample = new EquipmentInStorageExample();
                    equipmentInStorageExample.createCriteria().andOrderIdEqualTo(orderId).andIsActiveEqualTo(1);
                    List<EquipmentInStorage> equipmentInStorages = equipmentInStorageMapper.selectByExample(equipmentInStorageExample);
                    // 当无查询结果时，说明无入库记录
                    if (equipmentInStorages.size() == 0){
                        // 已入库量 = 0
                        signInfo.setAlreadyInStorageNum(alreadyInStorageNum);
                        // 剩余入库量 = 0
                        signInfo.setNotInStorageNum(notInStorageNum);
                        // 当有查询结果时
                    }else if (equipmentInStorages.size() > 0){
                        // 遍历查询结果
                        for (EquipmentInStorage equipmentInStorage : equipmentInStorages) {
                            // 将入库记录累计
                            alreadyInStorageNum = alreadySignNum + equipmentInStorage.getNumber();
                            // 已入库量
                            signInfo.setAlreadyInStorageNum(alreadyInStorageNum);
                            // 剩余可入库量 = 已签收量 - 已入库量
                            notInStorageNum = alreadySignNum - alreadyInStorageNum;
                            if (notInStorageNum >= 0) {
                                signInfo.setNotInStorageNum(notInStorageNum);
                            } else {
                                signInfo.setNotInStorageNum(0.0);
                            }
                        }
                    }
                }
            }
        }
        return signInfos;
    }

    /**
     * 周嘉玮
     * new 2.1、单个签收  Single（单个）
     */
    @Transactional
    @Override
    public String insertEquipmentOrderStatusSingleService(EquipmentOrderStatus equipmentOrderStatus) {
        equipmentOrderStatus.setId(IDUtils.getId());
        equipmentOrderStatus.setTime(new Date().getTime());
        equipmentOrderStatus.setIsActive(1);

        Long orderId = equipmentOrderStatus.getOrderId();
        //根据order_id在equipment_order表中获取该订单的 scheduler_arrival_num（应到货数量）
        EquipmentOrder equipmentOrderInfo = equipmentSignManagementExtendMapper.findEquipmentOrderInfoByOrderId(orderId);
        // 应到货数量
        Double schedulerArrivalNum = 0.0;
        if (equipmentOrderInfo != null && equipmentOrderInfo.getSchedulerArrivalNum() != null){
            // 应到货数量
            schedulerArrivalNum = equipmentOrderInfo.getSchedulerArrivalNum();
        }else {
            throw new CustomerException("该购买项无预定到货数量，请重新核对信息！");
        }

        // 根据OrderId从equipment_order_status中获取所有real_sign_num（实际签收数量）---（已签收数量）
        EquipmentOrderStatusExample equipmentOrderStatusExample = new EquipmentOrderStatusExample();
        equipmentOrderStatusExample.createCriteria().andOrderIdEqualTo(orderId).andIsActiveEqualTo(1);
        List<EquipmentOrderStatus> equipmentOrderStatuses = equipmentOrderStatusMapper.selectByExample(equipmentOrderStatusExample);

        // 剩余签收数量
        Double notSignNum = 0.0;

        // 已签收数量
        Double alreadySignNum = 0.0;

        // 本次签收数量
        Double realSignNum = equipmentOrderStatus.getRealSignNum();

        // 当无查询结果时，说明该购买项无签收记录
        if (equipmentOrderStatuses.size() == 0){
            // 剩余签收数量
            notSignNum = schedulerArrivalNum;
        }else if (equipmentOrderStatuses.size() > 0){
            // 遍历集合将real_sign_num累加
            for (EquipmentOrderStatus orderStatus : equipmentOrderStatuses) {
                // 累加已签收数量
                alreadySignNum = alreadySignNum + orderStatus.getRealSignNum();
            }
            // 剩余签收数量 = 应到货数量 -  签收数量累加
            notSignNum = schedulerArrivalNum - alreadySignNum;
        }

        // 如果 剩余签收数量 >= 本次的签收数量 并且剩余签收数量不等于0 则正常走流程签收；
        if (notSignNum >= realSignNum && notSignNum != 0){
            equipmentOrderStatusMapper.insert(equipmentOrderStatus);
            // 如果 剩余签收数量 < 本次的签收数量 则抛出异常提示刷新页面
        }else if (notSignNum < realSignNum){
            throw new CustomerException("本次签收数量大于剩余签收数量，请刷新页面，重新填选！");
        }else if (notSignNum == 0){
            throw new CustomerException("该采购项已全部签收，请勿再次签收！");
        }
        return "success";
    }

    /**
     * 周嘉玮
     * new 2.2、订单签收（批量）
     * 选择批量操作默认认为所选择的购买项：全部到货，并且全部合格，并且为同一个人签收，同一时刻到货
     */
    @Transactional
    @Override
    public String insertEquipmentOrderStatusService(EquipmentOrderStatusDTO equipmentOrderStatusDTOS) {
        // 剩余签收数量
        Double notSignNum = 0.0;
        // 已签收数量
        Double schedulerArrivalNum = 0.0;

        // 获取需要批量签收的所有购买项的订单跟踪id
        List<Long> orderIds = equipmentOrderStatusDTOS.getOrderId();
        for (Long orderId : orderIds) {
            /*
            在equipment_order表中获取该订单的 scheduler_arrival_num（应到货数量）、 unit_item（单位）、
            project_id、contract_id、item_id、supplier_id；
             */
            EquipmentOrder equipmentOrderInfo = equipmentSignManagementExtendMapper.findEquipmentOrderInfoByOrderId(orderId);
            if (equipmentOrderInfo != null && equipmentOrderInfo.getSchedulerArrivalNum() != null){
                // 应到货数量
                schedulerArrivalNum = equipmentOrderInfo.getSchedulerArrivalNum();
            }else {
                throw new CustomerException("该购买项无预定到货数量，请重新核对信息！");
            }
            // 本次签收数量
            Double realSignNum = 0.0;
            // 合格数量
            Double qualifiedNum = 0.0;
            // 不合格数量
            Double unqualifiedNum = 0.0;
            // 已签收数量
            Double alreadySignNum = 0.0;

            Long id = IDUtils.getId();
            EquipmentOrderStatus equipmentOrderStatus = new EquipmentOrderStatus();
            equipmentOrderStatus.setId(id);
//            equipmentOrderStatus.setProjectId(equipmentOrderInfo.getProjectId());
//            equipmentOrderStatus.setContractId(equipmentOrderInfo.getContractId());
//            equipmentOrderStatus.setItemId(equipmentOrderInfo.getItemId());
//            equipmentOrderStatus.setSupplierId(equipmentOrderInfo.getSupplierId());
            equipmentOrderStatus.setOrderId(orderId);
            equipmentOrderStatus.setUnqualifiedNum(unqualifiedNum); // 批量签收默认认为无不合格产品
            equipmentOrderStatus.setUnitItem(equipmentOrderInfo.getUnitItem());
            equipmentOrderStatus.setRealSignTime(equipmentOrderStatusDTOS.getEquipmentOrderStatus().getRealSignTime());
            equipmentOrderStatus.setSigner(equipmentOrderStatusDTOS.getEquipmentOrderStatus().getSigner());
            equipmentOrderStatus.setSignerTel(equipmentOrderStatusDTOS.getEquipmentOrderStatus().getSignerTel());
            equipmentOrderStatus.setRemark(equipmentOrderStatusDTOS.getEquipmentOrderStatus().getRemark());
            equipmentOrderStatus.setOperator(equipmentOrderStatusDTOS.getEquipmentOrderStatus().getOperator());
            equipmentOrderStatus.setTime(new Date().getTime());
            equipmentOrderStatus.setIsActive(1);

            // 根据OrderId从equipment_order_status中获取所有real_sign_num（实际签收数量）---（已签收数量）
            EquipmentOrderStatusExample equipmentOrderStatusExample = new EquipmentOrderStatusExample();
            equipmentOrderStatusExample.createCriteria().andOrderIdEqualTo(orderId).andIsActiveEqualTo(1);
            List<EquipmentOrderStatus> equipmentOrderStatuses = equipmentOrderStatusMapper.selectByExample(equipmentOrderStatusExample);
            // 当无查询结果时，说明该购买项无签收记录
            if (equipmentOrderStatuses.size() == 0){
                // 剩余签收数量 = 应到货数量
                notSignNum = schedulerArrivalNum;
                // 本次签收数量
                realSignNum = notSignNum;
                // 合格数量
                qualifiedNum = notSignNum;

                equipmentOrderStatus.setRealSignNum(realSignNum);
                equipmentOrderStatus.setQualifiedNum(qualifiedNum);
            } else if (equipmentOrderStatuses.size() > 0){
                // 遍历查询结果
                for (EquipmentOrderStatus orderStatus : equipmentOrderStatuses) {
                    // 累加已签收数量
                    alreadySignNum = alreadySignNum + orderStatus.getRealSignNum();
                }
                // 剩余签收数量 = 应到货数量 - 已签收数量
                notSignNum = schedulerArrivalNum - alreadySignNum;
                if (notSignNum > 0){
                    // 本次签收数量
                    realSignNum = notSignNum;
                    // 合格数量
                    qualifiedNum = notSignNum;
                    // 批量签收默认认为剩下未签收货物全部签收并且全部合格
                    equipmentOrderStatus.setRealSignNum(realSignNum);
                    equipmentOrderStatus.setQualifiedNum(qualifiedNum);
                }else if (notSignNum == 0){
                    throw new CustomerException("该采购项已全部签收，请勿再次签收！");
                }
            }

            equipmentOrderStatusMapper.insert(equipmentOrderStatus);

        }

        return "success";
    }

    /**
     * 周嘉玮
     * new 3.1、入库（单个）
     */
    @Transactional
    @Override
    public String insertEquipmentStorageSingleService(EquipmentInStorageDTO equipmentInStorageDTO) {

        if (equipmentInStorageDTO.getEquipmentInStorage().getNumber() == 0){
            return "入库数量不能为0！";
        }else {
            // 拿到入库设备的item_id
            Long itemId = equipmentInStorageDTO.getEquipmentStorage().getItemId();
            // 获取order_id
            Long orderId = equipmentInStorageDTO.getEquipmentInStorage().getOrderId();
            // 获取此次入库数量
            Double InStorageNum = equipmentInStorageDTO.getEquipmentInStorage().getNumber();

            // 计算可入库数量，可入库数量 = 已签收数量 - 已入库数量
            Double canInStorageNum = 0.0;
            // 计算已签收数量
            Double alreadySignNum = 0.0;
            // 根据OrderId从equipment_order_status中获取所有real_sign_num（实际签收数量）---（已签收数量）
            EquipmentOrderStatusExample equipmentOrderStatusExample = new EquipmentOrderStatusExample();
            equipmentOrderStatusExample.createCriteria().andOrderIdEqualTo(orderId).andIsActiveEqualTo(1);
            List<EquipmentOrderStatus> equipmentOrderStatuses = equipmentOrderStatusMapper.selectByExample(equipmentOrderStatusExample);

            // 当无查询结果时，说明该购买项无签收记录
            if (equipmentOrderStatuses.size() == 0){
                // 可入库数量为0
                return "可入库数量为0";
            }else if (equipmentOrderStatuses.size() > 0){
                // 遍历集合将real_sign_num累加
                for (EquipmentOrderStatus orderStatus : equipmentOrderStatuses) {
                    // 累加已签收数量
                    alreadySignNum = alreadySignNum + orderStatus.getRealSignNum();
                }
                System.out.println("已签收量：" + alreadySignNum);

                // 获取已入库数量
                Double alreadyInStorageNum = 0.0;
                // 根据order_id从equipment_in_storage中获取所有number（已入库量）
                EquipmentInStorageExample equipmentInStorageExample = new EquipmentInStorageExample();
                equipmentInStorageExample.createCriteria().andOrderIdEqualTo(orderId).andIsActiveEqualTo(1);
                List<EquipmentInStorage> equipmentInStorages = equipmentInStorageMapper.selectByExample(equipmentInStorageExample);
                // 当无查询结果时，说明无入库记录
                if (equipmentInStorages.size() == 0){
                    // 可入库量 = 已签收量
                    canInStorageNum = alreadySignNum;
                    // 当有查询结果时
                }else if (equipmentInStorages.size() > 0) {
                    // 遍历查询结果
                    for (EquipmentInStorage equipmentInStorage : equipmentInStorages) {
                        // 将入库记录累计
                        alreadyInStorageNum = alreadyInStorageNum + equipmentInStorage.getNumber();
                    }
                    // 可入库量 = 已签收量 - 已入库量
                    canInStorageNum = alreadySignNum - alreadyInStorageNum;
                }
                System.out.println("库入库数量：" + canInStorageNum);
                // 可入库数量 >= 此次入库数量 即可入库
                if (canInStorageNum >= InStorageNum) {
                    // 库存id
                    Long storageId = null;

                    // 根据item_id从equipment_storage表中获取该设备的库存信息
                    EquipmentStorageExample equipmentStorageExample = new EquipmentStorageExample();
                    equipmentStorageExample.createCriteria().andItemIdEqualTo(itemId).andIsActiveEqualTo(1);
                    List<EquipmentStorage> equipmentStorages = equipmentStorageMapper.selectByExample(equipmentStorageExample);
                    // 如果有查询结果并且有库存量，则做数量更新
                    if (equipmentStorages.size() > 0){
                        EquipmentStorage equipmentStorage = equipmentStorages.get(0);
                        if (equipmentStorage.getNumber() != null){
                            // 新库存数量 = 旧库存数量 + 此次入库数量
                            Double NewNumber = equipmentStorage.getNumber() + InStorageNum;
                            equipmentStorage.setNumber(NewNumber);
                            equipmentStorageMapper.updateByExample(equipmentStorage, equipmentStorageExample);
                            // 库存id
                            storageId = equipmentStorage.getId();
                        }
                        // 否则做新增
                    }else {
                        // 根据item_id从purchase_items表中获取该设备的详细信息
                        PurchaseItemsExample purchaseItemsExample = new PurchaseItemsExample();
                        purchaseItemsExample.createCriteria().andIdEqualTo(itemId).andIsActiveEqualTo(1);
                        List<PurchaseItems> purchaseItems = purchaseItemsMapper.selectByExample(purchaseItemsExample);
                        // item_id是唯一编码，所以所得结果必为一条数据
                        PurchaseItems purchaseItem = purchaseItems.get(0);

                        // 根据item_id从purchase_supply表中获取该设备的供应商信息
                        PurchaseSupplyExample purchaseSupplyExample = new PurchaseSupplyExample();
                        purchaseSupplyExample.createCriteria().andItemIdEqualTo(itemId).andIsActiveEqualTo(1);
                        List<PurchaseSupply> purchaseSupplies = purchaseSupplyMapper.selectByExample(purchaseSupplyExample);
                        // item_id是唯一编码，所以所得结果必为一条数据
                        PurchaseSupply purchaseSupply = purchaseSupplies.get(0);

                        // 新建一个库存对象
                        EquipmentStorage equipmentStorageN = new EquipmentStorage();
                        storageId = IDUtils.getId();
                        equipmentStorageN.setId(storageId);
                        equipmentStorageN.setProjectId(purchaseItem.getProjectId());
                        equipmentStorageN.setItemId(purchaseItem.getId());
                        equipmentStorageN.setItem(purchaseItem.getItem());
                        equipmentStorageN.setUnit(purchaseItem.getUnit());
                        equipmentStorageN.setParams(purchaseItem.getParams());
                        equipmentStorageN.setModel(purchaseItem.getModel());
                        equipmentStorageN.setNumber(InStorageNum);
                        equipmentStorageN.setSupplierId(purchaseSupply.getSupplierId());
//                        equipmentStorageN.setRemark(purchaseItem.getRemark());
//                        equipmentStorageN.setOperator(purchaseItem.getOperator());
                        equipmentStorageN.setTime(new Date().getTime());
                        equipmentStorageN.setIsActive(1);
                        equipmentStorageN.setTagNumer(purchaseItem.getTagNumer());
                        equipmentStorageN.setMeter(purchaseItem.getMeter());
                        equipmentStorageN.setMeasuringRange(purchaseItem.getMeasuringRange());
                        equipmentStorageN.setMeterSignal(purchaseItem.getMeterSignal());
                        equipmentStorageN.setConnectionMode(purchaseItem.getConnectionMode());
                        equipmentStorageN.setTube(purchaseItem.getTube());
                        // 入库
                        equipmentStorageMapper.insert(equipmentStorageN);
                    }

                    // 新增入库日志信息
                    EquipmentInStorage equipmentInStorage = equipmentInStorageDTO.getEquipmentInStorage();
                    equipmentInStorage.setId(IDUtils.getId());
                    equipmentInStorage.setStorageId(storageId);
                    equipmentInStorage.setTime(new Date().getTime());
                    equipmentInStorage.setIsActive(1);
                    equipmentInStorageMapper.insert(equipmentInStorage);
                } else {
                    return "此次入库数量大于可入库数量，请刷新页面重新选择入库！";
                }
            }
            return "success";
        }
    }


    /**
     * 周嘉玮
     * new 3.2、入库（批量）批量入库默认认为将剩余可入库数量全部入库，并且为同一个人入库
     */
    @Transactional
    @Override
    public String insertEquipmentStorageService(EquipmentInStorageListDTO equipmentInStorageListDTO) {
        // 获取订单跟踪id
        List<Long> orderIds = equipmentInStorageListDTO.getOrderId();

        for (Long orderId : orderIds) {
            // 根据OrderId从equipment_order_status中获取所有real_sign_num（实际签收数量）---（已签收数量）
            EquipmentOrderStatusExample equipmentOrderStatusExample = new EquipmentOrderStatusExample();
            equipmentOrderStatusExample.createCriteria().andOrderIdEqualTo(orderId).andIsActiveEqualTo(1);
            List<EquipmentOrderStatus> equipmentOrderStatuses = equipmentOrderStatusMapper.selectByExample(equipmentOrderStatusExample);

            Double alreadySignNum = 0.0;
            Double canInStorageNum = 0.0;
            // 当无查询结果时，说明该购买项无签收记录
            if (equipmentOrderStatuses.size() == 0){
                // 可入库数量为0
                return "存在购买项可入库数量为0，请刷新页面！";
            }else if (equipmentOrderStatuses.size() > 0) {
                // 遍历集合将real_sign_num累加
                for (EquipmentOrderStatus orderStatus : equipmentOrderStatuses) {
                    // 累加已签收数量
                    alreadySignNum = alreadySignNum + orderStatus.getRealSignNum();
                }

                // 获取已入库数量
                Double alreadyInStorageNum = 0.0;
                // 根据order_id从equipment_in_storage中获取所有number（已入库量）
                EquipmentInStorageExample equipmentInStorageExample = new EquipmentInStorageExample();
                equipmentInStorageExample.createCriteria().andOrderIdEqualTo(orderId).andIsActiveEqualTo(1);
                List<EquipmentInStorage> equipmentInStorages = equipmentInStorageMapper.selectByExample(equipmentInStorageExample);
                // 当无查询结果时，说明无入库记录
                if (equipmentInStorages.size() == 0){
                    // 可入库量 = 已签收量
                    canInStorageNum = alreadySignNum;
                    // 当有查询结果时
                }else if (equipmentInStorages.size() > 0) {
                    // 遍历查询结果
                    for (EquipmentInStorage equipmentInStorage : equipmentInStorages) {
                        // 将入库记录累计
                        alreadyInStorageNum = alreadyInStorageNum + equipmentInStorage.getNumber();
                    }
                    // 可入库量 = 已签收量 - 已入库量
                    canInStorageNum = alreadySignNum - alreadyInStorageNum;
                }

                // 可入库数量 > 0 即可入库
                if (canInStorageNum > 0) {
                    // 库存id
                    Long storageId = null;
//===========================================================================
                    // 根据order_id从purchase_items表中获取该设备的详细信息
                    PurchaseItemsExample purchaseItemsExample = new PurchaseItemsExample();
                    purchaseItemsExample.createCriteria().andOrderIdEqualTo(orderId).andIsActiveEqualTo(1);
                    List<PurchaseItems> purchaseItems = purchaseItemsMapper.selectByExample(purchaseItemsExample);
                    if (purchaseItems.size() > 0){
                        // order_id是唯一编码，所以所得结果必为一条数据
                        PurchaseItems purchaseItem = purchaseItems.get(0);
                        // 获取该订单的item_id
                        Long itemId = purchaseItem.getId();
                        // 根据item_id从equipment_storage表中获取该设备的库存信息
                        EquipmentStorageExample equipmentStorageExample = new EquipmentStorageExample();
                        equipmentStorageExample.createCriteria().andItemIdEqualTo(itemId).andIsActiveEqualTo(1);
                        List<EquipmentStorage> equipmentStorages = equipmentStorageMapper.selectByExample(equipmentStorageExample);
                        // 如果有查询结果并且有库存量，则做数量更新
                        if (equipmentStorages.size() > 0){
                            EquipmentStorage equipmentStorage = equipmentStorages.get(0);
                            if (equipmentStorage.getNumber() != null){
                                // 新库存数量 = 旧库存数量 + 可入库数量
                                Double NewNumber = equipmentStorage.getNumber() + canInStorageNum;
                                equipmentStorage.setNumber(NewNumber);
                                equipmentStorageMapper.updateByExample(equipmentStorage, equipmentStorageExample);
                                // 库存id
                                storageId = equipmentStorage.getId();
                            }
                            // 否则做新增
                        }else {
                            // 根据item_id从purchase_supply表中获取该设备的供应商信息
                            PurchaseSupplyExample purchaseSupplyExample = new PurchaseSupplyExample();
                            purchaseSupplyExample.createCriteria().andItemIdEqualTo(itemId).andIsActiveEqualTo(1);
                            List<PurchaseSupply> purchaseSupplies = purchaseSupplyMapper.selectByExample(purchaseSupplyExample);
                            // item_id是唯一编码，所以所得结果必为一条数据
                            PurchaseSupply purchaseSupply = purchaseSupplies.get(0);

                            // 新建一个库存对象
                            EquipmentStorage equipmentStorageN = new EquipmentStorage();
                            storageId = IDUtils.getId();
                            equipmentStorageN.setId(storageId);
                            equipmentStorageN.setProjectId(purchaseItem.getProjectId());
                            equipmentStorageN.setItemId(purchaseItem.getId());
                            equipmentStorageN.setItem(purchaseItem.getItem());
                            equipmentStorageN.setUnit(purchaseItem.getUnit());
                            equipmentStorageN.setParams(purchaseItem.getParams());
                            equipmentStorageN.setModel(purchaseItem.getModel());
                            equipmentStorageN.setNumber(canInStorageNum);
                            equipmentStorageN.setSupplierId(purchaseSupply.getSupplierId());
                            equipmentStorageN.setRemark(equipmentInStorageListDTO.getEquipmentInStorage().getRemark());
                            equipmentStorageN.setOperator(equipmentInStorageListDTO.getEquipmentInStorage().getOperator());
                            equipmentStorageN.setTime(new Date().getTime());
                            equipmentStorageN.setIsActive(1);
                            equipmentStorageN.setTagNumer(purchaseItem.getTagNumer());
                            equipmentStorageN.setMeter(purchaseItem.getMeter());
                            equipmentStorageN.setMeasuringRange(purchaseItem.getMeasuringRange());
                            equipmentStorageN.setMeterSignal(purchaseItem.getMeterSignal());
                            equipmentStorageN.setConnectionMode(purchaseItem.getConnectionMode());
                            equipmentStorageN.setTube(purchaseItem.getTube());
                            // 入库
                            equipmentStorageMapper.insert(equipmentStorageN);
                        }

                        // 新增入库日志信息
                        EquipmentInStorage equipmentInStorage = equipmentInStorageListDTO.getEquipmentInStorage();
                        equipmentInStorage.setId(IDUtils.getId());
                        equipmentInStorage.setOrderId(orderId);
                        equipmentInStorage.setStorageId(storageId);
                        equipmentInStorage.setNumber(canInStorageNum);
                        equipmentInStorage.setUnit(purchaseItem.getUnit());
                        equipmentInStorage.setTime(new Date().getTime());
                        equipmentInStorage.setIsActive(1);
                        equipmentInStorageMapper.insert(equipmentInStorage);
                    }else {
                        return "请核对该订单跟踪是否存在！";
                    }
                }else {
                    return "存在购买项可入库数量为0，请刷新页面！";
                }
            }
        }
        return "success";
    }
}
