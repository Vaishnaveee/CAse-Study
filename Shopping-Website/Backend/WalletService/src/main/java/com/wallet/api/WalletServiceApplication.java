package com.wallet.api;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EntityScan(basePackages = {"com.wallet.api.model"})  
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableEurekaClient
@EnableSwagger2
public class WalletServiceApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new  RestTemplate();
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	    return builder.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WalletServiceApplication.class, args);
	}
	
	
	@Bean
	public Docket SwaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				
				.apis(RequestHandlerSelectors.basePackage("com.wallet.api"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Wallet service API",
				"API for Shopping Cart System ",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Ankush Marathe", "ankushmarathe@gmail.com", "http://abc.com"),
				"API License",
				"http://shoppingsystem.com",
				Collections.emptyList()
				
				);
		
	}

}
