package com.xzx.xzxms.purchase.dao.extend;/**
 * @Author sunny
 * @Date 2021/3/14 14:47
 * @Version 1.0
 */

import com.xzx.xzxms.purchase.bean.SaleContract;
import com.xzx.xzxms.purchase.vo.SaleContractVO;

import java.util.List;

/**
 *@ClassName SaleContractExtendMapper
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface SaleContractExtendMapper {

    List<SaleContractVO> findSaleContractData(String name);
}
