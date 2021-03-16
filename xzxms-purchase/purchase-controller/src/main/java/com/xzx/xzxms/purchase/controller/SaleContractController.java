package com.xzx.xzxms.purchase.controller;/**
 * @Author sunny
 * @Date 2021/3/14 15:02
 * @Version 1.0
 */

import com.xzx.xzxms.commons.utils.JwtTokenUtil;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.bean.SaleContract;
import com.xzx.xzxms.purchase.service.ISaleContractService;
import com.xzx.xzxms.purchase.vo.SaleContractVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *@ClassName SaleContractController
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@RestController
@RequestMapping("/contract/sale")
public class SaleContractController {

    @Resource
    private ISaleContractService saleContractServiceImpl;

    @ApiOperation(value = "查询销售合同")
    @GetMapping(value = "findSaleContractData")
    public Message findSaleContractData(String name){

        List<SaleContractVO> list = saleContractServiceImpl.findSaleContractData(name);
        return MessageUtil.success("success", list);
    }

    @ApiOperation(value = "新增或修改销售合同")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(HttpServletResponse response, SaleContract saleContract){

        String token = response.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        String id = JwtTokenUtil.getUserId(token, JwtTokenUtil.base64Secret);
        saleContractServiceImpl.saveOrUpdate(saleContract, id);
        return MessageUtil.success("success");
    }

    @ApiOperation(value = "销售合同置为无效")
    @PostMapping(value = "setInvalid")
    public Message setInvalid(HttpServletResponse response, List<String> contractIds){

        String token = response.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        String id = JwtTokenUtil.getUserId(token, JwtTokenUtil.base64Secret);
        saleContractServiceImpl.setInvalid(contractIds, id);
        return MessageUtil.success("success");
    }

}
