package com.xzx.xzxms.stock.controller;/**
 * @Author sunny
 * @Date 2021/2/8 16:40
 * @Version 1.0
 */

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.stock.bean.StockActualAccount;
import com.xzx.xzxms.stock.service.StockCheckService;
import com.xzx.xzxms.stock.vo.StockCheckVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName StockCheckController
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@RestController
@RequestMapping("/stock/check")
public class StockCheckController {

    @Resource
    private StockCheckService stockCheckServiceImpl;

    @ApiOperation(value = "根据参数查询出验收信息")
    @GetMapping(value = "findStockCheck")
    public Message findStockCheck(Long proId, Long contractId, Long startTime, Long endTime) {

        List<StockCheckVO> list = stockCheckServiceImpl.findStockCheck(proId, contractId, startTime, endTime);
        return MessageUtil.success("success", list);
    }

}
