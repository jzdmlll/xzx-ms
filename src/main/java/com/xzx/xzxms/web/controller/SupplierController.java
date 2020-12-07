package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.bean.Supplier;
import com.xzx.xzxms.service.ISupplierService;
import com.xzx.xzxms.utils.Message;
import com.xzx.xzxms.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Supplier")
public class SupplierController {
    @Resource
    private ISupplierService iSupplierServiceImpl;
    @ApiOperation(value = "通过id查询")
    @GetMapping(value = "findById")
    public Message findById(Long id){
        List<Supplier> list = iSupplierServiceImpl.findById(id);
        return MessageUtil.success("success",list);
    }

    @ApiOperation(value = "保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(Supplier supplier){
        iSupplierServiceImpl.saveOrUpdate(supplier);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "通过id假删")
    @GetMapping(value = "deleteById")
    public Message deleteById(long id) {
        iSupplierServiceImpl.deleteById(id);
        return MessageUtil.success("success");
    }

}
