package com.xzx.xzxms.chapter.dao.extend;

import com.xzx.xzxms.chapter.bean.ChapterAudit;
import com.xzx.xzxms.chapter.dto.ChapterAuditorDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
@Repository
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
    List<ChapterAudit> findChapterAuditor(@Param("proName") String proId,
                                                    @Param("startTime") Long startTime,
                                                    @Param("overTime") Long overTime,
                                                    @Param("auditStatus") Integer auditStatus);
}
