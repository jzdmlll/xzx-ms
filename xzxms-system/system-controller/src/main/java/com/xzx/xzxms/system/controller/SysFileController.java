package com.xzx.xzxms.system.controller;/**
 * @Author sunny
 * @Date 2021/1/6 10:39
 * @Version 1.0
 */

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.system.bean.SysFile;
import com.xzx.xzxms.system.service.ISysFileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName SysFileController
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */

@RestController
@RequestMapping("/file")
public class SysFileController {

    @Resource
    private ISysFileService iSysFileServiceImpl;

    @ApiOperation("根据项目ID查询出文件")
    @GetMapping(value = "findByProId")
    public Message findByProId(Long proId){

        List<SysFile> sysFiles =iSysFileServiceImpl.findByProId(proId);
        return MessageUtil.success("success", sysFiles);
    }

}
