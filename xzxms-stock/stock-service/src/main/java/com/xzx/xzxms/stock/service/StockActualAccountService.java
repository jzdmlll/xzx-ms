package com.xzx.xzxms.stock.service;

import com.xzx.xzxms.stock.bean.StockActualAccount;

import java.util.List;

/**
 * 收发存模块 合同实付款表 业务层
 * @Author Lzc
 * @Date 2021/2/7 16:30
 * @Version 1.0
 */
public interface StockActualAccountService {
    /**
     * 根据合同ID查询合同实付款项
     * @param ContractId 合同ID
     * @return List<StockActualAccount> 合同实付款项
     */
    List<StockActualAccount> findByContractId(Long ContractId);
}
