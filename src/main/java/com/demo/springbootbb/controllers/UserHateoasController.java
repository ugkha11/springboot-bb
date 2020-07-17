package com.demo.springbootbb.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilderDsl;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.springbootbb.Exceptions.UserNotFoundException;
import com.demo.springbootbb.entities.Order;
import com.demo.springbootbb.entities.User;
import com.demo.springbootbb.repositories.UserRepository;
import com.demo.springbootbb.services.UserService;



@RestController
@RequestMapping(value = "/hateoas/users")
@Validated    //for pathid validation
public class UserHateoasController {
	
	@Autowired
	private UserRepository userRespository;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public CollectionModel<User> getAllUsers() throws UserNotFoundException
	{
		List<User> userList = userService.getAllUsers();
		
		for (User user : userList) {
			Long userid = user.getUserid();
	        Link selfLink = WebMvcLinkBuilder.linkTo(this.getClass())
	          .slash(userid).withSelfRel();
	       // Link selfLink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
	        user.add(selfLink);
	        
	        //relationship link with getAllOrders
	        CollectionModel<Order> orders = WebMvcLinkBuilder.methodOn(OrderHateoasController.class).getAllOrders(userid);
	        Link ordersLink = WebMvcLinkBuilder.linkTo(orders).withRel("all-orders"); 
	        user.add(ordersLink);
	        
	    }
		
		//self link to getAllUsers
		Link selfLink2 = WebMvcLinkBuilder.linkTo(this.getClass()).withSelfRel();
		
		
		CollectionModel<User> collectionModel = new CollectionModel<>(userList, selfLink2);
		
		
		
		//Resources<User> finalResouces = new Resources<User>(userList);
		return collectionModel;
		//return new ResponseEntity(userList,HttpStatus.OK);
		
		
		
		
		
	}
	
	
	@GetMapping("/{id}")
	public EntityModel<User> getUserById(@PathVariable("id") @Min(2) Long id)
	{
		try {
			Optional<User> optionalUser = userService.getUserById(id);
			User user = optionalUser.get();
			Long userid = user.getUserid();   // for self linking
			/*
			 * Link selfLink = linkTo(methodOn(UserHateoasController.class)
			 * .getOrderById(customerId, order.getOrderId())).withSelfRel();
			 * 
			 * order.add(selfLink);
			 * 
			 * 
			 * ControllerLinkBuilder.
			 */
			
			/*
			 * Link selfLink =
			 * linkTo(UserHateoasController.class).slash(userid).withSelfRel();
			 * user.add(selfLink);
			 */
			Link selfLink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
			//Link selfLink = ControllerLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
			//user.add(selfLink);
			return new EntityModel<User>(user, selfLink);
			//Resource<User> finalResouce = new Resource<User>(user);
			//return new ResponseEntity(user,HttpStatus.OK);
			
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
			
		}	
	}
	
}
