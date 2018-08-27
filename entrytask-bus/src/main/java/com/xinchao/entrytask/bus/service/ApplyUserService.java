/**
 * Copyright (c) 2018,maipu technologies,Inc.
 * All rights reserved.
 * 文件名称： ApplyOrderService
 * 摘要：
 * <p>
 * 当前版本： ${version}
 * 作者： alanp
 * 完成日期： 2018/4/3
 * <p>
 * 修改历史：
 * $Log:
 * 文件名称： ApplyOrderService.java,v $
 */
package com.xinchao.entrytask.bus.service;

import com.xinchao.entrytask.api.exception.GlobalException;
import com.xinchao.entrytask.bus.model.ApplyOrder;
import com.xinchao.entrytask.bus.model.ApplyUser;

import javax.annotation.Nullable;

/**
 * ApplyUserService 申请用户服务接口
 * 实现基本的申请用户功能
 * @author alan.pu
 * @version 1.0.0 2018/4/3
 * @see {@link ApplyOrder}
 * @since 1.0
 */
public interface ApplyUserService
{
    void insert(ApplyUser order) throws GlobalException;

    /**
     *
     * @param request 前段传入的参数，这里需要做2个事情保持applyUser and applyOrder
     */
    void insert(com.xinchao.entrytask.api.model.ApplyUser request) throws GlobalException;

    void update(ApplyUser order);

    ApplyUser getById(@Nullable Integer id);

    ApplyUser getByWeiXin(String weixin);

}
