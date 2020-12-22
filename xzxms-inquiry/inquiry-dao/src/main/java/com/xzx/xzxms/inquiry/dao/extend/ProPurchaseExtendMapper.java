package com.xzx.xzxms.inquiry.dao.extend;

import com.xzx.xzxms.inquiry.vm.ProPurchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProPurchaseExtendMapper {

    List<ProPurchase> findProPurchase(long proDetailId);

}
