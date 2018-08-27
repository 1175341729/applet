/**
 * Copyright (c) 2018,maipu technologies,Inc.
 * All rights reserved.
 * 文件名称： Page
 * 摘要：
 * <p>
 * 当前版本： ${version}
 * 作者： alanp
 * 完成日期： 2018/4/3
 * <p>
 * 修改历史：
 * $Log:
 * 文件名称： Page.java,v $
 */
package com.xinchao.core.page;

import java.io.Serializable;
import java.util.List;

/**
 * Page 分页数据返回实现
 * 实现分页的相关功能
 * @author alan.pu
 * @version 1.0.0 2018/4/3
 * @see
 * @since 1.0
 */
public class Page<T> implements Serializable
{

    // 总数据量
    private int total;

    // 每页数据量
    private int pageSize;

    // 总页数
    private int totalPage;

    // 当前页
    private int currentPage;

    // 结果集
    private List<T> records;

    public Page()
    {
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public List<T> getRecords()
    {
        return records;
    }

    public void setRecords(List<T> records)
    {
        this.records = records;
    }

    @Override
    public String toString()
    {
        return "Page{" + "total=" + total + ", pageSize=" + pageSize + ", totalPage=" + totalPage + ", currentPage=" + currentPage + ", records=" + records + '}';
    }
}
