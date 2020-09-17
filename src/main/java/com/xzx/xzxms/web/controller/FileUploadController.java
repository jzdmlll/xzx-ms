package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.service.IFileUploadService;
import com.xzx.xzxms.utils.CustomerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@Controller()
public class FileUploadController {
    @Resource
    private IFileUploadService picServiceImpl;
    /**
     * 文件上传
     * @param uploadFile
     * @return
     */
    @PostMapping("/file/upload")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam("file") MultipartFile uploadFile){
        return picServiceImpl.uploadBySFTP(uploadFile);
    }
    @PostMapping("/file/uploadCache")
    @ResponseBody
    public Map<String,Object> uploadCache(@RequestParam("file") MultipartFile uploadFile){
        try {
            return picServiceImpl.uploadByRedis(uploadFile);
        } catch (IOException e) {
            throw new CustomerException("图片上传失败");
        }
    }
}
