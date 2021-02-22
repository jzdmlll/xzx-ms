package com.xzx.xzxms.commons.fileupload;

import com.xzx.xzxms.system.bean.SysFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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

    /**
     * 各模块文件上传
     * @param otherId
     * @param fileList 前端需写入操作人
     * @param fileType 文件类型
     */
    void fileUpload(Long otherId, List<SysFile> fileList, Integer fileType, String operator);
}
