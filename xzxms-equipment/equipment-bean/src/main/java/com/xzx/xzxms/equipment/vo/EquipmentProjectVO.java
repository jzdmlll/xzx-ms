package com.xzx.xzxms.equipment.vo;

/**
 * @author：ZJW
 * @title：用于获取所有项目
 * @date：2021/1/24 9:54
 * @修改人：
 * @修改时间：2021/1/24 9:54
 * @修改描述：默认描述
 */
public class EquipmentProjectVO {
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
        return "EquipmentProjectVO{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
