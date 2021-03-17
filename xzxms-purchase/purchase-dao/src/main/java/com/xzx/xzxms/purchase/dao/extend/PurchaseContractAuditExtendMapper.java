package com.xzx.xzxms.purchase.dao.extend;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzx.xzxms.inquiry.vo.ContractAuditDealVO;
import org.apache.ibatis.annotations.Param;

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
    IPage<ContractAuditDealVO> dataSourceFirst(Page<?> page);

    /**
     * 查询二级审核待办
     * @return
     */
    IPage<ContractAuditDealVO> dataSourceSecond(Page<?> page);

    /**
     * 查询三级审核待办
     * @return
     */
    IPage<ContractAuditDealVO> dataSourceThree(Page<?> page);
}
