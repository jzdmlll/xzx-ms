package com.xzx.xzxms.service;



import com.xzx.xzxms.bean.SysUser;
import com.xzx.xzxms.bean.extend.SysUserExtend;
import com.xzx.xzxms.vm.UserVM;

import java.util.List;

public interface ISysUserService {
    /**
     * 登录
     * @param SysUserVM
     * @return
     */
    SysUser login(UserVM SysUserVM);
    /**
     * 通过id获取用户信息
     * @param id
     * @return
     */
    SysUserExtend findById(long id);
    /**
     * 查询所有用户信息
     * @return
     */
    List<SysUser> findAll();
    /**
     * 级联查询所有用户信息
     * @return
     */
    List<SysUserExtend> findAllCascade();
    /**
     * 根据id删除用户
     * @param id
     */
    void deleteById(long id);
    /**
     * 新增或修改用户
     * @param SysUser
     */
    void saveOrUpdate(SysUser SysUser);

    /**
     * 给指定用户设置角色
     * @param roles
     * @param id
     */
    void setRoles(List<Long> roles, long id);

    /**
     * 发送邮箱验证码
     * @param email
     */
    void getCode(String email);

    /**
     * 注册
     * @param SysUser
     */
    void register(SysUser SysUser);
}
