package com.xinchao.entrytask.api.swagger;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // 启用Swagger2
public class Swagger2 {

//    @Bean
//    public Docket createRestApi() {// 创建API基本信息
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.xinchao"))// 扫描该包下的所有需要在Swagger中展示的API，@ApiIgnore注解标注的除外
//                .paths(PathSelectors.any())
//                .build();
//    }

//    private ApiInfo apiInfo() {// 创建API的基本信息，这些信息会在Swagger UI中进行显示
//        return new ApiInfoBuilder()
//                .title("Spring Boot中使用Swagger2构建RESTful APIs")// API 标题
//                .description("《任务发布系统》提供的RESTful APIs")// API描述
//                .contact("chenpeng")// 联系人
//                .version("1.0")// 版本号
//                .build();
//    }

    @Value("${swagger.version:1.0}")
    private String version;
    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.xinchao"))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }


        private ApiInfo apiInfo() {// 创建API的基本信息，这些信息会在Swagger UI中进行显示
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")// API 标题
                .description("《任务发布系统》提供的RESTful APIs")// API描述
                .contact("chenpeng")// 联系人
                .version("1.0")// 版本号
                .build();
    }

}
