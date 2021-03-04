package com.xzx.xzxms.chapter.service.Impl;

import com.xzx.xzxms.chapter.bean.ChapterAudit;
import com.xzx.xzxms.chapter.bean.ChapterAuditExample;
import com.xzx.xzxms.chapter.dao.ChapterAuditMapper;
import com.xzx.xzxms.chapter.dao.extend.ChapterAuditExtendMapper;
import com.xzx.xzxms.chapter.service.ChapterAuditService;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.fileupload.IFileUploadService;
import com.xzx.xzxms.commons.utils.Base64Util;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.system.bean.SysFileExample;
import com.xzx.xzxms.system.bean.extend.SysFileExtend;
import com.xzx.xzxms.system.dao.SysFileMapper;
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
    @Resource
    private ChapterAuditExtendMapper chapterAuditExtendMapper;


    /**
     * 周嘉玮
     * 在文件表中新增文件；在用章审核表中新增信息
     * @param chapterAudit
     * @param files
     * @return
     */
    @Transactional
    @Override
    public String insertChapterAuditService(ChapterAudit chapterAudit, List<SysFile> files) {

        if(chapterAudit.getId() == null) {

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
            chapterAudit.setId(id);
            chapterAudit.setSenderTime(new Date().getTime());
            chapterAudit.setIsActive(1);
            // 审核状态初始化 0-未审核
            chapterAudit.setAuditStatus(0);

            chapterAuditMapper.insert(chapterAudit);

        }else {

            if (chapterAudit.getAuditStatus() == 0){
                chapterAuditMapper.updateByPrimaryKeySelective(chapterAudit);
            }else {
                throw new CustomerException("已审核,请勿修改!");
            }
        }
        return "success";
    }

    /**
     * 周嘉玮
     * 获取所有项目名
     * @return
     */
    @Override
    public List<ChapterAudit> findAllProjectNameService() {
        ChapterAuditExample chapterAuditExample = new ChapterAuditExample();
            chapterAuditExample.createCriteria().andIsActiveEqualTo(1);
            List<ChapterAudit> projectNames = chapterAuditMapper.selectByExample(chapterAuditExample);
            return projectNames;
    }

    /**
     * 周嘉玮
     * 根据id查询该条审核信息
     * @return
     */
    @Override
    public List<ChapterAudit> findChapterAuditInfosByProjectNameService(String proId, Long startTime, Long overTime,Integer auditStatus) {

        List<ChapterAudit> chapterAuditInfos = chapterAuditExtendMapper.findChapterAuditor(proId, startTime, overTime, auditStatus);
        return chapterAuditInfos;
    }

    /**
     * 周嘉玮
     * 审核人审核回馈
     * @param chapterAudit
     * @return
     */
    @Override
    public String updateChapterAuditService(ChapterAudit chapterAudit) {
        chapterAudit.setAuditTime(new Date().getTime());
        chapterAuditMapper.updateByPrimaryKeySelective(chapterAudit);
        return "success";
    }

    /**
     * 周嘉玮
     * 删除用章审核
     * @param id
     * @return
     */
    @Transactional
    @Override
    public String deleteChapterAuditService(Long id) {

        ChapterAuditExample chapterAuditExample = new ChapterAuditExample();
        // 查询需要删除的那条数据
        chapterAuditExample.createCriteria().andIdEqualTo(id);

        ChapterAudit chapterAudit = new ChapterAudit();
        // 假删
        chapterAudit.setIsActive(0);
        chapterAuditMapper.updateByExampleSelective(chapterAudit, chapterAuditExample);

        // 判断是否删除成功
        ChapterAuditExample chapterAuditExample1 = new ChapterAuditExample();
        chapterAuditExample1.createCriteria().andIdEqualTo(id).andIsActiveEqualTo(1);
        long count = chapterAuditMapper.countByExample(chapterAuditExample1);
        if (count == 0){
            return "success";
        }else {
            return "error";
        }


//        // 删除该条数据
//        chapterAuditMapper.deleteByPrimaryKey(id);
//
//        // 判断是否删除成功
//        ChapterAudit chapterAudit = chapterAuditMapper.selectByPrimaryKey(id);
//        // 删除成功
//        if (chapterAudit == null || chapterAudit.equals("")){
//            return "success";
//
//        //删除失败
//        }else {
//            return "error";
//        }
    }

    @Override
    public List<SysFile> findFileUrlByOtherIdService(Long otherId) {
        SysFileExample sysFileExample = new SysFileExample();
        sysFileExample.createCriteria().andIsActiveEqualTo(1).andOtherIdEqualTo(otherId);
        List<SysFile> sysFiles = sysFileMapper.selectByExample(sysFileExample);
        return sysFiles;
    }
}
