package com.xzx.xzxms.inquiry.dao.extend;

import com.xzx.xzxms.inquiry.bean.extend.InquiryAndProDetailExtend;
import com.xzx.xzxms.inquiry.bean.extend.InquiryExtend;
import com.xzx.xzxms.inquiry.vm.InquiryVM;
import com.xzx.xzxms.inquiry.vo.InquiryAndQuoteVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InquiryExtendMapper {

    List<InquiryAndProDetailExtend> findByProIdOrCompareStatus(@Param("proDetailId") long proDetailId, @Param("compare_audit") Integer compare_audit);

    List<InquiryExtend> findByProIdOrCompareStatusToEquals(@Param("proDetailId") long proDetailId, @Param("compareStatus") Integer compareStatus);

    List<InquiryExtend> findInquiryAndQuoteNum(@Param("proDetailId") Long proDetailId, @Param("name") String name, @Param("model") String model);

    List<InquiryVM> findInquiryByProId(long proDetailId);

    List<InquiryAndQuoteVO> findInquiryAndQuote(Long proDetailId);
}
