package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.InquiryExample;
import com.xzx.xzxms.bean.InquiryWithBLOBs;
import com.xzx.xzxms.bean.SysFile;
import com.xzx.xzxms.bean.SysProCheck;
import com.xzx.xzxms.bean.extend.InquiryExtend;
import com.xzx.xzxms.bean.extend.SysFileExtend;
import com.xzx.xzxms.bean.extend.SysProCheckExtend;
import com.xzx.xzxms.dao.InquiryMapper;
import com.xzx.xzxms.dao.SysFileMapper;
import com.xzx.xzxms.dao.redis.JedisDao;
import com.xzx.xzxms.service.IFileUploadService;
import com.xzx.xzxms.service.IInquiryService;
import com.xzx.xzxms.service.ISysFileService;
import com.xzx.xzxms.service.ISysProCheckService;
import com.xzx.xzxms.utils.Base64Util;
import com.xzx.xzxms.utils.IDUtils;
import com.xzx.xzxms.utils.SFTPUtil;
import com.xzx.xzxms.vm.InquiryVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class InquiryServiceImpl implements IInquiryService {

    @Resource
    private InquiryMapper inquiryMapper;
    @Autowired
    private JedisDao jedisDaoImpl;
    @Resource
    private IFileUploadService fileUploadServiceImpl;
    @Resource
    private SysFileMapper sysFileMapper;
    @Resource
    private ISysProCheckService sysProCheckServiceImpl;
    @Override
    public List<InquiryWithBLOBs> findByProDetailId(long proId) {

        InquiryExample inquiryExample=new InquiryExample();
        inquiryExample.createCriteria().andProDetailIdEqualTo(proId);
        return inquiryMapper.selectByExampleWithBLOBs(inquiryExample);
    }

    @Transactional
    @Override
    public void saveOrUpdate(InquiryVM inquiry) {
        if (inquiry.getId() != null){
            inquiryMapper.updateByPrimaryKeySelective(inquiry);
        }else {
            long inquiryId = IDUtils.getId();
            //文件上传
            List<SysFile> files = inquiry.getFiles();
            for (SysFile file:files) {
                //如果redis中存在该文件
                if(jedisDaoImpl.exists(file.getId().toString())) {
                    //从redis中取出base64文件码
                    String base64File = jedisDaoImpl.get(file.getId().toString());
                    //解码，还原成输入流
                    InputStream inputStream = Base64Util.decodeBase64File(base64File);
                    System.out.println("redis");
                    //清除redis该文件缓存
                    jedisDaoImpl.del(file.getId().toString());
                    //上传到Nginx
                    Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());

                    System.out.println(map.get("url"));
                    //文件信息持久化到数据库
                    file.setType(SysFileExtend.TYPE_INQUIRY);
                    file.setOtherId(inquiryId);
                    sysFileMapper.insert(file);
                    System.out.println("数据库");
                }
            }
            //询价信息插入数据库
            inquiry.setId(inquiryId);
            inquiryMapper.insert(inquiry);

            //审核信息插入数据库
            List<SysProCheck> proChecks = inquiry.getProChecks();
            int sort = 1;
            for (SysProCheck proCheck : proChecks) {
                proCheck.setCheckStatus(0);
                proCheck.setType(SysProCheckExtend.InquiryType);
                proCheck.setTime(new Date().getTime());
                proCheck.setSort(sort ++);
                proCheck.setId(IDUtils.getId());
                proCheck.setContentId(inquiryId);
                proCheck.setOperator(inquiry.getOperator());
                sysProCheckServiceImpl.inquiryInsert(proCheck);
            }
        }
    }

    @Transactional
    @Override
    public void setInvalid(long[] ids) {

        InquiryWithBLOBs inquiry=new InquiryWithBLOBs();
        for (long id:ids) {
            inquiry.setId(id);
            inquiry.setIsActive(0);
            inquiryMapper.updateByPrimaryKeySelective(inquiry);
        }
    }

    @Transactional
    @Override
    public void delete(long[] ids) {

        for (long id:ids) {
            inquiryMapper.deleteByPrimaryKey(id);
        }
    }
}
