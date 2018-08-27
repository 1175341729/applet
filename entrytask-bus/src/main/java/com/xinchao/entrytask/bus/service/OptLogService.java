package com.xinchao.entrytask.bus.service;

import com.xinchao.core.page.Page;
import com.xinchao.entrytask.bus.model.OptLog;
import com.xinchao.entrytask.bus.model.OptLogCondition;

import javax.annotation.Nullable;

/**
 * OptLogService 对外提供的操作日志接口定义
 *
 *
 * @author alan.pu
 * @version 1.0.0 2018/4/3
 * @see
 * @since 1.0
 */
public interface OptLogService
{
    void insert(@Nullable OptLog log);

    void delete(@Nullable Integer id);

    /**
     * update a OptLog if log.id is null will do no thing
     * @param log
     */
    void update(@Nullable OptLog log);

    /**
     * get the record by id
     * @param id
     * @return
     */
    OptLog get(@Nullable Integer id);

    Page<OptLog> search(OptLogCondition condition);
}
