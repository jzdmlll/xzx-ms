package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.vm.QuotePurchaseVM;

import java.util.List;

public interface IPurchaseContractService {
    /**
     * 通过项目id进行查询
     * @param projectId
     * @return
     */
    List<PurchaseContract> findByProjectId(Long projectId);

    /**
     * 逻辑假删
     * @param id
     */
    void deleteById(long id);

    /**
     * 新增或者修改合同
     * @param purchaseContract
     */
    void saveOrUpdate(PurchaseContract purchaseContract);

    /**
     * 根据合同编码进行模糊查询
     * @param contractNo
     * @return
     */
    List<PurchaseContract> findAllLikeByContractNo(String contractNo);


    /**
     * 询价结果生成采购合同
     * @param quotePurchaseVM
     */
    /*
    void generatePurchaseContract(QuotePurchaseVM quotePurchaseVM);

     */
}