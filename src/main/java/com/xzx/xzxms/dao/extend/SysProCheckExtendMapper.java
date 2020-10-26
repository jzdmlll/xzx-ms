package com.xzx.xzxms.dao.extend;

import com.xzx.xzxms.bean.extend.SysProCheckExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysProCheckExtendMapper {

    List<SysProCheckExtend> cascadeRoleFindAll();

    List<SysProCheckExtend> cascadeFindAllByCheckName(@Param("type") int type,@Param("checkName") String checkName,
                                                      @Param("checkStatus") int[] checkStatus,@Param("proDetailId") long proDetailId);
}
