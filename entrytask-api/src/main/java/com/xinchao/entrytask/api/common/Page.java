package com.xinchao.entrytask.api.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    @ApiModelProperty("结果集")
    private List<T> list;
    @ApiModelProperty("总数")
    private Long total;
}
