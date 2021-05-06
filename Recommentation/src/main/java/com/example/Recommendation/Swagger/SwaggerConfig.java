package com.example.Recommendation.Swagger;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket postApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Team3").
                apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/.*"), regex("/.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Music Application Rest API Documentation")
                .description("This is Recommended microservices")
                .contact("musicapp@gmail.com")
                .license("UST")
                .licenseUrl("www.UST.com")
                .termsOfServiceUrl("musicapp@gmail.com@gmail.com")
                .version("1.0").build();
    }
}



