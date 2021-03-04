package com.xzx.xzxms.stock.dao.extend;

import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.stock.vo.StockInvoiceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author sunny
 * @Date 2021/2/7 17:32
 * @Version 1.0
 */
@Mapper
public interface StockActualAccountExtendMapper {

    /**
     * 根据合同ID统计实际付款金额
     * @param contractId
     * @return
     */
    Double statisticsActualAccountByContractId(@Param("contractId") Long contractId);
}
