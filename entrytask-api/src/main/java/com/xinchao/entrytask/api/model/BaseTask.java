package com.xinchao.entrytask.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public abstract class BaseTask {

    @ApiModelProperty(value = "任务名称")
    private String taskName;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "任务编号")
    private String taskNumber;

    @ApiModelProperty(value = "物业公司")
    private String propertyCompany;

    @ApiModelProperty(value = "设备奖金")
    private BigDecimal bonus;

    @ApiModelProperty(value = "对接人")
    private String dockingPerson;

    @ApiModelProperty(value = "对接人电话")
    private String dockingPhone;

    @ApiModelProperty(value = "完成时间")
    private Date completionTime;

    @ApiModelProperty(value = "状态")
    private int status;

    @ApiModelProperty(value = "查询时间")
    private DateRange dateRange;
}
