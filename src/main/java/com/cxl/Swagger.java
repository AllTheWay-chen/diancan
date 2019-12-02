package com.cxl;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaolong
 * @Description: 集成swagger
 * @Date: Creaded in 16:34 2019/12/2
 */
@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        ParameterBuilder sourcePar = new ParameterBuilder();
        ParameterBuilder permPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("X-Token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        sourcePar.name("Call-Source").description("登录平台").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        permPar.name("Perm-Code").description("权限code").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        pars.add(sourcePar.build());
        pars.add(permPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cxl.api"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("cxl 测试 API")
                .description("by diancan")
                .termsOfServiceUrl("http://www.ifenxi.com")
                .version("v1.0")
                .build();
    }

}