package com.xzx.xzxms.stock.controller;/**
 * @Author sunny
 * @Date 2021/2/18 10:26
 * @Version 1.0
 */

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.stock.bean.StockDelivery;
import com.xzx.xzxms.stock.bean.StockEntry;
import com.xzx.xzxms.stock.service.StockDeliveryService;
import com.xzx.xzxms.stock.vo.StockDeliveryVO;
import com.xzx.xzxms.stock.vo.StockEntryVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName StockDeliveryController
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@RestController
@RequestMapping("/stock/delivery")
public class StockDeliveryController {

    @Resource
    private StockDeliveryService stockDeliveryServiceImpl;

    @ApiOperation(value = "查询出库信息")
    @GetMapping(value = "findDeliveryByParams")
    public Message findDeliveryByParams(String item) {

        List<StockDeliveryVO> list = stockDeliveryServiceImpl.findDeliveryByParams(item);
        return MessageUtil.success("success", list);
    }

    @ApiOperation(value = "批量出库")
    @PostMapping(value = "delivery")
    public Message delivery(List<StockDelivery> stockDeliveries) {

        stockDeliveryServiceImpl.delivery(stockDeliveries);
        return MessageUtil.success("success");
    }
}
