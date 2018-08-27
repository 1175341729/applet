package com.xinchao.entrytask.bus.service;

import com.xinchao.entrytask.bus.model.CodeHelpAnswer;

import java.util.List;

public interface CodeHelpAnswerService {

    /**
     * 根据问题ID 获取 答案列表
     * @param problemId
     * @return
     */
    List<CodeHelpAnswer> get(Long problemId);
}
