package com.xinchao.entrytask.api.controller;

import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.model.CodeHelp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * 帮助中心问题
 */
@Api(value = "CodeHelpController", description = "帮助中心相关api")
public interface ICodeHelpController {

    @ApiOperation(value = "获取所有问题")
    JSONResponse<List<CodeHelp>> get();


}
