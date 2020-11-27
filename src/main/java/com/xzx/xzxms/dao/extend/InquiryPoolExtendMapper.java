package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.InquiryPool;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InquiryPoolExtendMapper {

    List<InquiryPool> findByParams(@Param("name") String name, @Param("brand") String brand);
}


