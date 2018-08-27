package com.xinchao.entrytask.api.common;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 任务状态
 */
public enum TaskStatus
{
    NORMAL("接单中", 1),
    COMPLETED("已完成", 2),
    CANCELLED("已取消", 3),
    SUSPENDED("暂停接单", 4);
    @Getter
    @Setter
    public int value;
    @Getter
    @Setter
    public String des;

    TaskStatus(String des, int value)
    {
        this.des = des;
        this.value = value;
    }


    /**
     * 获取任务状态
     *
     * @param current
     * @return
     */
    public static List<TaskStatus> getNextStatus(TaskStatus current)
    {
        List<TaskStatus> res = new ArrayList<>(4);
        if (current == null)
        {
            return Arrays.asList(TaskStatus.values());
        }

        if (current == NORMAL)
        {
            res.add(SUSPENDED);
            res.add(CANCELLED);
            res.add(COMPLETED);
        }

        if (current == SUSPENDED)
        {
            res.add(NORMAL);
            res.add(COMPLETED);
            res.add(CANCELLED);
        }
        return res;
    }


    public static TaskStatus valueOf(int value)
    {
        for (TaskStatus taskStatus : TaskStatus.values())
        {
            if (taskStatus.getValue() == value)
            {
                return taskStatus;
            }
        }
        return null;
    }

    public static boolean isExit(int value)
    {
        for (int i = 0; i < TaskStatus.values().length; i++)
        {
            if (TaskStatus.values()[i].value == value)
            {
                return true;
            }
        }
        return false;
    }
}
