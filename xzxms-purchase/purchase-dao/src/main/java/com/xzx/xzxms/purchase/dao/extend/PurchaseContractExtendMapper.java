package com.xzx.xzxms.purchase.dao.extend;

import com.xzx.xzxms.purchase.bean.PurchaseContract;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseContractExtendMapper {
    /**
     * 根据合同编号进行模糊查询
     * @param contractNo
     * @return
     */
    List<PurchaseContract> findAllLikeByContractNo(@Param("contractNo") String contractNo);
}
