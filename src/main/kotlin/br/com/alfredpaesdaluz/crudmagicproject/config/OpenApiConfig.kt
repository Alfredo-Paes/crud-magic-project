package br.com.alfredpaesdaluz.crudmagicproject.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {
    @Bean
    fun customOpenApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("RESTful API with Kotlin 1.8.22 and Spring Boot 3.1.3")
                    .version("v1")
                    .description("Some description about your API.")
                    .license(
                        License().name("Apache 2.0")
                    )
            )
    }
}

