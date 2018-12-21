package org.xxpay.boot.swagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Simon
 * @version V1.0
 * @Title: Swagger2
 * @Package org.xxpay.boot
 * @Description: TODO
 * @date 2018/02/08
 */

@Configuration
@EnableSwagger2
public class Swagger2 {

    private final Logger log = LoggerFactory.getLogger(Swagger2.class);

    public static final String BASE_PACKAGE = "org.xxpay.boot";

    @Bean
    public Docket createRestApi() {
        log.debug("Swagger2 API");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("聚合支付APIs")
                .description("RESTful APIs in Spring Boot.")
                .termsOfServiceUrl("localhost")
                .contact("Simon")
                .version("1.0")
                .build();
    }
}
