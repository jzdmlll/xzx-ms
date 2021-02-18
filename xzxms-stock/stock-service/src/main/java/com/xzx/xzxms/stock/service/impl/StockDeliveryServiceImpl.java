package com.xzx.xzxms.stock.service.impl;/**
 * @Author sunny
 * @Date 2021/2/18 10:25
 * @Version 1.0
 */

import com.xzx.xzxms.stock.bean.StockDelivery;
import com.xzx.xzxms.stock.service.StockDeliveryService;
import com.xzx.xzxms.stock.vo.StockDeliveryVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@ClassName StockDeliveryServiceImpl
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Service
public class StockDeliveryServiceImpl implements StockDeliveryService {

    @Override
    public List<StockDeliveryVO> findDeliveryByParams(String item) {

        return null;
    }

    @Override
    public void delivery(List<StockDelivery> stockDeliveries) {

    }
}
