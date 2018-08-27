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
import com.github.pagehelper.PageHelper;
import com.xinchao.core.page.Page;
import com.xinchao.entrytask.api.common.ApplyOrderStatus;
import com.xinchao.entrytask.api.common.CommonCode;
import com.xinchao.entrytask.api.common.TaskStatus;
import com.xinchao.entrytask.api.exception.GlobalException;
import com.xinchao.entrytask.bus.dao.ApplyOrderMapper;
import com.xinchao.entrytask.bus.model.*;
import com.xinchao.entrytask.bus.service.ApplyOrderService;
import com.xinchao.entrytask.bus.service.ApplyUserService;
import com.xinchao.entrytask.bus.service.OptLogService;
import com.xinchao.entrytask.bus.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * OptLogServiceImpl 操作日志实现
 *
 * @author alan.pu
 * @version 1.0.0 2018/4/3
 * @see {@link OptLogService}
 * @since 1.0
 */
@Service("ApplyOrderService")
public class ApplyOrderServiceImpl implements ApplyOrderService
{

    @Autowired
    private ApplyOrderMapper applyOrderMapper;

    @Autowired
    private ApplyUserService applyUserService;

    @Autowired
    private TaskService taskService;

    @Override
    public Page<ApplyOrderSearchVo> search(ApplyOrderCondition condition)
    {
        Page<ApplyOrderSearchVo> result = new Page<>();
        result.setTotal(applyOrderMapper.selectCount(condition));
        result.setPageSize(condition.getSize());
        result.setCurrentPage(condition.getPage());
        result.setTotalPage((result.getTotal() + result.getPageSize() - 1) / result.getPageSize());
        result.setRecords(applyOrderMapper.selectByCondition(condition));
        return result;
    }

    @Override
    public com.xinchao.entrytask.api.common.Page<ApplyOrderSearchVo> selectByWeixin(@Nullable String weixin, Integer pageIndex, Integer pageSize)
    {
        com.github.pagehelper.Page<TaskSearchVo> page = PageHelper.startPage(pageIndex, pageSize);
        com.xinchao.entrytask.api.common.Page<ApplyOrderSearchVo> taskPage = new com.xinchao.entrytask.api.common.Page<>();
        List<ApplyOrderSearchVo> taskSearchVoList = applyOrderMapper.selectByWeixin(weixin);
        taskPage.setList(taskSearchVoList);
        taskPage.setTotal(page.getTotal());
        return taskPage;
    }

    @Override
    public void insert(ApplyOrder order)
    {
        applyOrderMapper.insert(order);
    }


    @Override
    @Transactional(rollbackFor = {Exception.class, GlobalException.class})
    public void createOrder(com.xinchao.entrytask.api.model.ApplyOrder request) throws GlobalException
    {
        String orderJson = JSON.toJSONString(request);
        ApplyOrder order = JSON.parseObject(orderJson, ApplyOrder.class);
        if ((order.getTaskId() == null) || (taskService.getTaskById(Long.parseLong(order.getTaskId().toString())) == null))
        {
            throw new GlobalException(CommonCode.PARAM_ERROR.getCode(), "the task id of:" + order.getTaskId() + " is Illegal");

        }
        // insert ApplyUser handle
        ApplyUser user = JSON.parseObject(orderJson, ApplyUser.class);
        // check db user is existed
        ApplyUser dbuser = applyUserService.getByWeiXin(user.getApplyWeixin());
        if (dbuser == null)
        {
            throw new GlobalException(CommonCode.PARAM_ERROR.getCode(), "the wei xin:" + user.getApplyWeixin() + " does not exist in db");
        }
        //        applyUserService.insert(user);
        // insert order， must keep
        order.setApplyUserId(dbuser.getId());
        if (exist(order.getTaskId(), order.getApplyUserId()))
        {
            throw new GlobalException(CommonCode.REPEAT.getCode(), "exist the order of[" + order.getTaskId() + "," + user.getApplyWeixin() + "]");
        }
        insert(order);
    }

