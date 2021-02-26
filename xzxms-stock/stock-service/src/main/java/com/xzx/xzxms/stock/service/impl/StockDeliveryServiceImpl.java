package com.xzx.xzxms.stock.service.impl;/**
 * @Author sunny
 * @Date 2021/2/18 10:25
 * @Version 1.0
 */

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.stock.bean.Stock;
import com.xzx.xzxms.stock.bean.StockDelivery;
import com.xzx.xzxms.stock.bean.StockExample;
import com.xzx.xzxms.stock.dao.StockDeliveryMapper;
import com.xzx.xzxms.stock.dao.StockMapper;
import com.xzx.xzxms.stock.dao.extend.StockDeliveryExtendMapper;
import com.xzx.xzxms.stock.dao.extend.StockExtendMapper;
import com.xzx.xzxms.stock.service.StockDeliveryService;
import com.xzx.xzxms.stock.vo.StockDeliveryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName StockDeliveryServiceImpl
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Service
public class StockDeliveryServiceImpl implements StockDeliveryService {

    @Resource
    private StockExtendMapper stockExtendMapper;
    @Resource
    private StockDeliveryMapper stockDeliveryMapper;
    @Resource
    private StockMapper stockMapper;
    @Resource
    private StockDeliveryExtendMapper stockDeliveryExtendMapper;

    @Override
    public List<StockDeliveryVO> findDeliveryByParams(String item) {

        List<StockDeliveryVO> list = stockDeliveryExtendMapper.findDeliveryByParams(item);
        return list;
    }

    @Transactional
    @Override
    public void batchDelivery(List<StockDelivery> stockDeliveries) {

        for(StockDelivery sd : stockDeliveries){
            delivery(sd);
        }
    }

    @Override
    public void signalDelivery(StockDelivery stockDelivery) {
        delivery(stockDelivery);
    }


    private void delivery(StockDelivery stockDelivery){

        //出库数量
        Double deliveryNumber = stockDelivery.getDeliveryNumber();
        //库存数量
        Double stockNumber = stockExtendMapper.findStockNumberByItemId(stockDelivery.getItemId());
        if (deliveryNumber <= stockNumber){

            //先插入出库表
            stockDelivery.setId(IDUtils.getId());
            stockDelivery.setTime(new Date().getTime());
            stockDelivery.setIsActive(CommonConstant.EFFECTIVE);
            stockDeliveryMapper.insertSelective(stockDelivery);
            //再更新库存表
            StockExample example = new StockExample();
            //查询库存数量不为0
            example.createCriteria().andItemIdEqualTo(stockDelivery.getItemId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE).andStockNumberNotEqualTo(0D);
            List<Stock> list = stockMapper.selectByExample(example);
            for(Stock stock : list){
                if (stock.getStockNumber() >= deliveryNumber){
                    //此条库存数量大于出库数量，直接出库后中断循环
                    stock.setStockNumber(stock.getStockNumber() - deliveryNumber);
                    stockMapper.updateByPrimaryKeySelective(stock);
                    break;
                }else {
                    //此条库存数量小于出库数量,需出库下一条库存记录
                    //因为出库数量大于此条库存数量，所有这条库存数量全部出库
                    stock.setStockNumber(0D);
                    stockMapper.updateByPrimaryKeySelective(stock);
                    deliveryNumber -= stock.getStockNumber();
                }
            }
        }else {
            throw new CustomerException("出库数量大于库存数量,出库失败!请核对出库数量后再出库");
        }
    }
}
