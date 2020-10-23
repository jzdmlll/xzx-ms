package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.*;
import com.xzx.xzxms.bean.extend.QuoteExtend;
import com.xzx.xzxms.bean.extend.SysFileExtend;
import com.xzx.xzxms.bean.extend.SysProCheckExtend;
import com.xzx.xzxms.dao.QuoteMapper;
import com.xzx.xzxms.dao.SysFileMapper;
import com.xzx.xzxms.dao.SysProCheckMapper;
import com.xzx.xzxms.dao.SysProDetailCheckMapper;
import com.xzx.xzxms.dao.redis.JedisDao;
import com.xzx.xzxms.service.IFileUploadService;
import com.xzx.xzxms.service.IQuoteService;
import com.xzx.xzxms.utils.Base64Util;
import com.xzx.xzxms.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class QuoteServiceImpl implements IQuoteService {
    @Resource
    private QuoteMapper quoteMapper;
    @Autowired
    private JedisDao jedisDaoImpl;
    @Resource
    private IFileUploadService fileUploadServiceImpl;
    @Resource
    private SysFileMapper sysFileMapper;
    @Resource
    private SysProCheckMapper sysProCheckMapper;
    @Resource
    private SysProDetailCheckMapper sysProDetailCheckMapper;
    @Override
    public List<Quote> findByInquiryId(long inquiryId) {
        QuoteExample example = new QuoteExample();
        example.createCriteria().andInquiryIdEqualTo(inquiryId);
        return quoteMapper.selectByExample(example);
    }
    @Transactional
    @Override
    public void saveOrUpdate(QuoteExtend quote) {
        long time = new Date().getTime();
        long operatorId = quote.getOperator();
        if (quote.getId() != null){
            /*inquiryMapper.updateByPrimaryKeySelective(inquiry);
            List<SysFile> files = inquiry.getFiles();
            if (files != null && files.size() > 0  ) {
                for ( SysFile file : files ) {
                    file.setTime(time);
                    file.setIsActive(1);
                    file.setIsUseful(1);
                    file.setOperator(operatorId);
                    // 询价文件
                    if(file.getType() == SysFileExtend.TYPE_INQUIRY) {
                        SysFileExample example = new SysFileExample();
                        example.createCriteria().andOtherIdEqualTo(inquiry.getId()).andTypeEqualTo(SysFileExtend.TYPE_INQUIRY);
                        List<SysFile> sysFiles = sysFileMapper.selectByExample(example);
                        //替换
                        if (sysFiles.size() > 0){
                            sysFileMapper.updateByExampleSelective(file, example);
                        }else {
                            //插入
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
                                file.setOtherId(inquiry.getId());


                                sysFileMapper.insert(file);
                                System.out.println("数据库");
                            }
                        }
                    }else if(file.getType() == SysFileExtend.TYPE_TECHNOLOGY){
                        // 技术文件
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
                            file.setType(SysFileExtend.TYPE_TECHNOLOGY);
                            file.setOtherId(inquiry.getId());
                            sysFileMapper.insert(file);
                            System.out.println("数据库");
                        }
                    }
                }
            }*/
        }else {
            long quoteId = IDUtils.getId();
            //文件上传
            List<SysFile> files = quote.getFiles();
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
                    file.setType(SysFileExtend.TYPE_QUOTE);
                    file.setOtherId(quoteId);
                    file.setTime(time);
                    file.setIsActive(1);
                    file.setIsUseful(1);
                    sysFileMapper.insert(file);
                    System.out.println("数据库");
                }
            }

        }
    }

    @Override
    public void batchAddQuote(MultipartFile uploadFile) throws IOException {

    }
}
