package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.InquiryWithBLOBs;

import java.util.List;

public interface InquiryExtendMapper {
    List<InquiryWithBLOBs> cascadeSelectByPrimaryKey();

    List<InquiryWithBLOBs> cascadeSelectByPrimaryKey(long id);
}
