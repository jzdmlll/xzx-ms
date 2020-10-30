package com.xzx.xzxms.service;

import java.util.List;
import java.util.Map;

public interface IFinallyCheckService {
    /**
     * 最终审核 数据查询
     * @param proDetailId 项目详情Id
     * @return
     */
    List<Map> cascadeFindAllByParams(long proDetailId);
}
