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

/**
 * OptLogCondition 操作日志的搜索条件
 *
 * @author alan.pu
 * @version 1.0.0 2018/4/3
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class OptLogCondition extends BaseCondition
{
   // 供应商
    private String supplierId;

    // 模块名称
    private String modeName;

    //操作方式
    private Byte operationType;

    // 操作内容
    private String operationDesc;

    // 操作人
    private Integer operatorId;

    public OptLogCondition()
    {
    }

    public String getSupplierId()
    {
        return supplierId;
    }

    public void setSupplierId(String supplierId)
    {
        this.supplierId = supplierId;
    }

    public String getModeName()
    {
        return modeName;
    }

    public void setModeName(String modeName)
    {
        this.modeName = modeName;
    }

    public Byte getOperationType()
    {
        return operationType;
    }

    public void setOperationType(Byte operationType)
    {
        this.operationType = operationType;
    }

    public String getOperationDesc()
    {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc)
    {
        this.operationDesc = operationDesc;
    }

    public Integer getOperatorId()
    {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId)
    {
        this.operatorId = operatorId;
    }


}
