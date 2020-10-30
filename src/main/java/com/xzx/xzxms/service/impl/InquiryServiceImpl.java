package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.InquiryExample;
import com.xzx.xzxms.bean.extend.InquiryCompareExtend;
import com.xzx.xzxms.bean.extend.InquiryExtend;
import com.xzx.xzxms.dao.InquiryMapper;
import com.xzx.xzxms.dao.extend.InquiryExtendMapper;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.IDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InquiryServiceImpl implements IInquiryService{
    @Resource
    private InquiryMapper inquiryMapper;
    @Override
    public List<Inquiry> findByProDetailId(long proDetailId) {
        InquiryExample example = new InquiryExample();
        example.createCriteria().andProDetailIdEqualTo(proDetailId).andIsActiveEqualTo(1);
        return inquiryMapper.selectByExample(example);
    }

    @Override
    public List<Inquiry> findAll() {
        InquiryExample example = new InquiryExample();
        example.createCriteria().andIsActiveEqualTo(1);
        return inquiryMapper.selectByExample(example);
    }

    /**
     * 批量插入
     * @param inquiryList
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void batchAddInquiry(List<Inquiry> inquiryList) throws SQLException {
        long time = new Date().getTime();
        InquiryExample  example = new InquiryExample();
        example.createCriteria().andProDetailIdEqualTo(inquiryList.get(0).getProDetailId());
        List<Inquiry> inquiries = inquiryMapper.selectByExample(example);
        if (inquiries.size() > 0) {
            for (Inquiry i:inquiries){
                if(i.getIsUseful() == 1) {
                    throw new CustomerException("询价函["+i.getName()+"]下已有报价单存在，禁止覆盖");
                }
            }
            inquiryMapper.deleteByExample(example);
        }
        int sort = 1;
        for (Inquiry inquiry : inquiryList) {
              long inquiryId = IDUtils.getId();
              inquiry.setId(inquiryId);
              inquiry.setTime(time);
              inquiry.setIsActive(1);
              inquiry.setIsUseful(0);
              inquiry.setSort(sort ++);
              inquiryMapper.insert(inquiry);
        }
    }

    @Override
    public void rowSave(Inquiry inquiry) {
        inquiry.setTime(new Date().getTime());
        inquiryMapper.updateByPrimaryKeySelective(inquiry);
    }


    @Transactional
    @Override
    public void batchSetInvalid(long[] ids) {

        for (long id : ids){
            Inquiry inquiry=inquiryMapper.selectByPrimaryKey(id);
            if (inquiry != null || !inquiry.getIsActive().equals(0)){
                inquiry.setIsActive(0);
                inquiryMapper.updateByPrimaryKeySelective(inquiry);
            }else {
                throw new CustomerException("该数据已不存在");
            }
        }
    }

    @Resource
    private InquiryExtendMapper inquiryExtendMapper;

    @Override
    public List<InquiryExtend> findByProIdOrCompareStatus(long proDetailId, Integer compareStatus) {

        List<InquiryExtend> list= new ArrayList<>();

        if(compareStatus == -1 || compareStatus == 0){
            List<InquiryCompareExtend> InquiryCompareExtends = inquiryExtendMapper.findByProIdOrCompareStatus(proDetailId,compareStatus);
            System.out.println(InquiryCompareExtends.size());
            long inquiryId = 0L;
            Boolean compare=true;
            Boolean buss=true;
            Boolean fina=true;
            Boolean tench=true;

            InquiryCompareExtend temp = null;

            for(int j = 0; j < InquiryCompareExtends.size(); j++){

                InquiryCompareExtend i = InquiryCompareExtends.get(j);

                if(inquiryId == 0L){

                    inquiryId = i.getCheContentId();
                }
                if(inquiryId != i.getCheContentId()) {

                    if(compare && buss && fina && tench){
                        temp = InquiryCompareExtends.get(j-1);
                        InquiryExtend inquiry = new InquiryExtend();
                        inquiry.setId(temp.getId());
                        inquiry.setName(temp.getName());
                        inquiry.setModel(temp.getModel());
                        inquiry.setNumber(temp.getNumber());
                        inquiry.setParams(temp.getParams());
                        inquiry.setUnit(temp.getUnit());
                        inquiry.setBrand(temp.getBrand());
                        inquiry.setRemark(temp.getRemark());
                        inquiry.setCheckStatus(0);

                        list.add(inquiry);
                    }
                    inquiryId = i.getCheContentId();
                    compare = true;
                    buss = true;
                    fina = true;
                    tench = true;
                }

                switch (i.getCheType()) {
                    case "比价审核":
                        if (!i.getCheCheckStatus().equals(0)) {
                            compare = false;
                        }
                        break;
                    case "商务审核":
                        if (!i.getCheCheckStatus().equals(1)) {
                            buss = false;
                        }
                        break;
                    case "技术审核":
                        if (!i.getCheCheckStatus().equals(1)) {
                            tench = false;
                        }
                        break;
                    case "最终审核":
                        if (!i.getCheCheckStatus().equals(0)) {
                            fina = false;
                        }
                        break;
                    default:
                        break;
                }

                if (j == InquiryCompareExtends.size() - 1){

                    temp = InquiryCompareExtends.get(j);

                    if(compare && buss && fina && tench){

                        InquiryExtend inquiry = new InquiryExtend();
                        inquiry.setName(temp.getName());
                        inquiry.setId(temp.getId());
                        inquiry.setModel(temp.getModel());
                        inquiry.setNumber(temp.getNumber());
                        inquiry.setParams(temp.getParams());
                        inquiry.setUnit(temp.getUnit());
                        inquiry.setBrand(temp.getBrand());
                        inquiry.setRemark(temp.getRemark());
                        inquiry.setCheckStatus(0);

                        list.add(inquiry);
                    }
                }

            }
        }else{

            list = inquiryExtendMapper.findByProIdOrCompareStatusToEquals(proDetailId,compareStatus);
        }

        return list;
    }
}
