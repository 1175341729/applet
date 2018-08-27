package com.xinchao.entrytask.api.controller;

import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.model.Area;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(value = "AreaController",description = "地理位置相关api")
public interface IAreaController {

    @ApiOperation(value = "获取所有省份")
    JSONResponse<List<Area>> get();

    @ApiOperation(value = "根据父ID 获取地市列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "父ID", required = true, dataType = "String", paramType = "query")
    })
    JSONResponse<List<Area>> get(String parentId);
}
