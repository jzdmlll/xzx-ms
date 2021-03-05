package com.xzx.xzxms.commons.model.base.service.impl;

import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.model.base.service.BaseCommonService;
import com.xzx.xzxms.commons.utils.IDUtils;
import com.xzx.xzxms.commons.utils.IPUtils;
import com.xzx.xzxms.commons.utils.JwtTokenUtil;
import com.xzx.xzxms.commons.utils.SpringContextUtils;
import com.xzx.xzxms.system.bean.SysLog;
import com.xzx.xzxms.system.bean.SysRole;
import com.xzx.xzxms.system.bean.SysRoleExample;
import com.xzx.xzxms.system.bean.SysUser;
import com.xzx.xzxms.system.dao.SysLogMapper;
import com.xzx.xzxms.system.dao.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class BaseCommonServiceImpl implements BaseCommonService {

    @Resource
    private SysLogMapper sysLogMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private JedisDao jedisDaoImpl;

    @Override
    public void addLog(SysLog log) {
        if(log.getId() == null) {
            log.setId(IDUtils.getId());
        }
        sysLogMapper.insert(log);
    }

    @Override
    public void addLog(String LogContent, Integer logType, Integer operateType, SysUser user) {
        SysLog sysLog = new SysLog();
        sysLog.setId(IDUtils.getId());
        //注解上的描述,操作日志内容
        sysLog.setLogContent(LogContent);
        sysLog.setLogType(logType);
        sysLog.setOperateType(operateType);
        HttpServletRequest request = null;
        try {
            //获取request
            request = SpringContextUtils.getHttpServletRequest();
            //设置IP地址
            sysLog.setIp(IPUtils.getIpAddr(request));
        } catch (Exception e) {
            sysLog.setIp("127.0.0.1");
        }
        //获取登录用户信息
        Long userId = null;
        String username = "";
        if(user == null) {
            String token = request.getHeader("X-Token");

            if(!(token == null || "".equals(token))){
                userId = Long.parseLong(JwtTokenUtil.getUserId(token, JwtTokenUtil.base64Secret).trim());
                username = JwtTokenUtil.getUsername(token, JwtTokenUtil.base64Secret);
            }

        }else {
            userId = user.getId();
            username = user.getUsername();
        }

        sysLog.setUserid(userId);
        sysLog.setUsername(username);
        sysLog.setCreateTime(new Date().getTime());
        //保存系统日志
        sysLogMapper.insert(sysLog);
    }

    @Override
    public void addLog(String LogContent, Integer logType, Integer operateType) {
        addLog(LogContent, logType, operateType, null);
    }

    @Override
    public void removePrivilegeRedis() {
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(new SysRoleExample());
        if (sysRoles!=null && sysRoles.size() > 0) {
            for(SysRole role: sysRoles) {
                String key = "xzx:privilege:"+role.getId();
                String menuKey = "xzx:menu:"+role.getId();
                if(jedisDaoImpl.exists(key)) {
                    jedisDaoImpl.del(key);
                }
                if(jedisDaoImpl.exists(menuKey)) {
                    jedisDaoImpl.del(menuKey);
                }
            }
        }
        if (jedisDaoImpl.exists("xzx:menu:all")) {
            jedisDaoImpl.del("xzx:menu:all");
        }
        if (jedisDaoImpl.exists("xzx:privilege:all")) {
            jedisDaoImpl.del("xzx:privilege:all");
        }
    }

}
