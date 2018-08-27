package com.xinchao.entrytask.bus.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplyOrderBonusVo {

    private BigDecimal balanceBonus;

    private String applyPhone;
}
