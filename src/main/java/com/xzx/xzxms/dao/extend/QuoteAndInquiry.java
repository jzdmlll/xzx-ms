package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.extend.QuoteExtendInquiry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuoteAndInquiry {

    List<QuoteExtendInquiry> findBySupplierOrPro(@Param("supplier") String supplier,@Param("proId") long proId);
}
