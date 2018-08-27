/**
 * Copyright (c) 2018,maipu technologies,Inc.
 * All rights reserved.
 * 文件名称： SmsVerify
 * 摘要：
 * <p>
 * 当前版本： ${version}
 * 作者： alanp
 * 完成日期： 2018/4/8
 * <p>
 * 修改历史：
 * $Log:
 * 文件名称： SmsVerify.java,v $
 */
package com.xinchao.entrytask.bus.common.helper;

/**
 * SmsVerifyRequest 短信验证请求
 * @author alan.pu
 * @version 1.0.0 2018/4/8
 */
public class SmsVerifyRequest
{

    // for test by http way
    public String verifyServer = "http://116.62.203.82:8094/common/api/verifySmsCode";
    private String phone;
    private String templateCode="SMS_123669762";
    private String productKey = "";
    private String smsCode;


    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getTemplateCode()
    {
        return templateCode;
    }

    public void setTemplateCode(String templateCode)
    {
        this.templateCode = templateCode;
    }

    public String getProductKey()
    {
        return productKey;
    }

    public void setProductKey(String productKey)
    {
        this.productKey = productKey;
    }

    public String getSmsCode()
    {
        return smsCode;
    }

    public void setSmsCode(String smsCode)
    {
        this.smsCode = smsCode;
    }

    public String getVerifyServer()
    {
        return verifyServer;
    }

    public void setVerifyServer(String verifyServer)
    {
        this.verifyServer = verifyServer;
    }

    @Override
    public String toString()
    {
        return "SmsVerifyRequest{" + "verifyServer='" + verifyServer + '\'' + ", phone='" + phone + '\'' + ", templateCode='" + templateCode + '\'' + ", productKey='" + productKey + '\'' + ", smsCode='" + smsCode + '\'' + '}';
    }
}
