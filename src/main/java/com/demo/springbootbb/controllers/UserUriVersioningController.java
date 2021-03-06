package com.demo.springbootbb.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.springbootbb.Exceptions.UserNotFoundException;
import com.demo.springbootbb.dtos.UserDtoV1;
import com.demo.springbootbb.dtos.UserDtoV2;
import com.demo.springbootbb.dtos.UserMmDTO;
import com.demo.springbootbb.entities.User;
import com.demo.springbootbb.services.UserService;

@RestController
@RequestMapping("/versioning/uri/users")
public class UserUriVersioningController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//Uri based versioning  - v1
	
	@GetMapping({"/v1.0/{id}", "/v1.1/{id}"})
	public UserDtoV1 getUserById(@PathVariable("id") @Min(2) Long id) throws UserNotFoundException
	{
		Optional<User> user = userService.getUserById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		
		User user1 = user.get();
		
		UserDtoV1 userDtoV1 = modelMapper.map(user1, UserDtoV1.class);  //one line to convert from User to UserDtoV1  (source, destination)
		return userDtoV1;
	}
	
	
	
	@GetMapping("/v2.0/{id}")
	public UserDtoV2 getUserById2(@PathVariable("id") @Min(2) Long id) throws UserNotFoundException
	{
		Optional<User> user = userService.getUserById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		
		User user1 = user.get();
		
		UserDtoV2 userDtoV2 = modelMapper.map(user1, UserDtoV2.class);  //one line to convert from User to UserDtoV2  (source, destination)
		return userDtoV2;
	}
	

}
