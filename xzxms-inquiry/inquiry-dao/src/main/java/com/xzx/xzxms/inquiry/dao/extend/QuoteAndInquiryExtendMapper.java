package com.xzx.xzxms.inquiry.dao.extend;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzx.xzxms.inquiry.bean.extend.QuoteExtendInquiry;
import com.xzx.xzxms.inquiry.vm.FinallyQuoteInquiryVM;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QuoteAndInquiryExtendMapper {

    IPage<QuoteExtendInquiry> findBySupplierOrPro(Page<?> page, @Param("supplier") String supplier, @Param("proId") long proId);

    /**
     * 根据报价表ID关联查询出询价、报价内容
     * @param quoteId 审核表ID
     * @return
     */
    QuoteExtendInquiry findByQuoteId(@Param("quoteId") long quoteId);

    /**
     * 查询该询价ID下是否存在报价
     * @param inquiryId
     * @return
     */
    @Select("SELECT COUNT(1) FROM quote q LEFT JOIN inquiry i on i.id = q.inquiry_id WHERE i.is_active = 1 AND q.is_active = 1 AND i.id = #{inquiryId}")
    int findIsExistQuote(long inquiryId);

    /**
     * 查询该询价是否已被终审
     * @param inquiryId
     * @return
     */
    @Select("SELECT COUNT(1) FROM inquiry i " +
            "LEFT JOIN quote q on i.id = q.inquiry_id " +
            "LEFT JOIN sys_pro_check c on q.id = c.quote_id " +
            "WHERE i.is_active = 1 AND q.is_active = 1 AND c.finally_audit != 0 AND i.id = #{inquiryId}")
    int findIsExistFinally(long inquiryId);

    /**
     * 查询该询价是否已被比价
     * @param inquiryId
     * @return
     */
    @Select("SELECT COUNT(1) FROM inquiry i " +
            "LEFT JOIN quote q on i.id = q.inquiry_id " +
            "LEFT JOIN sys_pro_check c on q.id = c.quote_id " +
            "WHERE i.is_active = 1 AND q.is_active = 1 AND (c.compare_audit != 0 OR c.compare_audit IS NOT NULL) AND i.id = #{inquiryId}")
    int findIsExistCompare(long inquiryId);


    List<FinallyQuoteInquiryVM> findQuoteByInquiryId(long inquiryId);
}
