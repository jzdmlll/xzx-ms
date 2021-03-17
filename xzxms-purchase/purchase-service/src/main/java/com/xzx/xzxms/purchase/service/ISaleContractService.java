package com.xzx.xzxms.purchase.service;/**
 * @Author sunny
 * @Date 2021/3/14 14:41
 * @Version 1.0
 */

import com.xzx.xzxms.purchase.bean.SaleContract;
import com.xzx.xzxms.purchase.vo.SaleContractVO;
import com.xzx.xzxms.purchase.vo.SaleItemsVO;

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

    /**
     * 根据销售合同ID查询合同明细
     * @param saleId
     * @return
     */
    List<SaleItemsVO> findSaleItemBySaleId(String saleId);

    /**
     * 根据销售合同ID查询销售详情
     * @param saleId
     * @return
     */
    SaleContractVO findSaleContractDetail(String saleId);
}
