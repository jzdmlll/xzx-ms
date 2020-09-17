package com.xzx.xzxms.service.impl;

import com.jcraft.jsch.SftpException;
import com.xzx.xzxms.dao.redis.JedisDao;
import com.xzx.xzxms.service.IFileUploadService;
import com.xzx.xzxms.utils.Base64Util;
import com.xzx.xzxms.utils.FtpUtil;
import com.xzx.xzxms.utils.IDUtils;
import com.xzx.xzxms.utils.SFTPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements IFileUploadService {
    @Autowired
    private JedisDao jedisDaoImpl;
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
                map.put("url", "http://"+host+"/images/"+fileName);
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
                map.put("url", "http://"+host+"/images/"+fileName);
                map.put("msg", "上传成功");
            }else{
                map.put("error", 1);
                map.put("msg", "图片上传失败!");
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> uploadByStream(InputStream inputStream, String fileName) {
        Map<String,Object> map = new HashMap<>();
        boolean result = false;
        try {
            SFTPUtil sftp = new SFTPUtil(username, password, host, 22);
            result = sftp.upload(dictory,fileName,inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(result){
                map.put("error", 0);
                map.put("url", "http://"+host+"/images/"+fileName);
                map.put("msg", "上传成功");
            }else{
                map.put("error", 1);
                map.put("msg", "图片上传失败!");
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> uploadByRedis(MultipartFile uploadFile) throws IOException {
        Map<String,Object> map = new HashMap<>();
        // 将文件输入流转进行base64编码
        String oldName = uploadFile.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        String base64File = Base64Util.encodeBase64File(uploadFile.getInputStream());
        // 生成随机文件id作为key存入redis
        Long fileId = IDUtils.getId();
        jedisDaoImpl.setCode(fileId.toString(), base64File, 10L);
        map.put("error", 0);
        map.put("msg", "上传成功");
        map.put("fileId", fileId);
        map.put("fileName", oldName);
        map.put("url", "http://"+host+"/images/"+fileName);
        return map;
    }
}

