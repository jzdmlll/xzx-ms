package com.xzx.xzxms.chapter.dao.extend;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzx.xzxms.chapter.dto.ChapterAuditorDTO;
import com.xzx.xzxms.chapter.vo.ChapterAuditVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/20 14:13
 * @修改人：
 * @修改时间：2021/1/20 14:13
 * @修改描述：默认描述
 */
@Mapper
public interface ChapterAuditExtendMapper {
    /**
     * 周嘉玮
     * 下拉显示所有可发往的用章审核人
     */
    List<ChapterAuditorDTO> findAllChapterAuditor();

    /**
     * 根据输入条件进行查询、模糊查询
     * @param proId
     * @param startTime
     * @param overTime
     * @param auditStatus
     * @return
     */
    IPage<ChapterAuditVO> findChapterAuditor(Page<?> page,
                                             @Param("proName") String proId,
                                             @Param("startTime") Long startTime,
                                             @Param("overTime") Long overTime,
                                             @Param("auditStatus") Integer auditStatus);
}
