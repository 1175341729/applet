package com.xinchao.entrytask.bus.controller;

import com.alibaba.fastjson.JSON;
import com.xinchao.entrytask.api.common.CommonCode;
import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.controller.IApplyUserController;
import com.xinchao.entrytask.api.exception.GlobalException;
import com.xinchao.entrytask.api.model.ApplyUser;
import com.xinchao.entrytask.bus.common.helper.SmsVerifyResponse;
import com.xinchao.entrytask.bus.common.helper.VerifyHelper;
import com.xinchao.entrytask.bus.feign.AuthFeignClient;
import com.xinchao.entrytask.bus.service.ApplyUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/***
 * demo
 */
@RestController
@Slf4j
public class ApplyUserController implements IApplyUserController
{


    @Autowired
    AuthFeignClient authFeignClient;

    @Autowired
    private ApplyUserService service;

    @Override
    @GetMapping("/users/{id}")
    public JSONResponse<ApplyUser> get(@PathVariable("id") Long id)
    {
        //        ApplyUser applyUser = new ApplyUser();
        //        applyUser.setId(Integer.parseInt(id + ""));
        //        applyUser.setApplyPhone("13456765456");
        //        applyUser.setApplyWeixin("weixin");
        return new JSONResponse<ApplyUser>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), JSON.parseObject(JSON.toJSONString(service.getById(Integer.valueOf(id.toString()))), ApplyUser.class));
    }

    @Override
    @GetMapping("/users")
    public JSONResponse<ApplyUser> get(@RequestParam("applyWeixin") String applyWeixin)
    {
        ApplyUser applyUser = null;
        com.xinchao.entrytask.bus.model.ApplyUser temp = service.getByWeiXin(applyWeixin);
        if (temp != null)
        {
            applyUser = new ApplyUser();
            applyUser.setId(temp.getId());
            applyUser.setApplyWeixin(temp.getApplyWeixin());
            applyUser.setApplyPhone(temp.getApplyPhone());
        }
        return new JSONResponse<ApplyUser>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), applyUser);
    }

    @Override
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void post(@RequestBody ApplyUser user) throws Exception
    {
        String res = authFeignClient.verifySmsCode(VerifyHelper.verifyRequest(user.getApplyPhone(), user.getCode(), user.getProductKey()));
        log.info("短信验证结果:" + res);
        SmsVerifyResponse verifyResponse = JSON.parseObject(res, SmsVerifyResponse.class);
        if (!verifyResponse.status())
        {
            throw new GlobalException(CommonCode.ERROR.getCode(), verifyResponse.getMsg());
        }
        com.xinchao.entrytask.bus.model.ApplyUser applyUser = new com.xinchao.entrytask.bus.model.ApplyUser();
        applyUser.setApplyPhone(user.getApplyPhone());
        applyUser.setApplyWeixin(user.getApplyPhone());
        applyUser.setApplyTime(new Date());
        service.insert(applyUser);
    }
}
