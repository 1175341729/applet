package com.xinchao.entrytask.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyUser
{

    @ApiModelProperty(value = "主键", hidden = false, notes = "主键，隐藏,post时请忽略", required = true, dataType = "Integer")
    private Integer id;

    @ApiModelProperty(value = "申请人微信帐号", hidden = false, required = true, dataType = "String")
    private String applyWeixin;

    @ApiModelProperty(value = "申请人手机号", hidden = false, required = true, dataType = "String")
    private String applyPhone;

    @ApiModelProperty(value = "短信验证码", hidden = false, required = true, dataType = "String")
    private String code;

    @ApiModelProperty(value = "产品Key", hidden = false, required = true, dataType = "String")
    private String productKey;
}