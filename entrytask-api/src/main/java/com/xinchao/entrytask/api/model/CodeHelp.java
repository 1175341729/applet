package com.xinchao.entrytask.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class CodeHelp implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", hidden = false, notes = "主键，隐藏", required = true, dataType = "Long")
    private Long id;

    @ApiModelProperty(value = "问题描述")
    private String problem;

    @ApiModelProperty(value = "是否可用")
    private String enabled;

    @ApiModelProperty(value = "排序")
    private String sort;
}
