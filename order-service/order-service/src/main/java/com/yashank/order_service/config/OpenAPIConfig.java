package com.yashank.order_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI orderServiceOpenApi()
    {
        return new OpenAPI()
        .info(new Info().title("Order Service API")
        .description("This is the Order API Service")
        .version("v.0.0.1")
        .license(new License().name("Apache 2.0")))
        .externalDocs(new ExternalDocumentation()
        .description("This is the external URL for Ordre Service MVC, Demo URL")
        .url("http://order-service/docs"));
    }
}
