/**
 * Copyright (c) 2018,maipu technologies,Inc.
 * All rights reserved.
 * 文件名称： OptLogAdvice
 * 摘要：
 * <p>
 * 当前版本： ${version}
 * 作者： alanp
 * 完成日期： 2018/4/8
 * <p>
 * 修改历史：
 * $Log:
 * 文件名称： OptLogAdvice.java,v $
 */
package com.xinchao.entrytask.bus.advice;

import com.alibaba.fastjson.JSON;
import com.xinchao.entrytask.bus.model.OptLog;
import com.xinchao.entrytask.bus.service.OptLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * OptLogAdvice 操作日志增强处理
 * @author alan.pu
 * @version 1.0.0 2018/4/8
 * @see {@link com.xinchao.entrytask.bus.service.OptLogService#insert(OptLog)}
 * @since 1.0.0
 */

@Aspect
public class OptLogAdvice
{

    @Autowired
    private OptLogService optLogService;

    @Pointcut("execution(* com.xinchao.entrytask.bus.service.ApplyOrderService.insert(..))")
    public void autoSaveOptLog()
    {

    }

    @After(value = "autoSaveOptLog()")
    public  void insertLog(JoinPoint jp)
    {
        OptLog log = new OptLog();
        System.out.println(JSON.toJSONString(jp.getArgs()[0]));
        log.setCreateTime(new Date());
        log.setModeName("task");
        log.setOperationDesc("test aop");
        log.setOperatorId(3);
        log.setSupplierId("dad");
        log.setOperationType((byte) 1);
        optLogService.insert(log);
    }

}
