package com.xzx.xzxms.recruit.service.Impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.fileupload.IFileUploadService;
import com.xzx.xzxms.commons.utils.Base64Util;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.recruit.bean.RecruitFile;
import com.xzx.xzxms.recruit.bean.RecruitFileExample;
import com.xzx.xzxms.recruit.dao.RecruitFileMapper;
import com.xzx.xzxms.recruit.extend.RecruitFileExtend;
import com.xzx.xzxms.recruit.service.RecruitFileService;
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
 * @date：2021/2/22 16:53
 * @修改人：
 * @修改时间：2021/2/22 16:53
 * @修改描述：默认描述
 */
@Service
public class RecruitFileServiceImpl implements RecruitFileService {

    @Resource
    private JedisDao jedisDaoImpl;

    @Autowired
    private IFileUploadService fileUploadServiceImpl;

    @Resource
    private RecruitFileMapper recruitFileMapper;

    @Override
    public List<RecruitFile> FileService(List<RecruitFile> fileList) {
        // 遍历
        for (RecruitFile recruitFile : fileList) {
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
     * 1-招标信息文件
     */
    @Transactional
    @Override
    public String insertRecruitInfoFileService(List<RecruitFile> fileList) {
        List<RecruitFile> recruitFiles = FileService(fileList);
        for (RecruitFile recruitFile : recruitFiles) {
            //文件信息插入到数据库
            recruitFile.setType(RecruitFileExtend.TYPE_RECRUIT_INFO);
            recruitFile.setTime(new Date().getTime());
            recruitFile.setIsActive(CommonConstant.EFFECTIVE);
            recruitFileMapper.insert(recruitFile);
        }
        return "success";
    }

    /**
     * 2-投标公司资质文件
     */
    @Transactional
    @Override
    public String insertQualificationFileService(List<RecruitFile> fileList) {
        List<RecruitFile> recruitFiles = FileService(fileList);
        for (RecruitFile recruitFile : recruitFiles) {
            //文件信息插入到数据库
            recruitFile.setType(RecruitFileExtend.TYPE_QUALIFICATION);
            recruitFile.setTime(new Date().getTime());
            recruitFile.setIsActive(CommonConstant.EFFECTIVE);
            recruitFileMapper.insert(recruitFile);
        }
        return "success";
    }

    /**
     * 3-开标、评标过程信息文件
     */
    @Transactional
    @Override
    public String insertBidEvaluationFileService(List<RecruitFile> fileList) {
        List<RecruitFile> recruitFiles = FileService(fileList);
        for (RecruitFile recruitFile : recruitFiles) {
            //文件信息插入到数据库
            recruitFile.setType(RecruitFileExtend.TYPE_BID_EVALUATION);
            recruitFile.setTime(new Date().getTime());
            recruitFile.setIsActive(CommonConstant.EFFECTIVE);
            recruitFileMapper.insert(recruitFile);
        }
        return "success";
    }

    /**
     * 4-汇总报告文件
     */
    @Transactional
    @Override
    public String insertReportFileService(List<RecruitFile> fileList) {
        List<RecruitFile> recruitFiles = FileService(fileList);
        for (RecruitFile recruitFile : recruitFiles) {
            //文件信息插入到数据库
            recruitFile.setType(RecruitFileExtend.TYPE_REPORT);
            recruitFile.setTime(new Date().getTime());
            recruitFile.setIsActive(CommonConstant.EFFECTIVE);
            recruitFileMapper.insert(recruitFile);
        }
        return "success";
    }

    /**
     * 根据id删除文件
     */
    @Override
    public String deleteFileByIdService(Long id) {
        RecruitFileExample recruitFileExample = new RecruitFileExample();
        recruitFileExample.createCriteria().andIdEqualTo(id).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        recruitFileMapper.deleteByExample(recruitFileExample);
        return "success";
    }

    /**
     * 周嘉玮
     * 根据招标项目id和需要查看的文件类型(查看权限)来获取文件
     */
    @Override
    public List<RecruitFile> findFileByOrderIdAndTypeService(RecruitFile recruitFile) {
        RecruitFileExample recruitFileExample = new RecruitFileExample();
        recruitFileExample.createCriteria().andOrderIdEqualTo(recruitFile.getOrderId()).andTypeEqualTo(recruitFile.getType()).andIsActiveEqualTo(CommonConstant.EFFECTIVE);
        List<RecruitFile> recruitFiles = recruitFileMapper.selectByExample(recruitFileExample);
        return recruitFiles;
    }
}
