package com.xzx.xzxms.purchase.vm;

/**
 * @author：ZJW
 * @title：
 * @date：2020/12/15 19:51
 * @修改人：
 * @修改时间：2020/12/15 19:51
 * @修改描述：默认描述
 */
public class PurchaseProjectVM {
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
        return "PurchaseProjectVM{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
