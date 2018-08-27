/**
 * Copyright (c) 2018,maipu technologies,Inc.
 * All rights reserved.
 * 文件名称： SmsVerifyResponse
 * 摘要：
 * <p>
 * 当前版本： ${version}
 * 作者： alanp
 * 完成日期： 2018/4/8
 * <p>
 * 修改历史：
 * $Log:
 * 文件名称： SmsVerifyResponse.java,v $
 */
package com.xinchao.entrytask.bus.common.helper;

/**
 * SmsVerifyResponse 短信验证请求结果，注意是此结构的json形式
 * @author alan.pu
 * @version 1.0.0 2018/4/8
 */
public class SmsVerifyResponse
{
    private boolean status;

    private String code;

    private String msg;

    // ? 是否使用泛型
    private Object data;

    public boolean status()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}
