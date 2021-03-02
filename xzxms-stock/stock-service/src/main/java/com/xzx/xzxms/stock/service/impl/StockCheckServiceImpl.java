package com.xzx.xzxms.stock.service.impl;/**
 * @Author sunny
 * @Date 2021/2/8 16:38
 * @Version 1.0
 */

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.stock.bean.StockCheck;
import com.xzx.xzxms.stock.bean.StockCheckExample;
import com.xzx.xzxms.stock.dao.StockCheckMapper;
import com.xzx.xzxms.stock.dao.extend.StockCheckExtendMapper;
import com.xzx.xzxms.stock.service.StockCheckService;
import com.xzx.xzxms.stock.vo.StockCheckVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName StockCheckServiceImpl
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Service
public class StockCheckServiceImpl implements StockCheckService {

    @Resource
    private StockCheckExtendMapper stockCheckExtendMapper;
    @Resource
    private PurchaseItemsMapper purchaseItemsMapper;
    @Resource
    private StockCheckMapper stockCheckMapper;

    @Override
    public List<StockCheckVO> findStockCheck(Long proId, Long contractId, Long startTime, Long endTime) {

        List<StockCheckVO> list = stockCheckExtendMapper.findStockCheckByParams(proId, contractId, startTime, endTime);
        return list;
    }

    @Transactional
    @Override
    public void sign(StockCheck stockCheck) {

        long time = new Date().getTime();
        // 查询总数
        PurchaseItems purchaseItems = purchaseItemsMapper.selectByPrimaryKey(stockCheck.getItemId());
        // 查询已签收数量
        StockCheckExample stockCheckExample = new StockCheckExample();
        stockCheckExample.createCriteria().andItemIdEqualTo(stockCheck.getItemId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<StockCheck> stockChecks = stockCheckMapper.selectByExample(stockCheckExample);
        Double numberCount = 0D;
        for(StockCheck check :stockChecks) {
            numberCount += check.getCheckNumber();
        }

        if (purchaseItems.getNumber() - numberCount < stockCheck.getCheckNumber()){
            throw new CustomerException("签收数量已大于应签收数量,签收失败!");
        }
        if (stockCheck.getCheckTime() == null){
            stockCheck.setCheckTime(time+"");
        }
        stockCheck.setIsActive(CommonConstant.EFFECTIVE);
        stockCheck.setId(IDUtils.getId());
        stockCheckMapper.insert(stockCheck);
    }
}
