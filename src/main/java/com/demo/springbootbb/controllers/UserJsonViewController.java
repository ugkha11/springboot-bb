package com.demo.springbootbb.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.springbootbb.Exceptions.UserNotFoundException;
import com.demo.springbootbb.entities.User;
import com.demo.springbootbb.entities.Views;
import com.demo.springbootbb.services.UserService;
import com.fasterxml.jackson.annotation.JsonView;


@RestController
@RequestMapping(value = "/jsonview/users")
@Validated
public class UserJsonViewController {
	
	@Autowired
	private UserService userService;
	
	
	//external
	@GetMapping("external/{id}")
	@JsonView(Views.External.class)
	public Optional<User> getUserById(@PathVariable("id") @Min(2) Long id)
	{
		try {
			return userService.getUserById(id);
		}catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
			
		}	
	}
	
	//internal	
	@GetMapping("internal/{id}")
	@JsonView(Views.Internal.class)
	public Optional<User> getUserById2(@PathVariable("id") @Min(2) Long id)
	{
		try {
			return userService.getUserById(id);
		}catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
			
		}	
	}
	
	
	
	

}
