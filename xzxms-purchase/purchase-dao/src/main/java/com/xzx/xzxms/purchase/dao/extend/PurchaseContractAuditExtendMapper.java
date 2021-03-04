package com.xzx.xzxms.purchase.dao.extend;

import com.xzx.xzxms.inquiry.vo.ContractAuditDealVO;

import java.util.List;

/**
 * @author：sunny
 * @title：合同审核界面
 * @date：2021/1/14 14:33
 * @修改人：
 * @修改时间：2021/1/14 14:33
 * @修改描述：默认描述
 */
public interface PurchaseContractAuditExtendMapper {

    /**
     * 查询一级审核待办
     * @return
     */
    List<ContractAuditDealVO> dataSourceFirst();

    /**
     * 查询二级审核待办
     * @return
     */
    List<ContractAuditDealVO> dataSourceSecond();

    /**
     * 查询三级审核待办
     * @return
     */
    List<ContractAuditDealVO> dataSourceThree();
}
