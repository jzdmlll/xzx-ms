package com.xzx.xzxms.inquiry.service;


import com.xzx.xzxms.inquiry.bean.Inquiry;

import java.util.List;
import java.util.Map;

public interface IFinallyCheckService {
    /**
     * 最终审核 数据查询
     * @param proDetailId 项目详情Id
     * @return
     */
    List<Map> cascadeFindAllByParams(long proDetailId);

    /**
     * 最终审核提交
     * @param checkIds 选用的审核ID
     * @param unCheckIds 未选用的审核ID
     * @param remarks 审核意见
     * @param userId 提交人ID
     */
    void FinallyCheckCommit(long[] checkIds, long[] unCheckIds, List<Map> remarks, long userId);

    /**
     * 终审拒绝一条询价（重新询价）
     * @param inquiry
     */
    void refuseInquiry(Inquiry inquiry);
}
