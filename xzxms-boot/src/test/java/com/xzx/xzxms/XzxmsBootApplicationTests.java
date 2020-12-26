package com.xzx.xzxms;

import com.xzx.xzxms.inquiry.bean.SysProDetail;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.service.PurchaseContractManagementService;
import com.xzx.xzxms.purchase.service.PurchasePlanService;
import com.xzx.xzxms.purchase.service.impl.PurchaseContractManagementServiceImpl;
import com.xzx.xzxms.purchase.service.impl.PurchasePlanServiceImpl;
import com.xzx.xzxms.purchase.vm.PurchaseContractVM;
import com.xzx.xzxms.purchase.vm.PurchaseProjectVM;
import com.xzx.xzxms.purchase.vm.PurchaseSupplierVM;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class XzxmsBootApplicationTests {

    @Autowired
    PurchaseContractManagementService purchaseContractManagementService;

    @Autowired
    PurchasePlanService purchasePlanService;
    
    @Test
    void test(){
        String project_name = "2";
        List<PurchaseProjectVM> list = purchaseContractManagementService.findAllProjectsService(project_name);
        for (PurchaseProjectVM s : list) {
            System.out.println(s);
        }
    }

    @Test
    void ContractTest(){
        Long projectId = 20201001L;
        List<PurchaseContractVM> list = purchaseContractManagementService.findContractByProjectId(projectId);
        for (PurchaseContractVM purchaseContractVM : list) {
            System.out.println(purchaseContractVM);
        }
    }

    @Test
    void update(){
        Integer firstAudit = 1;
        Integer secondAudit = 0;
        Integer threeAudit = 0;
        Long id = 1L;
        String s = purchaseContractManagementService.updateContractAuditByIdService(firstAudit, secondAudit, threeAudit, id);
        System.out.println(s);
    }

    @Test
    void updateInquiry(){
        String projectId = "20201001";
        List<Long> idList = new ArrayList<>();
        idList.add(7l);
        idList.add(77l);
        String s = purchasePlanService.updateItemsInquiryService(projectId, idList);
        System.out.println("========== "+s);

    }

    @Test
    void findNum(){
        PurchaseItems purchaseItems = new PurchaseItems();
        purchaseItems.setId(80L);
        purchaseItems.setContractId(6L);
        purchaseItems.setProjectId("20201001");
        purchaseItems.setSerialNumber(4);
        purchaseItems.setItem("鼠标");
        purchaseItems.setBrand("罗技");
        purchaseItems.setParams("1200dpi");
        purchaseItems.setModel("G304");
        purchaseItems.setUnit("个");
        purchaseItems.setNumber(199);
        purchaseItems.setIsInquiry(0);
        purchaseItems.setRemark("啦啦啦");
        purchaseItems.setIsActive(1);
        purchaseItems.setOperator(1L);
        purchaseItems.setTime(1608618132L);

        int itemNum = 123;
        purchasePlanService.insertItemService(purchaseItems, itemNum);
    }

    @Test
    void findInfo(){
        Long id = 7L;
        List<PurchaseSupplierVM> purchasingSupplierByItemIdService = purchasePlanService.findPurchasingSupplierByItemIdService(id);
    }

    @Test
    void insertProject(){
        String project_name = "智能综合管理系统";
        SysProDetail sysProDetail = new SysProDetail();
        sysProDetail.setName(project_name);
        String proNameByProName = purchasePlanService.insertSysProDetail(sysProDetail);
        System.out.println(proNameByProName);
    }
}
