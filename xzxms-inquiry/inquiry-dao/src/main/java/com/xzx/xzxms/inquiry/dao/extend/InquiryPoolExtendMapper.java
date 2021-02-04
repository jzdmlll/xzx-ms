package com.xzx.xzxms.inquiry.dao.extend;

import com.xzx.xzxms.inquiry.bean.InquiryPool;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InquiryPoolExtendMapper {

    List<InquiryPool> findByParams(@Param("name") String name, @Param("brand") String brand,
                                   @Param("proDetailId") Long proDetailId, @Param("model") String model);
}


