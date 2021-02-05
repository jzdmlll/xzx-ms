package com.xzx.xzxms.inquiry.service.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.utils.BeanHelper;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.inquiry.dao.InquiryMapper;
import com.xzx.xzxms.inquiry.dao.ProPoolMapper;
import com.xzx.xzxms.inquiry.dao.QuoteMapper;
import com.xzx.xzxms.inquiry.dao.SysProCheckMapper;
import com.xzx.xzxms.inquiry.dao.extend.InquiryExtendMapper;
import com.xzx.xzxms.inquiry.dao.extend.QuoteAndInquiryExtendMapper;
import com.xzx.xzxms.inquiry.dto.InquiryTree;
import com.xzx.xzxms.inquiry.dto.InquiryTreeDTO;
import com.xzx.xzxms.inquiry.service.IFinallyCheckService;
import com.xzx.xzxms.inquiry.service.IInquiryService;
import com.xzx.xzxms.inquiry.bean.*;
import com.xzx.xzxms.inquiry.bean.extend.InquiryAndProDetailExtend;
import com.xzx.xzxms.inquiry.bean.extend.InquiryExtend;
import com.xzx.xzxms.purchase.bean.PurchaseItems;
import com.xzx.xzxms.purchase.dao.PurchaseItemsMapper;
import com.xzx.xzxms.purchase.dao.PurchaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.smartcardio.CommandAPDU;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class InquiryServiceImpl implements IInquiryService {
    @Resource
    private InquiryMapper inquiryMapper;
    @Resource
    private InquiryExtendMapper inquiryExtendMapper;
    @Resource
    private QuoteMapper quoteMapper;
    @Resource
    private ProPoolMapper proPoolMapper;
    @Resource
    private PurchaseItemsMapper purchaseItemsMapper;

    @Override
    public List<InquiryExtend> findByProDetailId(Long proDetailId, String name, String model) {

        return inquiryExtendMapper.findInquiryAndQuoteNum(proDetailId, name, model);
    }

    @Override
    public List<InquiryExtend> findAll() {
        return inquiryExtendMapper.findInquiryAndQuoteNum(null, null, null);
    }

    /**
     * 根据询价ID查询存在报价的数量
     * @param inquiry
     * @return
     */
    public long isExistQuoteByInquiryId(Inquiry inquiry){

        QuoteExample example = new QuoteExample();
        example.createCriteria().andInquiryIdEqualTo(inquiry.getId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        long num = quoteMapper.countByExample(example);
        return num;
    }

    /**
     * 根据询价参数判断是否存在此询价
     * @param inquiry
     */
    public void isExistByInquiryParams(Inquiry inquiry){

        InquiryExample example = new InquiryExample();
        example.createCriteria().andNameEqualTo(inquiry.getName()).andVetoEqualTo(CommonConstant.VETOED)
                .andSortEqualTo(inquiry.getSort()).andProDetailIdEqualTo(inquiry.getProDetailId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        long num = inquiryMapper.countByExample(example);
        if (num > 0){
            throw new CustomerException(inquiry.getName() + ":询价内容已存在，勿重复添加!");
        }
    }

    /**
     * sunny
     * 批量插入
     * @param inquiryList
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void batchAddInquiry(List<Inquiry> inquiryList) throws SQLException {

        long time = new Date().getTime();
        /*InquiryExample example = new InquiryExample();
        example.createCriteria().andProDetailIdEqualTo(inquiryList.get(0).getProDetailId()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        long inquiryNum = inquiryMapper.countByExample(example);
        if (inquiryNum > 0){
            throw new CustomerException("已存在一条或多条询价信息,如需重新导入，请先全部删除后导入!");
        }*/

        for (Inquiry inquiry : inquiryList) {

            long inquiryId = IDUtils.getId();
            inquiry.setId(inquiryId);
            inquiry.setTime(time);
            inquiry.setIsActive(CommonConstant.EFFECTIVE);
            inquiry.setIsUseful(CommonConstant.IS_NOT_USEFUL);
            //需要询价
            inquiry.setIsinquiry(CommonConstant.IS_INQUIRY);
            //未否决
            inquiry.setVeto(CommonConstant.NOT_VETOED);

            //询价插入先判断是否已存在，防止重复
            isExistByInquiryParams(inquiry);
            inquiryMapper.insertSelective(inquiry);
        }
    }

    @Transactional
    @Override
    public void batchAddInquiryTree(InquiryTreeDTO inquiryTreeDTO) {

        long time = new Date().getTime();
        for(InquiryTree tree : inquiryTreeDTO.getInquiryList()){
            //如何tree.getChildren()=0,说明它是大类
            if (tree.getChildren().size() > 0){

                //生成大类表
                long parentId = IDUtils.getId();
                tree.setId(parentId);
                tree.setTime(time);
                tree.setParentId("-1"); // 区分大类和普通询价
                tree.setIsActive(CommonConstant.EFFECTIVE);
                tree.setIsUseful(CommonConstant.IS_NOT_USEFUL);
                tree.setVeto(CommonConstant.VETOED);
                isExistByInquiryParams(tree);
                inquiryMapper.insertSelective(tree);

                //遍历小类,补充信息
                for(Inquiry inquiry : tree.getChildren()){

                    inquiry.setId(IDUtils.getId());
                    inquiry.setParentId(parentId + "");
                    inquiry.setTime(time);
                    inquiry.setIsActive(CommonConstant.EFFECTIVE);
                    inquiry.setIsUseful(CommonConstant.IS_NOT_USEFUL);
                    inquiry.setIsinquiry(CommonConstant.IS_INQUIRY);
                    inquiry.setVeto(CommonConstant.NOT_VETOED);
                    isExistByInquiryParams(inquiry);
                    inquiryMapper.insertSelective(inquiry);
                }
            }else {
                throw new CustomerException("excel格式错误，无法解析!");
            }
        }
    }

    @Override
    public void rowSave(Inquiry inquiry) {

        long num = isExistQuoteByInquiryId(inquiry);
        if (num > 0){
            throw new CustomerException(inquiry.getName() + ":已存在报价，请勿修改询价内容!，如需修改请先删除报价!");
        }

        inquiry.setUpdateTime(new Date().getTime());
        inquiryMapper.updateByPrimaryKeySelective(inquiry);
    }

    @Transactional
    @Override
    public void batchSetInvalid(Long[] ids) {

        long time = new Date().getTime();
        for (Long id : ids){
            Inquiry inquiry = inquiryMapper.selectByPrimaryKey(id);
            long num = isExistQuoteByInquiryId(inquiry);
            if(num > 0) {
                throw new CustomerException(inquiry.getName() + ":下有报价内容，请删除对应报价内容后执行该操作");
            }
            if (inquiry != null && inquiry.getIsActive().equals(CommonConstant.EFFECTIVE)){
                if (inquiry.getItemId() != null && inquiry.getItemId() != 0){
                    //如果是采购发送过来的则需要同时将采购的is_inquiry重置
                    PurchaseItems purchaseItems = new PurchaseItems();
                    purchaseItems.setId(inquiry.getItemId());
                    purchaseItems.setIsInquiry(CommonConstant.IS_NOT_INQUIRY);
                    purchaseItemsMapper.updateByPrimaryKeySelective(purchaseItems);
                }
                inquiry.setIsActive(CommonConstant.INVALID);
                inquiry.setTime(time);
                inquiryMapper.updateByPrimaryKeySelective(inquiry);
            }else {
                throw new CustomerException(inquiry.getName() + ":已不存在");
            }
        }
    }

    @Override
    public List<InquiryAndProDetailExtend> findByProIdOrCompareStatus(long proDetailId, Integer compare_audit) {

        List<InquiryAndProDetailExtend> InquiryCompareExtends = inquiryExtendMapper.findByProIdOrCompareStatus(proDetailId,compare_audit);

        return InquiryCompareExtends;
    }

    @Transactional
    @Override
    public void batchSetIsNotInquiry(long[] ids, Integer status) {

        for (long id : ids){

            Inquiry inquiry = inquiryMapper.selectByPrimaryKey(id);
            long num = isExistQuoteByInquiryId(inquiry);
            if (num > 0){
                throw new CustomerException(inquiry.getName() + " :已存在报价，勿更改是否需要询价状态!");
            }
            inquiry.setId(id);
            inquiry.setIsinquiry(status);
            inquiryMapper.updateByPrimaryKeySelective(inquiry);
        }
    }

    @Override
    public void setVeto(long id) {

        Inquiry inquiry = new Inquiry();
        inquiry.setId(id);
        //否决
        inquiry.setVeto(CommonConstant.VETOED);
        inquiryMapper.updateByPrimaryKeySelective(inquiry);
    }

    @Override
    public void inquiryChoosePool(long inquiryId, long proPoolId, long operator) {

        long quoteId = IDUtils.getId();
        long time = new Date().getTime();

        ProPool proPool = proPoolMapper.selectByPrimaryKey(proPoolId);
        BeanHelper.nullToEmpty(proPool);
        Quote quote = new Quote();
        quote.setId(quoteId);
        quote.setSupplier(proPool.getSupplier());
        quote.setSuModel(proPool.getModel());
        quote.setSuBrand(proPool.getBrand());
        quote.setSuParams(proPool.getParams());
        quote.setSuPrice(proPool.getPrice());
        quote.setSuDelivery(proPool.getDelivery());
        quote.setSuRemark(proPool.getRemark());
        quote.setImage(proPool.getImage());
        quote.setSupplierId(proPool.getSupplierId());
        //数据来源于产品池
        quote.setDataSource(0);
        quote.setInquiryId(inquiryId);
        quote.setIsActive(1);
        quote.setIsUseful(0);
        quote.setOperator(operator+"");
        quote.setTime(time);
        quoteMapper.insertSelective(quote);
    }

    @Override
    public void insertInquiry(Inquiry inquiry) {

        inquiry.setId(IDUtils.getId());
        inquiry.setIsinquiry(CommonConstant.IS_INQUIRY);
        inquiry.setIsActive(CommonConstant.EFFECTIVE);
        inquiry.setIsUseful(CommonConstant.IS_NOT_USEFUL);
        inquiry.setVeto(CommonConstant.VETOED);
        inquiry.setTime(new Date().getTime());
        isExistByInquiryParams(inquiry);
        inquiryMapper.insert(inquiry);
    }

    @Override
    public void finallyUpdateDraft(Inquiry inquiry) {

        inquiry.setCorrectPrice(inquiry.getFinallyPrice());
        inquiry.setUpdateTime(new Date().getTime());
        inquiryMapper.updateByPrimaryKeySelective(inquiry);
    }

    @Override
    public void modifyDeviceType(long[] inquiryIds, long codeId) {
        Inquiry inquiry = new Inquiry();
        for (long id : inquiryIds){
            inquiry.setId(id);
            inquiry.setDeviceTypeId(codeId);
            inquiryMapper.updateByPrimaryKeySelective(inquiry);
        }
    }
}
