package com.xzx.xzxms.equipment.controller;/**
 * @Author sunny
 * @Date 2021/2/1 16:55
 * @Version 1.0
 */

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.equipment.dto.InvoiceUploadDTO;
import com.xzx.xzxms.equipment.service.InvoiceService;
import com.xzx.xzxms.equipment.vo.InvoiceVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName InvoiceController
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */

@RestController
@RequestMapping("/equipment/invoice")
public class InvoiceController {

    @Resource
    private InvoiceService invoiceServiceImpl;

    @ApiOperation("发票上传")
    @PostMapping("invoiceUpload")
    public Message invoiceUpload(@RequestBody InvoiceUploadDTO invoiceUploadDTO){

        invoiceServiceImpl.invoiceUpload(invoiceUploadDTO.getEquipmentInvoice(), invoiceUploadDTO.getFiles());
        return MessageUtil.success("success");
    }

    @ApiOperation("发票查询")
    @GetMapping("findInvoice")
    public Message findInvoice(Long contractId){

        List<InvoiceVO> list = invoiceServiceImpl.findInvoice(contractId);
        return MessageUtil.success("success", list);
    }
}
