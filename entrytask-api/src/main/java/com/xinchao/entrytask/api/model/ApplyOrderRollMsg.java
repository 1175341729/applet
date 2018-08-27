package com.xinchao.entrytask.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel
public class ApplyOrderRollMsg  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员电话号码")
    private String applyPhone;

    @ApiModelProperty(value = "结算奖金金额")
    private BigDecimal balanceBonus;

}
