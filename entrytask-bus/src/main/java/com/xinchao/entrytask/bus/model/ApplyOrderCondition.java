/**
 * Copyright (c) 2018,maipu technologies,Inc.
 * All rights reserved.
 * 文件名称： OptLogCondition
 * 摘要：
 * <p>
 * 当前版本： ${version}
 * 作者： alanp
 * 完成日期： 2018/4/3
 * <p>
 * 修改历史：
 * $Log:
 * 文件名称： OptLogCondition.java,v $
 */
package com.xinchao.entrytask.bus.model;

import lombok.Getter;
import lombok.Setter;

/**
 * ApplyOrderCondition 接单搜索条件
 *
 * @author alan.pu
 * @version 1.0.0 2018/4/3
 * @since 1.0
 */
@Getter
@Setter
public class ApplyOrderCondition extends BaseCondition
{
    // 省， 全匹配，需要根据此条件获取所有的任务单号做连接查询
    private String province;

    // 市，全匹配
    private String city;

    // 任务编号 模糊匹配
    private String taskNum;

    // 接单状态，全匹配
    private String status;

    // 任务名称，模糊匹配
    private String taskName;

    // 物业名称，模糊匹配
    private String propertyCompany;

    // 申请的手机号，模糊匹配不做校验
    private String applyPhone;

    // 供应商ID，精确匹配
    private String userGroup;


    public ApplyOrderCondition()
    {
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getTaskNum()
    {
        return taskNum;
    }

    public void setTaskNum(String taskNum)
    {
        this.taskNum = taskNum;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getPropertyCompany()
    {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany)
    {
        this.propertyCompany = propertyCompany;
    }

    public String getApplyPhone()
    {
        return applyPhone;
    }

    public void setApplyPhone(String applyPhone)
    {
        this.applyPhone = applyPhone;
    }
}
