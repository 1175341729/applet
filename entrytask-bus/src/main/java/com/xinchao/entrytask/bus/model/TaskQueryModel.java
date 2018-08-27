package com.xinchao.entrytask.bus.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 根据查询条件查询任务列表
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel
public class TaskQueryModel {

    @ApiModelProperty(value = "每页大小")
    private Integer pageSize;

    @ApiModelProperty(value = "第几页")
    private Integer pageIndex;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结算时间")
    private String endTime;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "任务名称")
    private String taskName;

    @ApiModelProperty(value = "物业公司")
    private String propertyCompany;

    @ApiModelProperty(value = "对接人")
    private String dockingPerson;

    @ApiModelProperty(value = "状态")
    private Integer taskStatus;

    @ApiModelProperty(value = "供应商")
    private String userGroup;


}
