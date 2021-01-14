package com.xzx.xzxms.purchase.service;

import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.dto.PurchaseContractDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/4 20:51
 * @修改人：
 * @修改时间：2021/1/4 20:51
 * @修改描述：默认描述
 */
@Repository
public interface PurchaseContractGenerateService {
//    String insertContractInfoService(PurchaseContract purchaseContract, Long[] ids);
    String insertContractInfoService(PurchaseContractDTO purchaseContractDTO);
}
