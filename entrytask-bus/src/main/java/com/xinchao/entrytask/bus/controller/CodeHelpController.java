package com.xinchao.entrytask.bus.controller;

import com.alibaba.fastjson.JSON;
import com.xinchao.entrytask.api.common.CommonCode;
import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.controller.ICodeHelpController;
import com.xinchao.entrytask.api.model.CodeHelp;
import com.xinchao.entrytask.bus.service.CodeHelpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CodeHelpController implements ICodeHelpController{

    @Autowired
    private CodeHelpService codeHelpService;

    @Override
    @GetMapping("help")
    public JSONResponse<List<CodeHelp>> get() {
        List<com.xinchao.entrytask.bus.model.CodeHelp> codeHelpList=codeHelpService.get();
        return new JSONResponse<>(true,CommonCode.SUCCESS.getCode(),CommonCode.SUCCESS.getMsg(),JSON.parseArray(JSON.toJSONString(codeHelpList),CodeHelp.class));
    }
}
