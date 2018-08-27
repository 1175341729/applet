package com.xinchao.entrytask.api.controller;

import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.common.Page;
import com.xinchao.entrytask.api.model.Task;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/***
 * 任务接口
 */
@Api(value = "TaskController",description = "任务相关api")
public interface ITaskController {
    @ApiOperation(value = "根据ID获取任务详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Task表ID", required = true, dataType = "Long", paramType = "path")
    })
    JSONResponse<Task> get(Long id);

    @ApiOperation(value = "根据用户（weixin），或者城市code（city）获取任务详细信息(app-我的任务，根据微信帐号获取相关信息)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "weixin", value = "微信号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "city", value = "城市code", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "当前页数",defaultValue = "1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页显示条数",defaultValue = "10",dataType = "int", paramType = "query")
    })
    JSONResponse<Page<Task>> getTaskByUserId(String weixin, String city, int pageIndex, int pageSize);

    @ApiOperation(value = "根据供应商获取所有任务（条件查询）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "分页大小默认值10", defaultValue = "10", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "分页大小默认值1", defaultValue = "1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始时间", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "province", value = "省份", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "city", value = "城市", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "taskName", value = "任务名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "propertyCompany", value = "物业公司", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "dockingPerson", value = "对接人", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "taskStatus", value = "任务状态", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "userGroup", value = "供应商", required = true, dataType = "String", paramType = "query")
    })
    JSONResponse<Page<Task>> get(Integer pageSize,
                                 Integer pageIndex,
                                 String startTime,
                                 String endTime,
                                 String province,
                                 String city,
                                 String taskName,
                                 String propertyCompany,
                                 String dockingPerson,
                                 Integer taskStatus,
                                 String userGroup);

    @ApiOperation(value = "发布新任务")
    @ResponseStatus(code = HttpStatus.CREATED)
    void createTask(Task task) throws Exception;


    @ApiOperation(value = "修改任务状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "任务ID",required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "任务状态值",required = true, dataType = "int", paramType = "query")
    })
    JSONResponse<String> updateStatus(Integer id, Integer status) throws Exception;


    @ApiOperation(value = "修改任务信息")
    JSONResponse<String> updateTask(@RequestBody Task task) throws Exception;

    @ApiOperation(value = "app-根据用户城市名称获取任务信息，并模糊查找")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cityName", value = "城市名称(中文，gps获取出来的名称)",required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "当前页数", dataType = "int",defaultValue = "1", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页显示条数", dataType = "int",defaultValue = "10", paramType = "query"),
            @ApiImplicitParam(name = "condition", value = "任务名称、物业公司名称", dataType = "String", paramType = "query"),
    })
    JSONResponse<Page<Task>> getPageByCityName(String cityName, Integer pageSize,
                                               Integer pageIndex,String condition);
}
