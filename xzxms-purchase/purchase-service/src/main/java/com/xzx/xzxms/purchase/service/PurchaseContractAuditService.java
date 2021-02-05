package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.purchase.bean.PurchaseContract;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/14 22:54
 * @修改人：
 * @修改时间：2021/1/14 22:54
 * @修改描述：默认描述
 */
@Repository
public interface PurchaseContractAuditService {
    /**
     * 根据合同id修改该合同当前审核级别的信息
     * @param purchaseContract
     * @return
     */
    String updateContractAuditInfoByIdService(PurchaseContract purchaseContract);
}
