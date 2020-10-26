package com.xzx.xzxms.service;

import com.xzx.xzxms.bean.SysProCheck;

import java.util.List;

public interface IProCheckService {


    /**
     * 报价单上传解析后需同时将报价信息根据审核流程插入到审核表中
     * @param type 审核类型
     * @param contentIds 询价ID
     * @param operator 操作人
     */
    void InsertQuoteToCheck(String type, List<Long> contentIds, long operator);

    /**
     * 改变审核状态
     * @param status 审核状态
     * @param ids 审核内容ID集合
     * @param operator 操作人
     */
    void UpdateCheckStatus(Integer status, List<Long> ids, long operator);
}
