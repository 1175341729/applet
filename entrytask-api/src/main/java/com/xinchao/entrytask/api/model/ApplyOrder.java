package com.xinchao.entrytask.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ApiModel
/**
 * 接单
 */
public class ApplyOrder extends BaseTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", hidden = false, notes = "主键，隐藏", required = true, dataType = "Long")
    private Long id;

    @ApiModelProperty(value = "申请时间")
    private Date applyTime;

    @ApiModelProperty(value = "结算奖金")
    private BigDecimal balanceBonus;

    @ApiModelProperty(value = "奖金上次凭证URL")
    private String bonusUrl;

    @ApiModelProperty(value = "申请人")
    private Long applyUserId;

    @ApiModelProperty(value = "申请人微信")
    private String applyWeixin;

    @ApiModelProperty(value = "申请人手机号")
    private String applyPhone;

    @ApiModelProperty(value = "任务ID")
    private Long taskId;

    @ApiModelProperty(value = "申请人优势ID")
    private String advantageId;

    @ApiModelProperty(value = "备注")
    private String remarks;


}
