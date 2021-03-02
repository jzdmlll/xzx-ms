package com.xzx.xzxms.stock.service.impl;/**
 * @Author sunny
 * @Date 2021/2/8 17:00
 * @Version 1.0
 */

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.stock.bean.*;
import com.xzx.xzxms.stock.dao.StockCheckMapper;
import com.xzx.xzxms.stock.dao.StockEntryMapper;
import com.xzx.xzxms.stock.dao.StockMapper;
import com.xzx.xzxms.stock.dao.extend.StockEntryExtendMapper;
import com.xzx.xzxms.stock.service.StockEntryService;
import com.xzx.xzxms.stock.vo.StockEntryVO;
import org.apache.sshd.client.session.ClientUserAuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName StockEntryServiceImpl
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Service
public class StockEntryServiceImpl implements StockEntryService {

    @Resource
    private StockEntryExtendMapper stockEntryExtendMapper;
    @Resource
    private StockEntryMapper stockEntryMapper;
    @Resource
    private StockMapper stockMapper;
    @Resource
    private StockCheckMapper stockCheckMapper;

    @Override
    public List<StockEntryVO> findEntryByParams(String item, String contractId, String beginTime, String endTime) {

        List<StockEntryVO> list = stockEntryExtendMapper.findEntryByParams(item, contractId, beginTime, endTime);
        return list;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void batchEntry(List<StockEntry> stockEntries) {

        for(StockEntry se : stockEntries){
            entry(se);
        }
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void signalEntry(StockEntry stockEntry) {
        entry(stockEntry);
    }

    @Override
    public void revokeBatchEntry(List<StockEntry> stockEntries) {

    }

    @Override
    public void revokeSignalEntry(StockEntry stockEntry) {

    }

    @Override
    public void updateEntryNumber(StockEntry stockEntry) {

    }

    /**
     * 入库
     * @param stockEntry
     */
    private void entry(StockEntry stockEntry){

        Double entryNum = stockEntry.getEntryNumber();
        //先从签收表中取出最多入库数量（只有签收了才能入库）
        StockCheckExample checkExample = new StockCheckExample();
        checkExample.createCriteria().andItemIdEqualTo(stockEntry.getPurchaseItemId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<StockCheck> stockChecks = stockCheckMapper.selectByExample(checkExample);
        if (stockChecks.size() > 0){
            StockCheck stockCheck = stockChecks.get(0);
            //应入库数量
            Double checkNum = stockCheck.getCheckNumber();
            //已入库数量
            Double storedNum = stockEntryExtendMapper.storedNum(stockEntry.getPurchaseItemId());
            if (storedNum == null){
                storedNum = 0D;
            }
            if ((checkNum - storedNum) >= entryNum){
                //先插入入库表
                StockEntry se = new StockEntry();
                se.setId(IDUtils.getId());
                se.setPurchaseItemId(stockEntry.getPurchaseItemId());
                se.setEntryNumber(entryNum);
                se.setEntryTime(stockEntry.getEntryTime());
                se.setEntryPerson(stockEntry.getEntryPerson());
                se.setOperator(stockEntry.getOperator());
                se.setTime(new Date().getTime());
                se.setIsActive(CommonConstant.EFFECTIVE);
                se.setEntryRemark(stockEntry.getEntryRemark());
                stockEntryMapper.insert(se);
                //再插入库存表
                Stock stock = new Stock();
                stock.setId(IDUtils.getId());
                stock.setItemId(stockEntry.getPurchaseItemId());
                stock.setStockNumber(entryNum);
                stock.setIsActive(CommonConstant.EFFECTIVE);
                stockMapper.insert(stock);
            }else {
                throw new CustomerException("入库数量大于已签收未入库的数量!");
            }
        }
    }
}
