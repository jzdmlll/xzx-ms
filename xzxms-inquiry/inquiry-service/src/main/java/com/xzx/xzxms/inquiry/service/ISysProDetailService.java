package com.xzx.xzxms.inquiry.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzx.xzxms.inquiry.bean.SysProDetail;
import com.xzx.xzxms.inquiry.bean.SysProDetailWithBLOBs;
import com.xzx.xzxms.inquiry.bean.extend.SysProDetailExtend;
import com.xzx.xzxms.system.bean.SysFile;

import java.util.List;

public interface ISysProDetailService {

    /***
     * 根据项目详情ID查询
     * @param proDetailId
     * @return
     */
    SysProDetailExtend findById(long proDetailId);

    List<SysProDetailExtend> findById();

    IPage<SysProDetailExtend> findById(Page<?> page);
    /**
     * 新增或修改项目
     * @param proDetail
     * @param files
     */
    void saveOrUpdate(SysProDetailWithBLOBs proDetail, List<SysFile> files, String loginId);

    /**
     * 验证项目名称是否存在
     * @param proName
     * @return
     */
    boolean verifyExistence(String proName);

    /**
     * 根据项目id查询项目审核流程
     * @param proDetailId
     * @return
     */
    //List<SysProDetailCheck> findProDetailCheck(long proDetailId);

    /**
     * 根据项目详情id查询利率
     * @param proDetailId
     * @return
     */
    SysProDetail findProRate(long proDetailId);

    /**
     * 根据项目详情id修改更新利率内容
     * @param proDetailId
     */
    void updateProRate(long proDetailId, int proRate);

    /**
     * 置为无效（假删）
     * @param id
     */
    void setInvalid(Long id, String loginId);

    /**
     * 询价页面查询招投标项目
     * @param proName 项目名
     * @param startTime 开始时间
     * @param overTime 结束时间
     * @return
     */
    List<SysProDetail> inquiryResultFindPro(String proName, Long startTime, Long overTime);

}
