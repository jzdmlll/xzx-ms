package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.vm.FinallyQuoteInquiryVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinallyCheckExtendMapper {

    List<FinallyQuoteInquiryVM> cascadeFindAllByParams(@Param("proDetailId") long proDetailId);

    List<SysProCheck> findCheckByQuoteId(long id);
}
