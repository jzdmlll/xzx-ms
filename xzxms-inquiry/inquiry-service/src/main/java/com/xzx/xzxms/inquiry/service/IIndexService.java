package com.xzx.xzxms.inquiry.service;/**
 * @Author sunny
 * @Date 2021/2/19 14:21
 * @Version 1.0
 */

import com.xzx.xzxms.inquiry.vo.ProProcessVO;

import java.util.List;

/**
 *@ClassName IIndexService
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
public interface IIndexService {

    /**
     * 查询项目流程
     * @param proId
     * @return
     */
    List<ProProcessVO> findProProcess(Long proId);
}
