package com.xzx.xzxms.stock.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.stock.service.StockReportService;
import com.xzx.xzxms.stock.vo.StockCheckVO;
import com.xzx.xzxms.stock.vo.StockDetailVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：ZJW
 * @title：报表
 * @date：2021/2/26 15:08
 * @修改人：
 * @修改时间：2021/2/26 15:08
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/stock/report")
public class StockReportController {

    @Resource
    StockReportService stockReportService;

    @ApiOperation("存货暂估明细表")
    @GetMapping("StockDetail")
    public Message StockDetail(Long date) throws Exception {
        List<StockDetailVO> stockDetailList = stockReportService.StockDetailService(date);
        return MessageUtil.success("success", stockDetailList);
    }
}
