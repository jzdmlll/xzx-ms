package com.xzx.xzxms.chapter.dao.extend;

import org.apache.ibatis.annotations.Mapper;
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
    List<String> findAllChapterAuditor();
}
