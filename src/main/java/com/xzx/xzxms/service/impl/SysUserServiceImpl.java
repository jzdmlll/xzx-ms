package com.xzx.xzxms.service.impl;

import com.xzx.xzxms.bean.SysUser;
import com.xzx.xzxms.bean.SysUserExample;
import com.xzx.xzxms.bean.SysUserRole;
import com.xzx.xzxms.bean.SysUserRoleExample;
import com.xzx.xzxms.bean.extend.SysUserExtend;
import com.xzx.xzxms.dao.SysUserMapper;
import com.xzx.xzxms.dao.SysUserRoleMapper;
import com.xzx.xzxms.dao.extend.SysUserExtendMapper;
import com.xzx.xzxms.dao.redis.JedisDao;
import com.xzx.xzxms.service.ISysUserService;
import com.xzx.xzxms.utils.CustomerException;
import com.xzx.xzxms.utils.IDUtils;
import com.xzx.xzxms.vm.UserVM;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Override
    public SysUser login(UserVM userVM) {
        String username = userVM.getUsername();
        String password = userVM.getPassword();

        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<SysUser> userList = userMapper.selectByExample(example);
        if(userList!=null && userList.size()>0) {
            SysUser user = userList.get(0);
            //验证密码
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
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
    public void getCode(String email) {
        //验证邮箱是否注册
       /* SysUserExample example = new SysUserExample();
        example.createCriteria().andEmailEqualTo(email);
        List<SysUser> users = userMapper.selectByExample(example);
        if(users.size() == 0){
            //刷新redis中验证码
            if(jedisDaoImpl.exists(email)){
                jedisDaoImpl.del(email);
            }else{
                //发送验证码
                String code = EmailUtils.sendEamilCode(email);
                //存入redis,5分钟过期
                jedisDaoImpl.setCode(email, code, 5);
            }
        }else {
            throw new CustomerException("该邮箱已注册");
        }*/
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
}
