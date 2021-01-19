package com.xzx.xzxms.chapter.service.Impl;

import com.xzx.xzxms.chapter.bean.ChapterAudit;
import com.xzx.xzxms.chapter.dao.ChapterAuditMapper;
import com.xzx.xzxms.chapter.service.ChapterAuditService;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.utils.Base64Util;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.system.bean.extend.SysFileExtend;
import com.xzx.xzxms.system.dao.SysFileMapper;
import com.xzx.xzxms.system.service.IFileUploadService;
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
 * @date：2021/1/19 14:36
 * @修改人：
 * @修改时间：2021/1/19 14:36
 * @修改描述：默认描述
 */
@Service
public class ChapterAuditServiceImpl implements ChapterAuditService {

    @Autowired
    private JedisDao jedisDaoImpl;
    @Resource
    private IFileUploadService fileUploadServiceImpl;
    @Resource
    private SysFileMapper sysFileMapper;
    @Resource
    private ChapterAuditMapper chapterAuditMapper;


    @Transactional
    @Override
    public String insertChapterAudit(ChapterAudit chapterAudit, List<SysFile> files) {

        // 生成用章审核信息id
        long id = IDUtils.getId();

        //文件上传
        for (SysFile file : files) {
            //如果redis中存在该文件
            if (jedisDaoImpl.exists(file.getId().toString())) {
                //从redis中取出base64文件码
                String base64File = jedisDaoImpl.get(file.getId().toString());
                //解码，还原成输入流
                InputStream inputStream = Base64Util.decodeBase64File(base64File);
                System.out.println("redis");
                //清除redis该文件缓存
                jedisDaoImpl.del(file.getId().toString());
                //上传到Nginx
                Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());

                //文件信息持久化到数据库
                file.setType(SysFileExtend.TYPE_CHAPTER);
                file.setOtherId(id);
                file.setTime(new Date().getTime());
                file.setUrl(map.get("url").toString());
                file.setIsActive(1);
                file.setIsUseful(1);
                file.setOperator(chapterAudit.getSender());
                sysFileMapper.insert(file);
                System.out.println("数据库");
            }
        }

        // 新增用章审核
        // 送审时间
        chapterAudit.setSenderTime(new Date().getTime());
        chapterAudit.setIsActive(1);
        // 审核状态初始化 0-未审核
        chapterAudit.setAuditStatus(0);

        chapterAuditMapper.insert(chapterAudit);

        return "success";
    }
}
