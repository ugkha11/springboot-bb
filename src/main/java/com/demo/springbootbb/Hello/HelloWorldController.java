package com.demo.springbootbb.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
public class HelloWorldController
{
	//simple method
	//@RequestMapping(method = RequestMethod.GET,path="/helloworld1")
	@GetMapping("/helloworld1")
	public String helloworld()
	{
		return "hello world";
	}
	
	@GetMapping("/helloworld-bean")
	public UserDetails helloworldbean()
	{
		return new UserDetails("Osman","Khan","Finland"); 
	}
 
}
