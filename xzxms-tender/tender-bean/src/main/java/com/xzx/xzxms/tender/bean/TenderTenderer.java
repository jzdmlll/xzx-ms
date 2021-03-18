package com.xzx.xzxms.tender.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lzc
 * @since 2021-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TenderTenderer对象", description="")
public class TenderTenderer implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "参标信息ID")
      @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    @ApiModelProperty(value = "参标信息")
    private String tendererInfo;

    @ApiModelProperty(value = "参标信息文件")
    private String tendererFile;

    @ApiModelProperty(value = "招标表ID")
    private String tenderId;

    @ApiModelProperty(value = "0: 逻辑删除；1：有效")
    private Integer isActive;

    @ApiModelProperty(value = "创建人")
      @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改人")
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @ApiModelProperty(value = "修改时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
