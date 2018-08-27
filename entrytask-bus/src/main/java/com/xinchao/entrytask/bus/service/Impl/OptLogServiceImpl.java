/**
 * Copyright (c) 2018,maipu technologies,Inc.
 * All rights reserved.
 * 文件名称： OptLogServiceImpl
 * 摘要：
 * <p>
 * 当前版本： ${version}
 * 作者： alanp
 * 完成日期： 2018/4/3
 * <p>
 * 修改历史：
 * $Log:
 * 文件名称： OptLogServiceImpl.java,v $
 */
package com.xinchao.entrytask.bus.service.Impl;

import com.xinchao.core.page.Page;
import com.xinchao.entrytask.bus.dao.OptLogMapper;
import com.xinchao.entrytask.bus.model.OptLog;
import com.xinchao.entrytask.bus.model.OptLogCondition;
import com.xinchao.entrytask.bus.service.OptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;

/**
 * OptLogServiceImpl 操作日志实现
 * @author alan.pu
 * @version 1.0.0 2018/4/3
 * @see   {@link OptLogService}
 * @since 1.0
 */
@Service("OptLogService")
public class OptLogServiceImpl implements OptLogService
{

    @Autowired
    private OptLogMapper optLogMapper;

    @Override
    public void insert(OptLog log)
    {
        optLogMapper.insert(log);
    }

    @Override
    public void delete(Integer id)
    {
        optLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(OptLog log)
    {
        if(log.getId() == null)
        {
            return;
        }
        optLogMapper.updateByPrimaryKey(log);
    }

    /**
     * get the record by id
     *
     * @param id
     * @return
     */
    @Override
    public OptLog get(@Nullable Integer id)
    {
        return optLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<OptLog> search(OptLogCondition condition)
    {
        Page<OptLog> result = new Page<>();
        result.setTotal(optLogMapper.selectCount(condition));
        result.setPageSize(condition.getSize());
        result.setCurrentPage(condition.getPage());
        result.setTotalPage((result.getTotal() + result.getPageSize() - 1) / result.getPageSize());
        result.setRecords(optLogMapper.selectByCondition(condition));
        return  result;
    }

}
