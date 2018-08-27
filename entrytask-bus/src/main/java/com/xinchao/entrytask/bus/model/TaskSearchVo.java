package com.xinchao.entrytask.bus.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskSearchVo {

    private Long id;

    private String mergerShortName;

    private String taskName;

    private String propertyCompany;

    private String taskAddress;

    private String taskNumber;

    private BigDecimal bonus;

    private int inOrdersNum;

    private String dockingPerson;

    private String dockingPhone;

    private int status;

    private String creator;

    private Date createTime;

    private Date completionTime;

    private String applyWeixin;

    private String applyPhone;

    private String province;

    private String city;
}
