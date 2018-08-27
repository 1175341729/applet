package com.xinchao.entrytask.bus.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xinchao.entrytask.api.common.CommonCode;
import com.xinchao.entrytask.api.common.TaskStatus;
import com.xinchao.entrytask.api.exception.GlobalException;
import com.xinchao.entrytask.bus.dao.TaskMapper;
import com.xinchao.entrytask.bus.model.Task;
import com.xinchao.entrytask.bus.model.TaskQueryModel;
import com.xinchao.entrytask.bus.model.TaskSearchVo;
import com.xinchao.entrytask.bus.service.ApplyOrderService;
import com.xinchao.entrytask.bus.service.TaskService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService
{

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private ApplyOrderService orderService;

    @Override
    public void createTask(Task task) throws Exception
    {
        int i = this.taskMapper.insertTask(task);
    }

    @Override
    public Task getTaskById(Long id)
    {
        return this.taskMapper.selectTaskById(id);
    }

    /**
     * @return
     */
    @Override
    public com.xinchao.entrytask.api.common.Page<Task> getTaskByUserId(String weixin, String city, int pageIndex, int pageSize)
    {
        Page<Task> page = PageHelper.startPage(pageIndex, pageSize);
        com.xinchao.entrytask.api.common.Page<Task> taskPage = new com.xinchao.entrytask.api.common.Page<>();
        List<Task> taskList = this.taskMapper.getTaskByUserId(weixin, city);
        taskPage.setList(taskList);
        taskPage.setTotal(page.getTotal());
        return taskPage;
    }

    @Override
    public com.xinchao.entrytask.api.common.Page<TaskSearchVo> get(TaskQueryModel taskQueryModel)
    {
        Page<TaskSearchVo> page = PageHelper.startPage(taskQueryModel.getPageIndex(), taskQueryModel.getPageSize());
        com.xinchao.entrytask.api.common.Page<TaskSearchVo> taskPage = new com.xinchao.entrytask.api.common.Page<>();
        List<TaskSearchVo> taskSearchVoList = this.taskMapper.get(taskQueryModel);
        taskPage.setList(taskSearchVoList);
        taskPage.setTotal(page.getTotal());
        return taskPage;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, GlobalException.class})
    public boolean update(Task task) throws GlobalException
    {

        Task dbTask = taskMapper.selectTaskById(Long.valueOf(task.getId()));
        // 同时修改了状态
        if (dbTask.getStatus() != task.getStatus() && !StringUtils.isEmpty(task.getStatus().toString()))
        {
            TaskStatus dbSt = TaskStatus.valueOf(dbTask.getStatus());
            TaskStatus thisSt = TaskStatus.valueOf(task.getStatus());
            if (!TaskStatus.getNextStatus(dbSt).contains(thisSt))
            {
                throw new GlobalException(CommonCode.STATUS_UNREACHABLE);
            }
            if (thisSt == TaskStatus.CANCELLED)
            {
                orderService.updateOrderStatusToCancelOfTask(task.getId());
            }
            // 完成时间
            if (thisSt == TaskStatus.COMPLETED)
            {
                task.setCompletionTime(new Date());
            }
        }
        if (taskMapper.updateByPrimaryKeySelective(task) > 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public com.xinchao.entrytask.api.common.Page<Task> selectByAreaWithStatus2(String cityCode, Integer pageIndex, Integer pageSize, String condition)
    {
        Page<Task> page = PageHelper.startPage(pageIndex, pageSize);
        com.xinchao.entrytask.api.common.Page<Task> taskPage = new com.xinchao.entrytask.api.common.Page<>();
        List<Task> taskList = this.taskMapper.selectByAreaWithStatus2(cityCode, condition);
        taskPage.setList(taskList);
        taskPage.setTotal(page.getTotal());
        return taskPage;
    }
}
