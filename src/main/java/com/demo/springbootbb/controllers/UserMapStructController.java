package com.demo.springbootbb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootbb.dtos.UserMsDTO;
import com.demo.springbootbb.entities.User;
import com.demo.springbootbb.mappers.UserMapper;
import com.demo.springbootbb.repositories.UserRepository;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {
	
	@Autowired  //	@Qualifier("usermapper")
	private UserMapper userMapper;
	
	@Autowired
	public UserRepository userRespository;
	

	
	@GetMapping
	public List<UserMsDTO> getAllUserDtos() {
		return userMapper.userToUserDTOs(userRespository.findAll());
	}

	@GetMapping("/{id}")
	public UserMsDTO getUserById(@PathVariable Long id) {
		Optional<User> userOptional = userRespository.findById(id);
		User user = userOptional.get();
		return userMapper.userToUserDTO(user);
	}

}
