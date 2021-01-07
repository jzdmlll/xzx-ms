package com.xzx.xzxms.purchase.service.impl;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.bean.Inquiry;
import com.xzx.xzxms.inquiry.bean.Quote;
import com.xzx.xzxms.inquiry.bean.SysProDetail;
import com.xzx.xzxms.inquiry.bean.SysProDetailWithBLOBs;
import com.xzx.xzxms.inquiry.dao.InquiryMapper;
import com.xzx.xzxms.inquiry.dao.QuoteMapper;
import com.xzx.xzxms.inquiry.dao.SysProDetailMapper;
import com.xzx.xzxms.inquiry.dao.extend.ProPurchaseExtendMapper;
import com.xzx.xzxms.inquiry.vm.ProPurchase;
import com.xzx.xzxms.purchase.bean.*;
import com.xzx.xzxms.purchase.dao.PurchaseContractMapper;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.PurchaseProjectMapper;
import com.xzx.xzxms.purchase.dao.PurchaseSupplyMapper;
import com.xzx.xzxms.purchase.dao.extend.PurchaseContractExtendMapper;
import com.xzx.xzxms.purchase.service.IPurchaseContractService;
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
    @Resource
    private ProPurchaseExtendMapper proPurchaseExtendMapper;


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
    public void inquiryResultSendPurchase(Long[] quoteIds, Long operator) {

        for(long id : quoteIds){
            List<ProPurchase> proPurchases = proPurchaseExtendMapper.findInquiryResult(id);
            if (proPurchases.size() > 0){
                ProPurchase proPurchase = proPurchases.get(0);
                if (proPurchase.getInquiry().getItemId() == null && proPurchase.getPurchaseProId() == null){

                    //先生成采购项目
                    PurchaseProject purchaseProject = new PurchaseProject();
                    long purchaseProjectId = IDUtils.getId();
                    purchaseProject.setId(purchaseProjectId);
                    purchaseProject.setProjectName(proPurchase.getName());
                    purchaseProject.setIsActive(CommonConstant.EFFECTIVE);
                    purchaseProject.setOperator(operator+"");
                    purchaseProject.setTime(new Date().getTime());
                    purchaseProject.setInquiryProId(proPurchase.getId());
                    purchaseProject.setPurchaseProNo(proPurchase.getProNo());
                    purchaseProjectMapper.insert(purchaseProject);

                    //再生成采购需求项
                    PurchaseItems purchaseItems = new PurchaseItems();
                    long purchaseItemsId = IDUtils.getId();
                    purchaseItems.setId(purchaseItemsId);
                    purchaseItems.setProjectId(purchaseProjectId);
                    purchaseItems.setSerialNumber(proPurchase.getInquiry().getSort());
                    purchaseItems.setItem(proPurchase.getInquiry().getName());
                    purchaseItems.setBrand(proPurchase.getInquiry().getBrand());
                    purchaseItems.setParams(proPurchase.getInquiry().getParams());
                    purchaseItems.setModel(proPurchase.getInquiry().getModel());
                    purchaseItems.setUnit(proPurchase.getInquiry().getUnit());
                    purchaseItems.setSalePrice(proPurchase.getInquiry().getCorrectPrice());
                    purchaseItems.setRequiredDelivery(proPurchase.getInquiry().getRequiredDelivery());
                    purchaseItems.setNumber(proPurchase.getInquiry().getNumber());
                    purchaseItems.setRemark(proPurchase.getInquiry().getRemark());
                    purchaseItems.setIsInquiry(CommonConstant.IS_INQUIRY);
                    purchaseItems.setIsActive(CommonConstant.EFFECTIVE);
                    purchaseItems.setOperator(operator+"");
                    purchaseItems.setTime(new Date().getTime());
                    purchaseItemsMapper.insert(purchaseItems);

                    //最后生成供货表
                    PurchaseSupply purchaseSupply = new PurchaseSupply();
                    long purchaseSupplyId = IDUtils.getId();
                    purchaseSupply.setId(purchaseSupplyId);
                    purchaseSupply.setSupplierId(proPurchase.getQuote().getSupplierId());
                    purchaseSupply.setSupplier(proPurchase.getQuote().getSupplier());
                    purchaseSupply.setItemId(purchaseItemsId);
                    purchaseSupply.setModel(proPurchase.getQuote().getSuModel());
                    purchaseSupply.setBrand(proPurchase.getQuote().getSuBrand());
                    purchaseSupply.setParams(proPurchase.getQuote().getSuParams());
                    purchaseSupply.setPrice(proPurchase.getQuote().getSuPrice());
                    purchaseSupply.setDelivery(proPurchase.getQuote().getSuDelivery());
                    purchaseSupply.setRemark(proPurchase.getQuote().getSuRemark());
                    purchaseSupply.setNumber(proPurchase.getInquiry().getNumber());
                    purchaseSupply.setWarranty(proPurchase.getQuote().getWarranty());
                    purchaseSupply.setIsActive(CommonConstant.EFFECTIVE);
                    purchaseSupply.setOperator(operator+"");
                    purchaseSupply.setTime(new Date().getTime());
                    purchaseSupply.setImage(proPurchase.getQuote().getImage());
                    purchaseSupplyMapper.insert(purchaseSupply);

                    //修改询价表中采购项ID
                    Inquiry inquiry = proPurchase.getInquiry();
                    inquiry.setItemId(purchaseItemsId);
                    inquiryMapper.updateByPrimaryKeySelective(inquiry);

                    //修改询价项目表中的采购项目ID
                    SysProDetailWithBLOBs sysProDetail = new SysProDetailWithBLOBs();
                    sysProDetail.setId(proPurchase.getId());
                    sysProDetail.setPurchaseProId(purchaseProjectId);
                    sysProDetailMapper.updateByPrimaryKeySelective(sysProDetail);

                }else {
                    throw new CustomerException("提交异常, 此询价结果已发往采购!");
                }
            }else {
                throw new CustomerException("提交异常，存在询价结果供应商报价无效!");
            }
        }
    }

    @Override
    public void updateSupplyPrice(PurchaseSupply purchaseSupply) {

        if(purchaseSupply.getPrice() != null && purchaseSupply.getNumber() != null){

            purchaseSupply.setTotalPrice(purchaseSupply.getPrice()*purchaseSupply.getNumber());
            purchaseSupply.setUpdateTime(new Date().getTime());
            purchaseSupplyMapper.updateByPrimaryKeySelective(purchaseSupply);
        }else {
            throw new CustomerException("供货单价或供货数量不能为空!");
        }
    }
}
