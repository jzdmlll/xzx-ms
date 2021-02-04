package com.xzx.xzxms.inquiry.dao.extend;

import com.xzx.xzxms.inquiry.bean.extend.InquiryQuoteCheckExtend;
import com.xzx.xzxms.inquiry.bean.extend.QuoteProCheckExtend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InquiryQuoteCheckExtendMapper {

    List<InquiryQuoteCheckExtend> findCheckStatus(long inquiryId);

    List<QuoteProCheckExtend> findQuoteAndCheck(long inquiryId);
}
