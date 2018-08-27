package com.xinchao.entrytask.api.common;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/***
 * 申请状态
 */
public enum ApplyOrderStatus
{
    APPLY("已申请", 1),
    ACCEPTED("已接受", 2), DONE("已签约", 3), BROKERAGE("已打款", 4), CANCELLED("已取消", 5), REFUSED("已拒绝", 6);
    @Getter
    @Setter
    public int value;
    @Getter
    @Setter
    public String des;

    ApplyOrderStatus(String des, int value)
    {
        this.des = des;
        this.value = value;
    }

    /**
     * 获取当前状态的下一个可用状态
     *
     * @param current 当前状态，如果为null 这默认使用<code>APPLY</code>
     * @return 返回下一个可用状态的集合
     */
    public static List<ApplyOrderStatus> getNextStatus(ApplyOrderStatus current)
    {
        List<ApplyOrderStatus> res = new ArrayList<>(6);
        if (current == null)
        {
            current = APPLY;
        }
        if (current == APPLY)
        {
            res.add(CANCELLED);
            res.add(REFUSED);
            res.add(ACCEPTED);
        }
        if (current == ACCEPTED)
        {
            res.add(CANCELLED);
            res.add(DONE);
        }
        if (current == DONE)
        {
            res.add(BROKERAGE);
        }
        return res;
    }

    public static ApplyOrderStatus valueOf(int id)
    {

        for (ApplyOrderStatus applyOrderStatus : ApplyOrderStatus.values())
        {
            if (applyOrderStatus.value == id)
            {
                return applyOrderStatus;
            }
        }
        return null;
    }

    @Override
    public String toString()
    {
        return "ApplyOrderStatus{" + "value=" + value + ", des='" + des + '\'' + '}';
    }
}
