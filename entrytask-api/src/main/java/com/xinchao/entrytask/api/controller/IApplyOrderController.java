package com.xinchao.entrytask.api.controller;

import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.common.Page;
import com.xinchao.entrytask.api.exception.GlobalException;
import com.xinchao.entrytask.api.model.ApplyOrder;
import com.xinchao.entrytask.api.model.ApplyOrderRollMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Api(value = "ApplyOrderController",description = "申请记录相关api")
public interface IApplyOrderController {

    @ApiOperation(value = "获取当前供应商下和查询条件的所有任务接单情况,并分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "分页大小默认值10",defaultValue = "10", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "分页大小默认值1", defaultValue = "1",required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "province", value = "省份", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "city", value = "城市", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "taskNumber", value = "任务编号", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "taskName", value = "任务名称", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "propertyCompany", value = "物业公司", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applyPhone", value = "申请人手机号码", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applyStatus", value = "申请记录状态", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "userGroup", value = "供应商", required = true, dataType = "String", paramType = "query")
    })
    JSONResponse<Page<ApplyOrder>> get(
            Integer pageSize,
            Integer pageIndex,
            String startTime,
            String endTime,
            String province,
            String city,
            String taskNumber,
            String taskName,
            String propertyCompany,
            String applyPhone,
            String applyStatus,
            String userGroup) throws GlobalException;


    @ApiOperation(value = "创建接单记录,（app抢任务）")
    @ResponseStatus(code = HttpStatus.CREATED)
    void createOrder(ApplyOrder applyOrder) throws Exception;

    @ApiOperation(value = "修改接单状态")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "申请记录id", required = true,dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "下一个状态",required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "remarks", value = "备注", required = false, dataType = "String", paramType = "query")
    })
    void updateStatus(Integer id,String status,String remarks) throws Exception;

    @ApiOperation(value = "更新奖励金，更新凭证图片地址")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "申请记录id", required = true,dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "bonus", value = "奖励金额",required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "bonusUrl", value = "凭证地址url", required = true, dataType = "String", paramType = "query")
    })
    void updateBonus(Integer id,String bonus,String bonusUrl) throws Exception;

    @ApiOperation(value = "app-获取当前用户下所有任务接单情况,并分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "分页大小默认值10", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "分页大小默认值1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "weixin", value = "微信号", required = true, dataType = "String", paramType = "query")
    })
    JSONResponse<Page<ApplyOrder>> get( Integer pageSize,
                                        Integer pageIndex,
                                        String weixin);


    @ApiOperation(value = "aap-任务类表，显示奖励滚动消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "显示滚动消息条数", dataType = "int", paramType = "query")
    })
    JSONResponse<List<ApplyOrderRollMsg>> getTaskRollMsg(Integer num);

    @ApiOperation(value = "app-我的，显示用户收益合计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applyUserId",value = "用户ID",dataType = "Long",paramType = "query",required = true)
    })
    JSONResponse<ApplyOrder> getApplyBonus(Long applyUserId);
}
