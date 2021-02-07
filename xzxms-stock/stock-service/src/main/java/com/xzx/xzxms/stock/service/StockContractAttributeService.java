package com.xzx.xzxms.stock.service;

import com.xzx.xzxms.stock.bean.StockContractAttribute;

/**
 * 收发存模块 合同属性表 业务层
 * @Author Lzc
 * @Date 2021/2/7 14:51
 * @Version 1.0
 */
public interface StockContractAttributeService {
    /**
     * 根据合同ID查询合同属性信息
     * @param ContractId 合同ID
     * @return StockContractAttribute 合同属性信息
     */
    StockContractAttribute findByContractId(Long ContractId);


}
