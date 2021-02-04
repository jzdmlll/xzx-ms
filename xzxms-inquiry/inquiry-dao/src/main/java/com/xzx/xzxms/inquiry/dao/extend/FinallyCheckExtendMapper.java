package com.xzx.xzxms.inquiry.dao.extend;

import com.xzx.xzxms.inquiry.bean.SysProCheck;
import com.xzx.xzxms.inquiry.vm.FinallyQuoteInquiryVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinallyCheckExtendMapper {

    List<FinallyQuoteInquiryVM> cascadeFindAllByParams(@Param("proDetailId") long proDetailId);

    List<SysProCheck> findCheckByQuoteId(long id);
}
