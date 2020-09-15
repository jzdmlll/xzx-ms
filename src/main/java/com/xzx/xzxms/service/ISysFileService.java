package com.xzx.xzxms.service;


import com.xzx.xzxms.bean.SysFile;

import java.util.List;

public interface ISysFileService {

    /**
     * 查询全部内容
     * @return
     */
    List<SysFile> findAll();

    /**
     * 根据设备类别的ID查询相对应的询价全部内容
     * @param fileId
     * @return
     */
    List<SysFile> findById(long fileId);

    /**
     * 保存或更改设备类别信息
     * @param sysFile
     */
    void saveOrUpdate(SysFile sysFile);

    /**
     * 批量置为无效
     * @param ids
     */
    void setInvalid(long[] ids);

    /**
     * 批量删除
     * @param ids
     */
    void delete(long[] ids);
}
