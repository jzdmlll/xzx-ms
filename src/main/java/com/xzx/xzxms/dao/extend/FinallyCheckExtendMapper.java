package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.vm.FinallyCheckCompareVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinallyCheckExtendMapper {

    List<FinallyCheckCompareVM> cascadeFindAllByParams(@Param("proDetailId") long proDetailId);

    List<SysProCheck> findCheckByQuoteId(long id);
}
