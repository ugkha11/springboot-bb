package com.demo.springbootbb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {           //model mapper config
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
