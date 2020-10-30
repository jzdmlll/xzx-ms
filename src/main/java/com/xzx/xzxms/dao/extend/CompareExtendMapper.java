package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.vm.QuoteRespVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompareExtendMapper {

    List<QuoteRespVM> cascadeFindAllByParams(@Param("inquiryId") long inquiryId);
}
