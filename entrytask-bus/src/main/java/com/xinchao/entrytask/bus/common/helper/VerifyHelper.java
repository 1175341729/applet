/**
 * Copyright (c) 2018,maipu technologies,Inc.
 * All rights reserved.
 * 文件名称： VerifyHelper
 * 摘要：
 * <p>
 * 当前版本： ${version}
 * 作者： alanp
 * 完成日期： 2018/4/8
 * <p>
 * 修改历史：
 * $Log:
 * 文件名称： VerifyHelper.java,v $
 */
package com.xinchao.entrytask.bus.common.helper;

import com.alibaba.fastjson.JSON;
import com.xinchao.core.http.HttpRequest;

import java.io.IOException;

/**
 * VerifyHelper 验证帮助类
 *
 * @author alan.pu
 * @version 1.0.0 2018/4/8
 */
public final class VerifyHelper
{

    /**
     * 验证码验证
     *
     * @param phone
     * @param code
     * @return
     */
    public static SmsVerifyResponse verifySmsCode(String phone, String code)
    {
        return verifySmsCodeByHttp(phone, code);
    }


    public static SmsVerifyResponse verifySmsCodeByHttp(String phone, String code)
    {
        SmsVerifyRequest verify = verifyRequest(phone, code);
        String res = null;
        try
        {
            res = HttpRequest.sendPost(verify.getVerifyServer(), JSON.toJSONString(verify));
        }
        catch (IOException e)
        {
            SmsVerifyResponse response = new SmsVerifyResponse();
            response.setStatus(false);
            response.setMsg("request verify error:" + verify.toString());
            return response;
        }
        return JSON.parseObject(res, SmsVerifyResponse.class);
    }


    public static SmsVerifyRequest verifyRequest(String phone, String code)
    {
        return verifyRequest(phone, code, "");
    }

    public static SmsVerifyRequest verifyRequest(String phone, String code, String productKey)
    {
        SmsVerifyRequest verify = new SmsVerifyRequest();
        verify.setPhone(phone);
        verify.setSmsCode(code);
        verify.setProductKey(productKey);
        return verify;
    }

    public static SmsVerifyResponse verifySmsCodeFeign(String phone, String code)
    {

        return JSON.parseObject("", SmsVerifyResponse.class);
    }

}
