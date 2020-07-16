package com.demo.springbootbb.Exceptions;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


//@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	

	//MethodArgumentNotValidException
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "From MethodArgumentNotValid Exception from GEH", ex.getMessage());

		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	//HttpRequestMethodNotSupportedException
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		  CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "From HttpRequestMethodNotSupported Exception from GEH - Method not allowed", ex.getMessage());
		  
		  return new ResponseEntity<>(customErrorDetails, HttpStatus.METHOD_NOT_ALLOWED);
		
	}
	
	//	UserNameNotFoundException
	@ExceptionHandler(UserNameNotFoundException.class)   //custom user defined exception
	public ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex, WebRequest request)
	{
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getMessage() , request.getDescription(true));
		  
		  return new ResponseEntity<>(customErrorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	//ConstraintViolationException
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request){
		
		
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getMessage() , request.getDescription(true));
		  
		  return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	
	

}
