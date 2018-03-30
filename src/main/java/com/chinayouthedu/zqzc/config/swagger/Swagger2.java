package com.chinayouthedu.zqzc.config.swagger;

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
@EnableSwagger2
public class Swagger2 {

	/*
	 * @Api 描述类/接口的主要用途
	 * @ApiOperation 描述方法用途
	 * @ApiImplicitParam 描述方法的参数
	 * @ApiImplicitParams 描述方法的参数(Multi-Params)
	 * @ApiIgnore 忽略某类/方法/参数的文档
	 */
	
	@Value("${swagger.enable}")
	private boolean enableSwagger;
	
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enableSwagger)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chinayouthedu.zqzc.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("排课系统的接口")
//                .description("副标题")
//                .termsOfServiceUrl("链接")
//                .contact("Who")	// Created By Who
//                .version("1.0")		// 版本号
                .build();
    }
}
