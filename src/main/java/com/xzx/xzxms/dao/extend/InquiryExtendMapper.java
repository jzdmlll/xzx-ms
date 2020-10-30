package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.Inquiry;
import com.xzx.xzxms.bean.extend.InquiryCompareExtend;
import com.xzx.xzxms.bean.extend.InquiryExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InquiryExtendMapper {

    List<InquiryCompareExtend> findByProIdOrCompareStatus(@Param("proDetailId") long proDetailId, @Param("compareStatus") Integer compareStatus);

    List<InquiryExtend> findByProIdOrCompareStatusToEquals(@Param("proDetailId") long proDetailId, @Param("compareStatus") Integer compareStatus);
}