    @Override
    public void update(ApplyOrder order)
    {
        order.setStatus(null);
        applyOrderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public void updateOrderStatus(@Nullable Integer id, String status, String remark) throws GlobalException
    {
        updateOrderStatus(new ApplyOrder()
        {{
            setStatus(status);
            setId(id);
            setRemarks(remark);
        }});
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, GlobalException.class})
    public void updateOrderStatus(ApplyOrder order) throws GlobalException
    {
        if (order.getId() == null)
        {
            throw new GlobalException(CommonCode.PARAM_ERROR);
        }
        ApplyOrder dbOrder = applyOrderMapper.selectByPrimaryKey(order.getId());
        ApplyOrderStatus dbStatus = ApplyOrderStatus.valueOf(Integer.valueOf(dbOrder.getStatus()));
        ApplyOrderStatus thisStatus = ApplyOrderStatus.valueOf(Integer.valueOf(order.getStatus()));
        // 状态相同
        if (dbStatus == thisStatus)
        {
            return;
        }
        if (!ApplyOrderStatus.getNextStatus(dbStatus).contains(thisStatus))
        {
            throw new GlobalException(CommonCode.STATUS_UNREACHABLE.getCode(), "current status:" + dbStatus + ",request status:" + thisStatus);
        }


        // 更新数据库的状态字段




        applyOrderMapper.updateOrderStatus(order);
        // 已打款
        byte taskStauts = -1;
        // flag 是否需要更新任务单号为取消
        boolean updateOrder = false;
        if (thisStatus == ApplyOrderStatus.DONE)
        {
            taskStauts = (byte) TaskStatus.COMPLETED.getValue();
            updateOrder = true;
        }
        if (thisStatus == ApplyOrderStatus.ACCEPTED)
        {
            taskStauts = (byte) TaskStatus.SUSPENDED.getValue();
        }
        // update task status
        if (taskStauts != -1)
        {
            Task dbTask = taskService.getTaskById(Long.valueOf(dbOrder.getTaskId().toString()));
            if (updateOrder)
            {
                applyOrderMapper.updateOrderStatusToCancelOfTask(dbTask.getId());
            }
            // 顺序不能倒置
            dbTask.setStatus(taskStauts);
            taskService.update(dbTask);
        }

    }

    @Override
    public void payOrder(@Nullable Integer id, BigDecimal balanceBonus, String bonusUrl) throws GlobalException
    {
        payOrder(new ApplyOrder()
        {{
            setBalanceBonus(balanceBonus);
            setId(id);
            setBonusUrl(bonusUrl);
        }});
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, GlobalException.class})
    public void payOrder(ApplyOrder order) throws GlobalException
    {
        if (order.getId() == null)
        {
            throw new GlobalException(CommonCode.PARAM_ERROR);
        }
        order.setCompleteTime(new Date());
        applyOrderMapper.payOrder(order);
        updateOrderStatus(order.getId(), ApplyOrderStatus.BROKERAGE.value + "", "打款完成");
    }

    /**
     * 获取任务列表 滚动信息
     *
     * @param num 滚动消息获取条数
     * @return 滚动消息列表
     */
    @Override
    public List<ApplyOrderRollMsg> getTaskRollMsg(Integer num)
    {
        return applyOrderMapper.getTaskRollMsg(num);
    }

    /**
     * 根据用户ID 获取结算合计奖金
     *
     * @param applyUserId 用户ID
     * @return 结算金额和电话号码
     */
    @Override
    public ApplyOrderBonusVo getApplyBonus(Long applyUserId)
    {
        return applyOrderMapper.getApplyBonus(applyUserId);
    }


    public boolean exist(ApplyOrder order)
    {
        return exist(order.getTaskId(), order.getApplyUserId());
    }

    public boolean exist(Integer taskId, Integer applyUserId)
    {
        return applyOrderMapper.selectByTaskIdAndUserId(taskId, applyUserId) > 0;
    }

    @Override
    public int updateOrderStatusToCancelOfTask(Integer taskId)
    {
        return applyOrderMapper.updateOrderStatusToCancelOfTask(taskId);
    }

    public ApplyOrder getById(Integer id)
    {
        return applyOrderMapper.selectByPrimaryKey(id);
    }

}
