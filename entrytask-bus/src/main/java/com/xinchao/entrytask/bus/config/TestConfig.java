package com.xinchao.entrytask.bus.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class TestConfig {
    @Value("${timeout:100}")
    private int timeout;
    @Value("${batch:200}")
    private int batch;
}
