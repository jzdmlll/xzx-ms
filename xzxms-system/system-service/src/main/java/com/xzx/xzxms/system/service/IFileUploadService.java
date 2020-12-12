package com.xzx.xzxms.system.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public interface IFileUploadService {
    /**
     * 文件上传通过ftp
     * @return
     */
    Map<String,Object> upload(MultipartFile uploadFile);
    /**
     * 文件上传通过sftp
     * @return
     */
    Map<String,Object> uploadBySFTP(MultipartFile uploadFile);
    /**
     * 文件上传通过流
     * @return
     */
    Map<String,Object> uploadByStream(InputStream inputStream, String fileName);
    /**
     * 文件上传到redis
     * @return
     */
    Map<String,Object> uploadByRedis(MultipartFile uploadFile) throws IOException;
}
