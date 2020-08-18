package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.service.IPicService;
import com.xzx.xzxms.utils.FtpUtil;
import com.xzx.xzxms.utils.SFTPUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PicServiceImpl implements IPicService {
    @Value("${ftpclient.host}")
    private String host;
    @Value("${ftpclient.port}")
    private int port;
    @Value("${ftpclient.username}")
    private String username;
    @Value("${ftpclient.password}")
    private String password;
    @Value("${ftpclient.basePath}")
    private String basePath;
    @Value("${ftpclient.filePath}")
    private String filePath;
    @Value("${ftpclient.dictory}")
    private String dictory;

    @Override
    public Map<String, Object> upload(MultipartFile uploadFile) {
        Map<String,Object> map = new HashMap<>();
        String oldName = uploadFile.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        boolean result = false;
        try {
            result = FtpUtil.uploadFile(host, port, username, password, basePath, filePath, fileName, uploadFile.getInputStream());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(result){
                map.put("error", 0);
                map.put("url", "http://images."+host+"/images/"+fileName);
            }else{
                map.put("error", 1);
                map.put("msg", "图片上传失败!");
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> uploadBySFTP(MultipartFile uploadFile) {
        Map<String,Object> map = new HashMap<>();
        String oldName = uploadFile.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        boolean result = false;
        try {
            SFTPUtil sftp = new SFTPUtil(username, password, host, 22);
            result = sftp.upload(dictory,fileName,uploadFile.getInputStream());
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(result){
                map.put("error", 0);
                map.put("url", "http://images."+host+"/images/"+fileName);
                map.put("msg", "上传成功");
            }else{
                map.put("error", 1);
                map.put("msg", "图片上传失败!");
            }
        }
        return map;
    }
}

