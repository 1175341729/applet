package com.xinchao.entrytask.bus.service.Impl;

import com.xinchao.entrytask.bus.dao.CodeHelpAnswerMapper;
import com.xinchao.entrytask.bus.model.CodeHelpAnswer;
import com.xinchao.entrytask.bus.service.CodeHelpAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeHelpAnswerServiceImpl implements CodeHelpAnswerService {

    @Autowired
    private CodeHelpAnswerMapper codeHelpAnswerMapper;

    /**
     * 根据问题ID 获取答案列表
     * @param problemId 问题ID
     * @return 答案列表
     */
    @Override
    public List<CodeHelpAnswer> get(Long problemId) {

        return codeHelpAnswerMapper.get(problemId);
    }
}
