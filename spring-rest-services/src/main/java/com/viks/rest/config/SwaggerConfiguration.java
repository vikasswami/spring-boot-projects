package com.viks.rest.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {                
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(true)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.viks.rest"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
				
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"REST API", 
				"Rest API to perform CRUD operation on USER table.", 
				"API", 
				"Terms of service", 
				new Contact("Vikas Swami", "", "vikas.swami92@gmail.com"), 
				"License of API", "API license URL", Collections.emptyList());
	}

}
