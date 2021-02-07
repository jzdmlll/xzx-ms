package com.xzx.xzxms.stock.service;

import com.xzx.xzxms.stock.bean.StockActualAccount;
import org.springframework.stereotype.Service;

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

    /**
     * 添加实际付款情况(前端添加合同ID,付款金额,付款时间,操作人,修改人)
     * @param equipmentActualAccount
     */
    void addActualAccount(StockActualAccount equipmentActualAccount);

    /**
     * 实际付款记录置为无效(前端添加实际付款ID,修改人)
     * @param equipmentActualAccount
     */
    void setInvalidActualAccount(StockActualAccount equipmentActualAccount);

    /**
     * 根据合同ID查询已付款总金额
     * @param contractId
     * @return
     */
    Double statisticsActualAccountByContractId(Long contractId);
}
