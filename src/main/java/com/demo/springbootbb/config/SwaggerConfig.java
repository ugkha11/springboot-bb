package com.demo.springbootbb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.demo.springbootbb"))
				.paths(PathSelectors.any())   
				.build();
	}

	//Swagger Metadata: http://localhost:8082/v2/api-docs
	//Swagger UI URL; http://localhost:8082/swagger-ui.html
	
	 @Bean
	    public WebMvcConfigurer webMvcConfigurer()
	    {
	        return new WebMvcConfigurer()
	        {
	            @Override
	            public void addResourceHandlers( ResourceHandlerRegistry registry )
	            {
	                registry.addResourceHandler( "swagger-ui.html" ).addResourceLocations( "classpath:/META-INF/resources/" );
	                registry.addResourceHandler( "/webjars/**" ).addResourceLocations( "classpath:/META-INF/resources/webjars/" );
	            }
	        };
	    }
	 
	 
	 
	 
	 private ApiInfo getApiInfo() {
		 
		 return new ApiInfoBuilder()
				 .title("Springboot fundamentals User Service")
				 .description("Some description")
				 .version("2.0")
				 .contact(new Contact("Osman","https://www.google.com","ugkha11@gmail.com"))
				 .license("License 2.0")
				 .licenseUrl("https://www.facebook.com")
				 .build();
		 
	 }
	

}
