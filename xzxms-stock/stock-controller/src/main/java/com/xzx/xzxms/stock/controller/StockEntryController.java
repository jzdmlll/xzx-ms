package com.xzx.xzxms.stock.controller;/**
 * @Author sunny
 * @Date 2021/2/8 16:40
 * @Version 1.0
 */

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.stock.bean.StockEntry;
import com.xzx.xzxms.stock.service.StockCheckService;
import com.xzx.xzxms.stock.service.StockEntryService;
import com.xzx.xzxms.stock.vo.StockCheckVO;
import com.xzx.xzxms.stock.vo.StockEntryVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/stock/entry")
public class StockEntryController {

    @Resource
    private StockEntryService stockEntryServiceImpl;

    @ApiOperation(value = "查询出入库信息")
    @GetMapping(value = "findEntryByParams")
    public Message findEntryByParams(String item) {

        List<StockEntryVO> list = stockEntryServiceImpl.findEntryByParams(item);
        return MessageUtil.success("success", list);
    }

    @ApiOperation(value = "批量入库")
    @PostMapping(value = "entry")
    public Message entry(List<StockEntry> stockEntries) {

        stockEntryServiceImpl.entry(stockEntries);
        return MessageUtil.success("success");
    }
}
