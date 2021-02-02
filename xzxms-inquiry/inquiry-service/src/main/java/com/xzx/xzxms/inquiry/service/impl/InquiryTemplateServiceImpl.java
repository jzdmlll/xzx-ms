package com.xzx.xzxms.inquiry.service.impl;/**
 * @Author sunny
 * @Date 2021/1/23 19:45
 * @Version 1.0
 */

import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.utils.JsonUtils;
import com.xzx.xzxms.inquiry.bean.InquiryTemplate;
import com.xzx.xzxms.inquiry.bean.InquiryTemplateWithBLOBs;
import com.xzx.xzxms.inquiry.dao.InquiryTemplateMapper;
import com.xzx.xzxms.inquiry.dao.extend.InquiryTemplateExtendMapper;
import com.xzx.xzxms.inquiry.service.IInquiryTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName InquiryTemplateServiceImpl
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Service
public class InquiryTemplateServiceImpl implements IInquiryTemplateService {

    @Resource
    private InquiryTemplateMapper inquiryTemplateMapper;
    @Resource
    private InquiryTemplateExtendMapper inquiryTemplateExtendMapper;
    @Resource
    private JedisDao jedisDaoImpl;

    @Override
    public List<InquiryTemplateWithBLOBs> findInquiryTemplate(Long id) {
        String key = "";
        if(id == null) {
            key = "xzx:inquiryTemplate:all";
        }else {
            key = "xzx:inquiryTemplate:" + id;
        }
        if(jedisDaoImpl.exists(key)) {
            String json = jedisDaoImpl.get(key);
            return JsonUtils.jsonToList(json, InquiryTemplateWithBLOBs.class);
        }else {
            List<InquiryTemplateWithBLOBs> templateList = inquiryTemplateExtendMapper.findAll(id);
            jedisDaoImpl.set(key, JsonUtils.objectToJson(templateList));
            return templateList;
        }
    }

    @Override
    public void insertInquiryTemplate(InquiryTemplateWithBLOBs inquiryTemplateWithBLOBs) {
        inquiryTemplateWithBLOBs.setTime(new Date().getTime());
        inquiryTemplateWithBLOBs.setJsonKeys(JsonUtils.string2Json(inquiryTemplateWithBLOBs.getJsonKeys().trim()));
        inquiryTemplateWithBLOBs.setTableColumn(JsonUtils.string2Json(inquiryTemplateWithBLOBs.getTableColumn().trim()));
        inquiryTemplateMapper.insertSelective(inquiryTemplateWithBLOBs);

        if(jedisDaoImpl.exists("xzx:inquiryTemplate:all")) {
            jedisDaoImpl.del("xzx:inquiryTemplate:all");
        }
    }

    @Override
    public void updateInquiryTemplate(InquiryTemplateWithBLOBs inquiryTemplateWithBLOBs) {

        inquiryTemplateWithBLOBs.setTime(new Date().getTime());
        inquiryTemplateWithBLOBs.setJsonKeys(JsonUtils.string2Json(inquiryTemplateWithBLOBs.getJsonKeys().trim()));
        inquiryTemplateWithBLOBs.setTableColumn(JsonUtils.string2Json(inquiryTemplateWithBLOBs.getTableColumn().trim()));
        inquiryTemplateMapper.updateByPrimaryKeyWithBLOBs(inquiryTemplateWithBLOBs);

        if(jedisDaoImpl.exists("xzx:inquiryTemplate:all")) {
            jedisDaoImpl.del("xzx:inquiryTemplate:all");
        }

        if (jedisDaoImpl.exists("xzx:inquiryTemplate:"+ inquiryTemplateWithBLOBs.getId())) {
            jedisDaoImpl.del("xzx:inquiryTemplate:"+ inquiryTemplateWithBLOBs.getId());
        }
    }

    @Override
    public void setInvalidInquiryTemplate(InquiryTemplate inquiryTemplate) {

        inquiryTemplateMapper.deleteByPrimaryKey(inquiryTemplate.getId());

        if(jedisDaoImpl.exists("xzx:inquiryTemplate:all")) {
            jedisDaoImpl.del("xzx:inquiryTemplate:all");
        }

        if (jedisDaoImpl.exists("xzx:inquiryTemplate:"+ inquiryTemplate.getId())) {
            jedisDaoImpl.del("xzx:inquiryTemplate:"+ inquiryTemplate.getId());
        }
    }
}
