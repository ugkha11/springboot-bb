package com.demo.springbootbb.Exceptions;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestControllerAdviceExceptionHandler {
	
	
	@ExceptionHandler(UserNameNotFoundException.class)  // so that when username is not found will be fired.
	@ResponseStatus(HttpStatus.NOT_FOUND)   //send the response status
	public CustomErrorDetails userNameNotFound(UserNameNotFoundException ex)
	{
		return new CustomErrorDetails(new Date(), "from @RestControllerAdvice NOT FOUND", ex.getMessage());
		
	}
	

}
