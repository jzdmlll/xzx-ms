package com.xzx.xzxms.system.service;


import com.xzx.xzxms.commons.utils.CustomerException;
import com.xzx.xzxms.system.bean.SysRole;
import com.xzx.xzxms.system.bean.extend.SysRoleExtend;

import java.util.List;

public interface ISysRoleService {
    /**
     * 授权
     * @param roleId
     * @param privilegeIds
     */
    void authorization(long roleId, List<Long> privilegeIds);

    /**
     * 查询所有角色
     * @return
     */
    List<SysRole> findAll();

    /**
     * 查询所有角色级联权限
     * @return
     */
    List<SysRoleExtend> cascadePrivilegeFindAll();

    /**
     * 新增或更新角色信息
     * @param baseRole
     * @throws CustomerException
     */
    void saveOrUpdate(SysRole baseRole) throws CustomerException;

    /**
     * 通过id删除角色
     * @param id
     * @throws CustomerException
     */
    void deleteById(long id) throws CustomerException;

    /**
     * 查询所有审核名
     * @return
     */
    List<SysRole> selectAllHasCheckName();
}
