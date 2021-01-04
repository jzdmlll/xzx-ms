package com.xzx.xzxms.purchase.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.inquiry.bean.SysProDetail;
import com.xzx.xzxms.inquiry.dao.InquiryMapper;
import com.xzx.xzxms.inquiry.dao.SysProDetailMapper;
import com.xzx.xzxms.purchase.bean.*;
import com.xzx.xzxms.purchase.dao.PurchaseContractMapper;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.PurchaseProjectMapper;
import com.xzx.xzxms.purchase.dao.PurchaseSupplyMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchaseContractExtendMapper;
import com.xzx.xzxms.purchase.service.IPurchaseContractService;
import com.xzx.xzxms.purchase.vm.QuotePurchaseVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseContractServiceImpl implements IPurchaseContractService {

    @Resource
    private PurchaseContractMapper purchaseContractMapper;
    @Resource
    private PurchaseContractExtendMapper purchaseContractExtendMapper;
    @Resource
    private PurchaseItemsMapper purchaseItemsMapper;
    @Resource
    private PurchaseSupplyMapper purchaseSupplyMapper;
    @Resource
    private PurchaseProjectMapper purchaseProjectMapper;
    @Resource
    private SysProDetailMapper sysProDetailMapper;
    @Resource
    private InquiryMapper inquiryMapper;


    /**
     * 通过项目id进行查询
     * @param projectId
     * @return
     */
    @Override
    public List<PurchaseContract> findByProjectId(Long projectId) {
        PurchaseContractExample example = new PurchaseContractExample();
        if (projectId == null) {
            example.createCriteria().andIsActiveNotEqualTo(0);
        }else {
            example.createCriteria().andProjectIdEqualTo(projectId).andIsActiveNotEqualTo(0);//查除了状态为0的其他合同
        }
        List<PurchaseContract> list = purchaseContractMapper.selectByExample(example);
        return list;
    }

    /**
     * 逻辑假删
     * @param id
     */
    @Override
    public void deleteById(long id) {
        long time = new Date().getTime();
        PurchaseContract purchaseContract = purchaseContractMapper.selectByPrimaryKey(id);
        if(purchaseContract==null || purchaseContract.getIsActive().equals(0)){
            throw new CustomerException("该数据已不存在");
        }else {
            purchaseContract.setIsActive(0);
            purchaseContract.setTime(time);
            purchaseContractMapper.updateByPrimaryKeySelective(purchaseContract);
        }
    }

    /**
     * 新增或者修改合同
     * @param purchaseContract
     */
    @Override
    public void saveOrUpdate(PurchaseContract purchaseContract) {
        long time = new Date().getTime();
        if(purchaseContract.getId()!= null){
            purchaseContract.setTime(time);
            purchaseContractMapper.updateByPrimaryKeySelective(purchaseContract);
        }else {
            purchaseContract.setId(IDUtils.getId());
            purchaseContract.setIsActive(1);
            purchaseContract.setTime(time);
            purchaseContract.setFirstAudit(0);
            purchaseContract.setSecondAudit(0);
            purchaseContract.setThreeAudit(0);
            purchaseContractMapper.insert(purchaseContract);
        }
    }

    /**
     * 根据合同编码进行模糊查询
     * @param contractNo
     * @return
     */
    @Override
    public List<PurchaseContract> findAllLikeByContractNo(String contractNo) {
        List<PurchaseContract> purchaseContracts = purchaseContractExtendMapper.findAllLikeByContractNo(contractNo);
        return purchaseContracts;
    }

    @Transactional
    @Override
    public void generatePurchaseContract(QuotePurchaseVM quotePurchaseVM) {

        List<Quote> quoteList = quotePurchaseVM.getQuoteList();

        PurchaseContract purchaseContract;
        PurchaseItems purchaseItems = new PurchaseItems();
        PurchaseSupply purchaseSupply = new PurchaseSupply();
        PurchaseProject purchaseProject = new PurchaseProject();

        long id = IDUtils.getId();

        purchaseContract = quotePurchaseVM.getPurchaseContract();
        purchaseContract.setId(id);
        purchaseContract.setTime(new Date().getTime());
        purchaseContract.setIsActive(CommonConstant.EFFECTIVE);
        purchaseContractMapper.insert(purchaseContract);

        for(Quote q : quoteList){
            Inquiry inquiry = inquiryMapper.selectByPrimaryKey(q.getInquiryId());

            if (inquiry.getItemId() == null){

                //如果itemId为空 则说明询价内容不是来源于采购项目，在生成采购合同时
                long purchaseProjectId = IDUtils.getId();
                SysProDetail sysProDetail = sysProDetailMapper.selectByPrimaryKey(inquiry.getProDetailId());
                purchaseProject.setId(purchaseProjectId);
                purchaseProject.setProjectName(sysProDetail.getName());
                purchaseProject.setTime(new Date().getTime());
                purchaseProject.setOperator(inquiry.getOperator());
                purchaseProjectMapper.insert(purchaseProject);
                //先询比价后采购生成;需将询价内容插入到采购名目表中
                long itemId = IDUtils.getId();
                purchaseItems.setId(itemId);
                purchaseSupply.setItemId(itemId);
                purchaseItems.setContractId(id);
                purchaseItems.setProjectId(Long.toString(purchaseProjectId));
                purchaseItems.setSerialNumber(inquiry.getSort());
                purchaseItems.setItem(inquiry.getName());
                purchaseItems.setBrand(inquiry.getBrand());
                purchaseItems.setParams(inquiry.getParams());
                purchaseItems.setModel(inquiry.getModel());
                purchaseItems.setUnit(inquiry.getUnit());
                purchaseItems.setSalePrice(inquiry.getCorrectPrice());
                purchaseItems.setSaleTotalprice(inquiry.getCorrectPrice()*inquiry.getNumber());
                purchaseItems.setSerialNumber(inquiry.getNumber());
                purchaseItems.setRequiredDelivery(inquiry.getRequiredDelivery());
                purchaseItems.setIsInquiry(1);
                purchaseItems.setRemark(inquiry.getRemark());
                purchaseItems.setIsActive(CommonConstant.EFFECTIVE);
                purchaseItems.setOperator(inquiry.getOperator());
                purchaseItems.setTime(new Date().getTime());
                purchaseItemsMapper.insert(purchaseItems);
            }else {
                //先有采购后询比价
                purchaseSupply.setItemId(inquiry.getItemId());
                PurchaseItems items = purchaseItemsMapper.selectByPrimaryKey(inquiry.getItemId());
                items.setContractId(id);
            }

            purchaseSupply.setId(IDUtils.getId());
            purchaseSupply.setSupplierId(q.getSupplierId());
            purchaseSupply.setSupplier(q.getSupplier());
            purchaseSupply.setModel(q.getSuModel());
            purchaseSupply.setBrand(q.getSuBrand());
            purchaseSupply.setParams(q.getSuParams());
            purchaseSupply.setPrice(q.getSuPrice());
            purchaseSupply.setDelivery(q.getSuDelivery());
            purchaseSupply.setRemark(q.getSuRemark());
            purchaseSupply.setNumber(inquiry.getNumber());
            purchaseSupply.setWarranty(q.getWarranty());
            purchaseSupply.setIsActive(CommonConstant.EFFECTIVE);
            purchaseSupply.setTime(new Date().getTime());
            purchaseSupply.setImage(q.getImage());
            purchaseSupplyMapper.insert(purchaseSupply);
        }
    }

}
