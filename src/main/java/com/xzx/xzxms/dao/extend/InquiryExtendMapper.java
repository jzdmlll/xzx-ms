package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.extend.InquiryAndProDetailExtend;
import com.xzx.xzxms.bean.extend.InquiryCompareExtend;
import com.xzx.xzxms.bean.extend.InquiryExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InquiryExtendMapper {

    List<InquiryAndProDetailExtend> findByProIdOrCompareStatus(@Param("proDetailId") long proDetailId, @Param("compare_audit") Integer compare_audit);

    List<InquiryExtend> findByProIdOrCompareStatusToEquals(@Param("proDetailId") long proDetailId, @Param("compareStatus") Integer compareStatus);

    List<InquiryExtend> findInquiryAndQuoteNum(long proDetailId);
}
