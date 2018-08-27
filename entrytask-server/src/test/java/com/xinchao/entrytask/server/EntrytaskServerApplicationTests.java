package com.xinchao.entrytask.server;

import com.alibaba.fastjson.JSON;
import com.xinchao.core.page.Page;
import com.xinchao.entrytask.api.common.ApplyOrderStatus;
import com.xinchao.entrytask.api.common.CommonCode;
import com.xinchao.entrytask.api.exception.GlobalException;
import com.xinchao.entrytask.bus.dao.TaskMapper;
import com.xinchao.entrytask.bus.model.*;
import com.xinchao.entrytask.bus.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrytaskServerApplicationTests {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private OptLogService optLogService;

    @Autowired
    private ApplyOrderService applyOrderService;

    @Autowired
    private ApplyUserService userService;

    @Autowired
    private CodeHelpService codeHelpService;

    @Autowired
    private CodeHelpAnswerService codeHelpAnswerService;

    @Autowired
    private ReportService reportService;


    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateTask() throws Exception {
        Task task = new Task();

        task.setBonus(new BigDecimal("11"));
        task.setCity("220200");
        task.setDockingPerson("123");
        task.setDockingPhone("17608007569");
        task.setPropertyCompany("123");
        task.setProvince("220000");
        task.setSupplierId("333");
        task.setTaskAddress("123");
        task.setTaskName("我发布任务");
        task.setCreator("admin");

        System.out.println(JSON.toJSONString(task));

//        taskService.createTask(task);
    }

    @Test
    public void testAddOptLog()
    {
        OptLog log = new OptLog();
        log.setCreateTime(new Date());
        log.setModeName("task");
        log.setOperationDesc("test task");
        log.setOperatorId(3);
        log.setSupplierId("dad");
        log.setOperationType((byte) 1);
        optLogService.insert(log);
    }

    @Test
    public void testDelOptLogById()
    {
        optLogService.delete(1);
    }


    @Test
    public void updateOptLog()
    {
        OptLog log = new OptLog();
        log.setCreateTime(new Date());
        log.setModeName("task");
        log.setOperationDesc("test task");
        log.setOperatorId(3);
        log.setId(2);
        log.setSupplierId("dad-d");
        log.setOperationType((byte) 1);
        optLogService.update(log);

    }

    @Test
    public void getOptLogById()
    {
        OptLog log = optLogService.get(2);
    }

    @Test
    public void search()
    {
        OptLogCondition condition = new OptLogCondition();
        condition.setModeName("ddd");
        condition.setStart(new Date());
        Page<OptLog> res = optLogService.search(condition);
        System.out.println(res);
    }

    @Test
    public void queryOrder()
    {

        ApplyOrderCondition condition = new ApplyOrderCondition();
        //        condition.setPageInfo(2, 1);
//        condition.setApplyPhone("1760");
//        condition.setPropertyCompany("大卫物业");
        condition.setUserGroup("a001");
        Page<ApplyOrderSearchVo> result = applyOrderService.search(condition);
        System.out.println(result.getTotal());
    }

    @Test
    public void queryApplyByWx()
    {
        ApplyUser user = userService.getByWeiXin("abc@126.com");
        System.out.println(user.toString());
    }

    @Test
    public void queryTask()
    {
        TaskQueryModel taskQueryModel = TaskQueryModel.builder()
                //        .city("510100")
                .userGroup("333")
                //        .startTime("2018-04-03 09:41:36")
                //        .endTime("2018-04-03 11:01:02")
                .taskName("ccc")
                //        .propertyCompany("大卫物业")
                //        .dockingPerson("王某某")
                .taskStatus(2).build();
        List<TaskSearchVo> taskSearchVoLis = this.taskMapper.get(taskQueryModel);
        System.out.println(JSON.toJSONString(taskSearchVoLis));
    }

    @Test
    public void queryHelpProblem()
    {
        List<CodeHelpAnswer> codeHelpList = codeHelpAnswerService.get(6L);
        System.out.println(JSON.toJSONString(codeHelpList));
    }

    @Test
    public void queryRollMsG()
    {
        List<ApplyOrderRollMsg> applyOrderRollMsgList = applyOrderService.getTaskRollMsg(3);
        System.out.println(JSON.toJSONString(applyOrderRollMsgList));
        applyOrderService.insert(new ApplyOrder());
    }

    @Test
    public void queryApplyBonus()
    {
        ApplyOrderBonusVo applyOrderBonusVo = applyOrderService.getApplyBonus(1L);
        System.out.println(JSON.toJSONString(applyOrderBonusVo));
    }


    /**
     * 测试接单，此用例可测试创建单以及一个任务一个人仅能接一个单
     */
    @Test
    public void testCreateOrder()
    {
        com.xinchao.entrytask.api.model.ApplyOrder order = new com.xinchao.entrytask.api.model.ApplyOrder();
        order.setAdvantageId("500");
        order.setApplyPhone("50000000000");
        order.setApplyTime(new Date());
        order.setApplyWeixin("123@qq.com");
        order.setBalanceBonus(new BigDecimal(500));
        order.setTaskId(25L);
        order.setRemarks("500 test");
        order.setStatus(1);
        order.setApplyUserId(6L);
        try
        {
            applyOrderService.createOrder(order);
        }
        catch (GlobalException e)
        {
            assert e.getCode() == CommonCode.REPEAT.getCode();
        }
    }

    /**
     * 测试订单状态的更新
     */
    @Test
    public void testUpdateOrderStatus()
    {
        try
        {
            // @ 状态不可达，pass
            // applyOrderService.updateOrderStatus(19, ApplyOrderStatus.DONE.getValue() + "", "ceshi");
            // 测试接单已接受，同时修改任务状态 pass
            // applyOrderService.updateOrderStatus(19, ApplyOrderStatus.ACCEPTED.getValue() + "", "ceshi");

            // 测试接单已取消 pass
            //            applyOrderService.updateOrderStatus(19, ApplyOrderStatus.CANCELLED.getValue() + "", "ceshi");
            // 测试接单签约 pass
            applyOrderService.updateOrderStatus(19, ApplyOrderStatus.DONE.getValue() + "", "ceshi");



        }
        catch (GlobalException e)
        {
            assert e.getCode() == CommonCode.STATUS_UNREACHABLE.getCode();
        }

    }


    /**
     * 测试打款
     */
    @Test
    public void testPayOrder()
    {
        try
        {
            applyOrderService.payOrder(20, new BigDecimal(500), "testurl");
        }
        catch (GlobalException e)
        {
            e.printStackTrace();
            assert false;
        }
    }

    /**
     * 统计简报
     */
    @Test
    public void queryBriefing(){
        BriefingModel briefingModel= reportService.get("333");
        System.out.println(JSON.toJSONString(briefingModel));
    }

    /**
     * 任务数据
     */
    @Test
    public void queryBriefingGroupBySupplier(){

        List<BriefingModel> briefingModel=reportService.get();
        System.out.println("sdfsdf"+JSON.toJSONString(briefingModel));
    }

    @Test
    public  void testApplyUser()
    {
        try
        {
            userService.insert(new ApplyUser(){{setApplyPhone("17713573561");setApplyWeixin("17713573561");setApplyTime(new Date());}});
        }
        catch (GlobalException e)
        {
            e.printStackTrace();
        }
    }

}
