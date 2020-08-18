package com.xzx.xzxms.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface IPicService {
    /**
     * 图片上传
     * @return
     */
    Map<String,Object> upload(MultipartFile uploadFile);
    /**
     * 图片上传
     * @return
     */
    Map<String,Object> uploadBySFTP(MultipartFile uploadFile);
}
