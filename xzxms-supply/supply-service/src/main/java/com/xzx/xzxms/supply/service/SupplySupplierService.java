package com.xzx.xzxms.supply.service;/**
 * @Author sunny
 * @Date 2021/2/18 14:50
 * @Version 1.0
 */

import com.xzx.xzxms.supply.bean.SupplySupplier;

import java.util.List;

/**
 *@ClassName SupplySupplierService
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface SupplySupplierService {

    /**
     * 查询供应商
     * @return
     */
    List<SupplySupplier> findSupplierByParams();

    /**
     * 新增或修改供应商
     * @param supplySupplier
     */
    void saveOrUpdate(SupplySupplier supplySupplier);
}
