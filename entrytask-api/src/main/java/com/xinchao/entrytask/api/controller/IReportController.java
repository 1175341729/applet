package com.xinchao.entrytask.api.controller;

import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.model.BriefingModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 报表相关接口
 */
@Api(value = "ReportController",description = "报表相关api")
public interface IReportController {

    @ApiOperation(value = "根据供应商ID获取相关简报信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "supplierId",value = "供应商ID",required = true,dataType = "String",paramType = "path")
    })
    JSONResponse<BriefingModel> get(@PathVariable String supplierId);

    @ApiOperation("获取所有供应商的任务数据")
    JSONResponse<List<BriefingModel>> get();
}
