package com.xzx.xzxms.tender.service;

import com.xzx.xzxms.tender.bean.TenderFile;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/24 18:54
 * @修改人：
 * @修改时间：2021/2/24 18:54
 * @修改描述：默认描述
 */
public interface TenderFileService {
    /**
     * 周嘉玮
     * 公共方法
     */
    List<TenderFile> FileService(List<TenderFile> fileList);

    /**
     * 周嘉玮
     * 1 - 招标公告文件
     */
    String insertBidAnnouncementFileService(List<TenderFile> fileList);

    /**
     * 周嘉玮
     * 2 - 报名函
     */
    String insertApplicationLetterFileService(List<TenderFile> fileList);

    /**
     * 周嘉玮
     * 3 - 招标文件
     */
    String insertBidFileService(List<TenderFile> fileList);

    /***
     * 周嘉玮
     * 4 - 硬件清单
     */
    String insertHardwareFileService(List<TenderFile> fileList);

    /**
     * 周嘉玮
     * 5 - 技术文件
     */
    String insertTechnologyFileService(List<TenderFile> fileList);

    /**
     * 周嘉玮
     * 6 - 投标文件
     */
    String insertTenderFileService(List<TenderFile> fileList);

    /**
     * 周嘉玮
     * 7 - 归档文件
     */
    String insertArchiveFileService(List<TenderFile> fileList);

    /**
     * 周嘉玮
     * 8 - 最终报价清单文件
     */
    String insertFinalQuotationFileService(List<TenderFile> fileList);

    /**
     * 周嘉玮
     * 9 - 中标通知书
     */
    String insertLetterOfAcceptanceFileService(List<TenderFile> fileList);

    /**
     * 周嘉玮
     * 删除文件
     */
    String deleteFileByIdService(Long id);

    /**
     * 周嘉玮
     * 根据招标项目id和需要查看的文件类型(查看权限)来获取文件
     */
    List<TenderFile> findFileByOrderIdAndTypeService(TenderFile tenderFile);
}
