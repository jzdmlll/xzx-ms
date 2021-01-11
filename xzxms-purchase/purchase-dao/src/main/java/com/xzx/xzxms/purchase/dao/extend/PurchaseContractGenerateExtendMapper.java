package com.xzx.xzxms.purchase.dao.extend;

import com.xzx.xzxms.purchase.vo.PurchaseContractGenerateVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author：ZJW
 * @title：采购合同生成界面
 * @date：2020/12/30 17:04
 * @修改人：
 * @修改时间：2020/12/30 17:04
 * @修改描述：默认描述
 */
public interface PurchaseContractGenerateExtendMapper {
    /**
     * 周嘉玮
     * 查询所有购买项信息
     * @param projectId
     * @return
     */
    List<PurchaseContractGenerateVO> findPurchaseItemsInfo(@Param("projectId") Long projectId);

    /**
     * 周嘉玮
     * 根据项目 id 及其 购买项 id 查询购项目信息
     * @param projectId
     * @param itemIds
     * @return
     */
    List<PurchaseContractGenerateVO> findPurchaseItemsInfoByItemIds(@Param("projectId") Long projectId, @Param("itemIds") Long[] itemIds);

    /**
     * 周嘉玮
     * 根据合同编号去purchase_contract表中查询是否存在此合同
     * @param contractNo
     * @return
     */
    int findContractNoNumByContractNo(@Param("contractNo") String contractNo);
}
