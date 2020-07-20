package com.demo.springbootbb;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
// 
@SpringBootApplication //(scanBasePackages = { "com.demo.springbootbb.mappers", "com.demo.springbootbb.repositories","com.demo.springbootbb","com.demo.springbootbb.config","com.demo.springbootbb.controllers","com.demo.springbootbb.dtos","com.demo.springbootbb.entities","com.demo.springbootbb.Exceptions","com.demo.springbootbb.Hello","com.demo.springbootbb.services"})
public class SpringbootBbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBbApplication.class, args);
	}
	
    //@Bean
	public LocaleResolver localeResolver() {
		
		AcceptHeaderLocaleResolver localResolver = new AcceptHeaderLocaleResolver();
		localResolver.setDefaultLocale(Locale.US);
		return localeResolver();
		
	}
	
	//@Bean
	public ResourceBundleMessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

}
