package com.demo.springbootbb.dtos;

import java.util.List;

import com.demo.springbootbb.entities.Order;

public class UserMmDTO {
	
	
	private Long userid;
	private String username;
	private String firstname;
	
	private List<Order> orders;
	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
