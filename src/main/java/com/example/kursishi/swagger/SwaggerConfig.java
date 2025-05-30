package com.example.kursishi.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                description = "Online transaction platform",
                title = "Transactions",
                version = "1.0"
        ),
        security = @SecurityRequirement(name = "BearerAuth")
)
@SecurityScheme(
        name = "BearerAuth",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
@Configuration
public class SwaggerConfig {
}

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.info.Info;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
//import org.springframework.context.annotation.Configuration;
//
//@OpenAPIDefinition(info = @Info(
//  description = "Online transaction platform",
//  title = "Transactions",
//  version = "1.0"
//),
//  security = @SecurityRequirement(
//    name = "BearerAuth"
//  )
//)
//@SecurityScheme(
//  name = "BearerAuth",
//  description = "JWT-based authentication",
//  scheme = "bearer",
//  type = SecuritySchemeType.HTTP,
//  bearerFormat = "JWT",
//  in = SecuritySchemeIn.HEADER
//)
//@Configuration
//public class SwaggerConfig {
//}
