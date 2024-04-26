package com.gptw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class OpenAPIConfig {

  @Bean
  OpenAPI myOpenAPI() {

    Info info = new Info()
        .title("file-service")
        .version("1.0")
        .description("Microsserviço Java RESTful para leitura de arquivo CSV e escrita dos registros em tópico kafka");

    return new OpenAPI().info(info);
  }
}
