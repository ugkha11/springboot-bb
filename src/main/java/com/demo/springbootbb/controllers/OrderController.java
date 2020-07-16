package com.demo.springbootbb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootbb.Exceptions.UserNotFoundException;
import com.demo.springbootbb.entities.Order;
import com.demo.springbootbb.entities.User;
import com.demo.springbootbb.repositories.OrderRepository;
import com.demo.springbootbb.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class OrderController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	//get all orders for a user
	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException{
		
		Optional<User> user = userRepository.findById(userid);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found.");
		}
		return user.get().getOrders();
	}
	
	//create order
	@PostMapping("/{userid}/orders")
	public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException {
		
		Optional<User> user = userRepository.findById(userid);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found.");
		}
		
		User user1 = user.get();
		order.setUser(user1);
		return orderRepository.save(order);
	}
	
	
		
}
