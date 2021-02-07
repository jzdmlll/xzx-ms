package com.xzx.xzxms.stock.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.stock.dao.StockInvoiceMapper;
import com.xzx.xzxms.stock.dto.StockInvoiceDTO;
import com.xzx.xzxms.stock.service.StockInvoiceService;
import com.xzx.xzxms.stock.vo.StockInvoiceVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author sunny
 * @Date 2021/2/7 18:40
 * @Version 1.0
 */

@RestController
@RequestMapping("/stock/invoice")
public class StockInvoiceController {

    @Resource
    private StockInvoiceService stockInvoiceServiceImpl;

    @ApiOperation("发票上传")
    @PostMapping("invoiceUpload")
    public Message invoiceUpload(@RequestBody StockInvoiceDTO invoiceUploadDTO){

        stockInvoiceServiceImpl.invoiceUpload(invoiceUploadDTO.getStockInvoice(), invoiceUploadDTO.getFiles());
        return MessageUtil.success("success");
    }

    @ApiOperation("发票查询")
    @GetMapping("findInvoice")
    public Message findInvoice(Long contractId){

        List<StockInvoiceVO> list = stockInvoiceServiceImpl.findInvoice(contractId);
        return MessageUtil.success("success", list);
    }
}
