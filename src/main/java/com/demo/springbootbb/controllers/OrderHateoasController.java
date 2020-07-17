package com.demo.springbootbb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootbb.Exceptions.UserNotFoundException;
import com.demo.springbootbb.entities.Order;
import com.demo.springbootbb.entities.User;
import com.demo.springbootbb.repositories.OrderRepository;
import com.demo.springbootbb.repositories.UserRepository;

@RestController
@RequestMapping(value = "/hateoas/users")
public class OrderHateoasController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	//get all orders for a user
	@GetMapping("/{userid}/orders")
	public CollectionModel<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException{
		
		Optional<User> user = userRepository.findById(userid);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found.");
		}
		 List<Order> orders = user.get().getOrders();
		/* 
		 * for (final Order order : orders) { Link link =
		 * WebMvcLinkBuilder.linkTo(this.getClass())
		 * .slash(order.getOrderId()).withSelfRel(); // Link selfLink =
		 * WebMvcLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
		 * order.add(link); }
		 */
	 
		/*
		 * Link link = linkTo(OrderHateoasController.class)
		 * .getOrdersForCustomer(userid).withSelfRel(); CollectionModel<Order> result =
		 * new CollectionModel<>(orders, link);
		 */
	    
	    CollectionModel<Order> collectionModel = new CollectionModel<>(orders);
	    return collectionModel;
		
	}
	

}
