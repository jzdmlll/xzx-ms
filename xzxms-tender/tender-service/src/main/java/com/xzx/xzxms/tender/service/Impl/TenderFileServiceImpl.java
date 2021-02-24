package com.xzx.xzxms.tender.service.Impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.fileupload.IFileUploadService;
import com.xzx.xzxms.commons.utils.Base64Util;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.tender.bean.TenderFile;
import com.xzx.xzxms.tender.bean.TenderFileExample;
import com.xzx.xzxms.tender.dao.TenderFileMapper;
import com.xzx.xzxms.tender.extend.TenderFileExtend;
import com.xzx.xzxms.tender.service.TenderFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author：ZJW
 * @title：
 * @date：2021/2/24 18:55
 * @修改人：
 * @修改时间：2021/2/24 18:55
 * @修改描述：默认描述
 */
@Service
public class TenderFileServiceImpl implements TenderFileService {

    @Resource
    private JedisDao jedisDaoImpl;

    @Autowired
    private IFileUploadService fileUploadServiceImpl;

    @Resource
    private TenderFileMapper tenderFileMapper;

    /**
     * 周嘉玮
     * 公共方法
     */
    @Override
    public List<TenderFile> FileService(List<TenderFile> fileList) {
        // 遍历
        for (TenderFile recruitFile : fileList) {
            // 文件上传 redis --> nginx
            if (recruitFile.getOperator()==null || "".equals(recruitFile.getOperator())) {
                if (jedisDaoImpl.exists(recruitFile.getId().toString())) {
                    //从redis中取出base64文件码
                    String base64File = jedisDaoImpl.get(recruitFile.getId().toString());
                    //解码，还原成输入流
                    InputStream inputStream = Base64Util.decodeBase64File(base64File);
                    //清除redis该文件缓存
                    jedisDaoImpl.del(recruitFile.getId().toString());
                    //上传到Nginx
                    Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, recruitFile.getName());
                    recruitFile.setUrl(map.get("url").toString());
                }else {
                    throw new CustomerException("文件上传信息过期，请重新上传");
                }
            }else {
                // 新增 重新生成ID
                recruitFile.setId(IDUtils.getId());
            }
        }
        return fileList;
    }

    /**
     * 周嘉玮
     * 1 - 招标公告文件
     */
    @Transactional
    @Override
    public String insertBidAnnouncementFileService(List<TenderFile> fileList) {
        List<TenderFile> tenderFiles = FileService(fileList);
        for (TenderFile tenderFile : tenderFiles) {
            //文件信息插入到数据库
            tenderFile.setType(TenderFileExtend.TYPE_BID_ANNOUNCEMENT);
            tenderFile.setTime(new Date().getTime());
            tenderFile.setIsActive(CommonConstant.EFFECTIVE);
            tenderFileMapper.insert(tenderFile);
        }
        return "success";
    }

    /**
     * 周嘉玮
     * 2 - 报名函
     */
    @Transactional
    @Override
    public String insertApplicationLetterFileService(List<TenderFile> fileList) {
        List<TenderFile> tenderFiles = FileService(fileList);
        for (TenderFile tenderFile : tenderFiles) {
            //文件信息插入到数据库
            tenderFile.setType(TenderFileExtend.TYPE_APPLICATION_LETTER);
            tenderFile.setTime(new Date().getTime());
            tenderFile.setIsActive(CommonConstant.EFFECTIVE);
            tenderFileMapper.insert(tenderFile);
        }
        return "success";
    }

    /**
     * 周嘉玮
     * 3 - 招标文件
     */
    @Transactional
    @Override
    public String insertBidFileService(List<TenderFile> fileList) {
        List<TenderFile> tenderFiles = FileService(fileList);
        for (TenderFile tenderFile : tenderFiles) {
            //文件信息插入到数据库
            tenderFile.setType(TenderFileExtend.TYPE_BID);
            tenderFile.setTime(new Date().getTime());
            tenderFile.setIsActive(CommonConstant.EFFECTIVE);
            tenderFileMapper.insert(tenderFile);
        }
        return "success";
    }

    /***
     * 周嘉玮
     * 4 - 硬件清单
     */
    @Transactional
    @Override
    public String insertHardwareFileService(List<TenderFile> fileList) {
        List<TenderFile> tenderFiles = FileService(fileList);
        for (TenderFile tenderFile : tenderFiles) {
            //文件信息插入到数据库
            tenderFile.setType(TenderFileExtend.TYPE_HARDWARE);
            tenderFile.setTime(new Date().getTime());
            tenderFile.setIsActive(CommonConstant.EFFECTIVE);
            tenderFileMapper.insert(tenderFile);
        }
        return "success";
    }

    /**
     * 周嘉玮
     * 5 - 技术文件
     */
    @Transactional
    @Override
    public String insertTechnologyFileService(List<TenderFile> fileList) {
        List<TenderFile> tenderFiles = FileService(fileList);
        for (TenderFile tenderFile : tenderFiles) {
            //文件信息插入到数据库
            tenderFile.setType(TenderFileExtend.TYPE_TECHNOLOGY);
            tenderFile.setTime(new Date().getTime());
            tenderFile.setIsActive(CommonConstant.EFFECTIVE);
            tenderFileMapper.insert(tenderFile);
        }
        return "success";
    }

    /**
     * 周嘉玮
     * 6 - 投标文件
     */
    @Transactional
    @Override
    public String insertTenderFileService(List<TenderFile> fileList) {
        List<TenderFile> tenderFiles = FileService(fileList);
        for (TenderFile tenderFile : tenderFiles) {
            //文件信息插入到数据库
            tenderFile.setType(TenderFileExtend.TYPE_TENDER);
            tenderFile.setTime(new Date().getTime());
            tenderFile.setIsActive(CommonConstant.EFFECTIVE);
            tenderFileMapper.insert(tenderFile);
        }
        return "success";
    }

    /**
     * 周嘉玮
     * 7 - 归档文件
     */
    @Transactional
    @Override
    public String insertArchiveFileService(List<TenderFile> fileList) {
        List<TenderFile> tenderFiles = FileService(fileList);
        for (TenderFile tenderFile : tenderFiles) {
            //文件信息插入到数据库
            tenderFile.setType(TenderFileExtend.TYPE_ARCHIVE);
            tenderFile.setTime(new Date().getTime());
            tenderFile.setIsActive(CommonConstant.EFFECTIVE);
            tenderFileMapper.insert(tenderFile);
        }
        return "success";
    }

    /**
     * 周嘉玮
     * 8 - 最终报价清单文件
     */
    @Transactional
    @Override
    public String insertFinalQuotationFileService(List<TenderFile> fileList) {
        List<TenderFile> tenderFiles = FileService(fileList);
        for (TenderFile tenderFile : tenderFiles) {
            //文件信息插入到数据库
            tenderFile.setType(TenderFileExtend.TYPE_FINAL_QUOTATION);
            tenderFile.setTime(new Date().getTime());
            tenderFile.setIsActive(CommonConstant.EFFECTIVE);
            tenderFileMapper.insert(tenderFile);
        }
        return "success";
    }

    /**
     * 周嘉玮
     * 9 - 中标通知书
     */
    @Transactional
    @Override
    public String insertLetterOfAcceptanceFileService(List<TenderFile> fileList) {
        List<TenderFile> tenderFiles = FileService(fileList);
        for (TenderFile tenderFile : tenderFiles) {
            //文件信息插入到数据库
            tenderFile.setType(TenderFileExtend.TYPE_LETTER_OF_ACCEPTANCE);
            tenderFile.setTime(new Date().getTime());
            tenderFile.setIsActive(CommonConstant.EFFECTIVE);
            tenderFileMapper.insert(tenderFile);
        }
        return "success";
    }

    /**
     * 周嘉玮
     * 删除文件
     */
    @Override
    public String deleteFileByIdService(Long id) {
        TenderFileExample tenderFileExample = new TenderFileExample();
        tenderFileExample.createCriteria().andIdEqualTo(id).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        tenderFileMapper.deleteByExample(tenderFileExample);
        return "success";
    }

    /**
     * 周嘉玮
     * 根据招标项目id和需要查看的文件类型(查看权限)来获取文件
     */
    @Override
    public List<TenderFile> findFileByOrderIdAndTypeService(TenderFile tenderFile) {
        TenderFileExample tenderFileExample = new TenderFileExample();
        tenderFileExample.createCriteria().andOrderIdEqualTo(tenderFile.getOrderId()).andTypeEqualTo(tenderFile.getType()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<TenderFile> tenderFiles = tenderFileMapper.selectByExample(tenderFileExample);
        return tenderFiles;
    }
}
