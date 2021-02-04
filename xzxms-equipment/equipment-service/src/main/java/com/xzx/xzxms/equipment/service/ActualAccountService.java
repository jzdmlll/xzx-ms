package com.xzx.xzxms.equipment.service;/**
 * @Author sunny
 * @Date 2021/2/4 14:44
 * @Version 1.0
 */

import com.xzx.xzxms.equipment.bean.EquipmentActualAccount;

import java.util.List;

/**
 *@ClassName ActualAccountService
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface ActualAccountService {

    /**
     * 根据合同ID查询出合同付款实际情况
     * @param contractId
     * @return
     */
    List<EquipmentActualAccount> findActualAccountByContractId(Long contractId);

    /**
     * 添加实际付款情况(前端添加合同ID,付款金额,付款时间,操作人,修改人)
     * @param equipmentActualAccount
     */
    void addActualAccount(EquipmentActualAccount equipmentActualAccount);

    /**
     * 实际付款记录置为无效(前端添加实际付款ID,修改人)
     * @param equipmentActualAccount
     */
    void setInvalidActualAccount(EquipmentActualAccount equipmentActualAccount);

    /**
     * 根据合同ID查询已付款总金额
     * @param contractId
     * @return
     */
    Double statisticsActualAccountByContractId(Long contractId);
}
