package com.xzx.xzxms.config;


import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.utils.*;
import com.xzx.xzxms.system.bean.SysPrivilege;
import com.xzx.xzxms.system.bean.SysPrivilegeExample;
import com.xzx.xzxms.system.bean.SysRole;
import com.xzx.xzxms.system.bean.SysRolePrivilege;
import com.xzx.xzxms.system.bean.extend.SysUserExtend;
import com.xzx.xzxms.system.dao.SysPrivilegeMapper;
import com.xzx.xzxms.system.dao.SysRolePrivilegeMapper;
import com.xzx.xzxms.system.service.ISysPrivilegeService;
import com.xzx.xzxms.system.service.ISysUserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ISysPrivilegeService privilegeService;
    @Resource
    private SysPrivilegeMapper sysPrivilegeMapper;
    @Resource
    private SysRolePrivilegeMapper sysRolePrivilegeMapper;
    @Resource
    private ISysUserService sysUserService;
    @Value("${webconfig.auto-add-privilege}")
    private Boolean autoAddPrivilege;
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
        if(autoAddPrivilege) {
            // 自动添加权限
            SysPrivilegeExample example = new SysPrivilegeExample();
            example.createCriteria().andRouteEqualTo(path);
            Long result = sysPrivilegeMapper.countByExample(example);
            if(result == 0) {
                String[] split = path.split("/");
                String pathParentLike = split[1];
                example = new SysPrivilegeExample();
                example.createCriteria().andParentIdIsNull().andRouteLike("%"+pathParentLike+"%");
                List<SysPrivilege> sysPrivileges = sysPrivilegeMapper.selectByExample(example);
                if(sysPrivileges.size() == 1) {
                    Long pId = sysPrivileges.get(0).getId();
                    SysPrivilege privilege = new SysPrivilege();
                    Long privilegeId = IDUtils.getId();
                    Long time = new Date().getTime();
                    privilege.setId(privilegeId);
                    privilege.setIsActive(1);
                    privilege.setTime(time);
                    privilege.setType("method");
                    privilege.setRoute(path);
                    privilege.setName(path);
                    privilege.setRemark("auto-add");
                    privilege.setParentId(pId);
                    sysPrivilegeMapper.insert(privilege);

                    // 自动授权
                    List<SysRole> roles = sysUserService.findById(userId).getRoles();
                    if(roles.size() > 0) {
                        SysRolePrivilege sysRolePrivilege = new SysRolePrivilege();
                        sysRolePrivilege.setRoleId(roles.get(0).getId());
                        sysRolePrivilege.setPrivilegeId(privilegeId);
                        sysRolePrivilege.setTime(time);
                        sysRolePrivilegeMapper.insert(sysRolePrivilege);
                    }

                    throw new CustomerException("权限不足--自动添加路由【"+path+"】成功--自动授权成功");
                }
                throw new CustomerException("权限不足--自动添加路由【"+path+"】失败，找不到父权限" );
            }
        }
        throw new PermissionException("权限不足");
    }

}