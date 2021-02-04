package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.bean.PurchaseContractExample;
import com.xzx.xzxms.purchase.dao.PurchaseContractMapper;
import com.xzx.xzxms.purchase.service.PurchaseContractAuditService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/14 22:59
 * @修改人：
 * @修改时间：2021/1/14 22:59
 * @修改描述：默认描述
 */
@Service
public class PurchaseContractAuditServiceImpl implements PurchaseContractAuditService {

    @Resource
    PurchaseContractMapper purchaseContractMapper;

    /**
     * 周嘉玮
     * 根据合同id修改该合同当前审核级别的信息
     * @param purchaseContract
     * @return
     */
    @Override
    public String updateContractAuditInfoByIdService(PurchaseContract purchaseContract) {

        PurchaseContractExample purchaseContractExample = new PurchaseContractExample();
        purchaseContractExample.createCriteria().andIdEqualTo(purchaseContract.getId());

        if (purchaseContract.getFirstAudit() != null && purchaseContract.getFirstAudit() != 0) {
            purchaseContract.setFirstTime(new Date().getTime());
        }

        if (purchaseContract.getSecondAudit() != null && purchaseContract.getSecondAudit() != 0){
            purchaseContract.setSecondTime(new Date().getTime());
        }

        if (purchaseContract.getThreeAudit() != null && purchaseContract.getThreeAudit() != 0){
            purchaseContract.setThreeTime(new Date().getTime());
        }

        purchaseContractMapper.updateByExampleSelective(purchaseContract, purchaseContractExample);
        return "success";
    }
}
