package com.xzx.xzxms;

import com.xzx.xzxms.purchase.service.PurchaseContractManagementService;
import com.xzx.xzxms.purchase.service.impl.PurchaseContractManagementServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
class XzxmsBootApplicationTests {

    @Autowired
    PurchaseContractManagementService purchaseContractManagementService;
    
    @Test
    void test(){
        String project_name = "2";
        List<String> list = purchaseContractManagementService.FindAllProjectsService(project_name);
        for (String s : list) {
            System.out.println(s);
            
        }

    }

    @Test
    void contextLoads() {
    }

}
