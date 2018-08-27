package com.xinchao.entrytask.api.controller;

import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.model.ApplyUser;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * demo interface
 */
@Api(value = "ApplyUserController",description = "申请用户相关api")
public interface IApplyUserController {
    @ApiOperation(value = "获取ApplyUser信息", notes = "根据id获取ApplyUser")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ApplyUser表ID", required = true, dataType = "Long", paramType = "path")
    })
// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，会报错paramType表示参数的类型，可选的值为"path","body","query","header","form"
    JSONResponse<ApplyUser> get(Long id);

    @ApiOperation(value = "获取用户详细信息",notes = "根据微信帐号获取applyUser详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applyWeixin", value = "用户微信号", required = true, dataType = "String", paramType = "query")
    })
    JSONResponse<ApplyUser> get(String applyWeixin);

    @ApiOperation(value = "绑定微信手机号（添加用户）",notes = "关联手机号码和微信帐号，请忽略主键否则失败。")
    @ResponseStatus(code = HttpStatus.CREATED)
    void post(ApplyUser applyuser) throws Exception;
}
