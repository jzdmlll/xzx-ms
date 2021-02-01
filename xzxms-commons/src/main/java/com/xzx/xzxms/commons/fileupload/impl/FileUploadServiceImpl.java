package com.xzx.xzxms.commons.fileupload.impl;

import com.xzx.xzxms.commons.constant.CommonConstant;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.utils.Base64Util;
import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.commons.utils.FtpUtil;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.system.bean.SysFileExample;
import com.xzx.xzxms.system.bean.extend.SysFileExtend;
import com.xzx.xzxms.system.dao.SysFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.xzx.xzxms.commons.fileupload.IFileUploadService;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;

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
    @Value("${ftpclient.realHost}")
    private String realHost;

    @Resource
    private SysFileMapper sysFileMapper;
    @Resource
    private IFileUploadService fileUploadServiceImpl;

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
                map.put("url", "http://"+realHost+":8006"+"/images/"+fileName);
            }else{
                map.put("error", 1);
                map.put("msg", "文件上传失败!");
                throw new CustomerException("文件上传失败!");
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
            map = uploadByStream(uploadFile.getInputStream(), oldName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        return map;
    }

    @Override
    public Map<String, Object> uploadByStream(InputStream inputStream, String fileName) {
        Map<String,Object> map = new HashMap<>();
        boolean result = false;
        FileOutputStream os = null;
        try {
            //SFTPUtil sftp = new SFTPUtil(username, password, host, 22);
            fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
           // result = sftp.upload(dictory,fileName,inputStream);
            BufferedInputStream bufin = new BufferedInputStream(inputStream);
            int len = bufin.available();
            System.out.println("len"+len);
            int buffSize = 256;
            os = new FileOutputStream(dictory+fileName);


            byte[] temp = new byte[buffSize];
            int size = 0;
            while ((size = bufin.read(temp)) != -1) {
                os.write(temp, 0, size);
            }
            os.flush();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(result){
                map.put("error", 0);
                map.put("url", "http://"+realHost+":8006"+"/images/"+fileName);
                map.put("msg", "上传成功");
                map.put("name", fileName);
                map.put("status", 200);
                map.put("fileId", IDUtils.getId());
                map.put("fileName", fileName);
            }else{
                map.put("error", 1);
                map.put("msg", "文件上传失败!");
                throw new CustomerException("文件上传失败!");
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        map.put("status", 200);

        map.put("error", 0);
        map.put("message", "上传成功");
        map.put("fileId", fileId);
        map.put("fileName", oldName);
        map.put("url", "http://"+realHost+":8006"+"/images/"+fileName);
        return map;
        //return uploadBySFTP(uploadFile);
    }

    @Transactional
    @Override
    public void fileUpload(Long otherId, List<SysFile> fileList, Integer fileType) {

        SysFileExample sysFileExample = new SysFileExample();
        sysFileExample.createCriteria().andOtherIdEqualTo(otherId).andIsActiveEqualTo(CommonConstant.EFFECTIVE)
                .andTypeEqualTo(fileType);
        Long fileNum = sysFileMapper.countByExample(sysFileExample);

        if (fileNum > 0) {
            //因前端将已存在的文件查询出，并同新上传的文件的一并提交，故文件先置为无效
            SysFile newFile = new SysFile();
            newFile.setIsActive(CommonConstant.INVALID);
            sysFileMapper.updateByExampleSelective(newFile, sysFileExample);
        }

        Long time = new Date().getTime();
        // 遍历
        for (SysFile file : fileList) {

            // 文件上传 redis --> nginx
            if (file.getOperator()==null || "".equals(file.getOperator())) {
                if (jedisDaoImpl.exists(file.getId().toString())) {
                    //从redis中取出base64文件码
                    String base64File = jedisDaoImpl.get(file.getId().toString());
                    //解码，还原成输入流
                    InputStream inputStream = Base64Util.decodeBase64File(base64File);
                    //清除redis该文件缓存
                    jedisDaoImpl.del(file.getId().toString());
                    //上传到Nginx
                    Map<String, Object> map = fileUploadServiceImpl.uploadByStream(inputStream, file.getName());
                    file.setUrl(map.get("url").toString());
                }else {
                    throw new CustomerException("文件上传信息过期，请重新上传");
                }
            }else {
                // 新增 重新生成ID
                file.setId(IDUtils.getId());
            }
            //文件信息插入到数据库

            file.setType(fileType);
            file.setOtherId(otherId);
            file.setTime(time);
            file.setIsActive(CommonConstant.EFFECTIVE);
            file.setIsUseful(CommonConstant.IS_NOT_USEFUL);
            sysFileMapper.insert(file);
        }
    }
}

