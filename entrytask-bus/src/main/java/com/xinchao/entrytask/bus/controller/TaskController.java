package com.xinchao.entrytask.bus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xinchao.entrytask.api.common.*;
import com.xinchao.entrytask.api.controller.ITaskController;
import com.xinchao.entrytask.api.model.Task;
import com.xinchao.entrytask.bus.model.SaleArea;
import com.xinchao.entrytask.bus.model.TaskQueryModel;
import com.xinchao.entrytask.bus.model.TaskSearchVo;
import com.xinchao.entrytask.bus.service.ApplyOrderService;
import com.xinchao.entrytask.bus.service.AreaService;
import com.xinchao.entrytask.bus.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class TaskController implements ITaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    AreaService areaService;

    @Autowired
    private ApplyOrderService applyOrderService;

    @Override
    @GetMapping("/tasks/{id}")
    public JSONResponse<Task> get(@PathVariable("id") Long id) {
        com.xinchao.entrytask.bus.model.Task task = this.taskService.getTaskById(id);
        Task task1 = JSON.parseObject(JSON.toJSONString(task), Task.class);
        return new JSONResponse<>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), task1);
    }

    @Override
    @GetMapping(value = "/tasks")
    public JSONResponse<Page<Task>> getTaskByUserId(@RequestParam(value = "weixin", required = false) String weixin,
                                                    @RequestParam(value = "city", required = false) String city,
                                                    @RequestParam(value = "pageIndex") int pageIndex,
                                                    @RequestParam(value = "pageSize") int pageSize) {
        Page<com.xinchao.entrytask.bus.model.Task> taskPage = this.taskService.getTaskByUserId(weixin, city, pageIndex, pageSize);
        Page<Task> resultTask = (Page<Task>) JSONObject.parseObject(JSON.toJSONString(taskPage), Page.class);
        return new JSONResponse<>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), resultTask);
    }

    @Override
    @GetMapping("/tasks/page")
    public JSONResponse<Page<Task>> get(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                        @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                        @RequestParam(value = "startTime", required = false) String startTime,
                                        @RequestParam(value = "endTime", required = false) String endTime,
                                        @RequestParam(value = "province", required = false) String province,
                                        @RequestParam(value = "city", required = false) String city,
                                        @RequestParam(value = "taskName", required = false) String taskName,
                                        @RequestParam(value = "propertyCompany", required = false) String propertyCompany,
                                        @RequestParam(value = "dockingPerson", required = false) String dockingPerson,
                                        @RequestParam(value = "taskStatus", required = false) Integer taskStatus,
                                        @RequestParam(value = "userGroup") String userGroup) {

        TaskQueryModel taskQueryModel = TaskQueryModel.builder()
                .city(city)
                .pageIndex(pageIndex)
                .pageSize(pageSize)
                .userGroup(userGroup)
                .startTime(startTime)
                .endTime(endTime)
                .taskName(taskName)
                .propertyCompany(propertyCompany)
                .dockingPerson(dockingPerson)
                .taskStatus(taskStatus).build();
        Page<TaskSearchVo> results = taskService.get(taskQueryModel);
        Page<Task> resultTask = (Page<Task>) JSONObject.parseObject(JSON.toJSONString(results), Page.class);
        return new JSONResponse<>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), resultTask);
    }

    @Override
    @PostMapping("/tasks")
    public void createTask(@RequestBody Task task) throws Exception {
        com.xinchao.entrytask.bus.model.Task temp = JSON.parseObject(JSON.toJSONString(task), com.xinchao.entrytask.bus.model.Task.class);
        temp.setVersionNum(GenerateNumber.getVersionNum());
        temp.setStatus(new Byte("1"));
        temp.setTaskNumber(GenerateNumber.getTaskNum());
        temp.setCreateTime(new Date());
        taskService.createTask(temp);
    }

    @Override
    @PatchMapping("/tasks")
    public JSONResponse<String> updateStatus(@RequestParam("id") Integer id, @RequestParam("status") Integer status) throws Exception {
        boolean isOk = false;
        if (TaskStatus.isExit(status)) {
            //TODO
            com.xinchao.entrytask.bus.model.Task task = new com.xinchao.entrytask.bus.model.Task();
            task.setId(id);
            task.setStatus(Byte.parseByte(status + ""));
            isOk = taskService.update(task);
        }
        if (isOk) {
            return new JSONResponse<String>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), null);
        } else {
            return new JSONResponse<String>(false, CommonCode.ERROR.getCode(), CommonCode.ERROR.getMsg(), null);
        }
    }

    @Override
    @PutMapping("/tasks")
    public JSONResponse<String> updateTask(@RequestBody Task task) throws Exception {
        boolean isOk = false;
        com.xinchao.entrytask.bus.model.Task tasktemp = JSON.parseObject(JSON.toJSONString(task), com.xinchao.entrytask.bus.model.Task.class);
        tasktemp.setVersionNum(GenerateNumber.getVersionNum());
        tasktemp.setStatus(null);
        isOk = taskService.update(tasktemp);
        if (isOk) {
            return new JSONResponse<String>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), null);
        } else {
            return new JSONResponse<String>(false, CommonCode.ERROR.getCode(), CommonCode.ERROR.getMsg(), null);
        }
    }

    @Override
    @GetMapping("/tasks/gps")
    public JSONResponse<Page<Task>> getPageByCityName(@RequestParam("cityName") String cityName,
                                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                      @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                                      @RequestParam(value = "condition",required = false) String condition){
        //通过名称模糊查找地址
        SaleArea saleArea = areaService.selectByCityName(cityName);
        String id = saleArea.getId();
        Page<com.xinchao.entrytask.bus.model.Task> reault = taskService.selectByAreaWithStatus2(id, pageIndex, pageSize,condition);
        Page<Task> taskPage = (Page<Task>) JSONObject.parseObject(JSON.toJSONString(reault), Page.class);
        return new JSONResponse<>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMsg(), taskPage);
    }

    private List<Task> getTask() {
        List<Task> taskList = new ArrayList<>();
        Task task = new Task();
        task.setId(1L);
        task.setTaskName("xxx任务");
        task.setTaskAddress("布鲁明顿广场");
        task.setPropertyCompany("盛和物业");
        task.setTaskNumber("111222222");
        task.setProvince("10022");
        task.setCity("1002211");
        task.setDockingPerson("王大力");
        task.setCreator("陈大鹏");
        task.setCreateTime(new Date());
        task.setStatus(TaskStatus.NORMAL.value);
        task.setBonus(new BigDecimal("200"));
//        task.setBonusUnit("元/台");
        task.setSupplierId("成都新潮生活圈文化传媒有限公司");


        Task task2 = new Task();
        task.setId(2L);
        task.setTaskName("xxx任务");
        task.setTaskAddress("环球中心");
        task.setPropertyCompany("高大尚物业");
        task.setTaskNumber("111222222");
        task.setProvince("10022");
        task.setCity("1002211");
        task.setDockingPerson("王大力");
        task.setCreator("陈大鹏");
        task.setCreateTime(new Date());
        task.setStatus(TaskStatus.NORMAL.value);
        task.setBonus(new BigDecimal("200"));
//        task.setBonusUnit("元/台");
        task.setSupplierId("成都新潮生活圈文化传媒有限公司");


        taskList.add(task);
        taskList.add(task2);

        task.setId(3L);
        task.setTaskName("xxx任务3");
        task.setTaskAddress("环球中心3");
        task.setPropertyCompany("高大尚物业3");
        task.setTaskNumber("1112222223");
        task.setProvince("100223");
        task.setCity("10022113");
        task.setDockingPerson("王大力3");
        task.setCreator("陈大鹏3");
        task.setCreateTime(new Date());
        task.setStatus(TaskStatus.NORMAL.value);
        task.setBonus(new BigDecimal("2003"));
//        task.setBonusUnit("元/台");
        task.setSupplierId("成都新潮生活圈文化传媒有限公司3");
        taskList.add(task);

        return taskList;
    }
}