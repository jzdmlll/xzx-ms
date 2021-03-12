package com.xzx.xzxms.inquiry.controller;/**
 * @Author sunny
 * @Date 2021/2/19 16:02
 * @Version 1.0
 */

import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.inquiry.service.IIndexService;
import com.xzx.xzxms.inquiry.vo.ProProcessVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *@ClassName IndexServiceController
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@RestController
@RequestMapping("/index")
public class IndexServiceController {

    @Resource
    private IIndexService iIndexServiceImpl;

    @ApiOperation("查询项目流程")
    @GetMapping("findProProcess")
    public Message findProProcess(Long proId){
        List<ProProcessVO> list = iIndexServiceImpl.findProProcess(proId);
        return MessageUtil.success("success", list);
    }

}
