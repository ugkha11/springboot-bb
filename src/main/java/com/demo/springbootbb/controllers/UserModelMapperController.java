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
import com.demo.springbootbb.dtos.UserMmDTO;
import com.demo.springbootbb.entities.User;
import com.demo.springbootbb.services.UserService;

@RestController
@RequestMapping("/modelmapper/users")
public class UserModelMapperController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/{id}")
	public UserMmDTO getUserById(@PathVariable("id") @Min(2) Long id) throws UserNotFoundException
	{
		Optional<User> user = userService.getUserById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		
		User user1 = user.get();
		
		UserMmDTO userMmDTO = modelMapper.map(user1, UserMmDTO.class);  //one line to convert from User to UserMmDTO
		return userMmDTO;
	}
	
	
	

}
