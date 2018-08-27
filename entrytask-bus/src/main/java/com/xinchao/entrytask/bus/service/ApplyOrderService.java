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

import com.xinchao.core.page.Page;
import com.xinchao.entrytask.api.exception.GlobalException;
import com.xinchao.entrytask.bus.model.*;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;

/**
 * ApplyOrderService 接单服务接口
 * 实现基本的接单功能如接单、更新状态等
 *
 * @author alan.pu
 * @version 1.0.0 2018/4/3
 * @see {@link ApplyOrder}
 * @since 1.0
 */
public interface ApplyOrderService {
    void insert(ApplyOrder order);


    ApplyOrder getById(Integer id);
    /**
     * @param request 前段传入的参数，这里需要做2个事情保持applyUser and applyOrder
     */
    void createOrder(com.xinchao.entrytask.api.model.ApplyOrder request) throws GlobalException;

    /**
     * 更新接单，此接口不能用于修改状态
     * 如果需要修改状态请调用{@link #updateOrderStatus(ApplyOrder)}
     * @param order
     */
    void update(ApplyOrder order);

    /**
     * 更新订单状态，如果订单状态为已接受那么修改任务状态为暂停节点
     * @param id
     * @param status
     * @param remark
     * @throws GlobalException
     */
    void updateOrderStatus(@Nullable Integer id, String status, String remark) throws GlobalException;

    void updateOrderStatus(ApplyOrder order) throws GlobalException;

    void payOrder(@Nullable Integer id, BigDecimal balanceBonus, String bonusUrl) throws GlobalException;

    void payOrder(ApplyOrder order) throws GlobalException;

    Page<ApplyOrderSearchVo> search(ApplyOrderCondition condition);

    com.xinchao.entrytask.api.common.Page<ApplyOrderSearchVo> selectByWeixin(String weixin, Integer pageIndex, Integer pageSize);

    /**
     * APP任务列表获取滚动消息
     *
     * @param num
     * @return
     */
    List<ApplyOrderRollMsg> getTaskRollMsg(Integer num);

    /**
     * 根据用户ID 获取结算合计奖金
     *
     * @param applyUserId 用户ID
     * @return 结算金额
     */
    ApplyOrderBonusVo getApplyBonus(Long applyUserId);


    /**
     * @param order
     * @return
     * @see  {@link #exist(Integer, Integer)}
     */
    boolean exist(ApplyOrder order);


    /**
     * 根据任务号以及申请人id 判断是否存在该人的记录
     * @param taskId
     * @param applyUserId
     * @return 存在true, 否则false
     */
    boolean exist(Integer taskId, Integer applyUserId);

    int updateOrderStatusToCancelOfTask(Integer taskId);
}
