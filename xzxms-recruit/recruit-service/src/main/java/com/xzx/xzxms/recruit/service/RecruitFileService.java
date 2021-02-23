package com.xzx.xzxms.recruit.service;

import com.xzx.xzxms.recruit.bean.RecruitFile;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/22 16:52
 * @修改人：
 * @修改时间：2021/2/22 16:52
 * @修改描述：默认描述
 */
public interface RecruitFileService {

    /**
     * 周嘉玮
     * 公共方法
     */
    List<RecruitFile> FileService(List<RecruitFile> fileList);

    /**
     * 周嘉玮
     * 1-招标信息文件
     */
    String insertRecruitInfoFileService(List<RecruitFile> fileList);

    /**
     * 周嘉玮
     * 2-投标公司资质文件
     */
    String insertQualificationFileService(List<RecruitFile> fileList);

    /**
     * 周嘉玮
     * 3-开标、评标过程信息文件
     */
    String insertBidEvaluationFileService(List<RecruitFile> fileList);

    /**
     * 周嘉玮
     * 4-汇总报告文件
     */
    String insertReportFileService(List<RecruitFile> fileList);

    /**
     * 周嘉玮
     * 删除文件
     */
    String deleteFileByIdService(Long id);

    /**
     * 周嘉玮
     * 根据招标项目id和需要查看的文件类型(查看权限)来获取文件
     */
    List<RecruitFile> findFileByOrderIdAndTypeService(RecruitFile recruitFile);
}
