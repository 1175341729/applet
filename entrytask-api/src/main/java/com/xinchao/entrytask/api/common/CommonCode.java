package com.xinchao.entrytask.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonCode {
    SUCCESS("001","操作成功"),
    ERROR("002","操作失败"),
    PARAM_ERROR("003","参数错误"),
    STATUS_UNREACHABLE("004","状态不可达"),
    REPEAT("005","重复数据"),

    ;

    private String code;
    private String msg;
}
