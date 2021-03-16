package com.xzx.xzxms.purchase.service;/**
 * @Author sunny
 * @Date 2021/3/14 14:41
 * @Version 1.0
 */

import com.xzx.xzxms.purchase.bean.SaleContract;
import com.xzx.xzxms.purchase.vo.SaleContractVO;

import java.util.List;

/**
 *@ClassName ISaleContractService
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface ISaleContractService {

    /**
     * 查询销售合同
     * @return
     */
    List<SaleContractVO> findSaleContractData(String name);

    /**
     * 新增或修改销售合同
     * @param saleContract
     * @param loginId
     */
    void saveOrUpdate(SaleContract saleContract, String loginId);

    /**
     * 置为无效
     * @param contractId
     * @param loginId
     */
    void setInvalid(List<String> contractId, String loginId);


}
