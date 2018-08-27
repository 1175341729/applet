package com.xinchao.entrytask.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@ApiModel
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * 地市
 */
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", hidden = false, notes = "主键，隐藏", required = true, dataType = "Long")
    private String id;

    @ApiModelProperty(value = "父ID")
    private String parentId;

    @ApiModelProperty(value = "地区名称")
    private String name;

    @ApiModelProperty(value = "地区短名称")
    private String shortName;

    @ApiModelProperty(value = "省市合并名称")
    private String mergerShortName;

    @ApiModelProperty(value = "地市等级")
    private String levelType;
}
