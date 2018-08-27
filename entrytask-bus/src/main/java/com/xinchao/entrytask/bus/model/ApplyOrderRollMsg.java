package com.xinchao.entrytask.bus.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 任务列表滚动消息
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplyOrderRollMsg {

    /**
     * 会员电话
     */
    private String applyPhone;

    /**
     * 结算奖金金额
     */
    private BigDecimal balanceBonus;

}
