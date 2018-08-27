package com.xinchao.entrytask.bus.controller;

import com.alibaba.fastjson.JSON;
import com.xinchao.entrytask.api.common.CommonCode;
import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.controller.ICodeHelpAnswerController;
import com.xinchao.entrytask.api.model.CodeHelpAnswer;
import com.xinchao.entrytask.bus.dao.CodeHelpAnswerMapper;
import com.xinchao.entrytask.bus.service.CodeHelpAnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CodeHelpAnswerController implements ICodeHelpAnswerController {

    @Autowired
    private CodeHelpAnswerService codeHelpAnswerService;


    @Override
    @GetMapping("help/{problemId}")
    public JSONResponse<List<CodeHelpAnswer>> get(@PathVariable Long problemId) {
        List<com.xinchao.entrytask.bus.model.CodeHelpAnswer> codeHelpAnswerList=this.codeHelpAnswerService.get(problemId);
        return new JSONResponse<>(true,CommonCode.SUCCESS.getCode(),CommonCode.SUCCESS.getMsg(), JSON.parseArray(JSON.toJSONString(codeHelpAnswerList),CodeHelpAnswer.class));
    }
}
