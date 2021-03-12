package com.xzx.xzxms.system.service.impl;

import com.xzx.xzxms.commons.aspect.annotation.AutoLog;
import com.xzx.xzxms.commons.utils.*;
import com.xzx.xzxms.system.bean.*;
import com.xzx.xzxms.system.bean.extend.SysUserExtend;
import com.xzx.xzxms.system.dao.SysUserMapper;
import com.xzx.xzxms.system.dao.SysUserRoleMapper;
import com.xzx.xzxms.system.dao.extend.SysUserExtendMapper;
import com.xzx.xzxms.commons.dao.redis.JedisDao;
import com.xzx.xzxms.system.vm.UserRoleVM;
import com.xzx.xzxms.system.vm.UserVM;
import org.springframework.stereotype.Service;
import com.xzx.xzxms.system.service.ISysUserService;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysUserServiceImpl implements ISysUserService {
    @Resource
    private SysUserMapper userMapper;
    @Resource
    private SysUserExtendMapper userExtendMapper;
    @Resource
    private SysUserRoleMapper userRoleMapper;
    @Resource
    private JedisDao jedisDaoImpl;

    @AutoLog(value = "登录成功！用户：")
    @Override
    public Map<String, String> login(UserVM userVM) {
        String username = userVM.getUsername();
        String password = userVM.getPassword();
        SysUser user = null;
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<SysUser> userList = userMapper.selectByExample(example);
        if(userList!=null && userList.size()>0) {
            //验证密码
            user = userList.get(0);
            if (password.equals(user.getPassword())) {
                // 2. 如果登录成功产生token,将token缓存起来，返回
                Map<String, String> map = new HashMap<>();
                //通过jwt产生token
                String token = JwtTokenUtil.createJWT(user.getId(), user.getUsername());
                map.put("token", token);
                // 将角色ID 放入
                SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
                sysUserRoleExample.createCriteria().andUserIdEqualTo(user.getId());
                UserRoleVM userRoleVM = new UserRoleVM();
                userRoleVM.setId(user.getId());
                userRoleVM.setUsername(user.getUsername());
                userRoleVM.setAvatar(user.getAvatar());
                List<SysUserRole> userRoles = userRoleMapper.selectByExample(sysUserRoleExample);
                if (userRoles != null && userRoles.size() > 0) {
                    List<Long> roles = new ArrayList<>();
                    for (SysUserRole sysUserRole:userRoles) {
                        roles.add(sysUserRole.getRoleId());
                    }
                    userRoleVM.setRoles(roles);
                }
                //放入redis缓存
                String userJson = JsonUtils.objectToJson(userRoleVM);
                jedisDaoImpl.setCode(token, userJson, JwtTokenUtil.REDIS_TOKEN_TIME);
                return map;
            }else {
                throw new CustomerException("密码错误");
            }
        }else {
            throw new CustomerException("用户名不存在");
        }
    }

    @Override
    public SysUserExtend findById(long id) {
        return userExtendMapper.selectById(id);
    }

    @Override
    public List<SysUser> findAll() {
        return userMapper.selectByExample(new SysUserExample());
    }

    @Override
    public List<SysUserExtend> findAllCascade() {
        return userExtendMapper.selectAll();
    }

    @Override
    public void deleteById(long id) {
        SysUser user = this.findById(id);
        if(user==null){
            throw new CustomerException("该用户不存在");
        }
        userMapper.deleteByPrimaryKey(id);
        jedisDaoImpl.del("xzx:user:all");
    }

    @Override
    public void saveOrUpdate(SysUser user) {
        if(user.getId()!=null){
            userMapper.updateByPrimaryKeySelective(user);
        } else {
            // 判断用户名是否被占用
            SysUserExample example = new SysUserExample();
            example.createCriteria().andUsernameEqualTo(user.getUsername());
            List<SysUser> list = userMapper.selectByExample(example);
            if(list.size()>0){
                throw new CustomerException("该用户已经被占用");
            }
            register(user);
        }
        jedisDaoImpl.del("xzx:user:all");
    }

    @Override
    public void setRoles(List<Long> roles, long id) {
        // 根据userid查询自己的角色
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(id);
        // 用户角色关系,获取所有老的角色
        List<SysUserRole> list = userRoleMapper.selectByExample(example);
        List<Long> oldRoles = new ArrayList<>();
        Iterator<SysUserRole> iterator = list.iterator();
        while(iterator.hasNext()){
            oldRoles.add(iterator.next().getRoleId());
        }
        // [1,2,3] -> [3,4] 添加1,2 => [1,2,3,4]
        // 依次判断新角色是否存在于list中，如果不存在则添加
        for(Long roleId : roles){
            if(!oldRoles.contains(roleId)){
                SysUserRole userRole = new SysUserRole();
                userRole.setRoleId(roleId);
                userRole.setUserId(id);
                userRoleMapper.insert(userRole);
            }
        }
        // [1,2,3] -> [1,2,3,4]   删除 3,4  => [1,2]
        // 依次判断旧的角色是否存在于roles中，如果不存在则删除
        for(SysUserRole userRole : list){
            if(!roles.contains(userRole.getRoleId())){
                SysUserRoleExample example1 = new SysUserRoleExample();
                userRoleMapper.deleteByPrimaryKey(userRole.getId());
            }
        }
    }

    @Override
    public void getEmailBindCode(String email) {
        // 邮箱 是否重复
        SysUserExample example = new SysUserExample();
        example.createCriteria().andEmailEqualTo(email);
        long num = userMapper.countByExample(example);
        if(num == 0){
            // 刷新redis中验证码
            String key = "xzx:code:bindEmail:"+email;
            if(jedisDaoImpl.exists(key)) {
                jedisDaoImpl.del(email);
            }
            //发送验证码
            String code = EmailUtils.sendEamilCode(email, "绑定邮箱");
            //存入redis,5分钟过期
            jedisDaoImpl.setCode(key, code, 5);

        }else {
            throw new CustomerException("该邮箱已绑定");
        }
    }

    @Override
    public void bindEmail(SysUser user) {
        // 邮箱 是否重复
        SysUserExample example = new SysUserExample();
        example.createCriteria().andEmailEqualTo(user.getEmail());
        long num = userMapper.countByExample(example);

        if(num == 0){
            userMapper.updateByPrimaryKeySelective(user);
        }else {
            throw new CustomerException("该邮箱已绑定");
        }
    }

    @Override
    public void register(SysUser user) {
        //插入用户
        long id = IDUtils.getId();
        user.setId(id);
        //user.setRegisterTime(new Date().getTime());
        userMapper.insertSelective(user);
        //为新用户设置默认角色（普通用户）
        SysUserRole userRole = new SysUserRole();
        userRole.setRoleId(2L);
        userRole.setUserId(id);
        userRoleMapper.insert(userRole);
    }

    @Override
    public Boolean validOldPassword(Long id, String password) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andIdEqualTo(id).andPasswordEqualTo(password);
        long num = userMapper.countByExample(example);
        if (num > 0) {
            return true;
        }
        return false;
    }
}
