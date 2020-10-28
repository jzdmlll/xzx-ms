package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.Inquiry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InquiryExtendMapper {

    List<Inquiry> findByProIdOrCompareStatus(@Param("proDetailId") long proDetailId, @Param("compareStatus") Integer compareStatus);
}
