package com.xzx.xzxms.web.controller;

import com.xzx.xzxms.service.IPicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class PicController {
    @Resource
    private IPicService picServiceImpl;
    /**
     * 文件上传
     * @param uploadFile
     * @return
     */
    @RequestMapping("pic/upload")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam("file") MultipartFile uploadFile){
        return picServiceImpl.uploadBySFTP(uploadFile);
    }
}
