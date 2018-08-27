package com.xinchao.entrytask.api.controller;

import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.model.CodeHelpAnswer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 帮助中心答案
 */
@Api(value = "CodeHelpAnswerController", description = "帮助中心相关api")
public interface ICodeHelpAnswerController {

    @ApiOperation(value = "根据问题ID获取答案")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "problemId", value = "问题ID", required = true, dataType = "Long", paramType = "path")
    })
    JSONResponse<List<CodeHelpAnswer>> get(@PathVariable Long problemId);
}
