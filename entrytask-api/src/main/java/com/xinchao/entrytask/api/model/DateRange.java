package com.xinchao.entrytask.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ApiModel
public class DateRange {

    @ApiModelProperty(value = "开始时间")
    private Date beginDate;

    @ApiModelProperty(value = "结束时间")
    private Date endDate;
}
