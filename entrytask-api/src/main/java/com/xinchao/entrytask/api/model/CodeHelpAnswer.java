package com.xinchao.entrytask.api.model;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class CodeHelpAnswer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long problemId;

    private String answer;

    private String enabled;

    private String sort;
}
