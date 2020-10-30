package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.extend.QuoteExtendInquiry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuoteAndInquiryExtendMapper {

    List<QuoteExtendInquiry> findBySupplierOrPro(@Param("supplier") String supplier,@Param("proId") long proId);

    /**
     * 根据报价表ID关联查询出询价、报价内容
     * @param quoteId 报价表ID
     * @return
     */
    QuoteExtendInquiry findByQuoteId(@Param("quoteId") long quoteId);
}
