package com.xinchao.entrytask.bus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xinchao.entrytask.api.common.ApplyOrderStatus;
import com.xinchao.entrytask.api.common.CommonCode;
import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.common.Page;
import com.xinchao.entrytask.api.controller.IApplyOrderController;
import com.xinchao.entrytask.api.exception.GlobalException;
import com.xinchao.entrytask.api.model.ApplyOrder;
import com.xinchao.entrytask.bus.model.ApplyOrderBonusVo;
import com.xinchao.entrytask.bus.model.ApplyOrderCondition;
import com.xinchao.entrytask.bus.model.ApplyOrderRollMsg;
import com.xinchao.entrytask.bus.model.ApplyOrderSearchVo;
import com.xinchao.entrytask.bus.service.ApplyOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * 申请记录
 */
@RestController
@Slf4j
public class ApplyOrderController implements IApplyOrderController
{


    @Autowired
    private ApplyOrderService applyOrderService;


    @Override
    @GetMapping("/orders/page")
    public JSONResponse<Page<ApplyOrder>> get(
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            @RequestParam(value = "province", required = false) String province,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "taskNumber", required = false) String taskNumber,
            @RequestParam(value = "taskName", required = false) String taskName,
            @RequestParam(value = "propertyCompany", required = false) String propertyCompany,
            @RequestParam(value = "applyPhone", required = false) String applyPhone,
            @RequestParam(value = "applyStatus", required = false) String applyStatus,
            @RequestParam(value = "userGroup", required = true) String userGroup
    ) throws GlobalException
    {
        List<ApplyOrder> applyOrders = new ArrayList<>();
        ApplyOrderCondition applyOrderCondition = new ApplyOrderCondition();
        applyOrderCondition.setStatus(applyStatus);
        applyOrderCondition.setPageInfo(pageIndex, pageSize);
        applyOrderCondition.setProvince(province);
        applyOrderCondition.setTaskName(taskName);
        applyOrderCondition.setPropertyCompany(propertyCompany);
        applyOrderCondition.setTaskNum(taskNumber);
        applyOrderCondition.setUserGroup(userGroup);
        applyOrderCondition.setApplyPhone(applyPhone);
        try
        {
            if (StringUtils.isNotEmpty(startTime))
                applyOrderCondition.setStart(DateFormat.getDateInstance().parse(startTime));
            if (StringUtils.isNotEmpty(endTime))
                applyOrderCondition.setEnd(DateFormat.getDateInstance().parse(endTime));
        }
        catch (ParseException e)
        {
            throw new GlobalException(CommonCode.PARAM_ERROR.getCode(), "日期格格式错误");
        }
//TODO  userGroup error
        com.xinchao.core.page.Page<ApplyOrderSearchVo> result = applyOrderService.search(new ApplyOrderCondition());
        String resultJson = JSON.toJSONString(result.getRecords());
        applyOrders.addAll(JSON.parseObject(resultJson, new TypeReference<List<ApplyOrder>>()
        {
        }));
        return new JSONResponse<Page<ApplyOrder>>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), new Page<ApplyOrder>(applyOrders, (long) applyOrders.size()));
    }

    @Override
    @PostMapping("/orders")
    public void createOrder(@RequestBody ApplyOrder applyOrder) throws Exception
    {
        applyOrderService.createOrder(applyOrder);
    }

    /**
     * @param id
     * @param status{@link ApplyOrderStatus#value}
     * @param remarks
     * @throws Exception
     */
    @Override
    @PatchMapping("/orders/status")
    public void updateStatus(@RequestParam("id") Integer id, @RequestParam("status") String status, @RequestParam(value = "remarks", required = false) String remarks) throws Exception
    {
        if (status == null)
        {
            throw new GlobalException(CommonCode.PARAM_ERROR);
        }
        try
        {
            ApplyOrderStatus applyOrderStatus = ApplyOrderStatus.valueOf(Integer.valueOf(status));
            com.xinchao.entrytask.bus.model.ApplyOrder dbOrder = applyOrderService.getById(id);
            ApplyOrderStatus dbOrderStatus = ApplyOrderStatus.valueOf(Integer.valueOf(dbOrder.getStatus()));
            if (!dbOrderStatus.getNextStatus(dbOrderStatus).contains(applyOrderStatus))
            {
                throw new GlobalException(CommonCode.STATUS_UNREACHABLE);
            }
        }
        catch (NumberFormatException e)
        {
            throw new GlobalException(CommonCode.PARAM_ERROR);
        }
        applyOrderService.updateOrderStatus(id, status, remarks);
    }

    @Override
    @PatchMapping("/orders/bonus")
    public void updateBonus(@RequestParam("id") Integer id, @RequestParam("bonus") String bonus, @RequestParam("bonusUrl") String bonusUrl) throws Exception
    {
        // FIXME  How to get the order id;
        // TODO
        applyOrderService.payOrder(id, new BigDecimal(bonus), bonusUrl);
    }

    @Override
    @GetMapping("/orders")
    public JSONResponse<Page<ApplyOrder>> get(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, @RequestParam(value = "weixin", required = true) String weixin)
    {
        Page<ApplyOrderSearchVo> applyOrderSearchVoPage = applyOrderService.selectByWeixin(weixin, pageIndex, pageSize);
        Page<ApplyOrder> resultTask = (Page<ApplyOrder>) JSONObject.parseObject(JSON.toJSONString(applyOrderSearchVoPage), Page.class);
        return new JSONResponse<>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), resultTask);
    }

    /**
     * 获取滚动消息
     *
     * @return
     */
    @Override
    @GetMapping("/orders/roll-msg")
    public JSONResponse<List<com.xinchao.entrytask.api.model.ApplyOrderRollMsg>> getTaskRollMsg(@RequestParam(value = "num", defaultValue = "10") Integer num)
    {

        List<ApplyOrderRollMsg> applyOrderRollMsgList = applyOrderService.getTaskRollMsg(num);

        return new JSONResponse<>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), JSON.parseArray(JSON.toJSONString(applyOrderRollMsgList), com.xinchao.entrytask.api.model.ApplyOrderRollMsg.class));
    }

    /**
     * 根据用户ID 获取用户收益
     *
     * @param applyUserId
     * @return
     */
    @Override
    @GetMapping("/orders/bonus")
    public JSONResponse<ApplyOrder> getApplyBonus(@RequestParam("applyUserId") Long applyUserId)
    {
        ApplyOrderBonusVo applyOrderBonusVo = applyOrderService.getApplyBonus(applyUserId);
        return new JSONResponse<>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), JSON.parseObject(JSON.toJSONString(applyOrderBonusVo), ApplyOrder.class));
    }


}
