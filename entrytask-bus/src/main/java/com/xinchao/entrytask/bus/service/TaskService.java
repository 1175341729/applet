package com.xinchao.entrytask.bus.service;


import com.xinchao.entrytask.api.exception.GlobalException;
import com.xinchao.entrytask.bus.model.Task;
import com.xinchao.entrytask.bus.model.TaskQueryModel;
import com.xinchao.entrytask.bus.model.TaskSearchVo;

/**
 * 任务 - - 逻辑实现接口
 */
public interface TaskService {

    void createTask(Task task)throws Exception ;

    Task getTaskById(Long id);

    com.xinchao.entrytask.api.common.Page<Task> getTaskByUserId(String weixin,String city,int pageIndex,int pageSize);

    /**
     * 根据查询条件获取任务列表
     * @param taskQueryModel
     * @return
     */
    com.xinchao.entrytask.api.common.Page<TaskSearchVo> get(TaskQueryModel taskQueryModel);

    boolean update(Task task) throws GlobalException;

    com.xinchao.entrytask.api.common.Page<Task> selectByAreaWithStatus2(String cityCode,Integer pageIndex,Integer pageSize,String condition);

}
