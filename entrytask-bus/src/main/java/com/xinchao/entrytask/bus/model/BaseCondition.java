/**
 * Copyright (c) 2018,maipu technologies,Inc.
 * All rights reserved.
 * 文件名称： BaseCondition
 * 摘要：
 * <p>
 * 当前版本： ${version}
 * 作者： alanp
 * 完成日期： 2018/4/3
 * <p>
 * 修改历史：
 * $Log:
 * 文件名称： BaseCondition.java,v $
 */
package com.xinchao.entrytask.bus.model;

import com.xinchao.core.page.Condition;

import java.util.Date;

/**
 * BaseCondition 基本的搜索条件
 * 该实现默认提供对时间和分页的控制实现
 *
 * @author alan.pu
 * @version 1.0.0 2018/4/3
 * @since 1.0
 */
public class BaseCondition implements Condition
{
    // 开始时间
    private Date start;

    // 结束时间
    private Date end;

    private Integer fromIndex;

    private Integer page;

    private Integer size = 10;

    public Date getStart()
    {
        return start;
    }

    public void setStart(Date start)
    {
        this.start = start;
        this.end = new Date();
    }

    public Date getEnd()
    {
        return end;
    }

    public void setEnd(Date end)
    {
        this.end = end;
    }


    public Integer getFromIndex()
    {
        return fromIndex;
    }

    protected void setFromIndex(Integer fromIndex)
    {
        this.fromIndex = fromIndex;
    }

    public Integer getSize()
    {
        return size;
    }

    protected void setSize(Integer size)
    {
        this.size = size;
    }

    public Integer getPage()
    {
        return page == null ? 1 : page;
    }

    public void setPageInfo(Integer page, Integer size)
    {
        this.page = page;
        setSize(size);
        if (page != null && size != null)
        {
            this.fromIndex = (page - 1) * getSize();
        }
    }
}
