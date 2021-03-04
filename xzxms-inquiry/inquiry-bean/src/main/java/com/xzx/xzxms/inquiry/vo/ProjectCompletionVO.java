package com.xzx.xzxms.inquiry.vo;

/**
 * @Author Lzc
 * @Date 2021/3/2 16:51
 * @Version 1.0
 */
public class ProjectCompletionVO {
    // 项目ID
    private Long id;
    // 项目名
    private String name;
    // 项目完成度
    private Double completion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCompletion() {
        return completion;
    }

    public void setCompletion(Double completion) {
        this.completion = completion;
    }
}
