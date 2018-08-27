package com.xinchao.entrytask.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ApiModel
public class BriefingModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "供应商ID")
    private String supplierId;

    @ApiModelProperty(value = "供应商名称")
    private String supplier;

    @ApiModelProperty(value = "接单记录总数")
    private int allInOrdersNum;

    @ApiModelProperty(value = "已申请")
    private int applyNum;

    @ApiModelProperty(value = "已接受")
    private int acceptNum;

    @ApiModelProperty(value = "已签约")
    private int finishNum;

    @ApiModelProperty(value = "已打款")
    private int balanceNum;

    @ApiModelProperty(value = "已拒绝")
    private int rejectNum;

    @ApiModelProperty(value = "已取消")
    private int cancelNum;

    @ApiModelProperty(value = "已支出奖金")
    private BigDecimal outBonusFee;

    @ApiModelProperty(value = "总任务数")
    private int taskAllTaskNum;

    @ApiModelProperty(value = "接单中")
    private int taskInOrdersNum;

    @ApiModelProperty(value = "暂不接单")
    private int taskPauseOrdersNum;

    @ApiModelProperty(value = "已完成")
    private int taskFinishNum;

    @ApiModelProperty(value = "已取消")
    private int taskCancelNum;

}
