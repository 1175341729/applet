package com.xinchao.entrytask.bus.feign;

import com.xinchao.entrytask.bus.common.helper.SmsVerifyRequest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("common")
@Configuration
public interface AuthFeignClient {

    @RequestMapping(value = "/verifySmsCode", method = {RequestMethod.POST})
    String verifySmsCode(@RequestBody SmsVerifyRequest request);

}