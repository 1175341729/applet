package com.xinchao.entrytask.api.exception;

import com.xinchao.entrytask.api.common.CommonCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalException extends RuntimeException
{
    private String code;
    private String msg;

    public GlobalException(String code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public GlobalException(CommonCode code)
    {
        if (code != null)
        {
            this.code = code.getCode();
            this.msg = code.getMsg();
        }
    }
}
