package com.xzx.xzxms.purchase.vo;

/**
 * @author：ZJW
 * @title：
 * @date：2021/1/8 11:22
 * @修改人：
 * @修改时间：2021/1/8 11:22
 * @修改描述：默认描述
 */
public class PurchaseProjectVO {
    private Long id;
    private String projectName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "PurchaseProjectVO{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
