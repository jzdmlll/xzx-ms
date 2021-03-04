package com.xzx.xzxms.inquiry.dao.extend;/**
 * @Author sunny
 * @Date 2021/2/19 15:13
 * @Version 1.0
 */

import com.xzx.xzxms.inquiry.vo.ProProcessVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@ClassName ProProcessExtendMapper
 *@Description TODO
 *@Author sunny
 *@Date DATE{TIME}
 */
@Mapper
public interface ProProcessExtendMapper {

    /**
     * 查询项目流程进展
     * @param proId
     * @return
     */
    List<ProProcessVO> findProProcessByProId(@Param("proId") Long proId);
}
