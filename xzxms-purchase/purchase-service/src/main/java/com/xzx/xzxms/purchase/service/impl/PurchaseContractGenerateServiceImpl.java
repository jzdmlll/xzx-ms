package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.purchase.bean.PurchaseContract;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.bean.PurchaseItemsExample;
import com.xzx.xzxms.purchase.dao.PurchaseContractMapper;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchaseContractGenerateExtendMapper;
import com.xzx.xzxms.purchase.dto.PurchaseContractDTO;
import com.xzx.xzxms.purchase.service.PurchaseContractGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/5 8:27
 * @修改人：
 * @修改时间：2021/1/5 8:27
 * @修改描述：默认描述
 */
@Service
public class PurchaseContractGenerateServiceImpl implements PurchaseContractGenerateService {

    @Resource
    private PurchaseContractGenerateExtendMapper purchaseContractGenerateExtendMapper;

    @Resource
    private PurchaseContractMapper purchaseContractMapper;

    @Resource
    private PurchaseItemsMapper purchaseItemsMapper;

    /**
     * 周嘉玮
     * @param purchaseContractDTO
     * @return
     */
    @Transactional
    @Override
    public String insertContractInfoService(PurchaseContractDTO purchaseContractDTO) {
        // 获取前台输入的合同编号
        String contractNo = purchaseContractDTO.getPurchaseContract().getContractNo();

        // 根据前台所传合同编号去合同表里查询是否该合同已存在
        int contractNoNum = purchaseContractGenerateExtendMapper.findContractNoNumByContractNo(contractNo);

        // 当合同编号不存在时
        if (contractNoNum == 0){
            // 根据项目以及前台所选购买项生成合同

            // 生成合同主键id
            Long id = IDUtils.getId();
            purchaseContractDTO.getPurchaseContract().setId(id);
            // 获取当前时间
            purchaseContractDTO.getPurchaseContract().setTime(new Date().getTime());
            purchaseContractDTO.getPurchaseContract().setIsActive(CommonConstant.EFFECTIVE);
            // 在合同表中新增一个新合同
            purchaseContractMapper.insert(purchaseContractDTO.getPurchaseContract());

            // 在购买项表中更新合同编号、更新操作人员、更新时间
//            purchaseItemsMapper.up
            PurchaseItemsExample purchaseItemsExample = new PurchaseItemsExample();
            purchaseItemsExample.createCriteria().andProjectIdEqualTo(purchaseContractDTO.getPurchaseContract().getProjectId()).andIdIn(purchaseContractDTO.getItemIds());
            PurchaseItems purchaseItems = new PurchaseItems();
            purchaseItems.setContractId(id);
            purchaseItems.setUpdateOperator(purchaseContractDTO.getPurchaseContract().getOperator());
            purchaseItems.setUpdateTime(new Date().getTime());
            //purchaseItemsMapper.updateByExample(purchaseItems, purchaseItemsExample);
            purchaseItemsMapper.updateByExampleSelective(purchaseItems, purchaseItemsExample);

            return "success";
        }else {
            return "合同已存在";
        }
    }


}
