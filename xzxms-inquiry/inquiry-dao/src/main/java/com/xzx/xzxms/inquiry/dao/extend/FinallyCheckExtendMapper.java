package com.xzx.xzxms.inquiry.dao.extend;

import com.xzx.xzxms.inquiry.bean.SysProCheck;
import com.xzx.xzxms.inquiry.vm.FinallyQuoteInquiryVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FinallyCheckExtendMapper {

    List<FinallyQuoteInquiryVM> cascadeFindAllByParams(@Param("proDetailId") Long proDetailId, String name);

    List<SysProCheck> findCheckByQuoteId(long id);

    List<Map> findInquiryNameByProId(Long proId);
}
