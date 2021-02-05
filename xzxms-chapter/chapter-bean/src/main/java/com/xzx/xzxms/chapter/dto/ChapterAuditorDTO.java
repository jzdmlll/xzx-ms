package com.xzx.xzxms.chapter.dto;

/**
 * @author：ZJW
 * @title：用章审核人
 * @date：2021/1/20 16:46
 * @修改人：
 * @修改时间：2021/1/20 16:46
 * @修改描述：默认描述
 */
public class ChapterAuditorDTO {
    private Long id;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ChapterAuditorDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
