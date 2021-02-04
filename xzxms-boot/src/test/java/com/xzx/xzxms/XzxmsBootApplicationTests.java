package com.xzx.xzxms;

import com.xzx.xzxms.equipment.bean.*;
import com.xzx.xzxms.equipment.dao.extend.EquipmentSignManagementExtendMapper;
import com.xzx.xzxms.equipment.dto.*;
import com.xzx.xzxms.equipment.service.EquipmentOrderManagementService;
import com.xzx.xzxms.equipment.service.EquipmentSignManagementService;
import com.xzx.xzxms.equipment.vo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class XzxmsBootApplicationTests {
    @Autowired
    EquipmentOrderManagementService equipmentOrderManagementService;

    /**
     * 周嘉玮
     * 1、获取所有的采购项目名，及其id
     */
    @Test
    void findAllPurchaseProject(){
        List<EquipmentProjectVO> allPurchaseProjectService = equipmentOrderManagementService.findAllPurchaseProjectService();
        for (EquipmentProjectVO equipmentProjectVO : allPurchaseProjectService) {
            System.out.println(equipmentProjectVO);
        }
    }

    /**
     * 周嘉玮
     * 2、根据项目id查询该项目下所有已生效合同
     */
    @Test
    void findContractInfoByProjectId(){
        Long projectId = 20201001L;
        List<EquipmentContractVO> allEffectContracts = equipmentOrderManagementService.findAllEffectContractsByProjectIdService(projectId);
        for (EquipmentContractVO contractInfo : allEffectContracts) {
            System.out.println(contractInfo);
        }
    }

    /**
     * 周嘉玮
     * 3、根据合同id查询该合同下所有购买项信息
     */
    @Test
    void findAllItemInfosByContractId(){
        Long contractId = 1032402804L;
        List<EquipmentItemVO> allItemInfos = equipmentOrderManagementService.findAllItemInfosByContractIdService(contractId);
        for (EquipmentItemVO allItemInfo : allItemInfos) {
            System.out.println(allItemInfo);
        }
    }

    /**
     * 周嘉玮
     * 4.1、新添合同订单跟踪信息
     */
    @Test
    void insertEquipmentContractOrder(){
        EquipmentContractOrder equipmentContractOrder = new EquipmentContractOrder();
//        equipmentContractOrder.setProjectId(20201001L);
//        equipmentContractOrder.setContractId(1032402805L);
        equipmentContractOrder.setPayType("货到付款");
        equipmentContractOrder.setNeedPay(90000.00);
        equipmentContractOrder.setUnitMoney("元");
        equipmentContractOrder.setCurrency("￥");
        equipmentContractOrder.setSchedulerPayTime(new Date().getTime());
        equipmentContractOrder.setSchedulerDeliveryTime(new Date().getTime());
        equipmentContractOrder.setAlreadyPayment(0.00);
        equipmentContractOrder.setPerformanceBond(33000.0);
        equipmentContractOrder.setPerformanceBondStatus(1);
        equipmentContractOrder.setPerformanceBondPayTime(new Date().getTime());
//        equipmentContractOrder.setPerformanceBondReturnTime(); // 履约保证金归还日期
        equipmentContractOrder.setSupplierInvoice(1);
        equipmentContractOrder.setPaymentNotice(1);
        equipmentContractOrder.setActualPayment(1);
        equipmentContractOrder.setRemark("热热热热热");
        equipmentContractOrder.setOperator(1);

        EquipmentContractOrderDTO equipmentContractOrderDTO = new EquipmentContractOrderDTO();
        equipmentContractOrderDTO.setEquipmentContractOrder(equipmentContractOrder);
        equipmentContractOrderDTO.setContractId(1032402804L);

        String s = equipmentOrderManagementService.insertEquipmentContractOrderService(equipmentContractOrderDTO);
        System.out.println(s);
    }

    /**
     * 周嘉玮
     * 4.2、根据合同id获取该合同的订单跟踪信息
     */
    @Test
    void findEquipmentContractOrderInfoByContractId(){
        Long contractId = 1032402804L;
        List<EquipmentContractOrder> equipmentContractOrderInfos = equipmentOrderManagementService.findEquipmentContractOrderInfoByContractIdService(contractId);
        for (EquipmentContractOrder equipmentContractOrderInfo : equipmentContractOrderInfos) {
            System.out.println(equipmentContractOrderInfo);
        }
    }

    /**
     * 周嘉玮
     * 4.3、新添购买项订单跟踪
     */
    @Test
    void insertEquipmentOrder(){
        List<EquipmentOrder> equipmentOrders = new ArrayList<>();
        
        EquipmentOrder equipmentOrder = new EquipmentOrder();
        equipmentOrder.setItemId(78L);
        equipmentOrder.setPayType("货到付款");
        equipmentOrder.setNeedPay(7000.0);
        equipmentOrder.setUnitMoney("元");
        equipmentOrder.setCurrency("￥");
        equipmentOrder.setSchedulerPayTime(new Date().getTime()); //预定支付时间
        equipmentOrder.setSchedulerDeliveryTime(new Date().getTime()); // 预定到货时间
        equipmentOrder.setSchedulerArrivalNum(100.0); // 预定到货数量
        equipmentOrder.setUnitItem("个");
        equipmentOrder.setRemark("啊啊啊啊啊");
        equipmentOrder.setOperator("1");
        equipmentOrders.add(equipmentOrder);


        EquipmentOrder equipmentOrder1 = new EquipmentOrder();
        equipmentOrder1.setItemId(79L);
        equipmentOrder1.setPayType("货到付款");
        equipmentOrder1.setNeedPay(30756.0);
        equipmentOrder1.setUnitMoney("元");
        equipmentOrder1.setCurrency("￥");
        equipmentOrder1.setSchedulerPayTime(new Date().getTime()); //预定支付时间
        equipmentOrder1.setSchedulerDeliveryTime(new Date().getTime()); // 预定到货时间
        equipmentOrder1.setSchedulerArrivalNum(100.0); // 预定到货数量
        equipmentOrder1.setUnitItem("个");
        equipmentOrder1.setRemark("啦啦啦啦啦啦");
        equipmentOrder1.setOperator("1");
        equipmentOrders.add(equipmentOrder1);

        EquipmentOrderDTO equipmentOrderDTO = new EquipmentOrderDTO();
        equipmentOrderDTO.setEquipmentOrders(equipmentOrders);
        equipmentOrderDTO.setContractId(1032402804L);

        String s = equipmentOrderManagementService.insertEquipmentOrderService(equipmentOrderDTO);
        System.out.println(s);
    }

    /**
     * 周嘉玮
     * 4.4、获取购买项订单跟踪详情
     */
    @Test
    void findEquipmentOrderInfoByItemId(){
        Long itemId = 79L;
        EquipmentOrderVO equipmentOrderInfo = equipmentOrderManagementService.findEquipmentOrderInfoByItemIdService(itemId);
        System.out.println(equipmentOrderInfo);
    }

//    /**
//     * 周嘉玮
//     * 5.1、单个签收  Single（单个）
//     */
//    @Test
//    void insertEquipmentOrderStatusSingle(){
//        EquipmentOrderStatus equipmentOrderStatus = new EquipmentOrderStatus();
//        equipmentOrderStatus.setProjectId(20201001L);
//        equipmentOrderStatus.setContractId(1032402804L);
//        equipmentOrderStatus.setItemId(79L);
//        equipmentOrderStatus.setSupplierId(1001L);
//        equipmentOrderStatus.setOrderId(95880573L);
//        equipmentOrderStatus.setRealSignNum(20.0);
//        equipmentOrderStatus.setQualifiedNum(20.0);
//        equipmentOrderStatus.setUnqualifiedNum(0.0);
//        equipmentOrderStatus.setUnitItem("个");
//        equipmentOrderStatus.setRealSignTime(new Date().getTime());
//        equipmentOrderStatus.setSigner("1");
//        equipmentOrderStatus.setSignerTel("13312341234");
//        equipmentOrderStatus.setRemark("阿斯蒂芬");
//        equipmentOrderStatus.setOperator("1");
//        String s = equipmentOrderManagementService.insertEquipmentOrderStatusSingleService(equipmentOrderStatus);
//        System.out.println(s);
//    }
//
//
//    /**
//     * 周嘉玮
//     * 5.2、订单签收（批量）
//     * 选择批量操作默认认为所选择的购买项：全部到货，并且全部合格，并且为同一个人签收，同一时刻到货
//     */
//    @Test
//    void insertEquipmentOrderStatus(){
//        List<Long> orderIds = new ArrayList<>();
//        orderIds.add(95880573L);
//        orderIds.add(2025559637L);
//
//        EquipmentOrderStatus equipmentOrderStatus = new EquipmentOrderStatus();
//        equipmentOrderStatus.setRealSignTime(new Date().getTime());
//        equipmentOrderStatus.setSigner("1");
//        equipmentOrderStatus.setSignerTel("15212341234");
//        equipmentOrderStatus.setRemark("哈哈哈哈");
//        equipmentOrderStatus.setOperator("1");
//
//        EquipmentOrderStatusDTO equipmentOrderStatusDTO = new EquipmentOrderStatusDTO();
//        equipmentOrderStatusDTO.setEquipmentOrderStatus(equipmentOrderStatus);
//        equipmentOrderStatusDTO.setOrderId(orderIds);
//
//        String s = equipmentOrderManagementService.insertEquipmentOrderStatusService(equipmentOrderStatusDTO);
//        System.out.println(s);
//    }


    @Resource
    EquipmentSignManagementExtendMapper equipmentSignManagementExtendMapper;

    @Autowired
    EquipmentSignManagementService equipmentSignManagementService;
    

    /**
     * 周嘉玮
     * new 1、根据前端所传条件查询需签收、入库的购买项信息
     */
    @Test
    void findSignInfos(){
        EquipmentSignDTO equipmentSignDTO = new EquipmentSignDTO();
//        equipmentSignDTO.setProjectId(20201002L);
//        equipmentSignDTO.setContractId(1032402805L);
//        equipmentSignDTO.setItem("鼠标");
        equipmentSignDTO.setSupplier("美");
        List<EquipmentSignVO> signInfos = equipmentSignManagementService.findSignInfosService(equipmentSignDTO);
        for (EquipmentSignVO signInfo : signInfos) {
            System.out.println(signInfo);
        }
    }

    /**
     * 周嘉玮
     * new 2.1、单个签收  Single（单个）
     */
    @Test
    void insertEquipmentOrderStatusSingle(){
        EquipmentOrderStatus equipmentOrderStatus = new EquipmentOrderStatus();
//        equipmentOrderStatus.setProjectId(20201001L);
//        equipmentOrderStatus.setContractId(1032402804L);
//        equipmentOrderStatus.setItemId(78L);
//        equipmentOrderStatus.setSupplierId(1001L);
        equipmentOrderStatus.setOrderId(1503951919L);
        equipmentOrderStatus.setRealSignNum(20.0);
        equipmentOrderStatus.setQualifiedNum(20.0);
        equipmentOrderStatus.setUnqualifiedNum(0.0);
        equipmentOrderStatus.setUnitItem("个");
        equipmentOrderStatus.setRealSignTime(new Date().getTime());
        equipmentOrderStatus.setSigner("1");
        equipmentOrderStatus.setSignerTel("13312341234");
        equipmentOrderStatus.setRemark("阿斯蒂芬");
        equipmentOrderStatus.setOperator("1");
        String s = equipmentSignManagementService.insertEquipmentOrderStatusSingleService(equipmentOrderStatus);
        System.out.println(s);
    }


    /**
     * 周嘉玮
     * new 2.2、订单签收（批量）
     * 选择批量操作默认认为所选择的购买项：全部到货，并且全部合格，并且为同一个人签收，同一时刻到货
     */
    @Test
    void insertEquipmentOrderStatus(){
        List<Long> orderIds = new ArrayList<>();
        orderIds.add(1503951919L);
        orderIds.add(546603231L);
//        orderIds.add(1284874828L);
//        orderIds.add(1279784681L);
//        orderIds.add(1693455151L);
//        orderIds.add(1507654862L);

        EquipmentOrderStatus equipmentOrderStatus = new EquipmentOrderStatus();
        equipmentOrderStatus.setRealSignTime(new Date().getTime());
        equipmentOrderStatus.setSigner("1");
        equipmentOrderStatus.setSignerTel("15212341234");
        equipmentOrderStatus.setRemark("哈哈哈哈");
        equipmentOrderStatus.setOperator("1");

        EquipmentOrderStatusDTO equipmentOrderStatusDTO = new EquipmentOrderStatusDTO();
        equipmentOrderStatusDTO.setEquipmentOrderStatus(equipmentOrderStatus);
        equipmentOrderStatusDTO.setOrderId(orderIds);

        String s = equipmentSignManagementService.insertEquipmentOrderStatusService(equipmentOrderStatusDTO);
        System.out.println(s);
    }

    /**
     * 周嘉玮
     * new 3.2、入库（单个）
     */
    @Test
    void insertEquipmentStorageSingle(){
        EquipmentStorage equipmentStorage = new EquipmentStorage();
        equipmentStorage.setItemId(79L);
        equipmentStorage.setOperator("1");
        equipmentStorage.setRemark("嚯嚯嚯吼吼吼");

        EquipmentInStorage equipmentInStorage = new EquipmentInStorage();
        equipmentInStorage.setOrderId(546603231L);
        equipmentInStorage.setNumber(67.0);
        equipmentInStorage.setUnit("个");
        equipmentInStorage.setInTime(new Date().getTime());
        equipmentInStorage.setInOperator("1");
        equipmentInStorage.setInPhone("14414441555");
        equipmentInStorage.setInVoucher(1);
        equipmentInStorage.setRemark("哦热热热热热");
        equipmentInStorage.setOperator("1");

        EquipmentInStorageDTO equipmentInStorageDTO = new EquipmentInStorageDTO();
        equipmentInStorageDTO.setEquipmentStorage(equipmentStorage);
        equipmentInStorageDTO.setEquipmentInStorage(equipmentInStorage);

        String s = equipmentSignManagementService.insertEquipmentStorageSingleService(equipmentInStorageDTO);
        System.out.println(s);
    }



    /**
     * 周嘉玮
     * new 3.2、入库（批量）批量入库默认认为将剩余可入库数量全部入库，并且为同一个人入库
     */
    @Test
    void insertEquipmentStorage(){
        EquipmentInStorage equipmentInStorage = new EquipmentInStorage();
        equipmentInStorage.setInTime(new Date().getTime());
        equipmentInStorage.setInOperator("1");
        equipmentInStorage.setInPhone("13312341234");
        equipmentInStorage.setInVoucher(1);
        equipmentInStorage.setRemark("哦哦哦哦哦哦");
        equipmentInStorage.setOperator("1");

        List<Long> orderIds = new ArrayList<>();
        orderIds.add(546603231L);
        orderIds.add(1503951919L);

        EquipmentInStorageListDTO equipmentInStorageListDTO = new EquipmentInStorageListDTO();
        equipmentInStorageListDTO.setEquipmentInStorage(equipmentInStorage);
        equipmentInStorageListDTO.setOrderId(orderIds);

        String s = equipmentSignManagementService.insertEquipmentStorageService(equipmentInStorageListDTO);
        System.out.println(s);
    }
}
