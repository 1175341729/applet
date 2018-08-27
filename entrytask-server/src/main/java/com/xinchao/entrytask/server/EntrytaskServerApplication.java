package com.xinchao.entrytask.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan("com.xinchao")
@MapperScan("com.xinchao.entrytask.bus.dao")
//@EnableDiscoveryClient
@EnableFeignClients("com.xinchao")
@EnableTransactionManagement
public class EntrytaskServerApplication
{


    public static void main(String[] args)
    {
        SpringApplication.run(EntrytaskServerApplication.class, args);
    }

    /**
     * 解决传统表单中文乱码问题 web-filter
     *
     * @return
     */
    @Bean
    public CharacterEncodingFilter initializeCharacterEncodingFilter()
    {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}



