package com.xzx.xzxms.purchase.controller;

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.purchase.dao.extend.PurchaseContractGenerateExtendMapper;
import com.xzx.xzxms.purchase.dto.PurchaseContractDTO;
import com.xzx.xzxms.purchase.service.PurchaseContractGenerateService;
import com.xzx.xzxms.purchase.vo.PurchaseContractGenerateVO;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/4 20:52
 * @修改人：
 * @修改时间：2021/1/4 20:52
 * @修改描述：默认描述
 */
@RestController
@RequestMapping("/purchase/purchaseContractGenerate")
public class PurchaseContractGenerateController {
    @Resource
    PurchaseContractGenerateExtendMapper purchaseContractGenerateExtendMapper;

    @Autowired
    PurchaseContractGenerateService purchaseContractGenerateService;

    /**
     * 周嘉玮
     * @param projectId
     * @return
     */
    @ApiOperation("查询该项目的所有采购项信息")
    @GetMapping("findPurchaseItemsInfo")
    public Message findPurchaseItemsInfo(@Param("projectId") Long projectId){
        List<PurchaseContractGenerateVO> purchaseItemsInfoList = purchaseContractGenerateExtendMapper.findPurchaseItemsInfo(projectId);
        return MessageUtil.success("success",purchaseItemsInfoList);
    }

    /**
     * 周嘉玮
     * @param purchaseContractDTO
     * @return
     */
    @ApiOperation("新增合同以及为购买项绑定合同")
    @PostMapping("insertContractInfo")
    public Message insertContractInfo(@Param("purchaseContractDTO") @RequestBody PurchaseContractDTO purchaseContractDTO){
        String result = purchaseContractGenerateService.insertContractInfoService(purchaseContractDTO);
        if (result.equals("success")){
            return MessageUtil.success("生成成功");
        }else if (result.equals("合同已存在")) {
            return MessageUtil.error("合同已存在");
        }else {
            return MessageUtil.error("error");
        }
    }

    /**
     * 周嘉玮
     * @param contractNo
     * @return
     */
    @ApiOperation("判断是否存在该合同编号")
    @GetMapping("findContractNo")
    public Message findContractNo(@Param("contractNo") String contractNo){
        int contractNoNum = purchaseContractGenerateExtendMapper.findContractNoNumByContractNo(contractNo);
        return MessageUtil.success("success", contractNoNum);
    }
}
