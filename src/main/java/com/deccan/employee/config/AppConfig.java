package com.deccan.employee.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public OpenAPI employeeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee API")
                        .description("API documentation for testing employee endpoints")
                        .version("v1"));
    }
}
