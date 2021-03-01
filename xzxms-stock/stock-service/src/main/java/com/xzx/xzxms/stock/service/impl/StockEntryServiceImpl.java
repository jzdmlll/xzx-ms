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
import com.xzx.xzxms.stock.bean.Stock;
import com.xzx.xzxms.stock.bean.StockEntry;
import com.xzx.xzxms.stock.bean.StockExample;
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
    private PurchaseItemsMapper purchaseItemsMapper;
    @Resource
    private StockMapper stockMapper;

    @Override
    public List<StockEntryVO> findEntryByParams(String item) {

        List<StockEntryVO> list = stockEntryExtendMapper.findEntryByParams(item);
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
        PurchaseItems purchaseItems = purchaseItemsMapper.selectByPrimaryKey(stockEntry.getPurchaseItemId());
        //应入库数量
        Double shouldEntryNum = purchaseItems.getNumber();
        //实际入库数量
        Double actualEntryNum;
        StockExample example = new StockExample();
        example.createCriteria().andItemIdEqualTo(stockEntry.getPurchaseItemId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<Stock> stocks = stockMapper.selectByExample(example);
        if (stocks != null){
            actualEntryNum = stocks.get(0).getStockNumber();
        }else {
            actualEntryNum = 0D;
        }
        if((shouldEntryNum - actualEntryNum) >= entryNum){
            //先插入入库表
            stockEntry.setId(IDUtils.getId());
            stockEntry.setTime(new Date().getTime());
            stockEntry.setIsActive(CommonConstant.EFFECTIVE);
            stockEntryMapper.insertSelective(stockEntry);
            //再插入库存表
            Stock stock = new Stock();
            stock.setId(IDUtils.getId());
            stock.setItemId(stockEntry.getPurchaseItemId());
            stock.setStockNumber(entryNum);
            stock.setIsActive(CommonConstant.EFFECTIVE);
            stockMapper.insertSelective(stock);
        }else {
            throw new CustomerException("入库数量大于剩余入库数量,入库失败!请核对入库数量后入库");
        }
    }
}
