package com.example.demoamposrestaurant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.ant;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("staff-order-api")
                .apiInfo(apiInfo)
                .select().paths(ant("/api/**"))
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Staff Only Order Management API")
                .description("APIs for AMPOS restaurant staff only order management.")
                .version("1.0.0")
                .contact(new Contact("Howard Wang", "", "idontwannarock@gmail.com"))
                .build();
    }
}
