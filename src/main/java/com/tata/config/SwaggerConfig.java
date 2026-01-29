package com.tata.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
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
								.url("https://www.instagram.com/apna_bhidu_2341/?__pwa=1")));
	}
}
