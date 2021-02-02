package com.xzx.xzxms.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.commons.utils.JsonUtils;
import com.xzx.xzxms.commons.utils.JwtTokenUtil;
import com.xzx.xzxms.commons.utils.Message;
import com.xzx.xzxms.commons.utils.MessageUtil;
import com.xzx.xzxms.system.bean.SysUser;
import com.xzx.xzxms.system.bean.extend.SysPrivilegeExtend;
import com.xzx.xzxms.system.bean.extend.SysUserExtend;
import com.xzx.xzxms.system.service.ISysPrivilegeService;
import com.xzx.xzxms.system.service.ISysUserService;
import com.xzx.xzxms.system.vm.UserRoleVM;
import com.xzx.xzxms.system.vm.UserVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Validated
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private ISysUserService userServiceImpl;
    @Resource
    private ISysPrivilegeService privilegeServiceImpl;
    @Resource
    private JedisDao jedisDaoImpl;

    @GetMapping("test")
    public Message test(int a, int b){

        Message ms=new Message();
        PageHelper.startPage(a, b);
        List<SysUser> all = userServiceImpl.findAll();
        PageInfo<SysUser> pi=new PageInfo<SysUser>(all);
        ms.setData(pi);
        return ms;
    }

    @PostMapping("login")
    public Message login(@RequestBody UserVM userVM) {
        // 1. 认证用户的用户名和密码
        Map<String, String> map = userServiceImpl.login(userVM);
        return MessageUtil.success("登录成功", map);
    }

    @PostMapping("refreshToken")
    public Message refreshToken(String token) {
        // 超过15分钟，token过期，判断redis里该token是否过期，如果没过期，将token刷新返回，否则抛出token过期异常
        if(jedisDaoImpl.exists(token)) {
            String userJson = jedisDaoImpl.get(token);
            UserRoleVM user = JsonUtils.jsonToPojo(userJson, UserRoleVM.class);
            Long userId = user.getId();
            String username = user.getUsername();
            //刷新token
            String newToken = JwtTokenUtil.createJWT(userId, username);
            // 将redis中token更新
            jedisDaoImpl.setCode(newToken, userJson, JwtTokenUtil.REDIS_TOKEN_TIME);
            // 将新token返回
            Map<String, String> map = new HashMap<>();
            map.put("token", newToken);
            return MessageUtil.success("刷新token成功", map);
        }else {
            return MessageUtil.unAuthorized("token过期, 请重新登陆");
        }
    }

    @ApiOperation(value = "通过token获取用户的基本信息")
    @GetMapping("info")
    public Message info(String token) {
        // 1. 通过token获取用户信息  {id,use,gender,roles:[]}
        //从redis中获取用户id
        if (jedisDaoImpl.exists(token)) {
            String userJson = jedisDaoImpl.get(token);
            UserRoleVM user = JsonUtils.jsonToPojo(userJson, UserRoleVM.class);
            long id = user.getId();
            SysUserExtend userExtend = userServiceImpl.findById(id);
            return MessageUtil.success("success", userExtend);
        }
        return MessageUtil.error("获取用户信息失败,请重新登陆");
    }

    @PostMapping("logout")
    public Message logout(HttpServletRequest request) {
        //从请求头中获取token
        String token = request.getHeader("X-Token");
        // 1. token从缓存中移除掉
        if (jedisDaoImpl.exists(token)) {
            jedisDaoImpl.del(token);
        }
        return MessageUtil.success("退出成功");
    }

    @ApiOperation(value = "查询所有")
    @GetMapping(value = "findAll")
    public Message findAll() {
        List<SysUser> list = userServiceImpl.findAll();
        return MessageUtil.success("success", list);
    }

    @ApiOperation(value = "查询所有", notes = "级联用户角色")
    @GetMapping(value = "cascadeRoleFindAll")
    public Message cascadeRoleFindAll() {
        List<SysUserExtend> list = userServiceImpl.findAllCascade();
        return MessageUtil.success("success", list);
    }

    @ApiOperation(value = "保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(SysUser User) {
        userServiceImpl.saveOrUpdate(User);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping(value = "deleteById")
    public Message deleteById(long id) {
        userServiceImpl.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "设置权限")
    @PostMapping(value = "setRoles")
    public Message setRoles(UserRoleVM userRoleVM) {
        System.out.println(userRoleVM);
        userServiceImpl.setRoles(userRoleVM.getRoles(), userRoleVM.getId());
        return MessageUtil.success("设置成功");
    }

    @ApiOperation(value = "通过用户id查询权限")
    @GetMapping(value = "findMenuByUserId")
    public Message findMenuByUserId(long id) {
        List<SysPrivilegeExtend> menuList = privilegeServiceImpl.findMenuByUserId(id);
        return MessageUtil.success("success",menuList);
    }

    @ApiOperation(value = "获取验证码")
    @GetMapping(value = "getCode")
    public Message getCode(String email) {
        userServiceImpl.getCode(email);
        return MessageUtil.success("success");
    }

   /* @ApiOperation(value = "注册")
    @PostMapping(value = "register")
    public Message register(UserRegister user) {
        *//*String code = user.getCode();
        System.out.println(user.getEmail()+" "+code);
        if(jedisDaoImpl.exists(user.getEmail())){
            if((jedisDaoImpl.get(user.getEmail())).equals(code)){
                System.out.println(jedisDaoImpl.get(user.getEmail()));
                userServiceImpl.register(user);
                return MessageUtil.success("注册成功");
            }
            return MessageUtil.error("验证码错误");
        }else{
            return MessageUtil.error("验证码已过期");
        }*//*
        return null;
    }*/

    @ApiOperation(value = "通过id查询用户")
    @GetMapping(value = "findById")
    public Message register(long id) {
        SysUserExtend user = userServiceImpl.findById(id);
        return MessageUtil.success("success",user);
    }
}