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

import com.alibaba.fastjson.JSON;
import com.xinchao.entrytask.api.common.CommonCode;
import com.xinchao.entrytask.api.exception.GlobalException;
import com.xinchao.entrytask.bus.dao.ApplyUserMapper;
import com.xinchao.entrytask.bus.model.ApplyUser;
import com.xinchao.entrytask.bus.service.ApplyUserService;
import com.xinchao.entrytask.bus.service.OptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;

/**
 * ApplyUserServiceImpl 操作日志实现
 *
 * @author alan.pu
 * @version 1.0.0 2018/4/3
 * @see {@link OptLogService}
 * @since 1.0
 */
@Service("ApplyUserService")
public class ApplyUserServiceImpl implements ApplyUserService
{

    @Autowired
    private ApplyUserMapper applyUserMapper;

    @Override
    public void insert(ApplyUser user) throws GlobalException
    {
        try
        {
            applyUserMapper.insert(user);
        }
        catch (DuplicateKeyException e)
        {
            throw new GlobalException(CommonCode.REPEAT.getCode(), "用户微信号" + user.getApplyWeixin() + "已存在");
        }
        catch (Exception e)
        {
            throw new GlobalException(CommonCode.ERROR);
        }
    }

    /**
     * @param request 前段传入的参数，这里需要做2个事情保持applyUser and applyOrder
     */
    @Override
    public void insert(com.xinchao.entrytask.api.model.ApplyUser request) throws GlobalException
    {

        String reqJson = JSON.toJSONString(request);
        ApplyUser applyUser = JSON.parseObject(reqJson, ApplyUser.class);
        insert(applyUser);
    }

    @Override
    public void update(ApplyUser user)
    {
        if (user.getId() == null)
        {
            throw new IllegalArgumentException("update apply user error, user id is null ");
        }
        applyUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public ApplyUser getById(@Nullable Integer id)
    {
        return applyUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public ApplyUser getByWeiXin(String weixin)
    {
        return applyUserMapper.selectByWeiXin(weixin);
    }
}
