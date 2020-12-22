package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseItemsExample;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchasePlanExtendMapper;
import com.xzx.xzxms.purchase.service.PurchasePlanService;
import com.xzx.xzxms.purchase.vm.PurchaseItemsVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/21 15:15
 * @修改人：
 * @修改时间：2020/12/21 15:15
 * @修改描述：默认描述
 */
@Service
public class PurchasePlanServiceImpl implements PurchasePlanService {

    @Autowired
    PurchasePlanExtendMapper purchasePlanExtendMapper;

    @Resource
    private PurchaseItemsMapper purchaseItemsMapper;

    /**
     * 根据项目id查询该项目下的所有购买项
     * @param projectId
     * @return
     */
    @Override
    public List<PurchaseItemsVM> findItemsByProjectIdService(String projectId) {
        List<PurchaseItemsVM> itemsList = purchasePlanExtendMapper.findItemsByProjectId(projectId);
        return itemsList;
    }

    @Override
    public String updateItemsInquiryService(String projectId, List<Long> idList) {
        PurchaseItemsExample purchaseItemsExample = new PurchaseItemsExample();
        purchaseItemsExample.createCriteria().andProjectIdEqualTo(projectId).andIdIn(idList);
        PurchaseItems purchaseItems = new PurchaseItems();
        purchaseItems.setIsInquiry(1);
        //purchaseItemsMapper.updateByExample(purchaseItems, purchaseItemsExample);
        purchaseItemsMapper.updateByExampleSelective(purchaseItems, purchaseItemsExample);
        return "success";
    }
}
