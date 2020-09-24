package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.vm.InquiryCompareVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompareExtendMapper {

    List<InquiryCompareVM> cascadeFindAll(@Param("compareStatus") int compareStatus, @Param("proDetailId") long proDetailId);

    List<InquiryCompareVM> cascadeFindAllByParams(@Param("proDetailId")long proDetailId, @Param("name") String name);
}
