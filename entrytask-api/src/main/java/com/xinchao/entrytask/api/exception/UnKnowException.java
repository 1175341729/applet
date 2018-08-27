package com.xinchao.entrytask.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.OK)
public class UnKnowException extends GlobalException
{

    UnKnowException(String code, String msg) {
        super(code, msg);
    }
}