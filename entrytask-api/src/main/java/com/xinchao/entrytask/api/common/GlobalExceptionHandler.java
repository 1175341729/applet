package com.xinchao.entrytask.api.common;

import com.xinchao.entrytask.api.exception.GlobalException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = GlobalException.class)
    public JSONResponse<String> jsonErrorHandler(GlobalException e) throws  Exception{
        JSONResponse<String> jsonResponse=new JSONResponse<>();
        jsonResponse.setCode(e.getCode());
        jsonResponse.setMsg(e.getMsg());
        return jsonResponse;
    }
}
