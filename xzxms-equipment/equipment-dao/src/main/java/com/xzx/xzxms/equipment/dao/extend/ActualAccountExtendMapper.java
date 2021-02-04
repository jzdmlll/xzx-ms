package com.xzx.xzxms.equipment.dao.extend;/**
 * @Author sunny
 * @Date 2021/2/4 15:05
 * @Version 1.0
 */

import org.apache.ibatis.annotations.Param;

/**
 *@ClassName ActualAccountExtendMapper
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface ActualAccountExtendMapper {

    /**
     * 根据合同ID统计实际付款金额
     * @param contractId
     * @return
     */
    Double statisticsActualAccountByContractId(@Param("contractId") Long contractId);
}
