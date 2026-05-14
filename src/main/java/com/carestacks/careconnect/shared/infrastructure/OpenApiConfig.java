package com.carestacks.careconnect.shared.infrastructure;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "CareConnect Backend API",
                version = "0.0.1",
                description = "REST API for CareConnect IAM, agenda, notifications, diary, and documents bounded contexts"
        )
)
public class OpenApiConfig {
}
