/**
 * Copyright (c) 2018,maipu technologies,Inc.
 * All rights reserved.
 * 文件名称： ApplyOrderSearchVo
 * 摘要：
 * <p>
 * 当前版本： ${version}
 * 作者： alanp
 * 完成日期： 2018/4/3
 * <p>
 * 修改历史：
 * $Log:
 * 文件名称： ApplyOrderSearchVo.java,v $
 */
package com.xinchao.entrytask.bus.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ApplyOrderSearchVo〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author alan.pu
 * @version 1.0.0 2018/4/3
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ApplyOrderSearchVo
{

    private Integer id;
    private String province;
    private String city;
    private String taskName;
    private String taskNumber;
    private String propertyCompany;
    private BigDecimal bonus;
    private String bonusUrl;
    private String dockingPerson;
    private String applyWeixin;
    private String applyPhone;
    private Date applyTime;
    private Date completeTime;
    private Byte status;
    private String mergerShortName;
    private BigDecimal balanceBonus;


    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
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

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getTaskNumber()
    {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber)
    {
        this.taskNumber = taskNumber;
    }

    public String getPropertyCompany()
    {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany)
    {
        this.propertyCompany = propertyCompany;
    }

    public BigDecimal getBonus()
    {
        return bonus;
    }

    public void setBonus(BigDecimal bonus)
    {
        this.bonus = bonus;
    }

    public String getDockingPerson()
    {
        return dockingPerson;
    }

    public void setDockingPerson(String dockingPerson)
    {
        this.dockingPerson = dockingPerson;
    }

    public String getApplyWeixin()
    {
        return applyWeixin;
    }

    public void setApplyWeixin(String applyWeixin)
    {
        this.applyWeixin = applyWeixin;
    }

    public String getApplyPhone()
    {
        return applyPhone;
    }

    public void setApplyPhone(String applyPhone)
    {
        this.applyPhone = applyPhone;
    }

    public Date getApplyTime()
    {
        return applyTime;
    }

    public void setApplyTime(Date applyTime)
    {
        this.applyTime = applyTime;
    }

    public Date getCompleteTime()
    {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime)
    {
        this.completeTime = completeTime;
    }

    public Byte getStatus()
    {
        return status;
    }

    public void setStatus(Byte status)
    {
        this.status = status;
    }

    public BigDecimal getBalanceBonus()
    {
        return balanceBonus;
    }

    public void setBalanceBonus(BigDecimal balanceBonus)
    {
        this.balanceBonus = balanceBonus;
    }

    public String getBonusUrl()
    {
        return bonusUrl;
    }

    public void setBonusUrl(String bonusUrl)
    {
        this.bonusUrl = bonusUrl;
    }

    public String getMergerShortName()
    {
        return mergerShortName;
    }

    public void setMergerShortName(String mergerShortName)
    {
        this.mergerShortName = mergerShortName;
    }
}
