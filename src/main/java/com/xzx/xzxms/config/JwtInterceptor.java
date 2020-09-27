package com.xzx.xzxms.config;


import com.xzx.xzxms.bean.SysPrivilege;
import com.xzx.xzxms.dao.redis.JedisDao;
import com.xzx.xzxms.service.ISysPrivilegeService;
import com.xzx.xzxms.utils.JwtTokenUtil;
import com.xzx.xzxms.utils.PermissionException;
import com.xzx.xzxms.utils.UnAuthorizedException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ISysPrivilegeService privilegeService;
    @Autowired
    private JedisDao jedisDaoImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果是options请求，直接返回true，不进行拦截
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        // 获取请求头信息authorization信息
        final String token = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        if(StringUtils.isEmpty(token)){
            throw new UnAuthorizedException("用户还未登录");
            /*System.out.println("用户还未登录");
            return true;*/
        }
        // 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
        Claims claims = JwtTokenUtil.parseJWT(token, JwtTokenUtil.base64Secret);
        if(claims == null ){
            if(jedisDaoImpl.exists(token)) {
                response.setHeader("Access-Control-Expose-Headers", "refresh");
                response.setHeader("refresh", "true");
            } else {
                throw new AuthenticationException("token过期, 请重新登陆");
            }
        }else {
            // 验证权限，通过token获取用户id，通过用户id获取权限，这里使用redis将用户信息维护在缓存中，减少与数据库交互次数
            long id = Long.parseLong(JwtTokenUtil.getUserId(token, JwtTokenUtil.base64Secret));
            this.auth(id, request.getServletPath());
        }
        return true;
    }

    // 判断权限
    private boolean auth(long userId,String path){
        // 查询出该用户的所有权限
        List<SysPrivilege> privileges = privilegeService.findByUserId(userId);
        // 匹配
        for(SysPrivilege p : privileges){
            if(p.getRoute().matches(path)){
                return true;
            }
        }
        throw new PermissionException("权限不足");
    }

}