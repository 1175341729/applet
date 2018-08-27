package com.xinchao.entrytask.api.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class JSONResponse<T> {
    @ApiModelProperty(value = "状态",hidden = false,required = true,dataType = "bool，true表示成功，false表示失败")
    private boolean status;

    @ApiModelProperty(value = "响应码",hidden = false,required = true,dataType = "String")
    private String code;

    @ApiModelProperty(value = "响应消息",hidden = false,required = true,dataType = "String")
    private String msg;

    @ApiModelProperty(value = "响应数据",hidden = false,required = true,dataType = "json")
    private T data;
}
