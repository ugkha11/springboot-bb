package com.demo.springbootbb.Exceptions;

import java.util.Date;
//simple custom error details bean 
public class CustomErrorDetails {
	
	private Date timestamp;
	private String message;
	private String errorDetails;
	
	//fields constructor
	public CustomErrorDetails(Date timestamp, String message, String errorDetails) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errorDetails = errorDetails;
	}
	
	//getters
	public Date getTimestamp() {
		return timestamp;
	}


	public String getMessage() {
		return message;
	}


	public String getErrorDetails() {
		return errorDetails;
	}
	
	
	

}
