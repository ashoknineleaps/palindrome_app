package com.qlik.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qlik.constant.Constant;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// Swagger Metadata: http://localhost:8090/v2/api-docs
	// Swagger UI URL: http://localhost:8090/swagger-ui.html

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
				.produces(new HashSet<>(Arrays.asList(Constant.PRODUCER_JSON))).select()
				.apis(RequestHandlerSelectors.basePackage(Constant.BASE_PACKAGE)).build();
	}

	private ApiInfo getApiInfo() {

		return new ApiInfoBuilder().title(Constant.TITLE)
				.description(Constant.DESCRIPTION)
				.version(Constant.VERSION)
				.contact(getContact())
				.license(Constant.LICENSE)
				.licenseUrl(Constant.LICENSE_URL)
				.build();
	}

	private Contact getContact() {
		return new Contact(Constant.NAME, Constant.URL, Constant.EMAIL);
	} 
}