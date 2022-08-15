package com.example.websocketproject.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Loyalty System Api")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("vartish2003@gmail.com")
                                                .name("Vadim Artish")
                                )

                )
                .servers(List.of(new Server().url("http://localhost:8080")
                        .description("Crypto currency service")));
    }
}
