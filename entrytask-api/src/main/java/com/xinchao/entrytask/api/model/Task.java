package com.xinchao.entrytask.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@ApiModel
@Getter
@Setter
@NoArgsConstructor
/**
 * 任务
 */
public class Task extends BaseTask implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", hidden = false, notes = "主键，隐藏", required = true, dataType = "Long")
    private Long id;

    @ApiModelProperty(value = "任务地址")
    private String taskAddress;

    @ApiModelProperty(value = "创建者")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "奖金单位")
    private String bonusUnit;

    @ApiModelProperty(value = "供应商ID")
    private String supplierId;

    @ApiModelProperty(value = "接单人数")
    private int inOrdersNum;

    @ApiModelProperty(value = "接单人微信")
    private String applyWeixin;

    @ApiModelProperty(value = "接单人电话")
    private String applyPhone;


}
