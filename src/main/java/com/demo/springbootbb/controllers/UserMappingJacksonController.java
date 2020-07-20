package com.demo.springbootbb.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.springbootbb.Exceptions.UserNotFoundException;
import com.demo.springbootbb.entities.User;
import com.demo.springbootbb.services.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/jacksonfilters/users")
@Validated
public class UserMappingJacksonController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")  //fields with Hashset
	public MappingJacksonValue getUserById(@PathVariable("id") @Min(2) Long id) {
		try {
			Optional<User> optionalUser = userService.getUserById(id);

			User user = optionalUser.get();
			Set<String> fields = new HashSet<String>();
			fields.add("userid");
			fields.add("username");
			fields.add("ssn");
			fields.add("orders");
			SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
			FilterProvider filterProvider = new SimpleFilterProvider().addFilter("userFilter", filter); //userFilter has to be applied on Entity
			MappingJacksonValue mapper = new MappingJacksonValue(user);

			mapper.setFilters(filterProvider);

			return mapper;
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());

		}
	}
	
	
	
	
	@GetMapping("/params/{id}")  //fields with @RequestParam
	public MappingJacksonValue getUserById2(@PathVariable("id") @Min(2) Long id, @RequestParam Set<String> fields) {
		try {
			Optional<User> optionalUser = userService.getUserById(id);

			User user = optionalUser.get();
			
			SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
			FilterProvider filterProvider = new SimpleFilterProvider().addFilter("userFilter", filter); //userFilter has to be applied on Entity
			MappingJacksonValue mapper = new MappingJacksonValue(user);

			mapper.setFilters(filterProvider);

			return mapper;
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());

		}
	}
	
	
	
	
	

}
