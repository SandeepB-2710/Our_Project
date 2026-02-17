package com.tata.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;

@Configuration
public class SwaggerConfig {
	
	private static final String SECURITY_SCHEME_NAME = "JWT";
	
	@Bean
	public OpenAPI ourApplicationOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("InfoCircle")
						.description("WEB App Developed By Team: 02")
						.version("1.0.0")
						.termsOfService("Terms and Condition of Service")
						.contact(new Contact()
								.name("TEAM 02")
								.url("https://github.com/SandeepB-2710/Our_Project/")
								.email("mallikarjunjamadar777@gmail.com"))
						.license(new License()
								.name("TATA Strive, Bengaluru")
								.url("https://www.instagram.com/apna_bhidu_2341/?__pwa=1")))
				
				.addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME, 
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .in(In.HEADER)));
	}
	
	@Bean
	public GroupedOpenApi publicApi() {
	    return GroupedOpenApi.builder()
	            .group("InfoCircle APIs")
	            .pathsToMatch("/api/**")
	            .build();
	}

}
